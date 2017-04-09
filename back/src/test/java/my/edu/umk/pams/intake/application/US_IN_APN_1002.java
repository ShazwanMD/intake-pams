package my.edu.umk.pams.intake.application;

import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.application.stage.ThenICanPayMyCourseFee;
import my.edu.umk.pams.intake.application.stage.WhenIViewMyCourseFee;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a applicant, I want to view my course fees so that I can know how much I would need to pay")
public class US_IN_APN_1002 extends SpringScenarioTest<GivenIAmApplicant, WhenIViewMyCourseFee, ThenICanPayMyCourseFee> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_1002.class);

    @Autowired
    private ApplicationService applicationService;

    @Test
    @Rollback
    @Issue("PAMI-23")
     public void testScenario1() {
    	//Need to link with account module
    	//Pending  
    	given().I_am_an_applicant_in_current_intake_session();
    	when().I_view_my_course_fee();
        then().I_can_pay_my_course_fee();
    }
}
