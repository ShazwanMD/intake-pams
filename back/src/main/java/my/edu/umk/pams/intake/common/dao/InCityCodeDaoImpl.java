package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InCityCode;
import my.edu.umk.pams.intake.common.model.InCityCodeImpl;
import my.edu.umk.pams.intake.common.model.InStateCode;
import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("inCityCodeDao")
public class InCityCodeDaoImpl extends GenericDaoSupport<Long, InCityCode> implements InCityCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(InCityCodeDaoImpl.class);

    public InCityCodeDaoImpl() {
        super(InCityCodeImpl.class);
    }

    @Override
    public InCityCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InCityCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return (InCityCode) query.uniqueResult();
    }

    // TODO:
    @Override
    public List<InCityCode> find(InStateCode stateCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InCityCode s where " +
                "s.metadata.state = :state ");
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<InCityCode>) query.list();
    }

    @Override
    public List<InCityCode> find(InStateCode stateCode, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InCityCode s where " +
                "s.metadata.state = :state ");
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<InCityCode>) query.list();
    }

    @Override
    public List<InCityCode> find(String filter, InStateCode stateCode, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InCityCode s where " +
                "s.metadata.state = :state ");
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<InCityCode>) query.list();
    }

    @Override
    public Integer count(InStateCode stateCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InCityCode s where " +
                "s.metadata.state = :state ");
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, InStateCode stateCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InCityCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InCityCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from InCityCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
