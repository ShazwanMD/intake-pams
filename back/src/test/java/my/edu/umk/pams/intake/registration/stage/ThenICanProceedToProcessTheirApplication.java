package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ThenICanProceedToProcessTheirApplication extends Stage<ThenICanProceedToProcessTheirApplication> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenICanProceedToProcessTheirApplication.class);

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private ApplicationService applicationService;

    public ThenICanProceedToProcessTheirApplication I_can_proceed_to_process_their_application() {

        return self();
    }
}

