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
	String getOfficeAddrs();

	void setOfficeAddrs(String officeAddrs);

	/**
	 *
	 * @return
	 */
	String getOccupation();

	void setOccupation(String occupation);

	/**
	 *
	 * @return
	 */
	String getPhoneNo();

	void setPhoneNo(String phoneNo);

	/**
	 *
	 * @param type
	 */
	void setType(InRefereeType type);
	
	InRefereeType getType();

	/**
	 *
	 * @return
	 */
	InIntakeApplication getApplication();

	void setApplication(InIntakeApplication application);


}
