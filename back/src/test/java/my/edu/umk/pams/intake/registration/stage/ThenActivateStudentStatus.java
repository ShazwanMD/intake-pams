package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;

public class ThenActivateStudentStatus extends Stage<ThenActivateStudentStatus> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenActivateStudentStatus.class);
	
	public ThenActivateStudentStatus student_status_is_activated() {
		return self();
	}
		 

}
