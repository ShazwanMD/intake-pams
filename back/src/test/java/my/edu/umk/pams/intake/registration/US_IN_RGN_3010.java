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
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenICanProceedRegistration;
import my.edu.umk.pams.intake.registration.stage.WhenPrepareApplicationSubmission;
import my.edu.umk.pams.intake.registration.stage.WhenVerifyStudyFees;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Registration")
@As("As a CPS academic administrator, I want to verify the study fees, so that I can proceed with the registration")
public class US_IN_RGN_3010 extends SpringScenarioTest<GivenIAmCPSAdministrator,
        WhenPrepareApplicationSubmission,
														ThenICanProceedRegistration>{

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_3010.class);
    private static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
    
    @Test
    @Rollback
    @Pending
    @Issue("PAMI-83")
    public void scenario1() {
   	 
   	 given().I_am_a_CPS_administrator_in_current_intake_session()
        .and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
   	 when().I_prepare_3_applications().and().I_submit_3_applications();
   	 addStage(WhenVerifyStudyFees.class).and().I_want_to_verify_study_fees();
   	 then().I_can_process_applicant_registration(); 
    }


}
