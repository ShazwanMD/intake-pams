package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenIProgressThenIntakeProcess;
import my.edu.umk.pams.intake.policy.stage.WhenISetIntakeProjection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/*As a MGSEB Academic Administrator, 
I want to set the projection for current intake session, 
so that i can proceed the intake process*/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class US_IN_PLC_3003 extends SpringScenarioTest<GivenIAmMGSEBAdministrator, WhenISetIntakeProjection,
        ThenIProgressThenIntakeProcess> {
    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_3003.class);

    @Test
    @Rollback
    @Issue("PAMI-16")
    public void testScenario1() {
        given().I_am_a_MGSEB_administrator_in_current_intake_session();
        when().i_set_projection_for_current_intake();
        then().i_can_progress_the_intake_process();
    }


}
