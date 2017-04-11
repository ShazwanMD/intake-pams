package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InBidResponse;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InBidType;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO;

@JGivenStage
public class WhenIFillApplication extends Stage<WhenIFillApplication> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIFillApplication.class);

    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private PolicyService policyService;

    @Autowired
    private SystemService systemService;
    
    @Autowired
    private CommonService commonService;
    
    @Autowired
    private SecurityService securityService;

    @ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InIntakeSession intakeSession;

    @ExpectedScenarioState
    private InApplicant applicant; 

    @ExpectedScenarioState
    private InUser user;

    @ProvidedScenarioState
    private InIntakeApplication intakeApplication;

    public WhenIFillApplication I_fill_in_application() {
       
    	InIntake intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
        Assert.notNull(intake, "intake is null");
         
        Map<String, Object> map = new HashMap<String, Object>();
    	map.put("intakeSession", intakeSession);
    	map.put("programLevel", intake.getProgramLevel());
    	String referenceNo = systemService.generateFormattedReferenceNo(INTAKE_APPLICATION_REFERENCE_NO, map);
    	
         InIntakeApplication application = new InIntakeApplicationImpl();
         application.setReferenceNo(INTAKE_APPLICATION_REFERENCE_NO); 
         
         BigDecimal merit = new BigDecimal("2.75");
        
         application.setIntake(intake);
         application.setName("Ahmad Kharizmi bin Khaldun");
         application.setCredentialNo("910607145581");
         application.setEmail("ibnu_khaldun@gmail.com");
         application.setAge(26);
         application.setRank(3);
         application.setMerit(merit);
         application.setPaymentSourceNo("0024188");
         application.setSchoolBatch(2006/2010);
         application.setSchoolName("SMK Sultan Ismail");
         application.setBidType(InBidType.FIRST);
         application.setBidStatus(InBidStatus.NEW);
         application.setBidResponse(InBidResponse.NEW);
         application.setStudyMode(commonService.findStudyModeByCode("P")); // parttime
         application.setGenderCode(commonService.findGenderCodeByCode("M"));
         application.setReligionCode(commonService.findReligionCodeByCode("ISLAM"));
         application.setNationalityCode(commonService.findNationalityCodeByCode("MALAYSIA"));
         application.setRaceCode(commonService.findRaceCodeByCode("MALAY"));
         application.setEthnicityCode(commonService.findEthnicityCodeByCode("JAVA"));
         application.setMaritalCode(commonService.findMaritalCodeByCode("MARRIED"));
         application.setDisabilityCode(commonService.findDisabilityCodeByCode("DISABLE"));
         application.setResidencyCode(commonService.findResidencyCodeByCode("RESIDENT"));
         application.setApplicant(applicant);

         applicationService.submitIntakeApplication(intake, application);
         //draftIntakeApplication(intake, application);
        
    	
    	/*Map<String, Object> map = new HashMap<String, Object>();
    	map.put("intakeSession", intakeSession);
    	map.put("programLevel", intake.getProgramLevel());
    	String referenceNo = systemService.generateFormattedReferenceNo(INTAKE_APPLICATION_REFERENCE_NO, map);

    	// start an intakeApplication
    	intakeApplication = new InIntakeApplicationImpl();
    	intakeApplication.setIntake(this.intake);
    	intakeApplication.setReferenceNo(referenceNo);
    	intakeApplication.setName("dummy john bin john doe");
    	intakeApplication.setEmail("dummyjohn@gmail.com");
    	intakeApplication.setPhone("0111020202");
    	intakeApplication.setOkuNo("S12223214");
    	intakeApplication.setSchoolName("SMKZA");
    	intakeApplication.setBidStatus(InBidStatus.DRAFTED);
    	applicationService.draftIntakeApplication(intake, intakeApplication);*/
         
        return self() ;
    }
}

