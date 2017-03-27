package my.edu.umk.pams.intake.policy.dao;

import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;

import java.util.List;

public interface InProgramLevelDao extends GenericDao<Long, InProgramLevel> {

    // ===================================================================
    // FINDER
    // ===================================================================

    InProgramLevel findByCode(String code);

    List<InProgramLevel> find(String filter, Integer offset, Integer limit);

    // ===================================================================
    // HELPER
    // ===================================================================

    Integer count(String filter);

}
