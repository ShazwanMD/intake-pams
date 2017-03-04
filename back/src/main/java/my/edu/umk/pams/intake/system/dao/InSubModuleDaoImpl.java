package my.edu.umk.pams.intake.system.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.system.model.InModule;
import my.edu.umk.pams.intake.system.model.InSubModule;
import my.edu.umk.pams.intake.system.model.InSubModuleImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 4/18/14
 */
@Repository("subModuleDao")
public final class InSubModuleDaoImpl extends GenericDaoSupport<Long, InSubModule> implements InSubModuleDao {

    private static final Logger LOG = LoggerFactory.getLogger(InSubModuleDaoImpl.class);

    public InSubModuleDaoImpl() {
        super(InSubModuleImpl.class);
    }

    @Override
    public InSubModule findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from InSubModule c where c.code = :code");
        query.setString("code", code);
        query.setCacheable(true);
        return (InSubModule) query.uniqueResult();
    }

    @Override
    public List<InSubModule> find(InModule module, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from InSubModule c where " +
                "c.module = :module");
        query.setEntity("module", module);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<InSubModule>) query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(c) from InSubModule c");
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(InModule module) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InSubModule s where " +
                "s.module = :module");
        query.setEntity("module", module);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InSubModule s where " +
                "upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from InSubModule c where " +
                "c.code = :code");
        query.setString("code", code);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

}
