package my.edu.umk.pams.intake.admission.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;

@JGivenStage
public class ThenICanFilterTheTopApplicant extends Stage<ThenICanFilterTheTopApplicant> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenICanFilterTheTopApplicant.class);

	@Autowired
	private ApplicationService applicationService;
	
	
    @ExpectedScenarioState
    private InCandidate candidate;

    @ExpectedScenarioState
    InIntake intake;
    
    public ThenICanFilterTheTopApplicant I_can_filter_the_top_applicant() {

    	List<InIntakeApplication>  applications =  applicationService.findIntakeApplicationsOrderedByRank(intake);
    	for (InIntakeApplication inIntakeApplication : applications) {
			LOG.debug("rank: " + inIntakeApplication.getRank());
		}

    	// do something
        return self();
    }

}