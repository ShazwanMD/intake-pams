package my.edu.umk.pams.intake.admission.service;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
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

    @Deprecated
    void processIntake(InIntake intake);

    void preSelectIntakeApplication(InIntakeApplication application);

    void processIntakeSelection(InIntake intake);

    void rejectIntakeApplication(InIntakeApplication application);

    void withdrawSelectedCandidate(InIntake intake, InCandidate candidate);

    void updateSelectedCandidate(InCandidate candidate);

    //====================================================================================================
    // CANDIDATE
    //====================================================================================================

    InCandidate findCandidateByIdentityNo(String identityNo);
    
    InCandidate findCandidateByMatricNo(String matricNo);
    
    InCandidate findCandidateByIntakeApplication(InIntakeApplication intakeApplication);

    List<InCandidate> findCandidates(InIntake intake);

    List<InCandidate> findCandidates(InIntake intake, Integer offset, Integer limit);

    List<InCandidate> findCandidatesByStatus(InIntake intake, InCandidateStatus status);

    Integer countCandidate(InIntake intake);

    Integer countCandidate(InIntake intake, InCandidateStatus candidateStatus);

    // note: still true?? or has it changed?
    void preapproveCandidate(InCandidate candidate);

    void offerCandidate(InCandidate candidate);
    
    void registerCandidate(InCandidate candidate);

    void registerCandidates(InIntake intake, List<InCandidate> candidates);
    
    void broadcastResult(InIntake intake);

	void approveCandidate(InCandidate candidate);

	void preSelectCandidate(InCandidate candidate);

	void selectCandidate(InCandidate candidate);

	void rejectCandidate(InCandidate candidate);

	List<InCandidate> findCandidatesAcceptOffered(InIntake intake, InCandidateStatus status);

	void acceptCandidate(InCandidate candidate);
	
	void declinedCandidate(InCandidate candidate);
	
	boolean isMatricNoExists(String matricNo);

	InCandidate findCandidateById(Long id);



}
