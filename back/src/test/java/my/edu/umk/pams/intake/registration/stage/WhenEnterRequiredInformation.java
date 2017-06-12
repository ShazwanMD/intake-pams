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
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO;
import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;

@JGivenStage
public class WhenEnterRequiredInformation extends Stage<WhenEnterRequiredInformation> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenEnterRequiredInformation.class);

    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

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

    public WhenEnterRequiredInformation I_enter_information_required_for_application() {
        InApplicant applicant = new InApplicantImpl();
        applicant.setApplicationNo("9999999");
        applicant.setName("dummy john bin john doe");
        applicant.setEmail("dummyjohn@gmail.com");
        applicant.setPhone("0111020202");
        identityService.saveApplicant(applicant);

        intake = policyService.findIntakeByReferenceNo(INTAKE_REFERENCE_NO_MGSSEB);
    	
        //String intakeReferenceNo = INTAKE_REFERENCE_NO_MGSSEB;
        //InIntake intake = policyService.findIntakeByReferenceNo(intakeReferenceNo);

        Assert.notNull(intake, "intake cannot be null");
        Assert.notNull(intakeSession, "intakeSession cannot be null");
       // Assert.notNull(intake.getProgramLevel(), "programLevel cannot be nx``xull");

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
        intakeApplication.setBidStatus(InBidStatus.SELECTED);
        intakeApplication.setRank(12);
        //intakeApplication.setMerit();
        intakeApplication.setCredentialNo("248674");
        intakeApplication.setPaymentSourceNo("56468");
        intakeApplication.setAge(26);
        intakeApplication.setBidType(InBidType.FIRST);
        intakeApplication.setBidResponse(InBidResponse.NEW);
        intakeApplication.setFax("0945666");
        // todo: change to studymodeselection
        // intakeApplication.setStudyMode(commonService.findStudyModeByCode("1"));

//        applicant.setApplicantApplication(Collections.singletonList(intakeApplication));
//        intakeApplication.setApplicant(applicant);

        applicationService.applyIntake(intake, intakeApplication);

        return self();
    }
}
