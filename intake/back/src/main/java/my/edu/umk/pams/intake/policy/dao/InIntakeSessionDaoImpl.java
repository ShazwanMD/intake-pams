package my.edu.umk.pams.intake.policy.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InIntakeSessionImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("intakeSessionDao")
public class InIntakeSessionDaoImpl extends GenericDaoSupport<Long, InIntakeSession> implements InIntakeSessionDao {

    public InIntakeSessionDaoImpl() {
        super(InIntakeSessionImpl.class);
    }

    @Override
    public InIntakeSession findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from InIntakeSession p " +
                "where p.code = :code ");
        query.setString("code", code);
        return (InIntakeSession) query.uniqueResult();
    }

    @Override
    public InIntakeSession findCurrent() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from InIntakeSession p " +
                "where p.current = true ");
        return (InIntakeSession) query.uniqueResult();
    }

    @Override
    public List<InIntakeSession> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from InIntakeSession p where " +
                "upper(p.code) like upper(:filter) or upper(p.description) like upper(:filter))");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<InIntakeSession>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InIntakeSession p " +
                "where upper(p.code) like  upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }
}
