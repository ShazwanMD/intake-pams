package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.core.InMetaObject;

import java.math.BigDecimal;

public interface InGuardian extends InMetaObject {

    String getIdentityNo();

    void setIdentityNo(String noIc);

    String getName();

    void setName(String name);

    BigDecimal getSalary();

    void setSalary(BigDecimal salary);

    InGuardianType getType();

    void setType(InGuardianType type);

    // TODO: occupation
 
    // TODO: commitment

    InIntakeApplication getApplication();

    void setApplication(InIntakeApplication application);

}
