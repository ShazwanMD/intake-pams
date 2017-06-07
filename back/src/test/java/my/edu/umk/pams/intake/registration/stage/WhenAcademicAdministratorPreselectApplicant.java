package my.edu.umk.pams.intake.registration.stage;

	import java.util.List;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.authentication.AuthenticationManager;
	import my.edu.umk.pams.intake.admission.model.InCandidate;
	import my.edu.umk.pams.intake.admission.service.AdmissionService;
	import my.edu.umk.pams.intake.application.model.InBidStatus;
	import my.edu.umk.pams.intake.application.model.InIntakeApplication;
	import my.edu.umk.pams.intake.application.service.ApplicationService;
	import my.edu.umk.pams.intake.policy.model.InIntake;
	import my.edu.umk.pams.intake.policy.service.PolicyService;
	import com.tngtech.jgiven.Stage;
	import com.tngtech.jgiven.annotation.ExpectedScenarioState;
	import com.tngtech.jgiven.annotation.Pending;
	import com.tngtech.jgiven.annotation.ProvidedScenarioState;
	import com.tngtech.jgiven.integration.spring.JGivenStage;
	import org.springframework.util.Assert;

	//@Pending
	@JGivenStage
	public class WhenAcademicAdministratorPreselectApplicant extends Stage<WhenAcademicAdministratorPreselectApplicant>{
		
		private static final Logger LOG = LoggerFactory.getLogger(WhenAcademicAdministratorPreselectApplicant.class);
		
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
	    private InCandidate candidate;
	    


		public WhenAcademicAdministratorPreselectApplicant academic_admin_preselect_applicant_in_intake_session_$(String identityNo, String intakeSession) {
			intake = policyService.findIntakeByReferenceNo(intakeSession);
			
			applications = applicationService.findIntakeApplications(intake, InBidStatus.APPLY);
			
			Assert.notEmpty(applications, "applications cannot be empty");

			//dapatkan senarai pemohon yang telah dipilih
			for (InIntakeApplication application : applications) {

				admissionService.preselectIntakeApplication(application);

				  
			}


			return self();
		}
	}

