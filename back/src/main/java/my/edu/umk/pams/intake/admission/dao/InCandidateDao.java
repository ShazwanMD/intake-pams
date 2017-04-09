package my.edu.umk.pams.intake.admission.dao;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InResult;
import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;

import java.util.List;

/**
 * @author PAMS
 */
public interface InCandidateDao extends GenericDao<Long, InCandidate> {

    InCandidate findByIdentityNo(String identityNo);

    List<InCandidate> find(InIntake intake);

    List<InCandidate> find(InIntake intake, Integer offset, Integer limit);
    
    void updateCandidate (InIntakeApplication application,InCandidate candidate);
    
}
