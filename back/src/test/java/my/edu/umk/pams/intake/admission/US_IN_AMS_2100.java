package my.edu.umk.pams.intake.admission;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.admission.stage.ThenStartIntakeApplication;
import my.edu.umk.pams.intake.admission.stage.WhenSelectProgramFromList;
import my.edu.umk.pams.intake.application.US_IN_APN_5005;
import my.edu.umk.pams.intake.application.stage.WhenWithdrawApplication;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

/**
 * @author PAMS
 * 
 *  As a applicant, 
 *  I want to select a program from a list of available programs, 
 *  so that I can start my intake application
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_AMS_2100 extends SpringScenarioTest<GivenIAmApplicant,
WhenSelectProgramFromList,
ThenStartIntakeApplication> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_AMS_2100.class);

	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	
		@Test
	    @Issue("PAMI-68")
	    @Rollback
	    public void scenario1() {
			
			given().I_am_an_applicant_in_current_intake_session()
            .and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
			when().Select_Program_From_List(); 
  			then().Start_Intake_Application(); 
		
		}
}
