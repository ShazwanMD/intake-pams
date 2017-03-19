package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InStudyMode;
import my.edu.umk.pams.intake.policy.service.PolicyService;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//pending
@JGivenStage
public class ThenICanChooseStudyMode extends Stage<ThenICanChooseStudyMode> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenICanChooseStudyMode.class);
	
	@Autowired
    private ApplicationService applicationService;
	
	@Autowired
	InStudyMode inStudyMode;
	
	@ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InApplicant applicant;

	public ThenICanChooseStudyMode I_can_choose_study_mode() {
		
		 InIntakeApplication application = applicationService.findIntakeApplicationByIntakeAndApplicant(intake, applicant);
		 Assert.assertEquals(InStudyMode.UNDECIDED, application.getStudyMode());
		 return self();     
    } 
}

