package my.edu.umk.pams.intake.registration;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmRegistrar;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenProceedRegistrationForSelectedApplicants;
import my.edu.umk.pams.intake.registration.stage.WhenFillInApplication;
import my.edu.umk.pams.intake.registration.stage.WhenFillAllRequiredInformation;
import my.edu.umk.pams.intake.registration.stage.WhenViewListOfSelectedApplicant;

/**
 *As a registrar, 
 *I want to view a list of selected applicant 
 *so that I can proceed with the selected applicants registration progress
 *
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_RGN_6000 extends SpringScenarioTest<GivenIAmRegistrar,WhenFillAllRequiredInformation,ThenProceedRegistrationForSelectedApplicants>{

	  public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	@Issue ("PAMI-101")
    @Test
    @Rollback(false)
    public void scenario1() {
     given().I_am_a_Registrar_in_current_intake_session();
     when().I_fill_in_all_the_required_information_in_my_application();
     addStage (WhenViewListOfSelectedApplicant.class).and().View_List_Of_Selected_Applicant();
     then().Proceed_Registration_For_Selected_Applicants();
}

}
