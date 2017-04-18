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
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenActivateStudentStatus;
import my.edu.umk.pams.intake.registration.stage.WhenActivateStudentAdmission;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a PPS academic administrator, I want to activate students admission during registration day, so that the student status will be activated")

public class US_IN_RGN_3006 extends  SpringScenarioTest<GivenIAmCPSAdministrator, WhenActivateStudentAdmission, ThenActivateStudentStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_3006.class);
	
	    @Test
	    @Rollback
	    @Pending
	    @Issue("PAMI-79")
	    public void scenario1() {
	    	//Test
	        given().I_am_a_CPS_administrator_in_current_intake_session();
	        when().I_want_to_activate_student_during_registration();
	      //  addStage(WhenIVerifySponsorshipStatus.class).and().I_verify_applicant_has_valid_sponsorship_status();
	        then().student_status_is_activated();
	    }
	}

