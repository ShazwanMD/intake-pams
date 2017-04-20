package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;

public class WhenViewApplicationWithInternationalAcademicQualification extends Stage<WhenViewApplicationWithInternationalAcademicQualification>{
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenViewApplicationWithInternationalAcademicQualification.class);
	
	public WhenViewApplicationWithInternationalAcademicQualification I_view_application_with_international_academic_qualification() {
		return self();
	}
	

}
