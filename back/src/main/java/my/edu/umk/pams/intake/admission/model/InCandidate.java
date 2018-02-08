package my.edu.umk.pams.intake.admission.model;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.core.InMetaObject;
import my.edu.umk.pams.intake.core.model.InDocument;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.model.InStudyModeOffering;
import my.edu.umk.pams.intake.policy.model.InSupervisorOffering;

/**
 * @author PAMS
 */
public interface InCandidate extends InMetaObject, InDocument {

	String getName();

    void setName(String name);

    // passport, nricno, army no,
    // police no, govt issued no
    String getIdentityNo();

    void setIdentityNo(String identityNo);

    String getMatricNo();

    void setMatricNo(String matricNo);
  
	String getEmail();

	void setEmail(String email);

    boolean getRegistration();

    void setRegistration(boolean registration);

    // todo: study mode selection
//    InStudyMode getStudyMode();
//
//    void setStudyMode(InStudyMode studyMode);
    
    InStudyModeOffering getStudyModeSelection();
    
    void setStudyModeSelection (InStudyModeOffering offering);

    InCandidateStatus getStatus();

    void setStatus(InCandidateStatus status);

    InIntake getIntake();

    void setIntake(InIntake intake);

    InProgramOffering getProgramSelection();

    void setProgramSelection(InProgramOffering offering);

    InSupervisorOffering getSupervisorSelection();

    void setSupervisorSelection(InSupervisorOffering offering);

	InIntakeApplication getApplication();

	void setApplication(InIntakeApplication application);

	String getReason();

	void setReason(String reason);

	boolean getAcception();

	void setAcception(boolean acception);

}
