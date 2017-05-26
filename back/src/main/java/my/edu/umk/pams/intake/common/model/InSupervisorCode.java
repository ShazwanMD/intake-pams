package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetaObject;

public interface InSupervisorCode extends InMetaObject {

    String getCode();

    void setCode(String code);

    String getName();

    void setName(String name);

    String getDescriptionMs();

    void setDescriptionMs(String descriptionMs);

	String getDescriptionEn();

	void setDescriptionEn(String descriptionEn);

}
