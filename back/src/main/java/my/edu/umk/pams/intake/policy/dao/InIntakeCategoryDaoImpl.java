package my.edu.umk.pams.intake.policy.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.policy.model.InIntakeCategory;
import my.edu.umk.pams.intake.policy.model.InIntakeCategoryImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("inIntakeCategoryDao")
public class InIntakeCategoryDaoImpl extends GenericDaoSupport<Long, InIntakeCategory> implements InIntakeCategoryDao {

    private static final Logger LOG = LoggerFactory.getLogger(InIntakeCategoryDaoImpl.class);

    public InIntakeCategoryDaoImpl() {
        super(InIntakeCategoryImpl.class);
    }

    @Override
    public InIntakeCategory findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from InIntakeCategory r where r.code = :code");
        query.setString("code", code);
        return (InIntakeCategory) query.uniqueResult();
    }


    @Override
    public List<InIntakeCategory> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from InIntakeCategory p where " +
                "(upper(p.code) like upper(:filter) or upper(p.description) like upper(:filter))");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<InIntakeCategory>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InIntakeCategory p " +
                "where upper(p.code) like  upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }

}
