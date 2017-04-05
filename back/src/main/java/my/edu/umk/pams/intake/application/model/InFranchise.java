package my.edu.umk.pams.intake.application.model;

import java.util.Date;

import my.edu.umk.pams.intake.core.InMetaObject;

public interface InFranchise extends InMetaObject {
	
    String getPassportNo();
    
    void setPassportNo(String passportNo);
    
    Date getPassportExpiry();
    
    void setPassportExpiry(Date passportExpiry);
    
    String getEntryPassType();
    
    void setEntryPassType(String entryPassType);

    String getNationality();

    void setNationality(String nationality);

    //InIntakeApplication getApplication();

   // void setApplication(InIntakeApplication application);
}
