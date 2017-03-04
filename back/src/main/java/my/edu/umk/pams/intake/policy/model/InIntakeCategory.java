package my.edu.umk.pams.intake.policy.model;

import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * SPM/STPM/O-LEVEL
 * STPM/A-LEVEL
 * DIPLOMA
 * FOUNDATION
 * DEGREE
 * INTERNATIONAL BACCAULERATE
 * OTHERS
 *
 * @author team utamacad
 * @since 3/2/2015.
 */
public interface InIntakeCategory extends InMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);

}
