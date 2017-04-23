package my.edu.umk.pams.intake.application;

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
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.application.stage.ThenApplicationIsSubmitted;
import my.edu.umk.pams.intake.application.stage.WhenISubmitApplication;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillAllRequiredInformation;
import my.edu.umk.pams.intake.application.stage.WhenReceiveConfirmationEmailForApplication;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Application")
@As("As a applicant, I want to submit my intake application and receive a confirmation via email so that I can know my status")
public class US_IN_APN_1014 extends SpringScenarioTest <GivenIAmApplicant, WhenIWantToFillAllRequiredInformation, ThenApplicationIsSubmitted>{
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_1014.class);
	
	public static final String INTAKE_REFERENCE_NO = INTAKE_REFERENCE_NO_MGSSEB;

	 @Test
	 @Issue("PAMI-35")
	 @Rollback
	 public void scenario1() {
		 given().I_am_an_applicant_in_current_intake_session()
     	.and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
		 when().I_fill_in_all_the_required_information_in_my_application();
		 addStage(WhenISubmitApplication.class).and().I_submit_application();
		 addStage(WhenReceiveConfirmationEmailForApplication.class).and().I_receive_confirmation_email();
		 then().application_is_submitted();
	 }
}
