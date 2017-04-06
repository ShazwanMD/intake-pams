package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;

@JGivenStage
public class WhenSelectedApplicantWithdrawApplication extends Stage<WhenSelectedApplicantWithdrawApplication> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenSelectedApplicantWithdrawApplication.class);
	
	@Autowired
    private ApplicationService applicationService;
	
	@Autowired
    private AdmissionService admissionService;
	
	@Autowired
    private PolicyService policyService;

	@ExpectedScenarioState
    private InIntake intake;

	@ExpectedScenarioState
    private InIntakeSession intakeSession;
	
    @ExpectedScenarioState
    private InApplicant applicant;
	
    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
    
    @ExpectedScenarioState
    private InCandidate candidate;
    
	public WhenSelectedApplicantWithdrawApplication Withdraw_Application_in_current_intake_session_$(String intakeSession) {

		 InIntake intake = policyService.findIntakeByReferenceNo(intakeSession);
		 LOG.debug("intake {}", intake);
		 
		 applicationService.withdrawIntakeApplication(intake, intakeApplication);
		 Assert.notNull(InBidStatus.WITHDRAWN, "withdraw application is null");
		 LOG.debug("intake application status: {} ", intakeApplication.getBidStatus());
		
		 admissionService.withdrawSelectedCandidate(intake, candidate);
		 Assert.notNull(InCandidateStatus.WITHDRAWN,"withdraw application is null");
		 LOG.debug("selected candidate status: {} ",candidate.getStatus());
		 return self();
	 }

}
