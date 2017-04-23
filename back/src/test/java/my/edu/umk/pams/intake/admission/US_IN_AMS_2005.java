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
import my.edu.umk.pams.intake.admission.stage.ThenICanSubmitTheApplication;
import my.edu.umk.pams.intake.admission.stage.WhenFillAllInformation;
import my.edu.umk.pams.intake.admission.stage.WhenIWantToReviewApplicationsFlaggedAsAppeal;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Admission")
@As("As MGSEB administrator, I want to review applications flagged as appeal, so that i can submit the application ")
public class US_IN_AMS_2005 extends
        SpringScenarioTest<GivenIAmMGSEBAdministrator,
        						WhenFillAllInformation,
        							ThenICanSubmitTheApplication> {

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_AMS_2005.class);
	public static final String INTAKE_REFERENCE_NO = "MGSEB/201720181/MASTER";
	
	@Issue("PAMI-64")
	@Test
    @Rollback
    public void scenario1() {
        given().I_am_a_MGSEB_administrator_in_current_intake_session().and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
        when().Applicant_fill_all_required_information_$(INTAKE_REFERENCE_NO); 
        addStage(WhenIWantToReviewApplicationsFlaggedAsAppeal.class).and().I_want_to_review_applications_flagged_as_appeal();
        then().I_can_submit_the_application();
	}
}