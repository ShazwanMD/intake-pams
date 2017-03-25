package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenICanChooseFromASelectionOfChoicesPPS;
import my.edu.umk.pams.intake.policy.stage.ToBeOfferedInAnIntakePPS;
import my.edu.umk.pams.intake.policy.stage.WhenIAddMultipleProgramCodePPS;
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
 *         to be offered in an intake so
 *         that I can choose from a selection of choices
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional

@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_PLC_2000 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIAddMultipleProgramCodePPS, ThenICanChooseFromASelectionOfChoicesPPS> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_2000.class);

    @Test
    @Rollback(true)
    @Issue("PAMI-5")
    public void testScenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().i_add_multiple_program_code_PPS();
        addStage(ToBeOfferedInAnIntakePPS.class).and().i_offer_in_an_intake_PPS();
        then().i_can_choose_from_selection_of_choices_PPS();
    }
}

