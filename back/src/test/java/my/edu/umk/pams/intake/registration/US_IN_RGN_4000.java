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
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenICanProceedRegistration;
import my.edu.umk.pams.intake.registration.stage.WhenPrepareApplicationSubmission;
import my.edu.umk.pams.intake.registration.stage.WhenIVerifySponsorshipStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Registration")
@As("As a MGSEB academic Administrator, I want to view applicant that have sponsorship or not so that i can proceed the applicant's registration")

public class US_IN_RGN_4000 extends SpringScenarioTest<GivenIAmMGSEBAdministrator, WhenPrepareApplicationSubmission, ThenICanProceedRegistration> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_4000.class);

    private String INTAKE_REFERENCE_NO = "MGSEB/201720181/MASTER";

    @Test
    @Rollback
    @Issue("PAMI-84")
    @Pending
    public void scenario1() {
    	
    	//removed from user story as MGSEB do not have sponsorship
        given().I_am_a_MGSEB_administrator_in_current_intake_session()
        .and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
        when().I_prepare_3_applications().and().I_submit_3_applications();
        addStage(WhenIVerifySponsorshipStatus.class).and().I_verify_applicant_has_valid_sponsorship_status_in_current_intake_session_$(INTAKE_REFERENCE_NO);
  //      addStage(WhenIPreselectApplicant.class).and().I_preselect_applicant_in_intake_session_$(IDENTITY_NO, INTAKE_REFERENCE_NO);
        then().I_can_process_applicant_registration();
    }
}
