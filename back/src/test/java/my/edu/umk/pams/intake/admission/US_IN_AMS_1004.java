package my.edu.umk.pams.intake.admission;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmPPSAdministrator;
import my.edu.umk.pams.intake.admission.stage.ThenICanInformTheSelectedApplicants;
import my.edu.umk.pams.intake.admission.stage.WhenIWantToSelectSuitableAppealedApplicants;
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
 * As academic administrator,
 * I want to select suitable appealed applicants,
 * so that I can inform the selected applicants.
 *
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_AMS_1004 extends
        SpringScenarioTest<GivenIAmPPSAdministrator,
                WhenIWantToSelectSuitableAppealedApplicants,
                ThenICanInformTheSelectedApplicants> {

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(true)
    public void scenario1() {
        given().I_am_a_PPS_administrator_in_current_intake_session();
        when().I_want_to_select_suitable_appealed_applicants();
        then().I_can_inform_the_selected_applicants();
    }

}
