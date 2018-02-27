package my.edu.umk.pams.intake.admission.dao;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateImpl;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InResult;
import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InFlowState;
import my.edu.umk.pams.intake.core.InMetaState;
import my.edu.umk.pams.intake.core.InMetadata;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;

import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author PAMS
 */

@Repository("inCandidateDao")
public class InCandidateDaoImpl extends GenericDaoSupport<Long, InCandidate> implements InCandidateDao {

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
    public InCandidate findCandidateByMatricNo(String matricNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from InCandidate c where c.matricNo = :matricNo");
        query.setString("matricNo", matricNo);
        return (InCandidate) query.uniqueResult();
    }
    
    @Override
    public InCandidate findByReferenceNo(String referenceNo) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from InCandidate c where c.referenceNo = :referenceNo");
        query.setString("referenceNo", referenceNo);
        return (InCandidate) query.uniqueResult();
    }
    
    @Override
    public InCandidate findCandidateByIntakeApplication(InIntakeApplication application) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from InCandidate c where c.application = :application");
        query.setEntity("application", application);
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

    @Override
    public List<InCandidate> findCandidateByStatus(InIntake intake, InCandidateStatus status) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InCandidate p " +
                "where p.status = :status ");
        query.setInteger("status", status.ordinal());
        return (List<InCandidate>) query.list();
    }

    @Override
    public List<InCandidate> find(InIntake intake, InCandidateStatus status) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InCandidate p where " +
                "p.intake = :intake " +
                "and p.status = :status ");
        query.setEntity("intake", intake);
        query.setInteger("status", status.ordinal());
        return (List<InCandidate>) query.list();
    }
    
    @Override
    public List<InCandidate> findByFlowStates(InFlowState... flowStates) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InCandidate p where " +
                "p.metadata.state = :state " +
                "and p.flowdata.state in (:flowStates) ");
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setParameterList("flowStates", flowStates);
        return (List<InCandidate>) query.list();
    }
    
    @Override
    public List<InCandidate> findAcceptCandidate(InIntake intake, InCandidateStatus status) {
    	System.out.println("execute query select accepted");
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InCandidate p where " +
                "p.intake = :intake " +
                "and p.status = :status "+
    			"and p.acception = :accept");
        query.setEntity("intake", intake);
        query.setInteger("status", status.ordinal());
        query.setBoolean("accept", true);
        return (List<InCandidate>) query.list();
    }

    @Override
    public Integer count(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InCandidate p " +
                "where p.intake = :intake");
        query.setEntity("intake", intake);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(InIntake intake, InCandidateStatus status) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InCandidate p " +
                "where p.intake = :intake " +
                "and p.status = :status ");
        query.setEntity("intake", intake);
        query.setInteger("status", status.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }
    
    @Override
    public boolean isExists(String matricNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from InCandidate p where " +
                "upper(p.matricNo) = upper(:generateMatricNumber) ");
        query.setString("generateMatricNumber", matricNo);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
