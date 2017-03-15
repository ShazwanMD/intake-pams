package my.edu.umk.pams.intake.application.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;

public class ThenICanCompleteMyApplication extends Stage<ThenICanCompleteMyApplication> {
	
	 	@Autowired
	    private ApplicationService applicationService;

	    @ExpectedScenarioState
	    private InIntake intake;

	    @ExpectedScenarioState
	    private InApplicant applicant;
	    
	    public ThenICanCompleteMyApplication I_can_complete_my_application() {
	    	
	    	 return self();
}
}
