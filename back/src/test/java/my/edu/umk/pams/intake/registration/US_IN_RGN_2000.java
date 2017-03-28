package my.edu.umk.pams.intake.registration;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.registration.stage.ThenMyNotificationIsQueued;
import my.edu.umk.pams.intake.registration.stage.WhenISignUpToReceiveNotification;
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


//As an anonymous, 
//I want to receive a notification for my sign up process, 
//so that i will know my login status


public class US_IN_RGN_2000 extends SpringScenarioTest<GivenIAmApplicant, WhenISignUpToReceiveNotification, ThenMyNotificationIsQueued> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_2000.class);

    @Autowired
    private RegistrationService registrationService;

    @Test
    @Rollback
    public void scenario1() {
        given().I_am_an_applicant_in_current_intake_session();
        when().I_sign_up_to_receive_notification();
        then().my_notification_is_queued_for_me();
    }
}
 
