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
import my.edu.umk.pams.bdd.stage.GivenIAmCandidate;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenProceedCandidateRegistration;
import my.edu.umk.pams.intake.registration.stage.WhenAcademicAdministratorOfferToCandidate;
import my.edu.umk.pams.intake.registration.stage.WhenAcademicAdministratorPreselectApplicant;
import my.edu.umk.pams.intake.registration.stage.WhenApplicantFillAndSubmitApplication;
import my.edu.umk.pams.intake.registration.stage.WhenCandidateAcceptOffer;
import my.edu.umk.pams.intake.registration.stage.WhenIOfferToCandidate;
import my.edu.umk.pams.intake.registration.stage.WhenIPreselectApplicant;



@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As(" As a selected applicant, I want to accept the offer, so that I can proceed with my registration")
public class US_IN_RGN_5003 extends SpringScenarioTest<GivenIAmCandidate,
WhenApplicantFillAndSubmitApplication,ThenProceedCandidateRegistration> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_5003.class);

	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	public static final String IDENTITY_NO = "248674";
	
	
	@Test
    @Issue("PAMI-99")
    @Rollback
    
    public void scenario1() {

		 given().I_am_candidate_in_current_intake_session()
		 .and().I_applied_for_intake_$(INTAKE_REFERENCE_NO);
		 when().I_fill_in_application().and().applicant_submit_application();
		 addStage(WhenAcademicAdministratorPreselectApplicant.class).and().academic_admin_preselect_applicant_in_intake_session_$(IDENTITY_NO, INTAKE_REFERENCE_NO);
		 addStage(WhenAcademicAdministratorOfferToCandidate.class).and().offer_to_candidate_in_intake_session_$(IDENTITY_NO, INTAKE_REFERENCE_NO);
		 addStage(WhenCandidateAcceptOffer.class).and().i_accept_offer_$(IDENTITY_NO,INTAKE_REFERENCE_NO);
		 then().I_can_proceed_with_the_registration(IDENTITY_NO);
	}

} 