package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

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

