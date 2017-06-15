package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class ThenIProcessTheApplication extends Stage<ThenIProcessTheApplication> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenIProcessTheApplication.class);

	@ExpectedScenarioState
	InIntakeSession intakeSession;

	@ExpectedScenarioState
	private InIntake intake;

	@Autowired
	private ApplicationService applicationService;

	public ThenIProcessTheApplication I_process_application() {

		// todo, findIntakeApplicationByNricNoOrPassportNo in
		// intakeApplicationDaoImpl incomplete ?

		// InIntakeApplication application =
		// applicationService.findIntakeApplicationByNricNoOrPassportNo("910607145581");
		InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo("INTAKE/10001");
		applicationService.selectIntakeApplication(intake, application);
		LOG.debug("intake status {} :", application.getBidStatus());

		return self();
	}
}
