package my.edu.umk.pams.intake.admission;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.intake.admission.stage.ThenICanPreferredTheirApplicationt;
import my.edu.umk.pams.intake.admission.stage.WhenIWantToPreSelectEligibleEndCapableApplicant;
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
 * As academic administrator, so that their application are preferred
 * I want to pre-select eligible and capable applicants,
 * so that I can preferred their application.
 *
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_AMS_1002 extends
        SpringScenarioTest<GivenIAmCPSAdministrator, WhenIWantToPreSelectEligibleEndCapableApplicant, ThenICanPreferredTheirApplicationt> {

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(true)
    public void scenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().I_want_to_pre_select_eligible_and_capable_applicants();
        then().I_can_preferred_their_application();
    }
}
