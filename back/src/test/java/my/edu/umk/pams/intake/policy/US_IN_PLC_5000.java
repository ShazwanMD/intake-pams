package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenCPSProgramsOfferedToIntake;
import my.edu.umk.pams.intake.policy.stage.WhenIOfferCPSProgramsInIntake;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Policy")
@As("As a CPS academic administrator, I want to list CPS programs to be offered in an intake so that I can choose from a selection of choices")
public class US_IN_PLC_5000 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIOfferCPSProgramsInIntake, ThenCPSProgramsOfferedToIntake> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_5000.class);

    @Test
    @Rollback
    @Issue("")
    public void testScenario1() {
        
        String referenceNo = INTAKE_REFERENCE_NO_MGSSEB;

        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().i_list_and_offer_programs_under_CPS_to_intake(referenceNo);
        then().the_CPS_selection_is_available_to_the_intake();
    }
}
