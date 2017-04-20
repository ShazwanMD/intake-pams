package my.edu.umk.pams.intake.registration;


import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.application.stage.WhenISubmitApplication;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.WhenCompleteApplication;
import my.edu.umk.pams.intake.registration.stage.GivenIncompleteApplication;
import my.edu.umk.pams.intake.registration.stage.ThenApplicationComplete;
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
@Submodule("Registration")
@As("As an applicant and i have an incomplete application, I want to complete my application so that my completion is completed")
public class US_IN_RGN_2001 extends SpringScenarioTest<GivenIAmApplicant, WhenCompleteApplication, ThenApplicationComplete> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_2001.class);

    @Test
    @Rollback
    public void scenario1() {
        given().I_am_an_applicant_in_current_intake_session();
            addStage(GivenIncompleteApplication.class).and().i_drafted_an_application();
        when().i_complete_my_application();
            addStage(WhenISubmitApplication.class).and().I_submit_application();
        then().the_application_is_complete();
    }

}
