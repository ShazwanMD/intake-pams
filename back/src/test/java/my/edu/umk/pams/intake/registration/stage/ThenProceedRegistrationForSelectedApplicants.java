package my.edu.umk.pams.intake.registration.stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;


@JGivenStage
public class ThenProceedRegistrationForSelectedApplicants extends Stage<ThenProceedRegistrationForSelectedApplicants> {
	
	@Autowired
	ApplicationService applicationService;
	
	@ExpectedScenarioState
	InIntake intake;
	
	@ExpectedScenarioState
	InApplicant applicant;
	
    @ProvidedScenarioState
    private InIntakeApplication intakeApplication;
	 
	 public ThenProceedRegistrationForSelectedApplicants Proceed_Registration_For_Selected_Applicants() {
		
		 return self();
	 }

}