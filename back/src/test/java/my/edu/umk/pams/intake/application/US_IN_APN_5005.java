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
import my.edu.umk.pams.intake.application.stage.ThenICanKnowTheDateline;
import my.edu.umk.pams.intake.application.stage.ThenTheApplicationIsWithdrawn;
import my.edu.umk.pams.intake.application.stage.WhenIWantToBeInformedOfTheClosingDate;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillAllRequiredInformation;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillinMultipleInformationOnMyExtraCurricularExperience;
import my.edu.umk.pams.intake.application.stage.WhenWithdrawApplication;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

/**
 * @author PAMS
 * 
 * As a applicant, 
 * I want to withdraw my intake application 
 * so that I can notify UMK that I dont want to apply
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_APN_5005 extends SpringScenarioTest<GivenIAmApplicant, 
WhenIWantToFillAllRequiredInformation, 
ThenTheApplicationIsWithdrawn> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_5005.class);
	
	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	
	    @Test
	    @Issue("PAMI-46")
	    @Rollback(false)
	    public void scenario1() {
	    	given().I_am_an_applicant_in_current_intake_session()
	              .and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
	    	when().I_fill_in_all_the_required_information_in_my_application(); //fill application dulu baru boleh withdraw, klau x nanti null
	    	addStage(WhenWithdrawApplication.class).and().Withdraw_Application();  //withdraw application yg dh diisi tadi
	        then().The_Application_Is_Withdrawn();
	    }

	}