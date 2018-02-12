package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InFieldCode;
import my.edu.umk.pams.intake.common.model.InFieldCodeImpl;
import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("inFieldCodeDao")
public class InFieldCodeDaoImpl extends GenericDaoSupport<Long, InFieldCode> implements InFieldCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(InFieldCodeDaoImpl.class);

    public InFieldCodeDaoImpl() {
        super(InFieldCodeImpl.class);
    }

    @Override
    public InFieldCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InFieldCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return (InFieldCode) query.uniqueResult();
    }

    @Override
    public List<InFieldCode> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InFieldCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.descriptionEn) like upper(:filter) " +
                "or upper(s.descriptionMs) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<InFieldCode>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InFieldCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.descriptionEn) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from InFieldCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
