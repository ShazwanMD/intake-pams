package my.edu.umk.pams.intake.admission.service;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.policy.model.InIntake;

/**
 * @author PAMS
 */
public interface AdmissionService {

    void preapproveCandidate(InCandidate candidate);

    void selectionIntake(InIntake inIntake);

    void preapproveIntakeApplication(InIntakeApplication application);

    void approveIntakeApplication(InIntakeApplication application);

    void rejectIntakeApplication(InIntakeApplication application);

}
