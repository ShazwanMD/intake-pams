package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */

@JGivenStage
public class ThenICanPayMyCourseFee extends Stage<ThenICanPayMyCourseFee> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenICanChooseStudyMode.class);

    @Autowired
    private ApplicationService applicationService;

    @ExpectedScenarioState
    private InUser user;

    public ThenICanPayMyCourseFee I_can_pay_my_course_fee() {
        return self();
    }
}

