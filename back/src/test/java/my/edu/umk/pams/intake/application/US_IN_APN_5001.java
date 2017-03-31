package my.edu.umk.pams.intake.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.application.stage.ThenIntakeHasProgramAvailable;
import my.edu.umk.pams.intake.application.stage.WhenIListIntakeProgramsOffered;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

/**
 * @author PAMS
 * 
 *As a applicant, 
 *I want a list of all the current offered programs, 
 *so that I can view what's available this session
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_APN_5001 extends SpringScenarioTest<GivenIAmApplicant,
        WhenIListIntakeProgramsOffered,
        ThenIntakeHasProgramAvailable> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_5001.class);

    private static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	private static final String PROGRAM_CODE_MCA = "MCA";

    @Test
    @Issue("PAMI-42")
    @Rollback
    public void scenario1() {
    	given().I_am_an_applicant_in_current_intake_session()
              .and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
        when().i_list_current_intake_offered_programs(PROGRAM_CODE_MCA);
        then().intake_has_program_as_available(PROGRAM_CODE_MCA);
    }

}