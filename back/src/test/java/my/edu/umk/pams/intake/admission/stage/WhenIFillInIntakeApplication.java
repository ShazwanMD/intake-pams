package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

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
public class WhenIFillInIntakeApplication extends Stage<WhenIFillInIntakeApplication> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIFillInIntakeApplication.class);

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private SystemService systemService;
    
    @Autowired
    private PolicyService policyService;

    @ExpectedScenarioState
    private InIntakeSession intakeSession;

    @ExpectedScenarioState
    private InApplicant applicant;
    
    @ProvidedScenarioState
    private InIntake intake;

    @ProvidedScenarioState
    private InIntakeApplication intakeApplication;
    


    public WhenIFillInIntakeApplication I_fill_in_intake_applicaton() {

    	intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
    	
        // start an intakeApplication
        intakeApplication = new InIntakeApplicationImpl();
        intakeApplication.setIntake(intake);
        intakeApplication.setReferenceNo("master123");
        intakeApplication.setName("dummy john bin john doe");
        intakeApplication.setEmail("dummyjohn@gmail.com");
        intakeApplication.setPhone("0111020202");
        intakeApplication.setOkuNo("S12223214");
        intakeApplication.setSchoolName("SMKZA");
        intakeApplication.setBidStatus(InBidStatus.PROCESSING);
        intakeApplication.setPaymentSourceNo("PETRONAS");
        applicationService.draftIntakeApplication(intake, intakeApplication);
        //

        return self();
    }
}
