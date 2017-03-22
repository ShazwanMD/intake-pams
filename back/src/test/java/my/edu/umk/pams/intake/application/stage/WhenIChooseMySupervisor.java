package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIChooseMySupervisor extends Stage<WhenIChooseMySupervisor> {

    @Autowired
    private ApplicationService applicationService;


    public WhenIChooseMySupervisor I_choose_my_supervisor() {
        return self();
    }

}

