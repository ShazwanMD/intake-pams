package my.edu.umk.pams.intake.admission;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmPPSAdministrator;
import my.edu.umk.pams.intake.admission.stage.ThenICanFilterTheTopApplicant;
import my.edu.umk.pams.intake.admission.stage.WhenISliceAndDiceTopApplicant;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * As academic administrator,
 * I want to slide and dice top applicant for an intake,
 * so that I can filter the top applicants.
 *
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_AMS_1001 extends
        SpringScenarioTest<GivenIAmPPSAdministrator,
                WhenISliceAndDiceTopApplicant,
                ThenICanFilterTheTopApplicant> {

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(true)
    public void scenario1() {
        given().I_am_a_PPS_administrator_in_current_intake_session();
        when().I_slide_and_dice_top_applicant_for_intake();
        then().I_can_filter_the_top_applicant();
    }
}

