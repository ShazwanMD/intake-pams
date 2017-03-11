package my.edu.umk.pams.intake.registration.service;

import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.security.integration.InAutoLoginToken;
import my.edu.umk.pams.intake.security.integration.NonSerializableSecurityContext;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author PAMS
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private static final Logger LOG = LoggerFactory.getLogger(RegistrationServiceImpl.class);

    @Autowired
    private IdentityService identityService;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void register(InUser user, InApplicant applicant) {
        SecurityContext sc = loginAsSystem();

        // todo(uda): move to activation
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

        // todo(uda): send email notification

        // logout
        logoutAsSystem(sc);
    }

    @Override
    public void activate(InUser user) {
        // todo(uda): impl
    }

    @Override
    public boolean isExists(String username) {
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

}
