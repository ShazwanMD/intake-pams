package my.edu.umk.pams.intake.admission.dao;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateImpl;
import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.policy.model.InIntake;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<InCandidate> find(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InCandidate p where " +
                "p.intake = :intake ");
        query.setEntity("intake", intake);
        return (List<InCandidate>) query.list();
    }

    @Override
    public List<InCandidate> find(InIntake intake, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InCandidate p where " +
                "p.intake = :intake ");
        query.setEntity("intake", intake);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<InCandidate>) query.list();
    }
}
