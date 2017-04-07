package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenIProgressIntakeProcess;
import my.edu.umk.pams.intake.policy.stage.WhenISetIntakeProjection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As an academic administrator, I want to set the projection for current intake session, so that i can proceed the intake process")
public class US_IN_PLC_2003 extends SpringScenarioTest<GivenIAmCPSAdministrator,
        WhenISetIntakeProjection,
        ThenIProgressIntakeProcess> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_2003.class);

    @Test
    @Rollback
    @Issue("PAMI-9")
    public void testScenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().i_set_projection_for_current_intake();
        then().i_can_progress_the_intake_process();
    }

}
