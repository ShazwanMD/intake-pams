package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;

public class ThenValidateTheApplication extends Stage<ThenValidateTheApplication>{
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenValidateTheApplication.class);
	
	public ThenValidateTheApplication I_can_validate_the_application() {
		return self();
	}
	

}

	
