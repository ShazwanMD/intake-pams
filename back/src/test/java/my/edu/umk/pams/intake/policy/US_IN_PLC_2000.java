package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenProgramsOfferedToIntake;
import my.edu.umk.pams.intake.policy.stage.WhenIAddPrograms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author PAMS
 *         As a CPS academic administrator,
 *         I want to select multiple program codes
 *         to be offered in an intake so
 *         that I can choose from a selection of choices
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional

@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_PLC_2000 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIAddPrograms, ThenProgramsOfferedToIntake> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_2000.class);

    @Test
    @Rollback
    @Issue("PAMI-5")
    public void testScenario1() {
        List<Data> dataCPS = Data.codesCPS();
        String referenceNo = "201720181/MASTER";

        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().i_add_program_codes(dataCPS)
                .and().i_offer_programs_to_intake(referenceNo);
        then().the_selection_is_available_to_the_intake();
    }
}

