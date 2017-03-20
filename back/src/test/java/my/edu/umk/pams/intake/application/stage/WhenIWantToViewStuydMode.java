package my.edu.umk.pams.intake.application.stage;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.bdd.stage.GivenIAmAnonymous;
import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.admission.stage.WhenIPreapproveCandidate;
import my.edu.umk.pams.intake.application.model.InBidType;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InActor;
import my.edu.umk.pams.intake.identity.model.InActorType;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InStudyMode;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.system.service.SystemService;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenIWantToViewStuydMode extends Stage<WhenIWantToViewStuydMode> {
	
	private static final Logger LOG = LoggerFactory.getLogger(GivenIAmAnonymous.class);
	
	@Autowired
    private ApplicationService applicationService;
	
	@Autowired
	SystemService systemService;
	
	@Autowired
    private PolicyService policyServce;
	
	@ProvidedScenarioState
    private InIntakeApplication intakeAppl;
	
	@ProvidedScenarioState
    private InIntake intake;

	public WhenIWantToViewStuydMode I_want_to_view_study_mode_by_intake_id_$(long id) {
		intake = policyServce.findIntakeById(id);
	
		
		//String generatedRefNo = systemService.generateReferenceNo(IntakeConstants.INTAKE_REFERENCE_NO);
		
		double c=47.48000;
        BigDecimal b = new BigDecimal(c);
        LOG.debug("intake: {}", intake.getReferenceNo());
        
		//Assert.notNull(intakeSession);
		//Assert.notNull(intake);
        Assert.notNull(intake);
        //Assert.notNull(generatedRefNo);
		//applicant isi permohonan
		intakeAppl =  new InIntakeApplicationImpl();
		
		intakeAppl.setAccountNo("abc123");
		intakeAppl.setRank(1);
		intakeAppl.setMerit(b);
		intakeAppl.setStudyMode(InStudyMode.UNDECIDED);
		intakeAppl.setName("hanif");
		intakeAppl.setBidType(InBidType.FIRST);
		intakeAppl.setEmail("hanifnoordin@umk.edu.my");
		intakeAppl.setReferenceNo("12345-ref-no");
		
		applicationService.draftIntakeApplication(intake, intakeAppl);
		
		return self();
	}

}
