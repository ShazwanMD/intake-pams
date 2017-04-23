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
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillAllRequiredInformation;
import my.edu.umk.pams.intake.application.stage.WhenWithdrawApplication;
import my.edu.umk.pams.intake.application.stage.ThenIFillInInformationAgain;
import my.edu.umk.pams.intake.config.TestAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Application")
@As("As a applicant, I want to cancel my intake application before submission so that I can cancel or start my application process again.")
public class US_IN_APN_1013 extends SpringScenarioTest <GivenIAmApplicant,
WhenIWantToFillAllRequiredInformation, ThenIFillInInformationAgain>{
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_1013.class);
	
	public static final String INTAKE_REFERENCE_NO = "MGSEB/201720181/MASTER";

	 @Test
	 @Issue("PAMI-34")
	 @Rollback
	 public void scenario1() {
		 
		 given().I_am_an_applicant_in_current_intake_session()
         	.and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
		 when().I_fill_in_all_the_required_information_in_my_application();	    	
		 addStage(WhenWithdrawApplication.class).and().Withdraw_Application();		 
	     then().I_can_fill_in_information_in_my_application_again();
		 		 
	 }
}
