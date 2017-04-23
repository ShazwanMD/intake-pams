package my.edu.umk.pams.intake.registration;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.admission.stage.WhenIFillInIntakeApplication;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenICanProceedRegistration;
import my.edu.umk.pams.intake.registration.stage.WhenIVerifySponsorshipStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Registration")
@As("As a CPS academic Administrator, I want to view applicant that have sponsorship or not so that i can proceed the applicant's registration")
public class US_IN_RGN_3000 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIFillInIntakeApplication, ThenICanProceedRegistration> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_3000.class);
    
    private String INTAKE_REFERENCE_NO = INTAKE_REFERENCE_NO_MGSSEB;

    @Pending
    @Test
    @Rollback
    @Issue("PAMI-73")
    public void scenario1() {
    	//Test
        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().I_fill_in_intake_applicaton();
        addStage(WhenIVerifySponsorshipStatus.class).and().I_verify_applicant_has_valid_sponsorship_status_in_current_intake_session_$(INTAKE_REFERENCE_NO);
        then().I_can_process_applicant_registration();
    }
}
