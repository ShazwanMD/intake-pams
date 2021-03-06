package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InStudyModeOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class ThenICanChooseStudyMode extends Stage<ThenICanChooseStudyMode> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenICanChooseStudyMode.class);

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

    @ExpectedScenarioState
    private InIntakeSession session;

    @ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private List<InStudyModeOffering> modeOfferings;

    public ThenICanChooseStudyMode I_can_choose_offered_study_mode() {
        for (InStudyModeOffering modeOffering : modeOfferings) {
        	//need to add study mode in studymode offering
        	modeOffering.setStudyMode(commonService.findStudyModeByCode("1"));
        	policyService.addStudyModeOffering(intake, modeOffering);
        	
            InStudyMode studyMode = modeOffering.getStudyMode();
            LOG.debug("studyMode available: {} {}", studyMode.getCode(), studyMode.getDescriptionMs());
        }

   //     Assert.notEmpty(modeOfferings, "mode offering cannot be empty");
        return self();
    }
}
