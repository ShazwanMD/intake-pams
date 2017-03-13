package my.edu.umk.pams.intake.admission.dao;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateImpl;
import my.edu.umk.pams.intake.core.GenericDaoSupport;

/**
 * @author PAMS
 */
public class InCandidateDaoImpl extends GenericDaoSupport<Long, InCandidate> implements InCandidateDao{

    public InCandidateDaoImpl() {
        super(InCandidateImpl.class);
    }


}
