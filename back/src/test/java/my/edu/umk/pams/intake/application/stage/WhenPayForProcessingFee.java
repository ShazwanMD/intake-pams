package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;

/**
 * @author PAMS
 */

@JGivenStage
public class WhenPayForProcessingFee  extends Stage<WhenPayForProcessingFee> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenPayForProcessingFee.class);

	 @Autowired
	 private CommonService commonService;

	 @Autowired
	 private ApplicationService applicationService;
	    
	 @ExpectedScenarioState
	 private InApplicant applicant;
	    
	 @ExpectedScenarioState
	 private InIntakeApplication application;
	   
	 @ExpectedScenarioState
     private InIntake intake;
	 
public WhenPayForProcessingFee I_Pay_Processing_Fee() {
		
		application.setPaid(true);
		applicationService.updateIntakeApplication(application);
		
		return self();
	}

}

