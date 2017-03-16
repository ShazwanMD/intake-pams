package my.edu.umk.pams.intake.policy.model;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.core.InMetaObject;


/**STUDY MODE :-
 			* FULL-TIME
 			* PART-TIME
*/
public interface InStudyMode extends InMetaObject {

	String getStdModeCode();
	
	void setStdModeCode(String stdModeCode);

	
	String getStdModeType();

	void setStdModeType(String stdModeType);
	

	String getStdModeDesc();

	void setStdModeDesc(String stdModeDesc);
	

	InStudyModeType getStdMode();

	void setStdMode(InStudyModeType stdMode);

	InIntakeApplication getApplication();

	void setApplication(InIntakeApplication application);

	void setId(Long id);

	

	
	
	

	

}
