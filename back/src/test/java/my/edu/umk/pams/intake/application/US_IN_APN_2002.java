package my.edu.umk.pams.intake.application;

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
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.application.stage.ThenTheApplicationIsWithdrawn;
import my.edu.umk.pams.intake.application.stage.WhenIFillProcessingApplication;
import my.edu.umk.pams.intake.application.stage.WhenSelectedApplicantWithdrawApplication;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;


@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Application")
@As("As a selected applicant, I want to be able to withdraw my intake application so that I can terminate my application")
public class US_IN_APN_2002 extends SpringScenarioTest<GivenIAmApplicant, WhenIFillProcessingApplication, ThenTheApplicationIsWithdrawn>{

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_2002.class);
	private String intakeReferenceNo = INTAKE_REFERENCE_NO_MGSSEB;
	
    @Test
    @Rollback
    @Issue("PAMI-38")
    public void testScenario1() {
    	given().I_am_an_applicant_in_current_intake_session()
    	.and().I_am_applying_for_intake_$(intakeReferenceNo);
    	when().I_fill_in_processing_application();
       	addStage(WhenSelectedApplicantWithdrawApplication.class)
    	.and().Withdraw_Application_in_current_intake_session_$(intakeReferenceNo);
    	then().The_Application_Is_Withdrawn();
   }
}
