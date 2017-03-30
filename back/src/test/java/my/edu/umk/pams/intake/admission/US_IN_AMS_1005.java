package my.edu.umk.pams.intake.admission;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.admission.stage.ThenICanSubmitTheApplication;
import my.edu.umk.pams.intake.admission.stage.WhenIFillApplication;
import my.edu.umk.pams.intake.admission.stage.WhenIWantToReviewApplicationsFlaggedAsAppeal;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillinMultipleInformationOnMyExtraCurricularExperience;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

/**
 * As academic administrator,
 * 	I want to review applications flagged as appeal, 
 *  	so that i can submit the application
 * 
 * @author PAMS
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_AMS_1005 extends
        SpringScenarioTest<GivenIAmCPSAdministrator,
        						WhenIFillApplication,
        							ThenICanSubmitTheApplication> {

	@Issue("PAMI-52")
	@Test
    @Rollback(false)
    public void scenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session()
        .and().I_pick_an_intake_$("201720181/MASTER");
        when().I_fill_in_application();
        addStage(WhenIWantToReviewApplicationsFlaggedAsAppeal.class).and().I_want_to_review_applications_flagged_as_appeal();
        then().I_can_submit_the_application();
	}
}
