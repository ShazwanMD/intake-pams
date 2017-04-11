package my.edu.umk.pams.intake.registration.stage;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

@JGivenStage
public class WhenReceiveNotificationOnRegistrationDate  extends Stage<WhenReceiveNotificationOnRegistrationDate> {

	private static final Logger LOG = LoggerFactory.getLogger (WhenReceiveNotificationOnRegistrationDate.class);
	
	 @Autowired
	 private ApplicationService applicationService;
	 
	 @Autowired
	 private PolicyService policyService;
	
	 @ExpectedScenarioState
	 private InIntake intake;
	 
	
	 public WhenReceiveNotificationOnRegistrationDate I_receive_notification_on_registration_date() {
		 
		  intake = policyService.findIntakeByReferenceNo(intake.getReferenceNo());
		 
		 LOG.debug("intake is : {}", intake);
	     List<InIntakeApplication> applications = applicationService.findIntakeApplications(intake, InBidStatus.SUBMITTED); 
	      
	     intake.getEndDate();
	     LOG.debug("intake end Date : {}", intake.getEndDate());
	     
	        
		 return self();
 	}

}
