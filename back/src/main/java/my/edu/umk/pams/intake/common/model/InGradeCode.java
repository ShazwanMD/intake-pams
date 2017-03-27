package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * A+,A,A-,B+,B,B-,C+,C,C-,
 */
public interface InGradeCode extends InMetaObject {

    Integer getOrdinal();

    void setOrdinal(Integer ordinal);

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);
}
