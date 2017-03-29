package my.edu.umk.pams.intake.application.stage;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InGuardianType;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenRegistrationIsComplete extends Stage<ThenRegistrationIsComplete> {

 	
@Autowired
private CommonService commonService;

@Autowired
private ApplicationService applicationService;
    
@ProvidedScenarioState
private InApplicant applicant;

@ExpectedScenarioState
private InIntake intake;

@ExpectedScenarioState
private InGuardianType guardianType;
    
@ProvidedScenarioState
private InIntakeApplication application;

	public ThenRegistrationIsComplete Registration_Is_Complete() {
		
		applicationService.submitIntakeApplication(intake, application);
		return self();
	 }
}
