package my.edu.umk.pams.intake.application.model;

import java.util.Date;

import my.edu.umk.pams.intake.core.InMetaObject;

public interface InFranchise extends InMetaObject {
	
    String getPassportNo();
    
    void setPassportNo(String passport);
    
    Date getPassportExpDate();
    
    void setPassportExpDate(Date passExpDate);
    
    String getImgPassType();
    
    void setImgPassType(String imgPassType);

    //InIntakeApplication getApplication();

   // void setApplication(InIntakeApplication application);
}
