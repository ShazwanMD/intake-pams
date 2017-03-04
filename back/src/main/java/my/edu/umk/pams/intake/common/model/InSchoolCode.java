package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * SMS,
 * SBP,
 * SBPI,
 * MRSM,
 * SMK,
 * SMAT,
 * SMAP,
 * SMA,
 * SMKA,
 * SMV,
 * SMT,
 * SEKOLAH,
 * KOLEJ
 */
public interface InSchoolCode extends InMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);

}
