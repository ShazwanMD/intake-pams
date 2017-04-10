package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;



import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.intake.application.model.InBidResponse;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InBidType;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.dao.InApplicantDao;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO;

@JGivenStage
public class WhenFillAllRequiredInformation extends Stage<WhenFillAllRequiredInformation> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenFillAllRequiredInformation.class);

    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private PolicyService policyService;

    @Autowired
    private SystemService systemService;
    
    @Autowired
    private IdentityService identityService;
    
    @ProvidedScenarioState
    private InIntake intake;

    @ProvidedScenarioState
    InIntakeSession intakeSession;

    @ExpectedScenarioState
    private InApplicant applicant;
    
    

    @ProvidedScenarioState
    private InIntakeApplication intakeApplication;

    public WhenFillAllRequiredInformation I_fill_in_all_the_required_information_in_my_application() {

    	
    	InApplicant applicant = new InApplicantImpl(); 
    	//applicant.setActorType(actorType);
    	//applicant.setApplicantApplication(applicantApplication);
    	applicant.setApplicationNo("qwer123");
    	applicant.setEmail("dummyjohn@gmail.com");
    	applicant.setName("john");
    	identityService.saveApplicant(applicant);

    	Assert.notNull(applicant, "applicant is null");
    	
    	
    	
    	intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
    	LOG.debug("test {} :",applicant);
        
        //String intakeReferenceNo = "201720181/MASTER";
        //InIntake intake = policyService.findIntakeByReferenceNo(intakeReferenceNo);

        Assert.notNull(intake, "intake cannot be null");
        Assert.notNull(intakeSession, "intakeSession cannot be null");
       // Assert.notNull(intake.getProgramLevel(), "programLevel cannot be null");

        // generate intake reference no
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("intakeSession", intakeSession);
        map.put("programLevel", intake.getProgramLevel());
        String referenceNo = systemService.generateFormattedReferenceNo(INTAKE_APPLICATION_REFERENCE_NO, map);
        Assert.notNull(referenceNo, "referenceNo cannot be null");

        // start an intakeApplication
        intakeApplication = new InIntakeApplicationImpl();
        
        intakeApplication.setIntake(intake);
        intakeApplication.setReferenceNo(referenceNo);
        intakeApplication.setName("dummy john bin john doe");
        intakeApplication.setEmail("dummyjohn@gmail.com");
        intakeApplication.setPhone("0111020202");
        intakeApplication.setOkuNo("S12223214");
        intakeApplication.setSchoolName("SMKZA");
        intakeApplication.setBidStatus(InBidStatus.PROCESSING);
        intakeApplication.setRank(12);
        //intakeApplication.setMerit();
        intakeApplication.setCredentialNo("248674");
        intakeApplication.setPaymentSourceNo("56468");
        intakeApplication.setAge(26);
        intakeApplication.setSchoolBatch(001);
        intakeApplication.setBidType(InBidType.FIRST);
        intakeApplication.setBidResponse(InBidResponse.NEW);
        intakeApplication.setFax("0945666");
        Assert.notNull(policyService.findStudyModeByCode("1"), "studymode is null");
        intakeApplication.setStudyMode(policyService.findStudyModeByCode("1"));
       // Assert.notNull(intakeApplication, "intakeApplication cannot be null");
        intakeApplication.setApplicant(applicant);
   //     intakeApplication.setProgramSelection(programSelection);
   //     intakeApplication.setSupervisorSelection(SupervisorSelection);
        

        applicationService.draftIntakeApplication(intake, intakeApplication);
        Assert.notNull(intakeApplication, "intakeApplication cannot be null");
        return self();
    }
}
