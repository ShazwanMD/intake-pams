package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenICanChooseFromMultipleSelections;
import my.edu.umk.pams.intake.policy.stage.WhenIListProgrammes;
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
 *         As a PPS academic administrator
 *         I want to list out the programme
 *         so that applicants can make multiply selection
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_PLC_TEST2 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIListProgrammes, ThenICanChooseFromMultipleSelections> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_TEST2.class);

    @Test
    @Rollback
    @Issue("PAMI-11")
    public void testScenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().i_list_out_programmes();
        then().i_can_choose_from_multiple_selections();
    }
}

