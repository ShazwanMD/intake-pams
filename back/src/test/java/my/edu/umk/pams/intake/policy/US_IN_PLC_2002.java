package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenICanIdentifyEligibleApplicants;
import my.edu.umk.pams.intake.policy.stage.WhenIEnterApplicationResult;
import my.edu.umk.pams.intake.policy.stage.WhenISelectApplicant;
import my.edu.umk.pams.intake.policy.stage.WhenISetupCompetenciesMatrix;
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
 *         I want to setup competencies matrix for an intake,
 *         so that I can identify eligible applicants.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Issue("PAMI-8")
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_PLC_2002 extends
        SpringScenarioTest<GivenIAmCPSAdministrator,
                WhenISetupCompetenciesMatrix,
                ThenICanIdentifyEligibleApplicants> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_2002.class);

    private String referenceNo;

    @Test
    @Rollback
    public void testScenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().I_setup_competencies_matrix();
        addStage(WhenIEnterApplicationResult.class).and().I_enter_application_result();
        addStage(WhenISelectApplicant.class).and().I_select_applicant();
        then().I_can_identify_eligible_applicants();
    }

}
