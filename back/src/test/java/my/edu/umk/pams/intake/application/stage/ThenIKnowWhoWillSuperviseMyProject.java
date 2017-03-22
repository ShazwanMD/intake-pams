package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenIKnowWhoWillSuperviseMyProject extends Stage<ThenIKnowWhoWillSuperviseMyProject> {

    @Autowired
    private ApplicationService applicationService;

    public ThenIKnowWhoWillSuperviseMyProject I_know_who_will_supervise_my_project() {

        return self();
    }
}

