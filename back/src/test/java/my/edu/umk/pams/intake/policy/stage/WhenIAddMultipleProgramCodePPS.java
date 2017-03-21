package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;


import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIAddMultipleProgramCodePPS extends Stage<WhenIAddMultipleProgramCodePPS> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIAddIntake.class);

    @Autowired
    private PolicyService policyService;

    @ExpectedScenarioState
    private InIntakeSession session;

    @ProvidedScenarioState
    private InProgramLevel level;

    @ProvidedScenarioState
    private InIntake intake;

    @Pending
    public WhenIAddMultipleProgramCodePPS i_select_multiple_program_code() {

        return self();
    }
}