package my.edu.umk.pams.intake.registration;

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
import my.edu.umk.pams.bdd.stage.GivenIAmCandidate;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.application.stage.WhenISubmitApplication;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillAllRequiredInformation;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenAlertAnyChanges;
import my.edu.umk.pams.intake.registration.stage.WhenReceiveNotificationOnRegistrationDate;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Registration")
@As("As a selected applicant, I want to receive notification on registration date and itineraries so that I can be alert about my registration")
public class US_IN_RGN_5001 extends SpringScenarioTest<GivenIAmCandidate,
											WhenIWantToFillAllRequiredInformation,
														ThenAlertAnyChanges> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_5000.class);

	public static final String INTAKE_REFERENCE_NO = INTAKE_REFERENCE_NO_MGSSEB;
	
	 @Test
	 @Issue("PAMI-97")
	 @Rollback
	 public void scenario1()  {
	
		 given().I_am_candidate_in_current_intake_session()
		 .and().I_applied_for_intake_$(INTAKE_REFERENCE_NO);
		 when().I_fill_in_all_the_required_information_in_my_application();
		 addStage(WhenISubmitApplication.class).and().I_submit_application();
		 addStage(WhenReceiveNotificationOnRegistrationDate.class).and().I_receive_notification_on_registration_date();
		 then().alert_any_changes();
	 }
}

