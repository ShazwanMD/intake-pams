package my.edu.umk.pams.intake.system.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import my.edu.umk.pams.intake.system.model.InConfiguration;
import my.edu.umk.pams.intake.system.model.InConfigurationImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@SuppressWarnings({"unchecked"})
@Repository("configurationDao")
public final class InConfigurationDaoImpl extends GenericDaoSupport<Long, InConfiguration> implements InConfigurationDao {

    public InConfigurationDaoImpl() {
        super(InConfigurationImpl.class);
    }

    public InConfigurationDaoImpl(Class clazz) {
        super(clazz);
    }

    @Override
    public InConfiguration findByKey(String key) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InConfiguration s where " +
                "s.key = :key and  " +
                " s.metadata.state = :state");
        query.setString("key", key);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (InConfiguration) query.uniqueResult();
    }

    @Override
    public List<InConfiguration> findByPrefix(String prefix) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InConfiguration s where " +
                "upper(s.key) like upper(:prefix)  " +
                "and s.metadata.state = :state");
        query.setString("prefix", prefix + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return query.list();
    }

    @Override
    public List<InConfiguration> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InConfiguration s where " +
                "s.metadata.state = :state");
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return query.list();
    }

    @Override
    public List<InConfiguration> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InConfiguration s where " +
                "(upper(s.key) like upper(:filter)  " +
                "or upper(s.description) like upper(:filter))  " +
                "and s.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<InConfiguration> find(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InConfiguration s where " +
                "upper(s.key) like upper(:filter)  " +
                "and s.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return query.list();
    }

    @Override
    public List<InConfiguration> findInverse(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InConfiguration s where " +
                "upper(s.key) not like upper(:filter)  " +
                "and s.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InConfiguration s where " +
                "(upper(s.key) like upper(:filter)  " +
                "or upper(s.description) like upper(:filter))  " +
                "and s.metadata.state = :state");
        query.setCacheable(true);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

}
