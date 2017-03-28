package my.edu.umk.pams.intake.admission;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.intake.admission.stage.ThenICanApprovedTheirApplication;
import my.edu.umk.pams.intake.admission.stage.WhenIWantToSelectSuitableApplicants;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * As academic administrator,
 * I want to select suitable applicants,
 * so that I can approved their application.
 *
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_AMS_1003 extends
        SpringScenarioTest<GivenIAmCPSAdministrator, 
        						WhenIWantToSelectSuitableApplicants, 
        							ThenICanApprovedTheirApplication> {

    @Test
    @Rollback
    public void scenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().I_want_to_select_suitable_applicants();
        then().I_can_approved_their_application();
    }
}


