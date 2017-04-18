package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenActivateStudentAdmission extends Stage<WhenActivateStudentAdmission> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenActivateStudentAdmission.class);
	
	
	 public WhenActivateStudentAdmission I_want_to_activate_student_during_registration() {
		 return self();
	 }

}
