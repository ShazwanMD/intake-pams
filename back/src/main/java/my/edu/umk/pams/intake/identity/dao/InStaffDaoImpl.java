package my.edu.umk.pams.intake.identity.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import my.edu.umk.pams.intake.identity.model.InStaff;
import my.edu.umk.pams.intake.identity.model.InStaffImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author team canang
 * @since 6/6/2015.
 */
@Repository("staffDao")
public class InStaffDaoImpl extends GenericDaoSupport<Long, InStaff> implements InStaffDao {

    public InStaffDaoImpl() {
        super(InStaffImpl.class);
    }

    @Override
    public InStaff findByStaffNo(String staffNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from InStaff p where " +
                "p.identityNo = :identityNo ");
        query.setString("identityNo", staffNo);
        return (InStaff) query.uniqueResult();
    }

    @Override
    public InStaff findByNricNo(String nricNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from InStaff p where " +
                "p.identityNo= :nricNo "); // TODO: fix this
        query.setString("nricNo", nricNo);
        return (InStaff) query.uniqueResult();
    }

    @Override
    public InStaff findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from InStaff p where " +
                "p.email = :email ");
        query.setString("email", email);
        return (InStaff) query.uniqueResult();
    }

    @Override
    public InStaff findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from InStaff p where " +
                "p.name = :name ");
        query.setString("name", name);
        return (InStaff) query.uniqueResult();
    }

    @Override
    public List<InStaff> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InStaff s where " +
                "(upper(s.identityNo) like upper(:filter) " +
                "or upper(s.name) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return (List<InStaff>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InStaff s where " +
                "(upper(s.identityNo) like upper(:filter) " +
                "or upper(s.name) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String staffNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InStaff s where " +
                "s.identityNo = :staffNo " +
                "and s.metadata.state = :state ");
        query.setString("staffNo", staffNo);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
    

    @Override
    public boolean isEmailExists(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InStaff s where " +
                "s.email = :email " +
                "and s.metadata.state = :state ");
        query.setString("email", email);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Integer) query.uniqueResult() > 0);
    }
}
