package my.edu.umk.pams.intake.system.dao;

import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface InEmailQueueDao extends GenericDao<Long, InEmailQueue> {

    List<InEmailQueue> find(InEmailQueueStatus status);

    List<InEmailQueue> find(InEmailQueueStatus... statuses);

	boolean hasEmailQueue(String email);
}
