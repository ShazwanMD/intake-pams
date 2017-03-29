package my.edu.umk.pams.intake.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.application.stage.ThenApplicationIsSubmitted;
import my.edu.umk.pams.intake.application.stage.WhenISubmitApplication;
import my.edu.umk.pams.intake.application.stage.WhenReceiveConfirmationEmail;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

/*As a applicant, 
I want to submit my intake application 
and receive a confirmation via email 
so that I can know my status
*/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_APN_1014 extends SpringScenarioTest <GivenIAmApplicant, WhenISubmitApplication, ThenApplicationIsSubmitted>{
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_1014.class);
	
	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";

	 @Test
	 @Pending
	 @Issue("PAMI-35")
	 @Rollback(false)
	 public void scenario1() {
		 given().I_am_an_applicant_in_current_intake_session()
     	.and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
		 when().I_submit_application();
		 addStage(WhenReceiveConfirmationEmail.class).and().i_receive_confirmation_email();		 
		 then().application_is_submitted();
	 }
}
