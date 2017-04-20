package my.edu.umk.pams.intake.registration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenICanProceedToProcessTheirApplication;
import my.edu.umk.pams.intake.registration.stage.WhenPrepareApplicationSubmission;
import my.edu.umk.pams.intake.registration.stage.WhenISelectTopApplicants;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Registration")
@As("As a MGSEB academic Administrator, I want to view all the top applicant applications for an intake so that I can proceed to process their application")
public class US_IN_RGN_4002 extends SpringScenarioTest<GivenIAmMGSEBAdministrator,
        WhenPrepareApplicationSubmission,
														ThenICanProceedToProcessTheirApplication> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_4002.class);

    private String intakeReferenceNo = "201720181/MASTER";

    @Test
    @Rollback
    @Issue("PAMI-86")
    public void scenario1() {
        given().I_am_a_MGSEB_administrator_in_current_intake_session()
        .and().I_pick_an_intake_$(intakeReferenceNo);
        when().I_prepare_3_applications().and().I_submit_3_applications();
        addStage(WhenISelectTopApplicants.class).and().I_select_top_applicants();
        then().I_can_proceed_to_process_their_application();
    }
}
