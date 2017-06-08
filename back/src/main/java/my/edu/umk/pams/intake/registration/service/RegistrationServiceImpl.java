package my.edu.umk.pams.intake.registration.service;

import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.registration.dao.InUserVerificationDao;
import my.edu.umk.pams.intake.registration.model.InUserVerification;
import my.edu.umk.pams.intake.registration.model.InUserVerificationImpl;
import my.edu.umk.pams.intake.security.integration.InAutoLoginToken;
import my.edu.umk.pams.intake.security.integration.NonSerializableSecurityContext;
import my.edu.umk.pams.intake.security.service.SecurityService;
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

        user.setEnabled(true);
        user.setLocked(true);

        // save user and refresh
        identityService.saveUser(user);
        sessionFactory.getCurrentSession().refresh(user);

        // save applicant
        identityService.saveApplicant(applicant);
        sessionFactory.getCurrentSession().refresh(applicant);

        // link user and applicant
        user.setActor(applicant);
        identityService.updateUser(user);

        // generate token
        String token = UUID.randomUUID().toString();
        InUserVerification verification = new InUserVerificationImpl();
        verification.setExpiryDate(calculateExpiryDate(ONE_WEEK));
        verification.setToken(token);
        verification.setUser(user);
        userVerificationDao.save(verification, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();

        // todo(samiya): send email notification

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
}
