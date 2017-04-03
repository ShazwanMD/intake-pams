package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;



import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
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

    @ProvidedScenarioState
    private InIntake intake;

    @ProvidedScenarioState
    InIntakeSession intakeSession;

    @ExpectedScenarioState
    private InApplicant applicant;

    @ProvidedScenarioState
    private InIntakeApplication intakeApplication;

    public WhenFillAllRequiredInformation I_fill_in_all_the_required_information_in_my_application() {

    	intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
    	
        String intakeReferenceNo = "201720181/MASTER";
        InIntake intake = policyService.findIntakeByReferenceNo(intakeReferenceNo);

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
        intakeApplication.setBidStatus(InBidStatus.SELECTED);

//        intakeApplication.setRank();
//        intakeApplication.setMerit();
//        intakeApplication.setCredentialNo();
//        intakeApplication.setPaymentSourceNo();
//        intakeApplication.setAge();
//        intakeApplication.setSchoolBatch();
//        intakeApplication.setBidType();

        applicationService.submitIntakeApplication(intake, intakeApplication);

        return self();
    }
}
