package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.core.InMetaObject;

public interface InReferee extends InMetaObject {

    /**
     *
     * @return
     */
    String getName();

    void setName(String name);

    /**
     *
     * @return
     */
    InIntakeApplication getApplication();

    void setApplication(InIntakeApplication application);
    
   /*   
	String getOfficeAddrs();

	void setOfficeAddrs(String officeAddrs);
	
	String getOccupation();

	void setOccupation(String occupation);

	String getPhoneNo();

	void setPhoneNo(String phoneNo);
	
	void setType(InRefereeType type);
	  InRefereeType getType();*/

}
