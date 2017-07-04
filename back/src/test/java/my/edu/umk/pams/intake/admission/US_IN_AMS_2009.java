package my.edu.umk.pams.intake.admission;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.admission.stage.ThenICanGenerateAnOfferLetter;
import my.edu.umk.pams.intake.admission.stage.WhenIOfferACandidate;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Admission")
@As("As MGSEB academic administrator, I want to offer a candidate, so that candidate ready for next selection phase")
public class US_IN_AMS_2009 extends SpringScenarioTest<GivenIAmMGSEBAdministrator,
															WhenIOfferACandidate,
																ThenICanGenerateAnOfferLetter> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_AMS_2009.class);

	public static final String INTAKE_REFERENCE_NO = INTAKE_REFERENCE_NO_MGSSEB;
	
		@Test
	    @Issue("PAMI-XX")
	    @Rollback
	    public void scenario1() {
			given().I_am_a_MGSEB_administrator_in_current_intake_session();
			when().I_offer_a_candidate_in_current_intake_session_$(INTAKE_REFERENCE_NO);
			then().I_can_generate_an_offer_letter_in_current_intake_session_$(INTAKE_REFERENCE_NO);
		}
}