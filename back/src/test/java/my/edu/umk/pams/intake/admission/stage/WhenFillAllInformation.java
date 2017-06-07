package my.edu.umk.pams.intake.admission.stage;

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
import my.edu.umk.pams.intake.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.Map;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO;

@JGivenStage
public class WhenFillAllInformation extends Stage<WhenFillAllInformation> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenFillAllInformation.class);

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

    public WhenFillAllInformation Applicant_fill_all_required_information_$(String intakeReferenceNo) {
        // generate intake reference no
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("intakeSession", intakeSession);
        map.put("programLevel", intake.getProgramLevel());
        String referenceNo = systemService.generateFormattedReferenceNo(INTAKE_APPLICATION_REFERENCE_NO, map);

        // start an intakeApplication
        intakeApplication = new InIntakeApplicationImpl();
        intakeApplication.setIntake(this.intake);
        intakeApplication.setReferenceNo(referenceNo);
        intakeApplication.setName("dummy john doe");
        intakeApplication.setEmail("dummy@gmail.com");
        intakeApplication.setPhone("011102020");
        intakeApplication.setOkuNo("S1222321");
        intakeApplication.setSchoolName("SMKZ1");
        intakeApplication.setBidStatus(InBidStatus.ENTRY);
        applicationService.applyIntake(intake, intakeApplication);
        Assert.notNull(intakeApplication, "intake application is empty");
        LOG.debug("intake appliaction {} :" , intakeApplication);
        return self();
    }
}
