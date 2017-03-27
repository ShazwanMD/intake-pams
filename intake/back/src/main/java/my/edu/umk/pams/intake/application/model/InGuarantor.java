package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.core.InMetaObject;

public interface InGuarantor extends InMetaObject {

    String getIdentityNo();

    void setIdentityNo(String noIc);

    String getName();

    void setName(String name);

    InGuarantorType getType();

    void setType(InGuarantorType type);

    InIntakeApplication getApplication();

    void setApplication(InIntakeApplication application);

}
