package my.edu.umk.pams.intake.identity.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.identity.model.InGroup;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.model.InUserImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Repository("userDao")
public class InUserDaoImpl extends GenericDaoSupport<Long, InUser> implements InUserDao {

    private static final Logger LOG = LoggerFactory.getLogger(InUserDaoImpl.class);

    public InUserDaoImpl() {
        super(InUserImpl.class);
    }

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public List<InGroup> findGroups(InUser user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from InGroup r inner join r.members m where m.id = :id");
        query.setLong("id", user.getId());
        return (List<InGroup>) query.list();
    }

    @Override
    public boolean isExists(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from InUser u where " +
                "upper(u.name) = upper(:username) ");
        query.setString("username", username);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasUser(my.edu.umk.pams.intake.identity.model.InActor actor) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from InUser u where " +
                "u.actor = :actor");
        query.setEntity("actor", actor);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public InUser findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from InUser u where u.email = :email ");
        query.setString("email", email);
        return (InUser) query.uniqueResult();
    }

    @Override
    public InUser findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from InUser u where u.name = :username ");
        query.setString("username", username);
        return (InUser) query.uniqueResult();
    }

    @Override
    public InUser findByActor(my.edu.umk.pams.intake.identity.model.InActor actor) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from InUser u where u.actor = :actor ");
        query.setEntity("actor", actor);
        return (InUser) query.uniqueResult();
    }

    @Override
    public List<InUser> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InUser s where (" +
                "upper(s.name) like upper(:filter) " +
                "or upper(s.firstName) like upper(:filter) " +
                "or upper(s.lastName) like upper(:filter)) " +
                "order by s.firstName, s.lastName, s.name");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<InUser>) query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(u) from InUser u");
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InUser s where " +
                "upper(s.name) like upper(:filter) " +
                "or upper(s.firstName) like upper(:filter) " +
                "or upper(s.lastName) like upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }
}
