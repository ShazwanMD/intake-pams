package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenICanIdentifyEligibleApplicants;
import my.edu.umk.pams.intake.policy.stage.WhenIWantToSetupCompetenciesMatrix;
import my.edu.umk.pams.intake.policy.stage.WhenIfillInApplicationResult;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/*As a MGSEB academic administration, 
I want to setup competencies matrix for an intake 
so that I can identify eligible applicants
*/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_PLC_3002 extends SpringScenarioTest<GivenIAmMGSEBAdministrator, WhenIWantToSetupCompetenciesMatrix, ThenICanIdentifyEligibleApplicants> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_3002.class);

    @Test
    @Rollback
    @Issue("PAMI-15")
    public void testScenario1() {
        given().I_am_a_MGSEB_administrator_in_current_intake_session();
        when().I_want_to_setup_competencies_matrix();
        addStage(WhenIfillInApplicationResult.class).and().I_fill_in_application_result();
        then().I_can_identify_eligible_applicants();
    }
}