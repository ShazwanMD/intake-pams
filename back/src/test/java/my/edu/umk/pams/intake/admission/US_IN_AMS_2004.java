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
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.admission.stage.ThenICanInformTheSelectedApplicants;
import my.edu.umk.pams.intake.admission.stage.WhenFillAllInformation;
import my.edu.umk.pams.intake.admission.stage.WhenIWantToSelectSuitableAppealedApplicants;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Admission")
@As("As MGSEB administrator, I want to select suitable appealed applicants, so that i can inform the selected applicants")
public class US_IN_AMS_2004 extends
        SpringScenarioTest<GivenIAmMGSEBAdministrator,
        						WhenFillAllInformation,
                					ThenICanInformTheSelectedApplicants> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_AMS_2004.class);
	public static final String INTAKE_REFERENCE_NO = "MGSEB/201720181/MASTER";
	
	@Issue ("PAMI-63")
    @Test
    @Rollback
    public void scenario1() {
		given().I_am_a_MGSEB_administrator_in_current_intake_session().and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
        when().Applicant_fill_all_required_information_$(INTAKE_REFERENCE_NO); 
        addStage(WhenIWantToSelectSuitableAppealedApplicants.class).and().I_want_to_select_suitable_appealed_applicants();
        then().I_can_inform_the_selected_applicants();
    }

}