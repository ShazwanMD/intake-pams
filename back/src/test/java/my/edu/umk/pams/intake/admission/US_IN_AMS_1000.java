package my.edu.umk.pams.intake.admission;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.admission.stage.ThenCandidateCanProceedToNextSelectionPhase;
import my.edu.umk.pams.intake.admission.stage.WhenFillAllInformation;
import my.edu.umk.pams.intake.admission.stage.WhenIPreapproveCandidate;
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
@As("As CPS academic administrator, I want to preapprove a candidate so that the candidate can proceed to the next selection stage")
public class US_IN_AMS_1000 extends
        SpringScenarioTest<GivenIAmCPSAdministrator, 
        						WhenFillAllInformation, 
        							ThenCandidateCanProceedToNextSelectionPhase> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_AMS_1002.class);
	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";

    @Test
    @Rollback
    @Issue("PAMI-47")
    public void scenario1() {
    	given().I_am_a_CPS_administrator_in_current_intake_session().and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
        when().Applicant_fill_all_required_information_$(INTAKE_REFERENCE_NO); 
        addStage(WhenIPreapproveCandidate.class).I_preapprove_candidate();
        then().candidate_can_proceed();
    }
}
