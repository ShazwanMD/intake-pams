package my.edu.umk.pams.intake.application.stage;

import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.service.ApplicationService;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenICanLoginAgain extends Stage<ThenICanLoginAgain> {

	 @Autowired
	    private ApplicationService applicationService;

	    public ThenICanLoginAgain I_can_login_again() {
	      
	        return self();
	    }
}

