package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.system.model.InConfiguration;
import my.edu.umk.pams.intake.system.service.SystemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */

@JGivenStage
public class WhenIWantToSetMaximumNumberOfSupervisor extends Stage<WhenIWantToSetMaximumNumberOfSupervisor> {

	 private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToSetMaximumNumberOfSupervisor.class);
	 
	    @Autowired
	    private PolicyService policyService;
	    
	    @Autowired
	    private SystemService systemService;

	    @ExpectedScenarioState
	    private InIntake intake;

	    @ExpectedScenarioState
	    private InIntakeSession Session;
	    
	 public WhenIWantToSetMaximumNumberOfSupervisor I_Want_To_Set_Maximum_Number_Of_Supervisor() {
		 
		 InIntake intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
		 
		 //InConfiguration configuration = systemService.findConfigurationByKey(IntakeConstants.ADVISING_SUPERVISOR_LIMIT);
		 //Integer limit = configuration.getValueAsInteger();
	
		 InConfiguration configuration = systemService.findConfigurationByKey(IntakeConstants.ADVISING_SUPERVISOR_LIMIT);
		 configuration.setValue("10");
		 systemService.updateConfiguration(configuration);
		  LOG.debug("value: {}", configuration.getValue());
		 return self();
	 }
}
