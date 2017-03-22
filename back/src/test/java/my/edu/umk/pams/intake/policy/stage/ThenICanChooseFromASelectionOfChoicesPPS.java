package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PAMS
 */
@JGivenStage

public class ThenICanChooseFromASelectionOfChoicesPPS extends Stage<ThenICanChooseFromASelectionOfChoicesPPS> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenICanChooseFromASelectionOfChoicesPPS.class);

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

    @ExpectedScenarioState
    private InIntakeSession session;

    @ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private List<InProgramCode> programCodes;

    @ExpectedScenarioState
    private List<InProgramOffering> programOfferings;

    public ThenICanChooseFromASelectionOfChoicesPPS i_can_choose_from_selection_of_choices_PPS() {


//todo     programOfferings = (List<InProgramOffering>) policyService.findProgramOfferingByIntakeAndProgramCode(intake, programCode);
// todo     Assert.notEmpty(programOfferings, "program offering cannot be empty");


        programOfferings = new ArrayList<>();
        programCodes.forEach(programCode -> {
            InProgramOffering offering = policyService.findProgramOfferingByIntakeAndProgramCode(intake, programCode);
            programOfferings.add(offering);
        });
        Assert.isTrue(programCodes.size() == programOfferings.size(), "The code & offering count should match");

        return self();
    }

}