package my.edu.umk.pams.intake.application.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.service.ApplicationService;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIWantToResetForgetPassword extends Stage<WhenIWantToResetForgetPassword> {

	@Autowired
    private ApplicationService applicationService;

    
    public WhenIWantToResetForgetPassword I_want_to_reset_forget_password() {
    	
    	return self();
    }
	
}
