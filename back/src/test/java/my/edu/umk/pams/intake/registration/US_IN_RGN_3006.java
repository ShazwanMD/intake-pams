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
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenActivateStudentStatus;
import my.edu.umk.pams.intake.registration.stage.WhenAcademicAdministratorOfferToCandidate;
import my.edu.umk.pams.intake.registration.stage.WhenAcademicAdministratorPreselectApplicant;
import my.edu.umk.pams.intake.registration.stage.WhenActivateStudentAdmission;
import my.edu.umk.pams.intake.registration.stage.WhenPrepareApplicationSubmission;
import my.edu.umk.pams.intake.registration.stage.WhenCandidateAcceptOffer;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a PPS academic administrator, "
		+ "I want to activate students admission during registration day, "
		+ "so that the student status will be activated")

public class US_IN_RGN_3006 extends  SpringScenarioTest<GivenIAmCPSAdministrator, WhenPrepareApplicationSubmission, ThenActivateStudentStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_3006.class);
	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	public static final String IDENTITY_NO = "248674";
	
	    @Test
	    @Rollback
	    @Issue("PAMI-79")
	    public void scenario1() {
	    	
	        given().I_am_a_CPS_administrator_in_current_intake_session()
	        .and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
            when().I_prepare_3_applications().and().I_submit_3_applications();
			addStage(WhenAcademicAdministratorPreselectApplicant.class).and().academic_admin_preselect_applicant_in_intake_session_$(IDENTITY_NO, INTAKE_REFERENCE_NO);
			addStage(WhenAcademicAdministratorOfferToCandidate.class).and().offer_to_candidate_in_intake_session_$(IDENTITY_NO, INTAKE_REFERENCE_NO);
			addStage(WhenCandidateAcceptOffer.class).and().i_accept_offer_$(IDENTITY_NO,INTAKE_REFERENCE_NO);
	        addStage(WhenActivateStudentAdmission.class).and().I_want_to_activate_student_during_registration_$(IDENTITY_NO,INTAKE_REFERENCE_NO);
	        then().student_status_is_activated();
	    }
	}
