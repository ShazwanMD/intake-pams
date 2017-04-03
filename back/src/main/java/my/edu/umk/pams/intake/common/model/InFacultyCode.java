package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetaObject;

public interface InFacultyCode extends InMetaObject {

    String getCode();

    void setCode(String code);

    String getPrefix();

    void setPrefix(String prefix);

    String getDescription();

    void setDescription(String description);

}
