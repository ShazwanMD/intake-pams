package my.edu.umk.pams.intake.registration.service;

import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;

/**
 * @author PAMS
 */
public interface RegistrationService {

    void register(InUser user, InApplicant applicant);

    void activate(InUser user);
   

    boolean isExists(String username);
}
