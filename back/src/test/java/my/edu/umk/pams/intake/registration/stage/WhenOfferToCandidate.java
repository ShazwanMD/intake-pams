package my.edu.umk.pams.intake.registration.stage;

import io.jsonwebtoken.lang.Assert;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.registration.US_IN_RGN_3002;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

//@Pending
@JGivenStage
public class WhenOfferToCandidate extends Stage<WhenOfferToCandidate>{
	
	private static final Logger LOG = LoggerFactory.getLogger(GivenIAmMGSEBAdministrator.class);
	
	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private AdmissionService admissionService;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @ProvidedScenarioState
    List<InIntakeApplication>  applications;
    
    @Autowired
    ApplicationService applicationService;
    
    @ProvidedScenarioState
    private InIntake intake; 
    
  //  @ProvidedScenarioState
  //  private InCandidate candidate; 
    


	public WhenOfferToCandidate offer_to_candidate_in_current_intake_session_$(String intakeSession) {
		
	
		intake = policyService.findIntakeByReferenceNo(intakeSession);
	
		applications = applicationService.findIntakeApplications(intake,InBidStatus.PROCESSING); 	
		
		//dapatkan senarai pemohon yang telah dipilih
		//for (InIntakeApplication intakeApplication : applications) {
		
		
		InIntakeApplication intakeApplication = applications.get(0);
			LOG.debug("intakeapplication {}", intakeApplication.getBidStatus());
			Assert.notNull(intakeApplication, "list is null");
			intakeApplication.setBidStatus(InBidStatus.SELECTED);
			LOG.debug("intakeapplication {}", intakeApplication.getBidStatus());
			admissionService.preselectIntakeApplication(intakeApplication);
			
			
			
			 //test preselectIntakeApplication function
		//	InCandidate candidate = admissionService.findCandidateByIdentityNo("248674");
		//	LOG.debug("candidate : {}", candidate);
			
	//	}


	
		return self();
	}
}

