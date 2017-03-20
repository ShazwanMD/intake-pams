package my.edu.umk.pams.intake.policy.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.model.InProgramLevelImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("inProgramLevelDao")
public class InProgramLevelDaoImpl extends GenericDaoSupport<Long, InProgramLevel> implements InProgramLevelDao {

    private static final Logger LOG = LoggerFactory.getLogger(InProgramLevelDaoImpl.class);

    public InProgramLevelDaoImpl() {
        super(InProgramLevelImpl.class);
    }

    @Override
    public InProgramLevel findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from InProgramLevel r where r.code = :code");
        query.setString("code", code);
        return (InProgramLevel) query.uniqueResult();
    }


    @Override
    public List<InProgramLevel> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from InProgramLevel p where " +
                "(upper(p.code) like upper(:filter) or upper(p.description) like upper(:filter))");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<InProgramLevel>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InProgramLevel p " +
                "where upper(p.code) like  upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }
}
