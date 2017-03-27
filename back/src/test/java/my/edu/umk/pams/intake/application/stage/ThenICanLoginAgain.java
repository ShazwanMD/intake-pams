package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenICanLoginAgain extends Stage<ThenICanLoginAgain> {

    @Autowired
    private ApplicationService applicationService;

    public ThenICanLoginAgain I_can_login_again() {

        return self();
    }
}

