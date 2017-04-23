package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
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

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenICanChooseFromMultipleSelections extends Stage<ThenICanChooseFromMultipleSelections> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenICanChooseFromMultipleSelections.class);

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

    @ExpectedScenarioState
    private InIntakeSession session;

    @ProvidedScenarioState
    private InIntake intake;


    @ExpectedScenarioState
    private InProgramCode programCodes;

    public ThenICanChooseFromMultipleSelections i_can_choose_from_multiple_selections() {

        InProgramCode programCodes = commonService.findProgramCodeByCode("MAM");
        intake = policyService.findIntakeByReferenceNo(INTAKE_REFERENCE_NO_MGSSEB);
        Assert.notNull(intake, "intake is null");

        InProgramOffering offering = policyService.findProgramOfferingByIntakeAndProgramCode(intake, programCodes);
//todo            policyService.addProgramOffering(intake, offering);


        return self();
    }

}