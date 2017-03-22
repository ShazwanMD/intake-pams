package my.edu.umk.pams.intake.policy.stage;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeImpl;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;

@JGivenStage
public class WhenIWantToSetProjectionForCurrentIntake extends Stage<WhenIWantToSetProjectionForCurrentIntake>{

	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToSetProjectionForCurrentIntake.class);
	
	@Autowired
	private PolicyService policyService;
	
	@ExpectedScenarioState
	private InIntake intake;
	
	@ExpectedScenarioState
	private InIntakeSession Session;
	
	
	public WhenIWantToSetProjectionForCurrentIntake I_Want_To_Set_Projection_For_Current_Intake(){
		
		InIntake intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
		
		//InIntake intk = new InIntakeImpl();
		
		intake.setProjection(1000);
		policyService.updateIntake(intake);
		
		return self();
	
	}
}
