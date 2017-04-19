package my.edu.umk.pams.intake.registration.stage;

	import java.util.List;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import my.edu.umk.pams.intake.admission.model.InCandidate;
	import my.edu.umk.pams.intake.admission.service.AdmissionService;
	import my.edu.umk.pams.intake.application.model.InIntakeApplication;
	import my.edu.umk.pams.intake.application.service.ApplicationService;
	import my.edu.umk.pams.intake.policy.model.InIntake;
	import my.edu.umk.pams.intake.policy.service.PolicyService;
	import com.tngtech.jgiven.Stage;
	import com.tngtech.jgiven.annotation.ExpectedScenarioState;
	import com.tngtech.jgiven.annotation.ProvidedScenarioState;
	import com.tngtech.jgiven.integration.spring.JGivenStage;

	//@Pending
	@JGivenStage
	public class WhenAcademicAdministratorOfferToCandidate extends Stage<WhenAcademicAdministratorOfferToCandidate>{
		
		private static final Logger LOG = LoggerFactory.getLogger(WhenAcademicAdministratorOfferToCandidate.class);
		
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
		
		@ProvidedScenarioState
		private List<InCandidate> candidates;



	    


		public WhenAcademicAdministratorOfferToCandidate offer_to_candidate_in_intake_session_$(String identityNo, String intakeSession) {
			
			InIntake intake = policyService.findIntakeByReferenceNo(intakeSession);

			
			candidates = admissionService.findCandidates(intake);
			
			
			for (InCandidate candidate : candidates) {
				
			LOG.debug("candidates status for {} is : {} ", candidate.getName(), candidate.getStatus());
		
			
			}
			

			return self();
		}

}
