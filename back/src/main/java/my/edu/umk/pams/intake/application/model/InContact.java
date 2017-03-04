package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * Contact or Next of Kin
 */
public interface InContact extends InMetaObject {

    InContactType getType();

    void setType(InContactType type);

    String getIdentityNo();

    void setIdentityNo(String noIc);

    String getName();

    void setName(String name);

    InIntakeApplication getApplication();

    void setApplication(InIntakeApplication application);

}
