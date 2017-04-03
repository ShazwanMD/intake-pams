package my.edu.umk.pams.intake.registration;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.intake.admission.stage.WhenIFillInIntakeApplication;
import my.edu.umk.pams.intake.admission.stage.WhenIWantToSelectSuitableApplicants;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.registration.stage.ThenICanProceedRegistration;
import my.edu.umk.pams.intake.registration.stage.WhenIVerifySponsorshipStatus;
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
public class US_IN_RGN_3000 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIFillInIntakeApplication, ThenICanProceedRegistration> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_3000.class);

    @Autowired
    private RegistrationService registrationService;

    @Test
    @Rollback
    public void scenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().I_fill_in_intake_applicaton();
        addStage(WhenIVerifySponsorshipStatus.class).and().I_verify_applicant_has_valid_sponsorship_status();
        then().I_can_process_applicant_registration();
    }
}
