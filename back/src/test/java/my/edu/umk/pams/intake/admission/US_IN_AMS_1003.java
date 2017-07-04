package my.edu.umk.pams.intake.admission;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.admission.stage.ThenICanApprovedTheirApplication;
import my.edu.umk.pams.intake.admission.stage.WhenFillAllInformation;
import my.edu.umk.pams.intake.admission.stage.WhenIWantToSelectSuitableApplicants;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;


@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Admission")
@As("As CPS administrator, I want to select suitable applicants, so that i can approved their application")
public class US_IN_AMS_1003 extends
        SpringScenarioTest<GivenIAmCPSAdministrator, 
        						WhenFillAllInformation,
        							ThenICanApprovedTheirApplication> {

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_AMS_1003.class);
	public static final String INTAKE_REFERENCE_NO = INTAKE_REFERENCE_NO_MGSSEB;
	
	@Issue("PAMI-50")
    @Test
    @Rollback
    public void scenario1() {
    	given().I_am_a_CPS_administrator_in_current_intake_session().and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
        when().Applicant_fill_all_required_information_$(INTAKE_REFERENCE_NO); 
        addStage(WhenIWantToSelectSuitableApplicants.class).and().I_want_to_select_suitable_applicants();
        then().I_can_approved_their_application();
    }
}


