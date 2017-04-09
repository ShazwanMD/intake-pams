package my.edu.umk.pams.intake.registration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenApplicantAdvisorIsAssigned;
import my.edu.umk.pams.intake.registration.stage.WhenAssignApplicantAdvisor;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a selected applicant, I want to know who is my applicant advisor so that I can know who inquire about my registration")
public class US_IN_RGN_5002 extends SpringScenarioTest<GivenIAmApplicant,
WhenAssignApplicantAdvisor,ThenApplicantAdvisorIsAssigned> {
	
	@Test
    @Issue("PAMI-98")
    @Rollback
    public void scenario1() {
		given().I_am_an_applicant_in_current_intake_session();
		when().I_want_to_know_my_applicant_advisor();
		then().I_know_who_inquire_my_registration();
	}
	

}
