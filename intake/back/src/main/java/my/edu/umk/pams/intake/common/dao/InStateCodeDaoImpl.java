package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InCountryCode;
import my.edu.umk.pams.intake.common.model.InStateCode;
import my.edu.umk.pams.intake.common.model.InStateCodeImpl;
import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("stateCodeDao")
public class InStateCodeDaoImpl extends GenericDaoSupport<Long, InStateCode> implements InStateCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(InStateCodeDaoImpl.class);

    public InStateCodeDaoImpl() {
        super(InStateCodeImpl.class);
    }

    @Override
    public InStateCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InStateCode s where s.code = :code and  " +
                " s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return (InStateCode) query.uniqueResult();
    }

    @Override
    public List<InStateCode> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InStateCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter) " +
                "or upper(s.countryCode.code) like upper(:filter) " +
                "or upper(s.countryCode.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return query.list();
    }

    @Override
    public List<InStateCode> find(InCountryCode countryCode, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InStateCode s where " +
                "s.countryCode = :countryCode " +
                "and s.metadata.state = :state ");
        query.setEntity("countryCode", countryCode);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<InStateCode>) query.list();
    }

    @Override
    public List<InStateCode> find(String filter, InCountryCode countryCode, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InStateCode s where " +
                "s.countryCode = :countryCode " +
                "and (upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter) " +
                "or upper(s.countryCode.code) like upper(:filter) " +
                "or upper(s.countryCode.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setEntity("countryCode", countryCode);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setCacheable(true);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<InStateCode>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InStateCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter) " +
                "or upper(s.countryCode.code) like upper(:filter) " +
                "or upper(s.countryCode.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setCacheable(true);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(InCountryCode countryCode) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InStateCode s where " +
                "s.countryCode = :countryCode " +
                "and s.metadata.state = :state ");
        query.setEntity("countryCode", countryCode);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, InCountryCode countryCode) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InStateCode s where " +
                "s.countryCode = :countryCode " +
                "and (upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter) " +
                "or upper(s.countryCode.code) like upper(:filter) " +
                "or upper(s.countryCode.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from InStateCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
