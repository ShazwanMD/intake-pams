
package my.edu.umk.pams.intake.registration.stage;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;


public class ThenICanProceedRegistration extends Stage<ThenICanProceedRegistration> {

    @Autowired
    private RegistrationService registrationService;

    @ProvidedScenarioState
    private InUser user;

    @ExpectedScenarioState
    private InIntakeApplication selectedApplication;
    
    public ThenICanProceedRegistration I_can_process_applicant_registration() {
    	
    	selectedApplication.setBidStatus(InBidStatus.SELECTED);
        return self();
    }


}
