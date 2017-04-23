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
import my.edu.umk.pams.intake.registration.stage.ThenCandidateProceedToNextSelectionPhase;
import my.edu.umk.pams.intake.registration.stage.WhenPrepareApplicationSubmission;
import my.edu.umk.pams.intake.registration.stage.WhenIOfferToCandidate;
import my.edu.umk.pams.intake.registration.stage.WhenPreselectApplicant;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Registration")
@As("As a MGSEB academic administrator, I want to offer a candidate, so that candidate ready for next selection phase")
public class US_IN_RGN_4011 extends SpringScenarioTest<GivenIAmMGSEBAdministrator,
        WhenPrepareApplicationSubmission,ThenCandidateProceedToNextSelectionPhase> {

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_4011.class);
	private static final String INTAKE_REFERENCE_NO = INTAKE_REFERENCE_NO_MGSSEB;
	private static final String IDENTITY_NO = "248674";

		@Test
	    @Issue("PAMI-95")
	    @Rollback
	    public void scenario1() {
	        given().I_am_a_MGSEB_administrator_in_current_intake_session()
	        .and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
			when().I_prepare_3_applications().and().I_submit_3_applications();
		    addStage(WhenPreselectApplicant.class).and().I_preselect_applicant_$(IDENTITY_NO);
		    addStage(WhenIOfferToCandidate.class).and().I_offer_to_candidate_in_intake_session_$(INTAKE_REFERENCE_NO);
		    then().candidate_is_selected(IDENTITY_NO);
		}
}
