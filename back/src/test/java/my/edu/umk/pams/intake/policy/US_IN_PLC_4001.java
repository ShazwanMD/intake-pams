package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenMGSEBProgramsOfferedToIntake;
import my.edu.umk.pams.intake.policy.stage.WhenIOfferMGSEBProgramsInIntake;
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
@Submodule("Policy")
@As("As a MGSEB academic administrator, I want to list MGSEB programs to be offered in an intake so that I can choose from a selection of choices")
public class US_IN_PLC_4001 extends SpringScenarioTest<GivenIAmMGSEBAdministrator, WhenIOfferMGSEBProgramsInIntake, ThenMGSEBProgramsOfferedToIntake> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_4001.class);

    @Test
    @Rollback
    @Issue("")
    public void testScenario1() {
        
        String referenceNo = "MGSEB/201720181/MASTER";

        given().I_am_a_MGSEB_administrator_in_current_intake_session();
        when().i_list_and_offer_programs_under_MGSEB_to_intake(referenceNo);
        then().the_MGSEB_selection_is_available_to_the_intake();
    }
}
