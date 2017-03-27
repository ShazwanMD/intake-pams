package my.edu.umk.pams.intake.admission.dao;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.core.GenericDao;

/**
 * @author PAMS
 */
public interface InCandidateDao extends GenericDao<Long, InCandidate> {
    InCandidate findByIdentityNo(String identityNo);
}
