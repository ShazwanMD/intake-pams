package my.edu.umk.pams.intake.application.model;

import java.util.Date;

import my.edu.umk.pams.intake.core.InMetaObject;

public interface InFranchise extends InMetaObject {
	
	String getF_IdentityNo();

    void setF_IdentityNo(String identityNo);

    String getF_Name();

    void setF_Name(String name);
    
    String getF_PassportNo();
    
    void setF_PassportNo(String passport);
    
    Date getF_PassportExpDate();
    
    void setF_PassportExpDate(Date passExpDate);
    
    String getF_ImgPassType();
    
    void setF_ImgPassType(String imgPassType);
       
    String getF_gender();
    
    void setF_gender(String gender);
    
    Date getF_DOB();
    
    void setF_DOB(Date dob);
    
    String getF_Nationality();
    
    void setF_Nationality(String nationality);
    
    String getF_email();
    
    void setF_email(String email);

    InIntakeApplication getApplication();

    void setApplication(InIntakeApplication application);
}
