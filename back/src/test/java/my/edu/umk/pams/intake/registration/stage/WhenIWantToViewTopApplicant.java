package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import com.tngtech.jgiven.Stage;

import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;
import my.edu.umk.pams.intake.registration.service.RegistrationService;


public class WhenIWantToViewTopApplicant extends Stage<WhenIWantToViewTopApplicant>{
	private static final Logger LOG = LoggerFactory.getLogger(GivenIAmAdministrator.class);

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private RegistrationService registrationService;
}
