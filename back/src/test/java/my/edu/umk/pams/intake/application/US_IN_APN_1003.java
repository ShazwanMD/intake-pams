package my.edu.umk.pams.intake.application;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.application.stage.ThenIKnowWhoWillSuperviseMyProject;
import my.edu.umk.pams.intake.application.stage.WhenIChooseMySupervisor;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a applicant, I want to choose my supervisor so that I can know who will supervise my project")
public class US_IN_APN_1003 extends SpringScenarioTest<GivenIAmApplicant, WhenIChooseMySupervisor, ThenIKnowWhoWillSuperviseMyProject> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_1003.class);

    @Autowired
    private ApplicationService applicationService;
    
    public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";

    
    @Test
    @Rollback
    @Issue("PAMI-24")
    public void scenario1() {
    	given().I_am_an_applicant_in_current_intake_session()
        .and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
        when().I_choose_my_supervisor();
        then().I_know_who_will_supervise_my_project();
    }
}

