package my.edu.umk.pams.intake.registration.service;

import my.edu.umk.pams.intake.identity.dao.InUserDao;
import my.edu.umk.pams.intake.identity.dao.RecursiveGroupException;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InGroup;
import my.edu.umk.pams.intake.identity.model.InPrincipal;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.registration.dao.InUserVerificationDao;
import my.edu.umk.pams.intake.registration.model.InUserVerification;
import my.edu.umk.pams.intake.registration.model.InUserVerificationImpl;
import my.edu.umk.pams.intake.security.integration.InAutoLoginToken;
import my.edu.umk.pams.intake.security.integration.NonSerializableSecurityContext;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.model.InEmailQueueImpl;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;
import my.edu.umk.pams.intake.system.service.SystemService;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

/**
 * @author PAMS
 */
@Transactional
@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {

    private static final Logger LOG = LoggerFactory.getLogger(RegistrationServiceImpl.class);
    public static final int ONE_WEEK = 60 * 24 * 7;

    @Autowired
    private InUserVerificationDao userVerificationDao;
    
    @Autowired
    private InUserDao userDao;
    
    @Autowired
    private SystemService systemService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void registerUser(InUser user, InApplicant applicant) {
        SecurityContext sc = loginAsSystem();      

        user.setEnabled(false);
        user.setLocked(true);

        // save user and refresh
        identityService.saveUser(user);
        try {
            InGroup group = identityService.findGroupByName("GRP_APCN");
            InPrincipal principal = identityService.findPrincipalByName(user.getName());
            System.out.println("group :"+group);
			identityService.addGroupMember(group, principal);
		} catch (RecursiveGroupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sessionFactory.getCurrentSession().refresh(user);

        // save applicant
        identityService.saveApplicant(applicant);
        sessionFactory.getCurrentSession().refresh(applicant);

        // link user and applicant
        user.setActor(applicant);
        identityService.updateUser(user);

        // generate token
        String token = generateToken();
        InUserVerification verification = new InUserVerificationImpl();
        verification.setExpiryDate(calculateExpiryDate(ONE_WEEK));
        verification.setToken(token);
        verification.setUser(user);
        userVerificationDao.save(verification, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();

        // todo(samiya): send email notification
        String applicationUrl= systemService.findConfigurationByKey("application.url").getValue();
        InEmailQueue email= new InEmailQueueImpl();
        String subject = "Email verification";
        String body = "Please verify your email address upon 7 days from your registration day by clicking this url : "+applicationUrl+"/verification/"+ token;
        //verification.getToken();
        email.setTo(user.getEmail());
        email.setSubject(subject);
        email.setBody(body);
       //method send email 
        email.setCode("EQ/" + System.currentTimeMillis());
        email.setQueueStatus(InEmailQueueStatus.QUEUED);
        systemService.saveEmailQueue(email);
        
        // logout
        logoutAsSystem(sc);
    }

    @Override
    public void verifyUser(String token) {
        SecurityContext sc = loginAsSystem();
        InUserVerification verification = userVerificationDao.findByToken(token);
        InUser user = verification.getUser();
        user.setEnabled(true);
        identityService.updateUser(user);
        logoutAsSystem(sc);
    }
    
    @Override
    public void forgetPassword(InUser user) {
    	SecurityContext sc = loginAsSystem();
    	if (user == null) LOG.debug("UserB is null");
    	if (user.getEmail() == null) LOG.debug("Email is null");
    	String applicationUrl= systemService.findConfigurationByKey("application.url").getValue();
    	InEmailQueue email= new InEmailQueueImpl();
        String subject = "Password Recovery";
        String body = "Your password is : "+ user.getPassword()+ 
        			  ". You are encourage to change your password. Please click the given url to login. " +applicationUrl+"/login/";
        email.setTo(user.getEmail());
        email.setSubject(subject);
        email.setBody(body);
        email.setCode("EQ/" + System.currentTimeMillis());
        email.setQueueStatus(InEmailQueueStatus.QUEUED);
        systemService.saveEmailQueue(email);
        logoutAsSystem(sc);
    }

    @Override
    public boolean isUserExists(String username) {
        return identityService.isUserExists(username);
    }

    private SecurityContext loginAsSystem() {
        SecurityContext savedCtx = SecurityContextHolder.getContext();
        InAutoLoginToken authenticationToken = new InAutoLoginToken("system");
        Authentication authed = authenticationManager.authenticate(authenticationToken);
        SecurityContext system = new NonSerializableSecurityContext();
        system.setAuthentication(authed);
        SecurityContextHolder.setContext(system);
        return savedCtx;
    }

    private void logoutAsSystem(SecurityContext context) {
        SecurityContextHolder.setContext(context);
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
    
    @Override
    public String generateToken (){
    	
    	String token = UUID.randomUUID().toString();
    	
    	return token;
    	
    }
}
