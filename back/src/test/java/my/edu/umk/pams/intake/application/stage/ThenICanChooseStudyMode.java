/*package my.edu.umk.pams.intake.application.stage;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.system.service.SystemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenICanChooseStudyMode extends Stage<ThenICanChooseStudyMode>{

	private static final Logger LOG = LoggerFactory.getLogger(ThenICanChooseStudyMode.class);
	
	    @Autowired
	    private ApplicationService applicationService;
	    
	    @Autowired
		private PolicyService policyService;

	    @ExpectedScenarioState
	    private InIntakeSession session;
	    
	    @Autowired
		private SystemService systemService;

	    @ExpectedScenarioState
	    private InIntake intake;
	
	public void I_can_choose_study_mode() {
		// TODO Auto-generated method stub
		InIntakeApplication application = new InIntakeApplicationImpl();
		application.getName();
		application.getCredentialNo();
		application.getEmail();
		application.getStudyMode();
	
	}
	
}
*/