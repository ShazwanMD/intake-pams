package my.edu.umk.pams.intake.admission;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.admission.stage.ThenICanInformTheSelectedApplicants;
import my.edu.umk.pams.intake.admission.stage.WhenIFillApplication;
import my.edu.umk.pams.intake.admission.stage.WhenIWantToReviewApplicationsFlaggedAsAppeal;
import my.edu.umk.pams.intake.admission.stage.WhenIWantToSelectSuitableAppealedApplicants;
import my.edu.umk.pams.intake.application.US_IN_APN_1001;
import my.edu.umk.pams.intake.application.US_IN_APN_1007;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillinMultipleInformationOnMyWorkingExperience;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
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
@As("As CPS administrator, I want to select suitable appealed applicants, so that i can inform the selected applicants")
public class US_IN_AMS_1004 extends
        SpringScenarioTest<GivenIAmCPSAdministrator,
        						WhenIFillApplication,
                					ThenICanInformTheSelectedApplicants> {
	
	@Issue ("PAMI-51")
    @Test
    @Rollback
    public void scenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session()
        .and().I_pick_an_intake_$("201720181/MASTER");
        when().I_fill_in_application();
        addStage(WhenIWantToSelectSuitableAppealedApplicants.class).and().I_want_to_select_suitable_appealed_applicants();
        //when().I_want_to_select_suitable_appealed_applicants();
        then().I_can_inform_the_selected_applicants();
    }

}
