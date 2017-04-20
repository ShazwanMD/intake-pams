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
import my.edu.umk.pams.bdd.stage.GivenIAmRegistrar;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenStudentRegistrationIsConfirmed;
import my.edu.umk.pams.intake.registration.stage.WhenAcademicAdministratorOfferToCandidate;
import my.edu.umk.pams.intake.registration.stage.WhenAcademicAdministratorPreselectApplicant;
import my.edu.umk.pams.intake.registration.stage.WhenActivateStudentAdmission;
import my.edu.umk.pams.intake.registration.stage.WhenPrepareApplicationSubmission;
import my.edu.umk.pams.intake.registration.stage.WhenCandidateAcceptOffer;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Registration")
@As("As a registrar, "
  + "I want to be able to confirm selected applicant admission on registration day, "
  + "so that the applicants are registered")

public class US_IN_RGN_6004 extends SpringScenarioTest<GivenIAmRegistrar, WhenPrepareApplicationSubmission, ThenStudentRegistrationIsConfirmed> {

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_6004.class);
	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	public static final String IDENTITY_NO = "248674";
	
	@Test
    @Rollback
    @Issue("PAMI-105")
    public void scenario1() {
	     given().I_am_a_Registrar_in_current_intake_session()
	     .and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
        when().I_prepare_3_applications().and().I_submit_3_applications();
		addStage(WhenAcademicAdministratorPreselectApplicant.class).and().academic_admin_preselect_applicant_in_intake_session_$(IDENTITY_NO, INTAKE_REFERENCE_NO);
		addStage(WhenAcademicAdministratorOfferToCandidate.class).and().offer_to_candidate_in_intake_session_$(IDENTITY_NO, INTAKE_REFERENCE_NO);
		addStage(WhenCandidateAcceptOffer.class).and().i_accept_offer_$(IDENTITY_NO,INTAKE_REFERENCE_NO);
        addStage(WhenActivateStudentAdmission.class).and().I_want_to_activate_student_during_registration_$(IDENTITY_NO,INTAKE_REFERENCE_NO);
        then().student_registration_is_confirmed();
    }
}