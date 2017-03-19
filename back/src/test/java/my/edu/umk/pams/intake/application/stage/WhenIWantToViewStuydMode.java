package my.edu.umk.pams.intake.application.stage;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.system.service.SystemService;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenIWantToViewStuydMode extends Stage<WhenIWantToViewStuydMode> {

	@Autowired
    private PolicyService policyService;
	
	@Autowired
    private CommonService commonService;
	
	@Autowired
    private ApplicationService applicationService;
	
	@Autowired
	private SystemService systemService;

    @ExpectedScenarioState
    private InIntakeSession session;

    @ProvidedScenarioState
    private InProgramLevel level;

    @ProvidedScenarioState
    private InIntake intake;
    
	public WhenIWantToViewStuydMode I_want_to_view_study_mode() {
		// TODO Auto-generated method stub
		 InIntakeApplication application = new InIntakeApplicationImpl();
		 
		/* Map<String, Object> map = new HashMap<String, Object>();
		    //x faham sebenarnye knapa perlu map
		map.put("intakeSession", intakeSession);
	    map.put("programLevel", policyService.findProgramLevelByCode("MASTER"));
	    intakeApplicationRefNo = systemService.generateFormattedReferenceNo(INTAKE_APPLICATION_REFERENCE_NO, map);
	    LOG.debug("creating application {}", intakeApplicationRefNo);*/
	    	 
		 application.setIntake(intake);
		 application.setReferenceNo("000001");
		 application.setAccountNo("465486451564");
		
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
         applicationService.submitIntakeApplication(intake, application);
         
         return self();
	}
	
}
