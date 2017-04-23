package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.system.model.InConfiguration;
import my.edu.umk.pams.intake.system.service.SystemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;

/**
 * @author PAMS
 */

@JGivenStage
public class WhenISetMaximumNumberOfSupervisor extends Stage<WhenISetMaximumNumberOfSupervisor> {

	 private static final Logger LOG = LoggerFactory.getLogger(WhenISetMaximumNumberOfSupervisor.class);
	 
	    @Autowired
	    private PolicyService policyService;
	    
	    @Autowired
	    private SystemService systemService;

	    @ExpectedScenarioState
	    private InIntake intake;

	    @ExpectedScenarioState
	    private InIntakeSession Session;
	    
	 public WhenISetMaximumNumberOfSupervisor I_set_maximum_number_of_supervisor() {
		 
		 InIntake intake = policyService.findIntakeByReferenceNo(INTAKE_REFERENCE_NO_MGSSEB);
		 
		 //InConfiguration configuration = systemService.findConfigurationByKey(IntakeConstants.ADVISING_SUPERVISOR_LIMIT);
		 //Integer limit = configuration.getValueAsInteger();
	
		 InConfiguration configuration = systemService.findConfigurationByKey(IntakeConstants.ADVISING_SUPERVISOR_LIMIT);
		 configuration.setValue("10");
		 systemService.updateConfiguration(configuration);
		  LOG.debug("value: {}", configuration.getValue());
		 return self();
	 }
}
