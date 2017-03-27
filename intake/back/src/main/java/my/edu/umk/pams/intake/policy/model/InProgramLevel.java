package my.edu.umk.pams.intake.policy.model;

import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * DIPLOMA
 * FOUNDATION
 * DEGREE
 * MASTER
 * PHD
 * OTHERS
 *
 * @author PAMS
 */
public interface InProgramLevel extends InMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);

}
