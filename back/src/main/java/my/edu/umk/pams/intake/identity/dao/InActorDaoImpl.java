package my.edu.umk.pams.intake.identity.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import my.edu.umk.pams.intake.identity.model.InActorImpl;
import my.edu.umk.pams.intake.identity.model.InActorType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Repository("actorDao")
public class InActorDaoImpl extends GenericDaoSupport<Long, my.edu.umk.pams.intake.identity.model.InActor> implements InActorDao {

    public InActorDaoImpl() {
        super(InActorImpl.class);
    }

    @Override
    public my.edu.umk.pams.intake.identity.model.InActor findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from InActor a where " +
                "a.code = :code");
        query.setString("code", code);
        return (my.edu.umk.pams.intake.identity.model.InActor) query.uniqueResult();
    }

    @Override
    public my.edu.umk.pams.intake.identity.model.InActor findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from InActor a where " +
                "a.email = :email");
        query.setString("email", email);
        return (my.edu.umk.pams.intake.identity.model.InActor) query.uniqueResult();
    }

    @Override
    public my.edu.umk.pams.intake.identity.model.InActor findByIdentityNo(String identityNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from InActor a where " +
                "a.identityNo = :identityNo");
        query.setString("identityNo", identityNo);
        return (my.edu.umk.pams.intake.identity.model.InActor) query.uniqueResult();
    }

    @Override
    public List<my.edu.umk.pams.intake.identity.model.InActor> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from InActor a where " +
                "(a.firsName like upper(:filter)" +
                "or a.lastName like uppoer(:filter)) " +
                "order by a.name");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return query.list();
    }

    @Override
    public List<my.edu.umk.pams.intake.identity.model.InActor> find(InActorType type, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from InActor a where " +
                "a.actorType = :actorType " +
                "order by a.name");
        query.setInteger("actorType", type.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<my.edu.umk.pams.intake.identity.model.InActor> find(String filter, InActorType type, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from InActor a where " +
                "(a.firsName like upper(:filter)" +
                "or a.lastName like uppoer(:filter)) " +
                "and a.actorType = :actorType " +
                "order by a.name");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setParameter("actorType", type);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from InActor a where " +
                "(upper(a.firstName) like upper(:filter)  " +
                "or upper(a.lastName) like upper(:filter))  " +
                "and a.metadata.state = :state");
        query.setCacheable(true);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, InActorType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from InActor a where " +
                "(upper(a.firstName) like upper(:filter)  " +
                "or upper(a.lastName) like upper(:filter))  " +
                "and a.actorType = :actorType " +
                "and a.metadata.state = :state");
        query.setCacheable(true);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setInteger("actorType", type.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(InActorType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from InActor a where " +
                "a.actorType = :actorType " +
                "and a.metadata.state = :state");
        query.setCacheable(true);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setInteger("actorType", type.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }
    
    @Override
    public boolean isEmailExists(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InActor s where " +
                "s.email = :email " +
                "and s.metadata.state = :state ");
        query.setString("email", email);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Integer) query.uniqueResult() > 0);
    }
    
    @Override
    public boolean isIdentityNoExists(String identityNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from InActor u where " +
                "u.identityNo = :identityNo ");
        query.setString("identityNo", identityNo);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
