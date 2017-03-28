package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenWithdrawApplication extends Stage<WhenWithdrawApplication> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenWithdrawApplication.class);
	
	@Autowired
    private ApplicationService applicationService;
	
	@Autowired
    private PolicyService policyService;

		
    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
	
	 public WhenWithdrawApplication Withdraw_Application() {
		 
		 InIntake intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
		 
		
		  
	//	 intakeApplication = applicationService.findIntakeApplicationByReferenceNo("20052/MASTER/001");
		 intakeApplication.setBidStatus(InBidStatus.WITHDRAWN);
	     applicationService.withdrawIntakeApplication(intake, intakeApplication);
	     
	    
		 
		 return self();
	 }

}
