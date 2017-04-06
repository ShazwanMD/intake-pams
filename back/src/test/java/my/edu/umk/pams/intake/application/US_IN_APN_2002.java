package my.edu.umk.pams.intake.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.application.stage.ThenTheApplicationIsWithdrawn;
import my.edu.umk.pams.intake.application.stage.WhenIAmSelectedApplicant;
import my.edu.umk.pams.intake.application.stage.WhenSelectedApplicantWithdrawApplication;
import my.edu.umk.pams.intake.application.stage.WhenWithdrawApplication;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.WhenISetupCompetenciesMatrix;


/*As a selected applicant, 
I want to be able to withdraw my intake application 
so that I can terminate my application
*/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_APN_2002 extends SpringScenarioTest<GivenIAmApplicant, WhenIAmSelectedApplicant, ThenTheApplicationIsWithdrawn>{

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_2002.class);
	
	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	
    @Test
    @Rollback
    @Issue("PAMI-38")
    @Pending
    public void testScenario1() {
    	given().I_am_an_applicant_in_current_intake_session()
    	.and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
    	when().I_am_selected_applicant_in_current_intake_session_$(INTAKE_REFERENCE_NO);    	
    	addStage(WhenSelectedApplicantWithdrawApplication.class).and().Withdraw_Application_in_current_intake_session_$(INTAKE_REFERENCE_NO);
    	then().The_Application_Is_Withdrawn();
    	
    }
}
