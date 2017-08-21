package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InVenueCode;
import my.edu.umk.pams.intake.common.model.InVenueCodeImpl;
import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("inVenueCodeDao")
public class InVenueCodeDaoImpl extends GenericDaoSupport<Long, InVenueCode> implements InVenueCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(InVenueCodeDaoImpl.class);

    public InVenueCodeDaoImpl() {
        super(InVenueCodeImpl.class);
    }

    @Override
    public InVenueCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InVenueCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return (InVenueCode) query.uniqueResult();
    }

    @Override
    public List<InVenueCode> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InVenueCode s where " +
                " s.metadata.state = :state ");
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<InVenueCode>) query.list();
    }

    @Override
    public List<InVenueCode> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InVenueCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.registrationLocation) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<InVenueCode>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InVenueCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.registrationLocation) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from InVenueCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
