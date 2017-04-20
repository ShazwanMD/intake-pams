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
import my.edu.umk.pams.intake.registration.stage.ThenSubmitResultOfSelection;
import my.edu.umk.pams.intake.registration.stage.WhenPrepareApplicationSubmission;
import my.edu.umk.pams.intake.registration.stage.WhenPreselectApplicant;
import my.edu.umk.pams.intake.registration.stage.WhenViewListOfSelectedApplicant;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Registration")
@As("As a PPS academic Administrator, "
		+ "I want to broadcast the result of the selection, "
		+ "so that I can submit the result")
public class US_IN_RGN_3005 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenPrepareApplicationSubmission, ThenSubmitResultOfSelection>{
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_3005.class);

	  public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	  private static final String IDENTITY_NO = "248674";
	  
	 
	  	@Test
	    @Rollback
	    @Issue("PAMI-78")
	    public void scenario1() {
	    	given().I_am_a_CPS_administrator_in_current_intake_session()
	    	.and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
	    	when().I_prepare_3_applications().and().I_submit_3_applications();
	        addStage(WhenPreselectApplicant.class).and().I_preselect_applicant_$(IDENTITY_NO);
	        addStage (WhenViewListOfSelectedApplicant.class).and().broadcast_result_of_Selected_Applicant();
	        then().I_can_submit_the_result();
	    }
		
	}
