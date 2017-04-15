package my.edu.umk.pams.intake.system.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import my.edu.umk.pams.intake.system.model.InAuditImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 3/8/14
 */
@Repository("auditDao")
public class InAuditDaoImpl extends GenericDaoSupport<Long, my.edu.umk.pams.intake.system.model.InAudit> implements InAuditDao {

    public InAuditDaoImpl() {
        super(InAuditImpl.class);
    }

    @Override
    public List<my.edu.umk.pams.intake.system.model.InAudit> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InAudit s where " +
                "(upper(s.message) like upper(:filter)  " +
                "or upper(s.className) like upper(:filter))  " +
                "and s.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setCacheable(true);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InAudit s where " +
                "(upper(s.message) like upper(:filter)  " +
                "or upper(s.className) like upper(:filter))  " +
                "and s.metadata.state = :state");
        query.setCacheable(true);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }
}

