package my.edu.umk.pams.intake.registration;

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

import my.edu.umk.pams.bdd.stage.GivenIAmCandidate;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.registration.stage.ThenAlertAnyChanges;
import my.edu.umk.pams.intake.registration.stage.WhenReceiveConfirmationEmailForRegistration;
import my.edu.umk.pams.intake.application.stage.WhenISubmitApplication;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillAllRequiredInformation;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

/*As a selected applicant(candidate), 
 * I want to receive notification on offering via email broadcast 
 * so that I can be alert of any changes
*/

@Pending
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_RGN_5000 extends SpringScenarioTest <GivenIAmCandidate, WhenIWantToFillAllRequiredInformation, ThenAlertAnyChanges>{
	
private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_5000.class);
	
	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	
	 @Test
	 @Issue("PAMI-96")
	 @Rollback
	 public void scenario1() {
		 given().I_am_candidate_in_current_intake_session()
     	.and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
		 when().I_fill_in_all_the_required_information_in_my_application();
		 addStage(WhenISubmitApplication.class).and().I_submit_application();
		 addStage(WhenReceiveConfirmationEmailForRegistration.class).and().I_receive_confirmation_email();
		 then().alert_any_changes();
	 }
}


