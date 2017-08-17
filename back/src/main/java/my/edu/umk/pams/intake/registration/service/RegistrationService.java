package my.edu.umk.pams.intake.registration.service;

import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;

/**
 * @author PAMS
 */
public interface RegistrationService {

    void registerUser(InUser user, InApplicant applicant);

    void verifyUser(String token);
    
    void forgetPassword(InUser user);

    boolean isUserExists(String username);
    
    boolean isActorEmailExists(String email);
    
    boolean isActorIdentityNoExists(String identityNo);

	String generateToken();
}
