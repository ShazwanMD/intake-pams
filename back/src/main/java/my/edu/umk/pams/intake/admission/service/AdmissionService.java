package my.edu.umk.pams.intake.admission.service;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.policy.model.InIntake;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdmissionService {

    //====================================================================================================
    // INTAKE, INTAKE APPLICATION
    //====================================================================================================

     void processIntake(InIntake intake);

    void preselectIntakeApplication(InIntakeApplication application);

    void rejectIntakeApplication(InIntakeApplication application);
    
    void withdrawSelectedCandidate(InIntake intake, InCandidate candidate); 
    
    void updateSelectedCandidate(InCandidate candidate);

    //====================================================================================================
    // CANDIDATE
    //====================================================================================================

    InCandidate findCandidateByIdentityNo(String identityNo);

    List<InCandidate> findCandidates(InIntake intake);

    List<InCandidate> findCandidates(InIntake intake, Integer offset, Integer limit);

    void preapproveCandidate(InCandidate candidate);

    void offerCandidate(InCandidate candidate);

}
