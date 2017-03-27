package my.edu.umk.pams.intake.system.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import my.edu.umk.pams.intake.system.model.InReferenceNo;
import my.edu.umk.pams.intake.system.model.InReferenceNoImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@SuppressWarnings({"unchecked"})
@Repository("referenceNoDao")
public final class InReferenceNoDaoImpl extends GenericDaoSupport<Long, InReferenceNo> implements InReferenceNoDao {

    public InReferenceNoDaoImpl() {
        super(InReferenceNoImpl.class);
    }

    @Override
    public InReferenceNo findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InReferenceNo s where " +
                "s.code = :code and  " +
                " s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return (InReferenceNo) query.uniqueResult();
    }

    @Override
    public List<InReferenceNo> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InReferenceNo s where " +
                "(upper(s.code) like upper(:filter)  " +
                "or upper(s.description) like upper(:filter))  " +
                "and s.metadata.state = :state");
        query.setString("filter", filter);
        query.setCacheable(true);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InReferenceNo s where " +
                "(upper(s.code) like upper(:filter)  " +
                "or upper(s.description) like upper(:filter))  " +
                "and s.metadata.state = :state");
        query.setCacheable(true);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }
}
