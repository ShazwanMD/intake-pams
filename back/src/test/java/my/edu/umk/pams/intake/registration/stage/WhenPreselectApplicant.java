package my.edu.umk.pams.intake.registration.stage;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.springframework.util.Assert;

//@Pending
@JGivenStage
public class WhenPreselectApplicant extends Stage<WhenPreselectApplicant>{
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenPreselectApplicant.class);
	
	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private AdmissionService admissionService;

    @ExpectedScenarioState
    List<InIntakeApplication>  applications;
    
    @Autowired
    ApplicationService applicationService;

	@ExpectedScenarioState
	private InIntakeApplication intakeApplication;

	@ExpectedScenarioState
    private InIntake intake; 
    
    @ProvidedScenarioState
    private List<InCandidate> candidates;
    
	public WhenPreselectApplicant I_preselect_applicant_$(String identityNo) {
		applications = applicationService.findIntakeApplications(intake, InBidStatus.SUBMITTED);
		Assert.notEmpty(applications, "applications cannot be empty");

		candidates = new ArrayList<>(); // todo(farah) Why collection when we method use a single identityNo?

		for (InIntakeApplication application : applications) {
			if (identityNo.equals(application.getCredentialNo()))
				admissionService.preselectIntakeApplication(application);
			 LOG.debug("candidates {}", candidates);
			candidates.add(admissionService.findCandidateByIdentityNo(application.getCredentialNo()));
		}
	//	 LOG.debug("candidates {}", candidates);

		return self();
	}
}

