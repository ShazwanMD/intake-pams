package my.edu.umk.pams.intake.registration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenGenerateAnOfferLetter;
import my.edu.umk.pams.intake.registration.stage.WhenOfferToCandidate;

/**
 * @author PAMS
 * 
 *  As a MGSEB academic administrator, 
 *  I want to offer a candidate, 
 *  so that candidate ready for next selection phase
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_RGN_4011 extends SpringScenarioTest<GivenIAmMGSEBAdministrator,
WhenOfferToCandidate,
ThenGenerateAnOfferLetter> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_4011.class);

	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	
		@Test
	    @Issue("PAMI-95")
	    @Rollback(false)
	    public void scenario1() {
			given().I_am_a_MGSEB_administrator_in_current_intake_session();
			when().offer_to_candidate_in_current_intake_session_$(INTAKE_REFERENCE_NO);
			then().generate_an_offer_letter();
		}
}
