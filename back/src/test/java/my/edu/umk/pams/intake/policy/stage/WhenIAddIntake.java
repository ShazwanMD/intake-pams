package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.common.model.InGraduateCenter;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeImpl;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIAddIntake extends Stage<WhenIAddIntake> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIAddIntake.class);

    @Autowired
    private PolicyService policyService;

    @ExpectedScenarioState
    private InIntakeSession session;

    @ExpectedScenarioState
    private InGraduateCenter graduateCenter;

    @ProvidedScenarioState
    private InProgramLevel level;

    @ProvidedScenarioState
    private InIntake intake;

    @ProvidedScenarioState
    private String referenceNo;

    public WhenIAddIntake I_add_intake() {
        level = policyService.findProgramLevelByCode("MASTER");

        // start a new intake
        intake = new InIntakeImpl();
        intake.setAuditNo(UUID.randomUUID().toString());
        intake.setDescriptionEn("Intake for Program Master 201720181");
        intake.setProjection(100);
        intake.setStartDate(new Date());
        intake.setEndDate(new Date());
        intake.setSourceNo("MASTER/201720182");
        intake.setProgramLevel(level);
        intake.setSession(session);
        intake.setGraduateCenter(graduateCenter);
        referenceNo = policyService.startIntakeTask(intake);
        return self();
    }
}