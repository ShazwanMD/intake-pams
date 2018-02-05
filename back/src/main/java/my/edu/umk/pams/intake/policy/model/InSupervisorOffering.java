package my.edu.umk.pams.intake.policy.model;

import my.edu.umk.pams.intake.common.model.InSupervisorCode;
import my.edu.umk.pams.intake.core.InMetaObject;

/**
 */
public interface InSupervisorOffering extends InMetaObject {

    InSupervisorCode getSupervisorCode();

    void setSupervisorCode(InSupervisorCode supervisorCode);
    
	InProgramLevel getProgramLevel();

	void setProgramLevel(InProgramLevel programLevel);

}
