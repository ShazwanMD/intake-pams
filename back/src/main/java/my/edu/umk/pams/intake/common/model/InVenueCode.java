package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetaObject;

public interface InVenueCode extends InMetaObject {

    String getCode();

    void setCode(String code);

	String getRegistrationDate();

	void setRegistrationDate(String registrationDate);

	String getRegistrationLocation();

	void setRegistrationLocation(String registrationLocation);
	
	

}
