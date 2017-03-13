package my.edu.umk.pams.intake.admission.model;

import my.edu.umk.pams.intake.core.InMetaObject;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;

/**
 * @author PAMS
 */
public interface InCandidate extends InMetaObject {

    InApplicant getApplicant();

    void setApplicant(InApplicant applicant);

    InProgramOffering getOffering();

    void setOffering(InProgramOffering offering);

}
