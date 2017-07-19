package my.edu.umk.pams.intake.identity.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.identity.model.InUser;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@SuppressWarnings({"unchecked"})
@Repository("applicantDao")
public class InApplicantDaoImpl extends GenericDaoSupport<Long, InApplicant> implements InApplicantDao {

    public InApplicantDaoImpl() {
        super(InApplicantImpl.class);
    }

    @Override
    public InApplicant findByApplicantNo(String applicantNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from InApplicant a where " +
                "a.identityNo = :identityNo");
        query.setString("identityNo", applicantNo);
        return (InApplicant) query.uniqueResult();
    }
    
    @Override
    public InApplicant findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from InApplicant u where u.email = :email ");
        query.setString("email", email);
        return (InApplicant) query.uniqueResult();
    }


    @Override
    public List<InApplicant> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InApplicant s where " +
                "(upper(s.identityNo) like upper(:filter) " +
                "or upper(s.name) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InApplicant s where " +
                "(upper(s.identityNo) like upper(:filter) " +
                "or upper(s.name) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }
}
