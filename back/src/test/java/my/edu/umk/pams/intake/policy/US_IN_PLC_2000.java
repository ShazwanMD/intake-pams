package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmPPSAdministrator;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenICanChooseFromASelectionOfChoicesPPS;
import my.edu.umk.pams.intake.policy.stage.ToBeOfferedInAnIntakePPS;
import my.edu.umk.pams.intake.policy.stage.WhenIAddMultipleProgramCodePPS;
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
 *         As a PPS academic administrator,
 *         I want to select multiple program codes
 *         to be offered in an intake
 *         so that I can choose from a selection of choices
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_PLC_2000 extends SpringScenarioTest<GivenIAmPPSAdministrator, WhenIAddMultipleProgramCodePPS, ThenICanChooseFromASelectionOfChoicesPPS> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_2000.class);

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
        when().i_select_multiple_program_code();
        addStage(ToBeOfferedInAnIntakePPS.class).and().i_offer_an_intake();
        then().i_can_choose_from_selection_of_choices();
    }
}

