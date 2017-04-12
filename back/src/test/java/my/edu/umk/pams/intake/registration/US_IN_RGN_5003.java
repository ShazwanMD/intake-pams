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
import my.edu.umk.pams.bdd.stage.GivenIAmCandidate;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.application.stage.WhenISubmitApplication;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenProceedWithTheRegistration;
import my.edu.umk.pams.intake.registration.stage.WhenAcceptOffer;
import my.edu.umk.pams.intake.registration.stage.WhenApplicantFillTheApplicationAndIsSelected;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a selected applicant, I want to accept the offer, so that I can proceed with my registration")

public class US_IN_RGN_5003 extends SpringScenarioTest<GivenIAmCandidate,
WhenApplicantFillTheApplicationAndIsSelected,ThenProceedWithTheRegistration> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_5003.class);

	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	public static final String IDENTITY_NO = "248674";
	
	@Test
    @Issue("PAMI-99")
    @Rollback
    public void scenario1() {
		
		 given().I_am_candidate_in_current_intake_session()
		 .and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
		 when().Applicant_fill_application_and_then_is_selected().and().applicant_submit_application();
		 addStage(WhenAcceptOffer.class).and().candidate_is_offered_in_intake_session_$(IDENTITY_NO, INTAKE_REFERENCE_NO)
		 .and().I_want_to_accept_offer_$(IDENTITY_NO, INTAKE_REFERENCE_NO);
		 then().I_can_proceed_with_the_registration(IDENTITY_NO);
		
		
	}

}
