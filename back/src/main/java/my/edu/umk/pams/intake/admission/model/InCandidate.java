package my.edu.umk.pams.intake.admission.model;

import my.edu.umk.pams.intake.core.InMetaObject;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;

/**
 * @author PAMS
 */
public interface InCandidate extends InMetaObject {

    String getEmailAddress = null;
    
    void setEmailAddress(String emailAddress);

	String getName();

    void setName(String name);

    // passport, nricno, army no,
    // police no, govt issued no
    String getIdentityNo();

    void setIdentityNo(String identityNo);

    String getMatricNo();

    void setMatricNo(String matricNo);

    InCandidateStatus getStatus();

    void setStatus(InCandidateStatus status);

    InApplicant getApplicant();

    void setApplicant(InApplicant applicant);

    InProgramOffering getOffering();

    void setOffering(InProgramOffering offering);

	String getEmailAddress();

}
