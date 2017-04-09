package my.edu.umk.pams.intake.registration;

import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSKeraniAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.registration.stage.ThenICanProcessTheirApplication;
import my.edu.umk.pams.intake.registration.stage.WhenIVerifyRefereeStatus;
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
@As("As an academic administrator, I want to know who is applicant's referee so that i can process their application")
public class US_IN_RGN_3003 extends SpringScenarioTest<GivenIAmCPSKeraniAdministrator, WhenIVerifyRefereeStatus, ThenICanProcessTheirApplication> {
    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_3003.class);

    @Autowired
    private RegistrationService registerationservice;

    @Test
    @Rollback
    @Issue("")
    public void scenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().I_verify_applicant_has_referee();
        then().I_can_process_their_application();
    }

    // todo(samiya + ashraf)
    @Pending
    public void testScenario1_pending() {
//		given().I_am_a_administrator_in_current_intake_session_as_$("pps", "abc123");
        // Add additional given
//        additionalStage.and().an_applicant_has_a_referee(applicant);	<-- put assertion(s) inside
        // Perform the behavior
//        when().I_process_the_student_application(); 					<-- put assertion(s) inside
        // Verify the behavior
//        then().the_student_application_is_processed(); 				<-- put assertion(s) inside
    }

}
