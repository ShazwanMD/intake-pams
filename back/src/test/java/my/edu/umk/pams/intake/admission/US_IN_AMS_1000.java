package my.edu.umk.pams.intake.admission;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.admission.stage.ThenCandidateCanProceedToNextSelectionPhase;
import my.edu.umk.pams.intake.admission.stage.WhenIPreapproveCandidate;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * As academic administrator,
 * I want to preapprove a candidate,
 * so that the candidate can proceed to the next selection stage
 *
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_AMS_1000 extends
        SpringScenarioTest<GivenIAmCPSAdministrator, WhenIPreapproveCandidate, ThenCandidateCanProceedToNextSelectionPhase> {

    @Test
    @Rollback(true)
    @Issue("PAMI-6")
    public void scenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().I_preapprove_candidate();
        then().candidate_can_proceed();
    }
}
