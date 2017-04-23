package my.edu.umk.pams.intake.registration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmInternationalOfficer;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenValidateTheApplication;
import my.edu.umk.pams.intake.registration.stage.WhenViewApplicationWithInternationalAcademicQualification;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Registration")
@As("As an International Officer, "
		+ "I want to view applications with an international academic qualification, "
		+ "so that I can validate the application")

public class US_IN_RGN_7000 extends
SpringScenarioTest<GivenIAmInternationalOfficer, WhenViewApplicationWithInternationalAcademicQualification, ThenValidateTheApplication> {
	
	 public static final String INTAKE_REFERENCE_NO = INTAKE_REFERENCE_NO_MGSSEB;
	 
	 @Issue ("PAMI-107")
	 @Test
	 @Rollback
	 public void scenario1() {
		 
		 given().I_am_a_International_Officer_in_current_intake_session()   
		 .and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
		 when().I_view_application_with_international_academic_qualification();
		 then().I_can_validate_the_application();
	 }
	

}
