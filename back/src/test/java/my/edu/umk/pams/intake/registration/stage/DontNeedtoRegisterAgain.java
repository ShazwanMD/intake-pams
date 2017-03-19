package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import org.springframework.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

/**
 * @author PAMS
 */
@JGivenStage
public class DontNeedtoRegisterAgain extends Stage<DontNeedtoRegisterAgain> {

	private static final Logger LOG = LoggerFactory.getLogger(DontNeedtoRegisterAgain.class);

	@Autowired
	private RegistrationService registrationService;

	@ExpectedScenarioState
	InUser user;

	@ExpectedScenarioState
	boolean exists;

	public DontNeedtoRegisterAgain dont_need_to_register_again() {

		Assert.isTrue(exists, "yes i have registered before");

		return self();
	}

}