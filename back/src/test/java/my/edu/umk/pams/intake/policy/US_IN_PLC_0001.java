package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmPPSAdministrator;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenIntakeIsReadyForSetup;
import my.edu.umk.pams.intake.policy.stage.WhenIAddIntake;
import org.junit.After;
import org.junit.Before;
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
public class US_IN_PLC_0001 extends SpringScenarioTest<GivenIAmPPSAdministrator, WhenIAddIntake, ThenIntakeIsReadyForSetup> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_0001.class);

    private String referenceNo;

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(true)
    public void testScenario1() {
        given().I_am_a_PPS_administrator_in_current_intake_session();
        when().I_add_intake();
        then().intake_is_ready_for_setup();
    }
}

