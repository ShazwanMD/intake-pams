package my.edu.umk.pams.intake.registration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.registration.stage.ThenICanProceedRegistration;
import my.edu.umk.pams.intake.registration.stage.WhenReceiveProofOfPayment;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a CPS academic administrator, I want to receive proof of payment for matriculation so that I can proceed to the applicant�s registration.")
public class US_IN_RGN_3009 extends SpringScenarioTest <GivenIAmCPSAdministrator,WhenReceiveProofOfPayment, ThenICanProceedRegistration>{
	
	  private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_3009.class);

	    @Autowired
	    private RegistrationService registrationService;
	    private String intakeReferenceNo = "201720181/MASTER";

	    @Test
	    @Rollback
	    @Issue("PAMI-86")
	    @Pending
	    public void scenario1() {
	        given().I_am_a_CPS_administrator_in_current_intake_session()
	        .and().I_pick_an_intake_$(intakeReferenceNo);
	        when().receive_proof_of_payment();
	        then().I_can_process_applicant_registration();

	    }
	
}