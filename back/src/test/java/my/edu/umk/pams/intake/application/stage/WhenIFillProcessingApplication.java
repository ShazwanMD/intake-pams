package my.edu.umk.pams.intake.application.stage;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import my.edu.umk.pams.intake.system.service.SystemService;

@JGivenStage
public class WhenIFillProcessingApplication extends Stage<WhenIFillProcessingApplication> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIFillProcessingApplication.class);
	
	@Autowired
    private ApplicationService applicationService;

    @Autowired
    private SystemService systemService;

    @ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InIntakeSession intakeSession;

    @ExpectedScenarioState
    private InApplicant applicant;

    @ProvidedScenarioState
    private InIntakeApplication intakeApplication;

    public WhenIFillProcessingApplication I_fill_in_processing_application() {
        // generate intake reference no
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("intakeSession", intakeSession);
        map.put("programLevel", intake.getProgramLevel());
        String referenceNo = systemService.generateFormattedReferenceNo(INTAKE_APPLICATION_REFERENCE_NO, map);
        
       // LOG.debug(intake:"");
        
        // start an intakeApplication
        intakeApplication = new InIntakeApplicationImpl();
        intakeApplication.setIntake(this.intake);
        intakeApplication.setReferenceNo(referenceNo);
        intakeApplication.setName("dummy john bin john doe");
        intakeApplication.setEmail("dummyjohn@gmail.com");
        intakeApplication.setPhone("0111020202");
        intakeApplication.setOkuNo("S12223214");
        intakeApplication.setSchoolName("SMKZA");
        intakeApplication.setBidStatus(InBidStatus.PROCESSING);  
        applicationService.draftIntakeApplication(intake, intakeApplication);

        return self();
    }
}


