package my.edu.umk.pams.intake.policy.model;


import my.edu.umk.pams.intake.core.InMetaObject;

public interface InIntakeSession extends InMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);

    Boolean isCurrent();

    void setCurrent(Boolean current);
}
