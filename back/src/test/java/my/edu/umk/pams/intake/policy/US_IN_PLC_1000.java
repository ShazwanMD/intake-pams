package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenIntakeIsReadyForSetup;
import my.edu.umk.pams.intake.policy.stage.WhenIAddIntake;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_PLC_1000 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIAddIntake, ThenIntakeIsReadyForSetup> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_1000.class);

    private String referenceNo;

    @Test
    @Issue("PAMI-3")
    @Rollback
    public void scenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().I_add_intake();
        then().intake_is_ready_for_setup();
    }
}

