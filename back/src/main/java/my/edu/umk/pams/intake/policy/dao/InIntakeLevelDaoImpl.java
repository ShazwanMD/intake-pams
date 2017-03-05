package my.edu.umk.pams.intake.policy.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.policy.model.InIntakeLevel;
import my.edu.umk.pams.intake.policy.model.InIntakeLevelImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("inIntakeLevelDao")
public class InIntakeLevelDaoImpl extends GenericDaoSupport<Long, InIntakeLevel> implements InIntakeLevelDao {

    private static final Logger LOG = LoggerFactory.getLogger(InIntakeLevelDaoImpl.class);

    public InIntakeLevelDaoImpl() {
        super(InIntakeLevelImpl.class);
    }

    @Override
    public InIntakeLevel findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from InIntakeLevel r where r.code = :code");
        query.setString("code", code);
        return (InIntakeLevel) query.uniqueResult();
    }


    @Override
    public List<InIntakeLevel> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from InIntakeLevel p where " +
                "(upper(p.code) like upper(:filter) or upper(p.description) like upper(:filter))");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<InIntakeLevel>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InIntakeLevel p " +
                "where upper(p.code) like  upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }

}
