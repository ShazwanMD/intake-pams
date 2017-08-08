package my.edu.umk.pams.intake.system.dao;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.model.InEmailQueueImpl;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Repository("emailQueueDao")
public class InEmailQueueDaoImpl extends GenericDaoSupport<Long, InEmailQueue> implements InEmailQueueDao {

    public InEmailQueueDaoImpl() {
        super(InEmailQueueImpl.class);
    }

    @Override
    public List<InEmailQueue> find(InEmailQueueStatus status) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select eq from InEmailQueue eq where " +
                "eq.queueStatus = (:status) ");
        query.setInteger("status", status.ordinal());
        return query.list();
    }

    @Override
    public List<InEmailQueue> find(InEmailQueueStatus... statuses) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select eq from InEmailQueue eq where " +
                "eq.queueStatus in (:statuses) ");
        query.setParameterList("statuses", statuses);
        return query.list();
    }
    
    @Override
    public boolean hasEmailQueue(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select eq from InEmailQueue eq where " +
                "eq.to = :email");
        query.setString("email", email);
        return true;
    }
}
