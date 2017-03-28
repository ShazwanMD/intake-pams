package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@JGivenStage
public class WhenISetIntakeProjection extends Stage<WhenISetIntakeProjection> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenISetIntakeProjection.class);

    @Autowired
    private PolicyService policyService;

    @ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InIntakeSession Session;


    public WhenISetIntakeProjection i_set_projection_for_current_intake() {

        InIntake intake = policyService.findIntakeByReferenceNo("201720181/MASTER");

        //InIntake intk = new InIntakeImpl();

        intake.setProjection(1000);
        intake.setStartDate(new Date());
        intake.setEndDate(new Date());
        policyService.updateIntake(intake);

        return self();

    }
}
