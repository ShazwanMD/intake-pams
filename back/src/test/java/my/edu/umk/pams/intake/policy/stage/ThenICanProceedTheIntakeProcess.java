package my.edu.umk.pams.intake.policy.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenICanProceedTheIntakeProcess  extends Stage<ThenICanProceedTheIntakeProcess> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenICanProceedTheIntakeProcess.class);

	@Autowired
    private PolicyService policyService;

    @ExpectedScenarioState
    private InIntakeSession session;

    @ExpectedScenarioState
    private InIntake intake;
    
    public ThenICanProceedTheIntakeProcess I_Can_Proceed_The_Intake_Process(){
    	
    	InIntake intake =  policyService.findIntakeByReferenceNo("201720181/MASTER");
    	intake.getProjection();
    	policyService.startIntakeTask(intake);
    	return self();
    }
}
    
    	
 
