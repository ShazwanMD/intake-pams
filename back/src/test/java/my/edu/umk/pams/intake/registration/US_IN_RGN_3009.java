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
import my.edu.umk.pams.intake.registration.stage.ThenICanProceedRegistration;
import my.edu.umk.pams.intake.registration.stage.WhenApplicantFillAndSubmitApplication;
import my.edu.umk.pams.intake.registration.stage.WhenIPickPaidOrUnpaidStatus;
import my.edu.umk.pams.intake.registration.stage.WhenIPreselectApplicant;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a CPS academic administrator, I want to receive proof of payment for matriculation so that I can proceed to the applicant's registration.")
public class US_IN_RGN_3009 extends SpringScenarioTest <GivenIAmCPSAdministrator,WhenApplicantFillAndSubmitApplication, ThenICanProceedRegistration>{
  
    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_3009.class);

      private static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
  
      private static final String IDENTITY_NO = "248674";

      @Test
      @Rollback
      @Issue("PAMI-86")
      public void unpaid() {
    	  
      given().I_am_a_CPS_administrator_in_current_intake_session()
      .and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
      when().I_fill_in_application().and().applicant_submit_application();
      addStage(WhenIPickPaidOrUnpaidStatus.class).and().I_pick_unpaid_status_in_intake_session_$(IDENTITY_NO, INTAKE_REFERENCE_NO);
      then().application_process_cannot_be_proceeded();
      
      }
      
      
      @Test
      @Rollback 
      @Pending
      public void paid() {

          given().I_am_a_CPS_administrator_in_current_intake_session()
          .and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
          when().I_fill_in_application().and().applicant_submit_application();
          addStage(WhenIPickPaidOrUnpaidStatus.class).and().I_pick_paid_status_in_intake_session_$(IDENTITY_NO, INTAKE_REFERENCE_NO);
          addStage(WhenIPreselectApplicant.class).and().I_preselect_applicant_in_intake_session_$(IDENTITY_NO, INTAKE_REFERENCE_NO);
          then().registration_is_matriculated();

      }
  
}