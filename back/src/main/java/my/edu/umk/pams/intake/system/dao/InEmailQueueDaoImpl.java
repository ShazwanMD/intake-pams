package my.edu.umk.pams.intake.system.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import my.edu.umk.pams.intake.core.InMetadata;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.model.InEmailQueueImpl;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;

import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@SuppressWarnings({"unchecked"})
@Repository("emailQueueDao")
public final class InEmailQueueDaoImpl extends GenericDaoSupport<Long, InEmailQueue> implements InEmailQueueDao {

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
    public void addEmailQueue(InEmailQueue emailQueue) {
        Validate.notNull(emailQueue, "Email cannot be null");
        
        Session session = sessionFactory.getCurrentSession();
  //      offering.setIntake(intake);

        InMetadata metadata = new InMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
  //      metadata.setModifierId(user.getId());
        metadata.setState(InMetaState.ACTIVE);
        emailQueue.setMetadata(metadata);
        session.save(emailQueue);
    } 
}
