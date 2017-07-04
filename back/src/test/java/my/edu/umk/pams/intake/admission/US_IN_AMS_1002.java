package my.edu.umk.pams.intake.admission;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.admission.stage.ThenICanPreferredTheirApplicationt;
import my.edu.umk.pams.intake.admission.stage.WhenFillAllInformation;
import my.edu.umk.pams.intake.admission.stage.WhenIWantToPreSelectEligibleEndCapableApplicant;
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
@As("As CPS academic administrator, I want to pre-select eligible and capable applicants so that I can preferred their application")
public class US_IN_AMS_1002 extends
        SpringScenarioTest<GivenIAmCPSAdministrator, 
        						WhenFillAllInformation,
        										ThenICanPreferredTheirApplicationt> {

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_AMS_1002.class);
	public static final String INTAKE_REFERENCE_NO = INTAKE_REFERENCE_NO_MGSSEB;
	
    @Test
    @Rollback
    @Issue("PAMI-49")
    public void scenario1() {
    	given().I_am_a_CPS_administrator_in_current_intake_session().and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
        when().Applicant_fill_all_required_information_$(INTAKE_REFERENCE_NO); 
        addStage(WhenIWantToPreSelectEligibleEndCapableApplicant.class).and().I_want_to_pre_select_eligible_and_capable_applicants();
        then().I_can_preferred_their_application();
    } 
}
