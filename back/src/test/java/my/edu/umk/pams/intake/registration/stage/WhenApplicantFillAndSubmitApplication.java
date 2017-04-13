package my.edu.umk.pams.intake.registration.stage;

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
import my.edu.umk.pams.intake.common.model.InResidencyCode;
import my.edu.umk.pams.intake.common.model.InResidencyCodeImpl;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
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
public class WhenApplicantFillAndSubmitApplication extends Stage<WhenApplicantFillAndSubmitApplication> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenApplicantFillAndSubmitApplication.class);

    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private PolicyService policyService;

    @Autowired
    private SystemService systemService;
    
    @Autowired
    private CommonService commonService;
    
    @Autowired
    private IdentityService identityService;

    @ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InApplicant applicant; 
    
    @ExpectedScenarioState
    private InUser user;


    public WhenApplicantFillAndSubmitApplication I_fill_in_application() {
       
    	InIntake intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
        Assert.notNull(intake, "intake is null");
         
        Map<String, Object> map = new HashMap<String, Object>();
    	map.put("intakeSession", intakeSession);
    	map.put("programLevel", intake.getProgramLevel());
    	String referenceNo = systemService.generateFormattedReferenceNo(INTAKE_APPLICATION_REFERENCE_NO, map);
    	
    	
    	
    	InResidencyCode resident = new InResidencyCodeImpl();
    	resident.setCode("101");
    	resident.setDescription("test resident");
    	commonService.saveResidencyCode(resident);
    	Assert.notNull(resident, "resident is null");
    	LOG.debug("test resident {} :", resident);
    	
    	
    	
        InApplicant applicant = new InApplicantImpl();
        applicant.setApplicationNo("9999999");
        applicant.setName("dummy john bin john doe");
        applicant.setEmail("dummyjohn@gmail.com");
        applicant.setPhone("0111020202");
        identityService.saveApplicant(applicant);
        Assert.notNull(applicant, "applicant is null");
        
       //application 1
    	
        InIntakeApplication application1 = new InIntakeApplicationImpl();
       //  application1.setReferenceNo(INTAKE_APPLICATION_REFERENCE_NO); 
         
         BigDecimal merit1 = new BigDecimal("2.85");
        
         application1.setIntake(intake);
         application1.setReferenceNo("INTAKE/10001");
         application1.setName("Ahmad Kharizmi bin Khaldun");
         application1.setCredentialNo("910607145581");
         application1.setEmail("ibnu_khaldun@gmail.com");
         application1.setPhone("0111020202");
         application1.setAge(26);
         application1.setRank(3);
         application1.setMerit(merit1);
         application1.setPaymentSourceNo("0024188");
         application1.setSchoolBatch(2006/2010);
         application1.setSchoolName("SMK Sultan Ismail");
         application1.setBidType(InBidType.FIRST);
         application1.setBidStatus(InBidStatus.NEW);
         application1.setBidResponse(InBidResponse.NEW);
         application1.setOkuNo("S12223214");
         
         application1.setStudyMode(commonService.findStudyModeByCode("1")); //Full time
         Assert.notNull(commonService.findStudyModeByCode("1"), "studymode is null");
         
         application1.setGenderCode(commonService.findGenderCodeByCode("1")); //Male
         Assert.notNull(commonService.findGenderCodeByCode("1"), "gendercode is null");
         
         application1.setReligionCode(commonService.findReligionCodeByCode("1")); //Islam
         Assert.notNull(commonService.findReligionCodeByCode("1"), "religioncode is null");
         
         application1.setNationalityCode(commonService.findNationalityCodeByCode("1")); //Warganegara
         Assert.notNull(commonService.findNationalityCodeByCode("1"), "nationalitycode is null");
         
         application1.setRaceCode(commonService.findRaceCodeByCode("0100")); //Melayu
         Assert.notNull(commonService.findRaceCodeByCode("0100"), "racecode is null");
   
         application1.setEthnicityCode(commonService.findEthnicityCodeByCode("0100")); //Melayu
         Assert.notNull(commonService.findEthnicityCodeByCode("0100"), "ethnicitycode is null");
         
         application1.setMaritalCode(commonService.findMaritalCodeByCode("1")); //Bujang
         Assert.notNull(commonService.findMaritalCodeByCode("1"), "maritalcode is null");
         
         application1.setDisabilityCode(commonService.findDisabilityCodeByCode("12")); //Tidak cacat
         Assert.notNull(commonService.findDisabilityCodeByCode("12"), "disabilitycode is null");
         
         application1.setResidencyCode(commonService.findResidencyCodeByCode("101")); //no data in seed, created test code in unit
         Assert.notNull(commonService.findResidencyCodeByCode("101"), "residencycode is null");
         
         application1.setApplicant(applicant);
         Assert.notNull(applicant, "applicant is null");
         LOG.debug("intake status : {} ", application1.getBidStatus());
         applicationService.draftIntakeApplication(intake, application1);
         LOG.debug("intake status : {} ", application1.getBidStatus());
         
       //application 2

     	
          InIntakeApplication  application2 = new InIntakeApplicationImpl();
    //      application2.setReferenceNo(INTAKE_APPLICATION_REFERENCE_NO); 
          
          BigDecimal merit2 = new BigDecimal("2.80");
         
          application2.setIntake(intake);
          application2.setReferenceNo("INTAKE/10002");
          application2.setName("Ahmad Sam bin Khaldun Sam");
          application2.setCredentialNo("910607149913");
          application2.setEmail("ahmad_sam@gmail.com");
          application2.setPhone("01710112002");
          application2.setAge(25);
          application2.setRank(2);
          application2.setMerit(merit2);
          application2.setPaymentSourceNo("002268sd");
          application2.setSchoolBatch(2006/2012);
          application2.setSchoolName("SMK Sultan Ismail Hash");
          application2.setBidType(InBidType.FIRST);
          application2.setBidStatus(InBidStatus.NEW);
          application2.setBidResponse(InBidResponse.NEW);
          application2.setOkuNo("S17453214");
          
          application2.setStudyMode(commonService.findStudyModeByCode("1")); //Full time
          Assert.notNull(commonService.findStudyModeByCode("1"), "studymode is null");
          
          application2.setGenderCode(commonService.findGenderCodeByCode("1")); //Male
          Assert.notNull(commonService.findGenderCodeByCode("1"), "gendercode is null");
          
          application2.setReligionCode(commonService.findReligionCodeByCode("1")); //Islam
          Assert.notNull(commonService.findReligionCodeByCode("1"), "religioncode is null");
          
          application2.setNationalityCode(commonService.findNationalityCodeByCode("1")); //Warganegara
          Assert.notNull(commonService.findNationalityCodeByCode("1"), "nationalitycode is null");
          
          application2.setRaceCode(commonService.findRaceCodeByCode("0100")); //Melayu
          Assert.notNull(commonService.findRaceCodeByCode("0100"), "racecode is null");
    
          application2.setEthnicityCode(commonService.findEthnicityCodeByCode("0100")); //Melayu
          Assert.notNull(commonService.findEthnicityCodeByCode("0100"), "ethnicitycode is null");
          
          application2.setMaritalCode(commonService.findMaritalCodeByCode("1")); //Bujang
          Assert.notNull(commonService.findMaritalCodeByCode("1"), "maritalcode is null");
          
          application2.setDisabilityCode(commonService.findDisabilityCodeByCode("12")); //Tidak cacat
          Assert.notNull(commonService.findDisabilityCodeByCode("12"), "disabilitycode is null");
          
          application2.setResidencyCode(commonService.findResidencyCodeByCode("101")); //no data in seed, created test code in unit
          Assert.notNull(commonService.findResidencyCodeByCode("101"), "residencycode is null");
          
          application2.setApplicant(applicant);
          Assert.notNull(applicant, "applicant is null");
          LOG.debug("intake status : {} ", application2.getBidStatus());
          applicationService.draftIntakeApplication(intake, application2);
          LOG.debug("intake status : {} ", application2.getBidStatus());
          
          //application 2

       	
          InIntakeApplication  application3 = new InIntakeApplicationImpl();
    //    application2.setReferenceNo(INTAKE_APPLICATION_REFERENCE_NO); 
          
          BigDecimal merit3 = new BigDecimal("3.80");
         
          application3.setIntake(intake);
          application3.setReferenceNo("INTAKE/10003");
          application3.setName("Siti Samiya bin Khaldun Sam");
          application3.setCredentialNo("870607149913");
          application3.setEmail("siti_samiya@gmail.com");
          application3.setPhone("0171023442");
          application3.setAge(30);
          application3.setRank(1);
          application3.setMerit(merit3);
          application3.setPaymentSourceNo("767268sd");
          application3.setSchoolBatch(2003/2009);
          application3.setSchoolName("SMK Sultanah Asma");
          application3.setBidType(InBidType.FIRST);
          application3.setBidStatus(InBidStatus.NEW);
          application3.setBidResponse(InBidResponse.NEW);
          application3.setOkuNo("S17453217874");
          
          application3.setStudyMode(commonService.findStudyModeByCode("2")); //Part time
          Assert.notNull(commonService.findStudyModeByCode("2"), "studymode is null");
          
          application3.setGenderCode(commonService.findGenderCodeByCode("2")); //Female
          Assert.notNull(commonService.findGenderCodeByCode("2"), "gendercode is null");
          
          application3.setReligionCode(commonService.findReligionCodeByCode("1")); //Islam
          Assert.notNull(commonService.findReligionCodeByCode("1"), "religioncode is null");
          
          application3.setNationalityCode(commonService.findNationalityCodeByCode("1")); //Warganegara
          Assert.notNull(commonService.findNationalityCodeByCode("1"), "nationalitycode is null");
          
          application3.setRaceCode(commonService.findRaceCodeByCode("0100")); //Melayu
          Assert.notNull(commonService.findRaceCodeByCode("0100"), "racecode is null");
    
          application3.setEthnicityCode(commonService.findEthnicityCodeByCode("0403")); //Minangkabau
          Assert.notNull(commonService.findEthnicityCodeByCode("0403"), "ethnicitycode is null");
          
          application3.setMaritalCode(commonService.findMaritalCodeByCode("1")); //Bujang
          Assert.notNull(commonService.findMaritalCodeByCode("1"), "maritalcode is null");
          
          application3.setDisabilityCode(commonService.findDisabilityCodeByCode("12")); //Tidak cacat
          Assert.notNull(commonService.findDisabilityCodeByCode("12"), "disabilitycode is null");
          
          application3.setResidencyCode(commonService.findResidencyCodeByCode("101")); //no data in seed, created test code in unit
          Assert.notNull(commonService.findResidencyCodeByCode("101"), "residencycode is null");
          
          application3.setApplicant(applicant);
          Assert.notNull(applicant, "applicant is null");
          LOG.debug("intake status : {} ", application3.getBidStatus());
          applicationService.draftIntakeApplication(intake, application3);
          LOG.debug("intake status : {} ", application3.getBidStatus());
         
         
         return self();
         
    }
    
    
    
    public WhenApplicantFillAndSubmitApplication applicant_submit_application() {
             
        	 //submit application 1
        	 
        	 InIntakeApplication application1 = applicationService.findIntakeApplicationByReferenceNo("INTAKE/10001");
  
        	 applicationService.submitIntakeApplication(intake, application1);
        	 
             Assert.notNull(application1, "application is null");
             InBidStatus bidStatus1 = application1.getBidStatus();
             Assert.isTrue(InBidStatus.SUBMITTED.equals(bidStatus1), "application1 is not submitted");
             LOG.debug("intake status : {} ", application1.getBidStatus());
             
        	 //submit application 2
        	 
             InIntakeApplication application2 = applicationService.findIntakeApplicationByReferenceNo("INTAKE/10002");
        	 
        	 applicationService.submitIntakeApplication(intake, application2);
        	 
             Assert.notNull(application2, "application is null");
             InBidStatus bidStatus2 = application2.getBidStatus();
             Assert.isTrue(InBidStatus.SUBMITTED.equals(bidStatus2), "application2 is not submitted");
             LOG.debug("intake status : {} ", application2.getBidStatus());
             
        	 //submit application 3
        	 
             InIntakeApplication application3 = applicationService.findIntakeApplicationByReferenceNo("INTAKE/10003");
        	 
        	 applicationService.submitIntakeApplication(intake, application3);
        	 
             Assert.notNull(application3, "application is null");
             InBidStatus bidStatus3 = application3.getBidStatus();
             Assert.isTrue(InBidStatus.SUBMITTED.equals(bidStatus3), "application2 is not submitted");
             LOG.debug("intake status : {} ", application3.getBidStatus());


            
              
        return self() ;
    }
}

