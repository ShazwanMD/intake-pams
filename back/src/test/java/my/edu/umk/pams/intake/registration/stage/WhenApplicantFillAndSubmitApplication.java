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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
        Assert.notNull(intake, "intake is null");
         
    	//created a residency code
    	InResidencyCode resident = new InResidencyCodeImpl();
    	resident.setCode("101");
    	resident.setDescription("test resident");
    	commonService.saveResidencyCode(resident);
    	LOG.debug("test resident {} :", resident);
    	
    	//created an applicant1
        InApplicant applicant1 = new InApplicantImpl();
        applicant1.setApplicationNo("9999990");
        applicant1.setName("Ahmad Kharizmi bin Khaldun");
        applicant1.setEmail("ibnu_khaldun@gmail.com");
        applicant1.setPhone("0111020202");
        identityService.saveApplicant(applicant1);

    	//created an applicant2
        InApplicant applicant2 = new InApplicantImpl();
        applicant2.setApplicationNo("9999991");
        applicant2.setName("Ahmad Sam bin Khaldun Sam");
        applicant2.setEmail("ahmad_sam@gmail.com");
        applicant2.setPhone("0111020203");
        identityService.saveApplicant(applicant2);

    	//created an applicant3
        InApplicant applicant3 = new InApplicantImpl();
        applicant3.setApplicationNo("9999992");
        applicant3.setName("Siti Samiya bin Khaldun Sam");
        applicant3.setEmail("siti_samiya@gmail.com");
        applicant3.setPhone("0111020204");
        identityService.saveApplicant(applicant3);

         //Application 1
         InIntakeApplication application1 = new InIntakeApplicationImpl();
         application1.setIntake(intake);
         application1.setReferenceNo("INTAKE/10001");
         application1.setName(applicant1.getName());
         application1.setCredentialNo("910607145581");
         application1.setEmail(applicant1.getEmail());
         application1.setPhone(applicant1.getPhone());
         application1.setAge(26);
         application1.setRank(3);
         application1.setMerit(new BigDecimal("2.85"));
         application1.setPaymentSourceNo("0024188");
         application1.setSchoolBatch(2006/2010);
         application1.setSchoolName("SMK Sultan Ismail");
         application1.setBidType(InBidType.FIRST);
         application1.setBidStatus(InBidStatus.NEW);
         application1.setBidResponse(InBidResponse.NEW);
         application1.setOkuNo("S12223214");
         application1.setStudyMode(commonService.findStudyModeByCode("1")); //Full time
		 application1.setGenderCode(commonService.findGenderCodeByCode("1")); // Male
		 application1.setReligionCode(commonService.findReligionCodeByCode("1")); // Islam
		 application1.setNationalityCode(commonService.findNationalityCodeByCode("1")); // Warganegara
		 application1.setRaceCode(commonService.findRaceCodeByCode("0100")); // Melayu
		 application1.setEthnicityCode(commonService.findEthnicityCodeByCode("0100")); // Melayu
		 application1.setMaritalCode(commonService.findMaritalCodeByCode("1")); // Bujang
		 application1.setDisabilityCode(commonService.findDisabilityCodeByCode("12")); // Tidak
		 application1.setResidencyCode(commonService.findResidencyCodeByCode("101")); // no data in seed, created test code for residency in unit
		 application1.setApplicant(applicant1);
		 LOG.debug("intake status : {} ", application1.getBidStatus());
		 
		 applicationService.draftIntakeApplication(intake, application1);
		 Assert.notNull(application1, "application 1 is not drafted");
		 LOG.debug("intake status : {} ", application1.getBidStatus());
         

		  //Application 2
          InIntakeApplication  application2 = new InIntakeApplicationImpl();
          application2.setReferenceNo(INTAKE_APPLICATION_REFERENCE_NO); 
          
          application2.setIntake(intake);
          application2.setReferenceNo("INTAKE/10002");
          application2.setName(applicant2.getName());
          application2.setCredentialNo("910607149913");
          application2.setEmail(applicant2.getEmail());
          application2.setPhone(applicant2.getPhone());
          application2.setAge(25);
          application2.setRank(2);
          application2.setMerit(new BigDecimal("2.80"));
          application2.setPaymentSourceNo("002268sd");
          application2.setSchoolBatch(2006/2012);
          application2.setSchoolName("SMK Sultan Ismail Hash");
          application2.setBidType(InBidType.FIRST);
          application2.setBidStatus(InBidStatus.NEW);
          application2.setBidResponse(InBidResponse.NEW);
          application2.setOkuNo("S17453214");
          application2.setStudyMode(commonService.findStudyModeByCode("1")); //Full time
          application2.setGenderCode(commonService.findGenderCodeByCode("1")); //Male
          application2.setReligionCode(commonService.findReligionCodeByCode("1")); //Islam    
          application2.setNationalityCode(commonService.findNationalityCodeByCode("1")); //Warganegara  
          application2.setRaceCode(commonService.findRaceCodeByCode("0100")); //Melayu
          application2.setEthnicityCode(commonService.findEthnicityCodeByCode("0100")); //Melayu
          application2.setMaritalCode(commonService.findMaritalCodeByCode("1")); //Bujang
          application2.setDisabilityCode(commonService.findDisabilityCodeByCode("12")); //Tidak cacat
          application2.setResidencyCode(commonService.findResidencyCodeByCode("101")); // no data in seed, created test code for residency in unit
          application2.setApplicant(applicant2);
          LOG.debug("intake status : {} ", application2.getBidStatus());
          
          applicationService.draftIntakeApplication(intake, application2);
          Assert.notNull(application2, "applicantion2 is not drafted");
          LOG.debug("intake status : {} ", application2.getBidStatus());
          
          //Application 3
          InIntakeApplication  application3 = new InIntakeApplicationImpl();
          application3.setIntake(intake);
          application3.setReferenceNo("INTAKE/10003");
          application3.setName(applicant3.getName());
          application3.setCredentialNo("870607149913");
          application3.setEmail(applicant3.getEmail());
          application3.setPhone(applicant3.getPhone());
          application3.setAge(30);
          application3.setRank(1);
          application3.setMerit(new BigDecimal("3.80"));
          application3.setPaymentSourceNo("767268sd");
          application3.setSchoolBatch(2003/2009);
          application3.setSchoolName("SMK Sultanah Asma");
          application3.setBidType(InBidType.FIRST);
          application3.setBidStatus(InBidStatus.NEW);
          application3.setBidResponse(InBidResponse.NEW);
          application3.setOkuNo("S17453217874");  
          application3.setStudyMode(commonService.findStudyModeByCode("2")); //Part time  
          application3.setGenderCode(commonService.findGenderCodeByCode("2")); //Female
          application3.setReligionCode(commonService.findReligionCodeByCode("1")); //Islam  
          application3.setNationalityCode(commonService.findNationalityCodeByCode("1")); //Warganegara                
          application3.setRaceCode(commonService.findRaceCodeByCode("0100")); //Melayu   
          application3.setEthnicityCode(commonService.findEthnicityCodeByCode("0403")); //Minangkabau       
          application3.setMaritalCode(commonService.findMaritalCodeByCode("1")); //Bujang
          application3.setDisabilityCode(commonService.findDisabilityCodeByCode("12")); //Tidak cacat
          application3.setResidencyCode(commonService.findResidencyCodeByCode("101")); // no data in seed, created test code for residency in unit
          application3.setApplicant(applicant3);
          LOG.debug("intake status : {} ", application3.getBidStatus());
          
          applicationService.draftIntakeApplication(intake, application3);
          Assert.notNull(application3, "applicantion3 is not drafted");
          LOG.debug("intake status : {} ", application3.getBidStatus());
         

         return self();
    }
    
    
    
    public WhenApplicantFillAndSubmitApplication applicant_submit_application() {

        List<String> referenceNos = Arrays.asList("INTAKE/10001", "INTAKE/10002", "INTAKE/10003");

        //submit each application
        for (String refNo : referenceNos) {
            InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(refNo);
            applicationService.submitIntakeApplication(intake, application);
            Assert.notNull(application, refNo + " application is null");

            InBidStatus bidStatus = application.getBidStatus();
            Assert.isTrue(InBidStatus.SUBMITTED.equals(bidStatus), refNo + "application is not submitted");
            LOG.debug("intake status : {} ", application.getBidStatus());
        }

        return self() ;
    }
}
