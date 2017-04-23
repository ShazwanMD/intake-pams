package my.edu.umk.pams.intake.registration;

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
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.application.stage.ThenICanSubmitMyApplication;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillAllRequiredInformation;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenICanProcessTheirApplication;
import my.edu.umk.pams.intake.registration.stage.WhenApplicantHasReferee;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Registration")
@As("As a MGSEB academic Administrator, I want to know who is applicant's referee, so that i can process their application")
public class US_IN_RGN_4003 extends SpringScenarioTest<GivenIAmMGSEBAdministrator, WhenIWantToFillAllRequiredInformation, ThenICanSubmitMyApplication>{	

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_4003.class);
	
	private String intakeReferenceNo = INTAKE_REFERENCE_NO_MGSSEB;
	
	@Test
    @Rollback
    @Issue("PAMI-87")
	public void scenario1() {
	    	given().I_am_a_MGSEB_administrator_in_current_intake_session()
	    		.and().I_pick_an_intake_$(intakeReferenceNo);
	    	when().I_fill_in_all_the_required_information_in_my_application();
	    	addStage(WhenApplicantHasReferee.class).and().an_applicant_has_referee();    	
	    	then().I_can_submit_my_application();
	    	addStage(ThenICanProcessTheirApplication.class).and().I_can_process_the_application();
	    }
}
