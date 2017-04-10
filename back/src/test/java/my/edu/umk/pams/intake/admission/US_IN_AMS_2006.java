package my.edu.umk.pams.intake.admission;

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
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.admission.stage.ThenUpdateReasonToApplicant;
import my.edu.umk.pams.intake.admission.stage.WhenAddReasonForUnSuccessfulApplication;
import my.edu.umk.pams.intake.admission.stage.WhenISubmitApplication;
import my.edu.umk.pams.intake.admission.stage.WhenIWantToFillAllRequiredInformation;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As MGSEB academic Administrator, I want to add reason for unsuccessful application, so that the applicant can view the reason")

public class US_IN_AMS_2006 extends SpringScenarioTest<GivenIAmMGSEBAdministrator,
															WhenIWantToFillAllRequiredInformation,
																		ThenUpdateReasonToApplicant> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_AMS_2006.class);

	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	
	@Test
    @Issue("PAMI-65")
    @Rollback
    public void scenario1() {
		
		 given().I_am_a_MGSEB_administrator_in_current_intake_session();
		 when().I_fill_in_all_the_required_information_in_my_application();    	
		 addStage(WhenISubmitApplication.class).and().I_submit_application();
		 addStage(WhenAddReasonForUnSuccessfulApplication.class).and().add_reason_for_unsuccessful_application();
		// when().add_reason_for_unsuccessful_application();
		 then().unsuccessful_applicant_view_the_reason();
	}
	

}
