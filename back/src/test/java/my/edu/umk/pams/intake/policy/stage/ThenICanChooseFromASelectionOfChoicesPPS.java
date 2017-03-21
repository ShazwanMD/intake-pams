package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;


import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenICanChooseFromASelectionOfChoices extends Stage<ThenICanChooseFromASelectionOfChoices> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenICanChooseFromASelectionOfChoices.class);

    @Autowired
    private PolicyService policyService;

    @ExpectedScenarioState
    private InIntakeSession session;

    @ExpectedScenarioState
    private InIntake intake;

    public ThenICanChooseFromASelectionOfChoices i_can_choose_from_selection_of_choices(){

        return self();
    }
}
