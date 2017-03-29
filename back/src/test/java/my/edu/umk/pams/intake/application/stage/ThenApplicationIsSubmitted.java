package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;

public class ThenApplicationIsSubmitted extends Stage<ThenApplicationIsSubmitted>{
	private static final Logger LOG = LoggerFactory.getLogger(ThenApplicationIsSubmitted.class);
	
	
	public ThenApplicationIsSubmitted application_is_submitted(){
		return self();
		
	}

}
