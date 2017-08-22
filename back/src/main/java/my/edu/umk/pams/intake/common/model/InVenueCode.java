package my.edu.umk.pams.intake.common.model;

import java.util.Date;

import my.edu.umk.pams.intake.core.InMetaObject;

public interface InVenueCode extends InMetaObject {

    String getCode();

    void setCode(String code);

	Date getRegistrationDate();

	void setRegistrationDate(Date registrationDate);

	String getRegistrationLocation();

	void setRegistrationLocation(String registrationLocation);
	
	String getStartTimeEn();

	void setStartTimeEn(String startTimeEn);
	
	String getStartTimeMs();

	void setStartTimeMs(String startTimeMs);	
	
	String getEndTimeEn();

	void setEndTimeEn(String endTimeEn);	
	
	String getEndTimeMs();

	void setEndTimeMs(String endTimeMs);
	
	

}
