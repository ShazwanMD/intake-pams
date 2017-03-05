package my.edu.umk.pams.intake.policy.dao;

import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.policy.model.InIntakeLevel;

import java.util.List;

public interface InIntakeLevelDao extends GenericDao<Long, InIntakeLevel> {

    // ===================================================================
    // FINDER
    // ===================================================================

    InIntakeLevel findByCode(String code);

    List<InIntakeLevel> find(String filter, Integer offset, Integer limit);

    // ===================================================================
    // HELPER
    // ===================================================================

    Integer count(String filter);

}
