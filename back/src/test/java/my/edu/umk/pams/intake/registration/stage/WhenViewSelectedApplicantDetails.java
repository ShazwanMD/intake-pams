package my.edu.umk.pams.intake.registration.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.system.service.SystemService;

public class WhenViewSelectedApplicantDetails extends Stage<WhenViewSelectedApplicantDetails> {
	
	 private static final Logger LOG = LoggerFactory.getLogger(WhenViewSelectedApplicantDetails.class);
	 
	@Autowired
    private PolicyService policyService;
	
    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private SystemService systemService;

    @Autowired
    private IdentityService identityService;
    
    @Autowired
    private AdmissionService admissionService;

    @ExpectedScenarioState
    InIntakeSession intakeSession;

    @ExpectedScenarioState
    private InApplicant applicant;

    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
	
	@ExpectedScenarioState
	private InIntake intake;

	public WhenViewSelectedApplicantDetails View_selected_applicant_details() {
		
		admissionService.preselectIntakeApplication(intakeApplication);

		List<InCandidate> candidates = admissionService.findCandidates(intake);
		LOG.debug(" test  : {}", candidates);
		
		Assert.notEmpty(candidates, "is empty");
		

		
		return self();
	}

}
