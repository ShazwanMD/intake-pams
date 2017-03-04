package my.edu.umk.pams.intake.policy.model;

import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InStudyCenterCode;
import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * todo(uda): program offering children? competency/matrix?
 */
public interface InProgramOffering extends InMetaObject {

    Integer getProjection();

    void setProjection(Integer projection);

    boolean isInterview();

    void setInterview(boolean interview);

    String getGeneralCriteria();

    void setGeneralCriteria(String generalCriteria);

    String getSpecificCriteria();

    void setSpecificCriteria(String specificCriteria);

    InProgramCode getProgramCode();

    void setProgramCode(InProgramCode programCode);

    InStudyCenterCode getStudyCenterCode();

    void setStudyCenterCode(InStudyCenterCode studyCenterCode);

    InIntake getIntake();

    void setIntake(InIntake intake);

}
