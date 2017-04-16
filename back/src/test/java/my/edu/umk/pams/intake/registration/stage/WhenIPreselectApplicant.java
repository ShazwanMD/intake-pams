package my.edu.umk.pams.intake.registration.stage;

import java.util.ArrayList;
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
import org.springframework.util.Assert;

//@Pending
@JGivenStage
public class WhenIPreselectApplicant extends Stage<WhenIPreselectApplicant>{
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIPreselectApplicant.class);
	
	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private AdmissionService admissionService;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @ExpectedScenarioState
    List<InIntakeApplication>  applications;
    
    @Autowired
    ApplicationService applicationService;

	@ExpectedScenarioState
	private InIntakeApplication intakeApplication;

	@ProvidedScenarioState
    private InIntake intake; 
    
    @ProvidedScenarioState
    private List<InCandidate> candidates;
    
	public WhenIPreselectApplicant I_preselect_applicant_in_intake_session_$(String identityNo, String code) {
		intake = policyService.findIntakeByReferenceNo(code);
		applications = applicationService.findIntakeApplications(intake, InBidStatus.SUBMITTED);
		Assert.notEmpty(applications, "applications cannot be empty");

		candidates = new ArrayList<>();

		//dapatkan senarai pemohon yang telah dipilih
		for (InIntakeApplication application : applications) {
			admissionService.preselectIntakeApplication(application);
			candidates.add(admissionService.findCandidateByIdentityNo(application.getCredentialNo()));
		}

		return self();
	}
}
