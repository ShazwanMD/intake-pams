package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author PAMS
 **/
@JGivenStage
public class ThenIntakeHasProgramAvailable extends Stage<ThenIntakeHasProgramAvailable> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenIntakeHasProgramAvailable.class);

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

    @ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private List<InProgramOffering> programOfferings;


    public ThenIntakeHasProgramAvailable intake_has_program_as_available(String programCode) {

        InProgramCode myProgramCode = commonService.findProgramCodeByCode(programCode);
        Assert.notNull(myProgramCode, "programCode cannot be null");

        InProgramOffering programOffering = policyService.findProgramOfferingByIntakeAndProgramCode(intake, myProgramCode);
        Assert.notNull(programOffering, "programOffering cannot be null");

        return self();
    }

}