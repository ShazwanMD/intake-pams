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

@JGivenStage
public class ThenICanDetermineTheLimitOfSupervisor extends Stage<ThenICanDetermineTheLimitOfSupervisor> {

   private static final Logger LOG = LoggerFactory.getLogger(ThenICanDetermineTheLimitOfSupervisor.class);

   @Autowired
   private PolicyService policyService;
   
   @Autowired
   private SystemService systemService;

   @ExpectedScenarioState
   private InIntake intake;

   @ExpectedScenarioState
   private InIntakeSession Session;	
   
    public ThenICanDetermineTheLimitOfSupervisor I_Can_Determine_The_Limit_Of_Supervisor() {
    	
    		InIntake intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
    		
    		InConfiguration configuration = systemService.findConfigurationByKey(IntakeConstants.ADVISING_SUPERVISOR_LIMIT);
    		systemService.saveConfiguration(configuration);
    	 
     return self();
    }
}