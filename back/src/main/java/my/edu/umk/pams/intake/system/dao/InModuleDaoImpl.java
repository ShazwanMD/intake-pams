package my.edu.umk.pams.intake.system.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.system.model.InModule;
import my.edu.umk.pams.intake.system.model.InModuleImpl;
import my.edu.umk.pams.intake.system.model.InSubModule;
import org.apache.commons.lang3.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * @author canang technologies
 * @since 4/18/14
 */
@SuppressWarnings({"unchecked"})
@Repository("moduleDao")
public final class InModuleDaoImpl extends GenericDaoSupport<Long, InModule> implements InModuleDao {

    public InModuleDaoImpl() {
        super(InModuleImpl.class);
    }

    @Override
    public InModule findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from InModule c where c.code = :code");
        query.setString("code", code);
        query.setCacheable(true);
        return (InModule) query.uniqueResult();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InModule s where " +
                "upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from InModule c where " +
                "c.code = :code");
        query.setString("code", code);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isSubModuleExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from InSubModule c where " +
                "c.code = :code");
        query.setString("code", code);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public void addSubModule(InModule module, InSubModule subModule, InUser user) {
        Validate.notNull(module, "Module should not be null");
        Validate.notNull(subModule, "SubModule member should not be null");

        Session session = sessionFactory.getCurrentSession();
        subModule.setModule(module);
        session.save(subModule);
    }

    @Override
    public void updateSubModule(InModule module, InSubModule subModule, InUser user) {
        Validate.notNull(module, "Module should not be null");
        Validate.notNull(subModule, "SubModule member should not be null");

        Session session = sessionFactory.getCurrentSession();
        subModule.setModule(module);
        session.update(subModule);
    }

    @Override
    public void removeSubModule(InModule module, InSubModule subModule, InUser user) {
        Validate.notNull(module, "Module should not be null");
        Validate.notNull(subModule, "SubModule member should not be null");

        Session session = sessionFactory.getCurrentSession();
        session.delete(subModule);
    }
}
