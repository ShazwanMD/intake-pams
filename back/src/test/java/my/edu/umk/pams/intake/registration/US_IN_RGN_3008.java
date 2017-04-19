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
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.stage.ThenCompleteApplicantRegistration;
import my.edu.umk.pams.intake.registration.stage.WhenPrepareApplicationSubmission;
import my.edu.umk.pams.intake.registration.stage.WhenCollectStudyFeeForMatriculation;
import my.edu.umk.pams.intake.registration.stage.WhenPreselectApplicant;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a CPS academic administrator,  "
		+ "I want to collect study fees for matriculation, "
		+ "so that i can complete the applicant's registration")

public class US_IN_RGN_3008 extends SpringScenarioTest <GivenIAmCPSAdministrator,
        WhenPrepareApplicationSubmission, ThenCompleteApplicantRegistration> {
	

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_3008.class);
	
	private static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	private static final String IDENTITY_NO = "248674";
	
	@Test
    @Rollback
    @Issue("PAMI-81")
    public void scenario1() {
    	
        given().I_am_a_CPS_administrator_in_current_intake_session()
        .and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
        when().I_prepare_3_applications().and().I_submit_3_applications();
	    addStage(WhenPreselectApplicant.class).and().I_preselect_applicant_in_intake_$(IDENTITY_NO, INTAKE_REFERENCE_NO);
	    addStage(WhenCollectStudyFeeForMatriculation.class).and().I_want_to_collect_study_fee_for_matriculation_$(INTAKE_REFERENCE_NO);
	  
        then().I_can_complete_applicant_registration();
    }
}
