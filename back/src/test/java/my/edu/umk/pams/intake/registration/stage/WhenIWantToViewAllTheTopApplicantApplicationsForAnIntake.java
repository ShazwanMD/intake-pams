package my.edu.umk.pams.intake.registration.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

@JGivenStage
public class WhenIWantToViewAllTheTopApplicantApplicationsForAnIntake extends Stage <WhenIWantToViewAllTheTopApplicantApplicationsForAnIntake> {
	
	private static final Logger LOG = LoggerFactory.getLogger (WhenIWantToViewAllTheTopApplicantApplicationsForAnIntake.class);

	@ExpectedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InCandidate candidate;
    
    @ExpectedScenarioState
    private InIntake intake;
    
    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
    
    @Autowired
    private ApplicationService applicationService;

	public WhenIWantToViewAllTheTopApplicantApplicationsForAnIntake I_want_to_view_all_the_top_applicant_applications_for_an_intake() {
		
		List<InIntakeApplication> applications  =  applicationService.findIntakeApplications(intake,InBidStatus.APPEAL);
		for (InIntakeApplication intakeApplication : applications) {
			intakeApplication.getName();
			LOG.debug(intakeApplication.getName());
			intakeApplication.getAddresses();
			//LOG.debug(intakeApplication.getAddresses());
			intakeApplication.getEmail();
			LOG.debug(intakeApplication.getEmail());
			
			LOG.debug("intake status {} :", intakeApplication.getBidStatus());
			
		}
		
        return self();

    }
}