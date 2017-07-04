package my.edu.umk.pams.intake.admission;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.admission.stage.ThenUpdateReasonToApplicant;
import my.edu.umk.pams.intake.admission.stage.WhenAddReasonForUnSuccessfulApplication;
import my.edu.umk.pams.intake.admission.stage.WhenSubmitApplication;
import my.edu.umk.pams.intake.admission.stage.WhenFillAllInformation;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Admission")
@As("As MGSEB academic Administrator, I want to add reason for unsuccessful application, so that the applicant can view the reason")

public class US_IN_AMS_2006 extends SpringScenarioTest<GivenIAmMGSEBAdministrator,
															WhenFillAllInformation,
																		ThenUpdateReasonToApplicant> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_AMS_2006.class);

	public static final String INTAKE_REFERENCE_NO = INTAKE_REFERENCE_NO_MGSSEB;
	
	@Test
    @Issue("PAMI-65")
    @Rollback
    public void scenario1() {
		
		 given().I_am_a_MGSEB_administrator_in_current_intake_session().and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
	   // .and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
		 when().Applicant_fill_all_required_information_$(INTAKE_REFERENCE_NO);    	
		 addStage(WhenSubmitApplication.class).and().applicant_submit_application();
		 addStage(WhenAddReasonForUnSuccessfulApplication.class).and().I_add_reason_for_unsuccessful_application();
		// when().add_reason_for_unsuccessful_application();
		 then().unsuccessful_applicant_view_the_reason();
	}
	

}
