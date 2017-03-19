package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateImpl;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InStudyMode;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.system.service.SystemService;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class WhenIViewMyStudyMode extends Stage<WhenIViewMyStudyMode> {
	

	@Autowired
	private CommonService commonService;
	
	@Autowired
	private PolicyService policyService;
	
	@Autowired
    private ApplicationService applicationService;
	
	@Autowired
    private AdmissionService admissionService;
	
	@Autowired
    private SecurityService securityService;
	
	@Autowired
	private SystemService systemService;
	 
	@Autowired
	InStudyMode inStudyMode;
	
	@ProvidedScenarioState
    private String intakeApplicationRefNo;
	
	@ExpectedScenarioState
	private InIntakeSession intakeSession;
	
	 @ExpectedScenarioState
	 private InApplicant applicant;
	 
	 @ProvidedScenarioState
	 private InUser user;

    
    public WhenIViewMyStudyMode I_view_study_mode() {
    	
    	InIntake intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
        Assert.notNull(intake, "intake is null");

        InUser currentUser = securityService.getCurrentUser();
        Assert.isTrue((user.getActor() instanceof InApplicant), "actor is not an applicant");
        if (currentUser.getActor() instanceof InApplicant) {
	
        applicant = (InApplicant) currentUser.getActor();
        Assert.notNull(applicant, "applicant is null");
        }
      //uda and max,en hanif, tolong btolkan.saya rasa ad yg salah atau x lengkap 
         InIntakeApplication application = new InIntakeApplicationImpl();
         application.setReferenceNo(INTAKE_APPLICATION_REFERENCE_NO); 
         application.setIntake(intake);
         application.setStudyMode(InStudyMode.UNDECIDED);
    
    	 applicationService.draftIntakeApplication(intake, application);
    	 return self();
}
}


