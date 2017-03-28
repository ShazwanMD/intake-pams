package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.service.IdentityService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIWantToResetForgetPassword extends Stage<WhenIWantToResetForgetPassword> {

    @Autowired
    private IdentityService identityService;
    
    @ExpectedScenarioState
    InUser user;
    
    
    
    public WhenIWantToResetForgetPassword I_want_to_reset_forget_password() {
    	
    	
//i changed password
    	
    	identityService.findUserByUsername("applicant1");
    	user.setPassword("123abc");
    	identityService.changePassword(user, user.getPassword());
    	
    	return self();
    	
    }

}

