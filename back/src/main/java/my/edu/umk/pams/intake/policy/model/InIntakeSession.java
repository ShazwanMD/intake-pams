package my.edu.umk.pams.intake.policy.model;


import my.edu.umk.pams.intake.core.InMetaObject;

public interface InIntakeSession extends InMetaObject {

    String getCode();

    void setCode(String code);

    String getLabel();

    void setLabel(String label);

    String getDescriptionEn();

    void setDescriptionEn(String descriptionEn);

    String getDescriptionMs();

    void setDescriptionMs(String descriptionMs);

    Boolean isCurrent();

    void setCurrent(Boolean current);

	int getYear();

	void setYear(int year);
}
