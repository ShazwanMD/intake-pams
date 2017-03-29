package my.edu.umk.pams.intake.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.application.stage.ThenDraftIsNotSubmitted;
import my.edu.umk.pams.intake.application.stage.WhenIDraftMyIntake;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

/*As a applicant, 
 * I want to be able to pause my intake application 
 * so that I can complete it later before the closing date
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_APN_1010 extends
		SpringScenarioTest<GivenIAmApplicant, WhenIDraftMyIntake, ThenDraftIsNotSubmitted> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_1010.class);
	
	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";

	 @Test
	 @Issue("PAMI-31")
	 @Rollback(true)
	 public void scenario1() {
		 
		 given().I_am_an_applicant_in_current_intake_session()
         	.and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
		 when().I_Draft_My_Intake();	    		 
	     then().I_dont_submit_application();
		 		 
	 }
}
