package my.edu.umk.pams.intake.admission.model;

import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.core.InMetaObject;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.model.InSupervisorOffering;

/**
 * @author PAMS
 */
public interface InCandidate extends InMetaObject {

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

    InStudyMode getStudyMode();

    void setStudyMode(InStudyMode studyMode);

    InCandidateStatus getStatus();

    void setStatus(InCandidateStatus status);

    InApplicant getApplicant();

    void setApplicant(InApplicant applicant);

    InIntake getIntake();

    void setIntake(InIntake intake);

    InProgramOffering getProgramSelection();

    void setProgramSelection(InProgramOffering offering);

    InSupervisorOffering getSupervisorSelection();

    void setSupervisorSelection(InSupervisorOffering offering);

	boolean isRegistration();

	void setRegistration(boolean registration);
}
