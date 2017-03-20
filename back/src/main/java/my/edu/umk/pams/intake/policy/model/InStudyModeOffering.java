package my.edu.umk.pams.intake.policy.model;

import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.core.InMetaObject;

/**
 */
public interface InStudyModeOffering extends InMetaObject {

    InStudyMode getStudyMode();

    void setStudyMode(InStudyMode studyMode);

    InIntake getIntake();

    void setIntake(InIntake intake);

}
