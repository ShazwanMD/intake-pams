package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * EXAMPLE: KEJURUTERAAN, SAINS SOSIAL, PERAKAUNAN
 **/
public interface InFieldCode extends InMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);
}
