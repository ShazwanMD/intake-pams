package my.edu.umk.pams.intake.admission.dao;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateImpl;
import my.edu.umk.pams.intake.core.GenericDaoSupport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * @author PAMS
 */

@Repository("inCandidateDao")
public class InCandidateDaoImpl extends GenericDaoSupport<Long, InCandidate> implements InCandidateDao{

    public InCandidateDaoImpl() {
        super(InCandidateImpl.class);
    }


    @Override
    public InCandidate findByIdentityNo(String identityNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from InCandidate c where c.identityNo = :identityNo");
        query.setString("identityNo", identityNo);
        return (InCandidate) query.uniqueResult();
    }
}
