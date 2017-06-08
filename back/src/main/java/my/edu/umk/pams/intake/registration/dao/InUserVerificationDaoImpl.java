package my.edu.umk.pams.intake.registration.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.model.InUserVerification;
import my.edu.umk.pams.intake.registration.model.InUserVerificationImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author PAMS
 */
@SuppressWarnings({"unchecked"})
@Repository("userVerificationDao")
public class InUserVerificationDaoImpl extends GenericDaoSupport<Long, InUserVerification> implements InUserVerificationDao {

    private static final Logger LOG = LoggerFactory.getLogger(InUserVerificationDaoImpl.class);

    public InUserVerificationDaoImpl() {
        super(InUserVerificationImpl.class);
    }

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public InUserVerification findByToken(String token) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from InUserVerification u where u.token = :token ");
        query.setString("token", token);
        return (InUserVerification) query.uniqueResult();
    }



}
