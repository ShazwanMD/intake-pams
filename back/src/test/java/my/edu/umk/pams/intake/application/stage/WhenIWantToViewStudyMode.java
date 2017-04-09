package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InStudyModeOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenIWantToViewStudyMode extends Stage<WhenIWantToViewStudyMode> {

    @Autowired
    private PolicyService policyService;

    @ProvidedScenarioState
    private InIntake intake;

    @ProvidedScenarioState
    private List<InStudyModeOffering> modeOfferings;

    public void I_want_to_view_offered_study_mode_by_intake_$(String intakeReferenceNo) {
        intake = policyService.findIntakeByReferenceNo(intakeReferenceNo);
        modeOfferings = policyService.findStudyModeOfferings(intake);

        Assert.notEmpty(modeOfferings, "mode offering cannot be empty");
    }
}
