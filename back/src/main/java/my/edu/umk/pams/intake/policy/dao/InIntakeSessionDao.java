package my.edu.umk.pams.intake.policy.dao;

import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

import java.util.List;

public interface InIntakeSessionDao extends GenericDao<Long, InIntakeSession> {

    // ===================================================================
    // FINDER
    // ===================================================================

    InIntakeSession findByCode(String code);

    InIntakeSession findCurrent();

    List<InIntakeSession> find(String filter, Integer offset, Integer limit);

    // ===================================================================
    // HELPER
    // ===================================================================

    Integer count(String filter);

	List<InIntakeSession> findInIntakeSessionsByCurrent(Boolean current);
}
