package my.edu.umk.pams.intake.admission.dao;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.policy.model.InIntake;

import java.util.List;

/**
 * @author PAMS
 */
public interface InCandidateDao extends GenericDao<Long, InCandidate> {

    InCandidate findByIdentityNo(String identityNo);
    
    List<InCandidate> findCandidateByStatus(InIntake intake, InCandidateStatus status);

    List<InCandidate> find(InIntake intake);

    List<InCandidate> find(InIntake intake, Integer offset, Integer limit);
    
    List<InCandidate> find(InIntake intake, InCandidateStatus status);
    
    void updateCandidate (InIntakeApplication application,InCandidate candidate);
    
    //void registeredCandidate (InIntake intake, InCandidate candidate);
}
