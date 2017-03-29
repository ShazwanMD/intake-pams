package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;

public class WhenReceiveConfirmationEmail extends Stage<WhenReceiveConfirmationEmail>{
	private static final Logger LOG = LoggerFactory.getLogger(WhenReceiveConfirmationEmail.class);
	
	
	
	public WhenReceiveConfirmationEmail i_receive_confirmation_email(){
		return self();
		
	}

}
