package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InStudyCenterCode;
import my.edu.umk.pams.intake.common.model.InStudyCenterCodeImpl;
import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("inStudyCenterCodeDao")
public class InStudyCenterCodeDaoImpl extends GenericDaoSupport<Long, InStudyCenterCode> implements InStudyCenterCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(InStudyCenterCodeDaoImpl.class);

    public InStudyCenterCodeDaoImpl() {
        super(InStudyCenterCodeImpl.class);
    }

    @Override
    public InStudyCenterCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InStudyCenterCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return (InStudyCenterCode) query.uniqueResult();
    }

    @Override
    public List<InStudyCenterCode> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InStudyCenterCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.descriptionEn) like upper(:filter) " +
                "or upper(s.descriptionMs) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<InStudyCenterCode>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InStudyCenterCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.descriptionMs) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from InStudyCenterCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
