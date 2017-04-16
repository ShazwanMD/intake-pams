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
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.admission.stage.ThenApplicantChooseSupervisor;
import my.edu.umk.pams.intake.admission.stage.ThenInternationalApplicantIsDeclared;
import my.edu.umk.pams.intake.admission.stage.WhenAssignSupervisorToApplicant;
import my.edu.umk.pams.intake.admission.stage.WhenIDeclareInternationalApplicant;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

@Pending
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As CPS academic Administrator, I want to declare international student'ss application, so that i can identify their application")
public class US_IN_AMS_1008 extends SpringScenarioTest	<GivenIAmCPSAdministrator, WhenIDeclareInternationalApplicant, ThenInternationalApplicantIsDeclared> {

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_AMS_1008.class);

	//public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	//private static final String SUPERVISOR_CODE = "SC001"; //Perlu seed data untuk supervisor list
	
	@Test
    @Rollback
    @Issue("PAMI-54")
    public void scenario1() {
			given().I_am_a_CPS_administrator_in_current_intake_session();
			when().I_declare_international_applicant();
		 	then().international_applicant_is_declared();
	}
}