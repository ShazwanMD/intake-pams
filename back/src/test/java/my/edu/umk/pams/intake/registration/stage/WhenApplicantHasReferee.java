package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;


public class WhenApplicantHasReferee extends Stage<WhenApplicantHasReferee>{
	private static final Logger LOG = LoggerFactory.getLogger(WhenApplicantHasReferee.class);
	
	@Autowired
	private PolicyService policyService;
	
	@ProvidedScenarioState
	private InIntake intake;
	
	 public WhenApplicantHasReferee an_applicant_has_referee(){
		 Assert.notNull(intake, "intake cannot be null");
		 intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
		 
		 //todo : need referee's setup
		 return self();
	 }
		

}
