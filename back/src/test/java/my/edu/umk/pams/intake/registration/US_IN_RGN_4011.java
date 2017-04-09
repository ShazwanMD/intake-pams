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
import my.edu.umk.pams.intake.admission.stage.WhenIFillApplication;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenCandidateProceedToNextSelectionPhase;
import my.edu.umk.pams.intake.registration.stage.ThenGenerateAnOfferLetter;
import my.edu.umk.pams.intake.registration.stage.WhenISelectTopApplicants;
import my.edu.umk.pams.intake.registration.stage.WhenOfferToCandidate;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a MGSEB academic administrator, I want to offer a candidate, so that candidate ready for next selection phase")
public class US_IN_RGN_4011 extends SpringScenarioTest<GivenIAmMGSEBAdministrator,
WhenIFillApplication,ThenCandidateProceedToNextSelectionPhase> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_4011.class);
	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	
		@Test
	    @Issue("PAMI-95")
	    @Rollback
	    public void scenario1() {
			given().I_am_a_MGSEB_administrator_in_current_intake_session();
		    when().I_fill_in_application();
		    addStage(WhenOfferToCandidate.class).and().offer_to_candidate_in_current_intake_session_$(INTAKE_REFERENCE_NO);
		    then().candidate_can_proceed_next_selection();
		}
}
