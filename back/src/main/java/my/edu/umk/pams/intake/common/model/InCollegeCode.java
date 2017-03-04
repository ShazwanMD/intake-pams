package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetaObject;

public interface InCollegeCode extends InMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    InCampusCode getCampusCode();

    void setCampusCode(InCampusCode campusCode);

    void setDescription(String description);

}
