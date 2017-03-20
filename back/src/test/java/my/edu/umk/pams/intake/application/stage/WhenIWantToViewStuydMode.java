package my.edu.umk.pams.intake.application.stage;

import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.model.InStudyMode;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.policy.stage.WhenIAddIntake;
import my.edu.umk.pams.intake.system.service.SystemService;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;

@JGivenStage
public class WhenIWantToViewStuydMode extends Stage<WhenIWantToViewStuydMode> {

	final Logger LOG = LoggerFactory.getLogger(GivenIAmApplicant.class);

	@Autowired
    private PolicyService policyService;
	
	@Autowired
    private CommonService commonService;
	
	@Autowired
    private ApplicationService applicationService;

    @ProvidedScenarioState
    private InIntake intake;
    
    @ProvidedScenarioState
    private InIntakeApplication intakeapplication;
   
	public WhenIWantToViewStuydMode I_want_to_view_study_mode_by_intake_id_$(Long id) {
		// TODO Auto-generated method stub
		
		intake = policyService.findIntakeById(1L);
		LOG.debug("intake: {}", intake.getReferenceNo());
		Assert.notNull(intake);
		
		InIntakeApplication application = new InIntakeApplicationImpl();
		
		 application.setName("Ahmad Kharizmi bin Khaldun");
         application.setCredentialNo("910607145581");
         application.setEmail("ibnu_khaldun@gmail.com");
         application.setAge(21);
         application.setPhone("012-3456789");
         application.setGenderCode(commonService.findGenderCodeByCode("M"));
         application.setReligionCode(commonService.findReligionCodeByCode("ISLAM"));
         application.setNationalityCode(commonService.findNationalityCodeByCode("MALAYSIA"));
         application.setRaceCode(commonService.findRaceCodeByCode("MALAY"));
         application.setEthnicityCode(commonService.findEthnicityCodeByCode("JAVA"));
         application.setMaritalCode(commonService.findMaritalCodeByCode("MARRIED"));
         application.setDisabilityCode(commonService.findDisabilityCodeByCode("DISABLE"));
         application.setResidencyCode(commonService.findResidencyCodeByCode("RESIDENT"));
         application.setStudyMode(InStudyMode.FULLTIME);
         applicationService.draftIntakeApplication(intake, intakeapplication);
		return self();
		
	}
	
}
	

