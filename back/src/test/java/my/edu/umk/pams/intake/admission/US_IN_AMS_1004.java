package my.edu.umk.pams.intake.admission;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.admission.stage.ThenICanInformTheSelectedApplicants;
import my.edu.umk.pams.intake.admission.stage.WhenIWantToSelectSuitableAppealedApplicants;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
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
        SpringScenarioTest<GivenIAmCPSAdministrator,
                				WhenIWantToSelectSuitableAppealedApplicants,
                					ThenICanInformTheSelectedApplicants> {

	@Issue ("PAMI-51")
    @Test
    @Rollback
    public void scenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().I_want_to_select_suitable_appealed_applicants();
        then().I_can_inform_the_selected_applicants();
    }

}
