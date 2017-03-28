package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
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
 *         As a MGSEB Academic Administrator
 *         I want to configure initiated intake,
 *         so that the applicant can apply the application
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Issue("PAMI-2")
public class US_IN_PLC_1002 extends SpringScenarioTest<GivenIAmMGSEBAdministrator, 
															WhenIAddIntake, 
																ThenIntakeIsReadyForSetup> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_1002.class);

    private String referenceNo;

    @Test
    @Rollback
    public void scenario1() {
        given().I_am_a_MGSEB_administrator_in_current_intake_session();
        when().I_add_intake();
        then().intake_is_ready_for_setup();
    }
}

