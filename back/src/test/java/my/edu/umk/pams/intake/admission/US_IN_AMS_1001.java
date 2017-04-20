package my.edu.umk.pams.intake.admission;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.admission.stage.ThenICanFilterTheTopApplicant;
import my.edu.umk.pams.intake.admission.stage.WhenFillAllInformation;
import my.edu.umk.pams.intake.admission.stage.WhenISliceAndDiceTopApplicant;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Admission")
@As("As CPS administrator, I want to slide and dice top applicant applications for an intake so that I can filter the top applicants")
public class US_IN_AMS_1001 extends
        SpringScenarioTest<GivenIAmCPSAdministrator,
        						WhenFillAllInformation,
                					ThenICanFilterTheTopApplicant> {

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_AMS_1001.class);
	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	
    @Test
    @Rollback
    @Issue("PAMI-48")
    public void scenario1() {
    	given().I_am_a_CPS_administrator_in_current_intake_session().and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
        when().Applicant_fill_all_required_information_$(INTAKE_REFERENCE_NO); 
        addStage(WhenISliceAndDiceTopApplicant.class).I_slide_and_dice_top_applicant_for_intake();
        then().I_can_filter_the_top_applicant();
    }
}

