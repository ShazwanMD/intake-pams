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
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.admission.stage.ThenApplicantChooseSupervisor;
import my.edu.umk.pams.intake.admission.stage.WhenAssignSupervisorToApplicant;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;

@Pending
@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Admission")
@As("As CPS academic Administrator, I want to assign supervisor to applicant, so that the applicants can choose their supervisor")
public class US_IN_AMS_1007 extends SpringScenarioTest	<GivenIAmCPSAdministrator,
															WhenAssignSupervisorToApplicant,
																	ThenApplicantChooseSupervisor> {

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_AMS_1007.class);

	public static final String INTAKE_REFERENCE_NO = INTAKE_REFERENCE_NO_MGSSEB;
	private static final String SUPERVISOR_CODE = "SC001"; //Perlu seed data untuk supervisor list
	
	@Test
    @Rollback
    @Issue("PAMI-54")
    public void scenario1() {
			given().I_am_a_CPS_administrator_in_current_intake_session().and().I_pick_an_intake_$(INTAKE_REFERENCE_NO);
			when().I_assign_supervisor_to_applicant(SUPERVISOR_CODE); //Perlu seed data untuk supervisor list
		 	then().applicant_can_choose_the_supervisor();
	}
}