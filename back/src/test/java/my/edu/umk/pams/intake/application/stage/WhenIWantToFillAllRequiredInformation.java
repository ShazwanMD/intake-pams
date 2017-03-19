package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIWantToFillAllRequiredInformation extends Stage<WhenIWantToFillAllRequiredInformation> {

	   
	    private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToFillAllRequiredInformation.class);

	    @Autowired
	    private CommonService commonService;
	    
	    @Autowired
	    private PolicyService policyService;
	    
    
	    
    public WhenIWantToFillAllRequiredInformation I_want_to_fill_all_required_information() { /*
        InIntakeApplication application = new InIntakeApplicationImpl();

		@Autowired
		private SystemService systemService;
		  
        application.setReferenceNo("000001");
        application.setName("Ahmad Radzif Radzol");
        application.setEmail("ahmad.razif@gmail.com");
        application.setPhone("123456789");
        application.setOkuNo("123461654");
        application.setSchoolName("SMKZA");
        application.setStudyMode(InStudyMode.FULLTIME);

	    public WhenIWantToFillAllRequiredInformation I_want_to_fill_all_required_information() {
	    	
	    	 InIntakeApplication application = new InIntakeApplicationImpl();
	    	 
	    	 Map<String, Object> map = new HashMap<String, Object>();
	    
			map.put("intakeSession", intakeSession);
	         map.put("programLevel", policyService.findProgramLevelByCode("MASTER"));
	         intakeApplicationRefNo = systemService.generateFormattedReferenceNo(INTAKE_APPLICATION_REFERENCE_NO, map);
	    	 LOG.debug("creating application {}", intakeApplicationRefNo);
	    	 
	    	 application.setReferenceNo(intakeApplicationRefNo);
	         application.setIntake(intake);
	         application.setName("Ahmad Kharizmi bin Khaldun");
	         application.setCredentialNo("910607145581");
	         application.setEmail("ibnu_khaldun@gmail.com");
	         application.setAge(21);
	         application.setGenderCode(commonService.findGenderCodeByCode("M"));
	         application.setReligionCode(commonService.findReligionCodeByCode("ISLAM"));
	         application.setNationalityCode(commonService.findNationalityCodeByCode("MALAYSIA"));
	         application.setRaceCode(commonService.findRaceCodeByCode("MALAY"));
	         application.setEthnicityCode(commonService.findEthnicityCodeByCode("JAVA"));
	         application.setMaritalCode(commonService.findMaritalCodeByCode("MARRIED"));
	         application.setDisabilityCode(commonService.findDisabilityCodeByCode("DISABLE"));
	         application.setResidencyCode(commonService.findResidencyCodeByCode("RESIDENT"));
	    	 
	         applicationService.draftIntakeApplication((InIntake) applicant, InIntakeApplication);
	    	*/
	    	return self();
	    	
	    }
}
