package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetaObject;

public interface  InProgramCode extends InMetaObject {

    String getCode();

    void setCode(String code);

    String getDescriptionMs();

    void setDescription(String descriptionMs);

	String getDescriptionEn();

	void setDescriptionEn(String descriptionEn);
}
