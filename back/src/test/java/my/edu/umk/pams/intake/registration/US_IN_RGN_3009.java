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
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenICanProceedRegistration;
import my.edu.umk.pams.intake.registration.stage.WhenPrepareApplicationSubmission;
import my.edu.umk.pams.intake.registration.stage.WhenPickApplicationsByFeeStatus;
import my.edu.umk.pams.intake.registration.stage.WhenPreselectApplicant;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Registration")
@Issue("PAMI-82")
@As("As a CPS academic administrator, I want to receive proof of payment for matriculation so that I can proceed to the applicant's registration.")
public class US_IN_RGN_3009 extends SpringScenarioTest <GivenIAmCPSAdministrator,WhenPrepareApplicationSubmission, ThenICanProceedRegistration>{
  
    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_3009.class);

      private static final String INTAKE_REFERENCE_NO = "MGSEB/201720181/MASTER";
  
      private static final String IDENTITY_NO = "248674";

      @Test
      @Rollback
      public void unpaid() {
    	  
      given().I_am_a_CPS_administrator_in_current_intake_session()
      .and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
      when().I_prepare_3_applications().and().I_submit_3_applications();
      addStage(WhenPickApplicationsByFeeStatus.class).and().I_pick_unpaid_status_in_intake_session_$(IDENTITY_NO, INTAKE_REFERENCE_NO);
      then().application_process_cannot_be_proceeded();
      
      }
      
      
      @Test
      @Rollback 
      public void paid() {

          given().I_am_a_CPS_administrator_in_current_intake_session()
          .and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
          when().I_prepare_3_applications().and().I_submit_3_applications();
          addStage(WhenPickApplicationsByFeeStatus.class).and().I_pick_paid_applications();
          addStage(WhenPreselectApplicant.class).and().I_preselect_applicant_$(IDENTITY_NO);
          then().registration_is_matriculated();

      }
  
}