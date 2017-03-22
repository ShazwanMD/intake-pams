package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class ThenICanIdentifyEligibleApplicants extends Stage<ThenICanIdentifyEligibleApplicants> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenICanIdentifyEligibleApplicants.class);

    @Autowired
    private PolicyService policyService;

    @ProvidedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InProgramOffering programOffering;

    public ThenICanIdentifyEligibleApplicants I_can_identify_eligible_applicants() {


        //    Assert.notEmpty(programOfferings, "program offering cannot be empty");

        return self();
    }
}
