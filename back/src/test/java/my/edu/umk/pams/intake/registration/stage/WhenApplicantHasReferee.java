package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InReferee;
import my.edu.umk.pams.intake.application.model.InRefereeImpl;
import my.edu.umk.pams.intake.application.model.InRefereeType;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

@JGivenStage
public class WhenApplicantHasReferee extends Stage<WhenApplicantHasReferee>{
	private static final Logger LOG = LoggerFactory.getLogger(WhenApplicantHasReferee.class);
	
	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private ApplicationService applicationService;
	
	@ProvidedScenarioState
	private InIntake intake;
	
	@ExpectedScenarioState
    private InIntakeApplication application;
	
	
	 public WhenApplicantHasReferee an_applicant_has_referee(){
		
		 intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
		 Assert.notNull(intake, "intake cannot be null");
		 LOG.debug("intake status {}", application.getBidStatus());
		 
		 InReferee referee = new InRefereeImpl();
		 // referee.setApplication(application);		 
		 
		 //todo mia : need to add a method for drafting an application
		 
		 referee.setName("Mr. Chan");
		 referee.setOccupation("Lecturer");
		 referee.setOfficeAddrs("UMK Pengkalan Chepa, Kota Bharu");
		 referee.setPhoneNo("012343234");
		 referee.setType(InRefereeType.PRIMARY);
		 applicationService.addReferee(application, referee);
		 
		 
		 Assert.notNull(referee, "referee cannot be null");
		 LOG.debug("referee status : {} ", referee.getType());
		 
		 
		 referee.setName("Mr. Lim");
		 referee.setOccupation("Lecturer");
		 referee.setOfficeAddrs("UMK Pengkalan Chepa, Kota Bharu");
		 referee.setPhoneNo("0123433303");
		 referee.setType(InRefereeType.SECONDARY);
		 applicationService.addReferee(application, referee);
		
		 Assert.notNull(referee, "referee cannot be null");
		 LOG.debug("referee status : {} ", referee.getType());
		 //todo mia : need to add a method to save referee
		 
		 return self();
	 }
		

}
