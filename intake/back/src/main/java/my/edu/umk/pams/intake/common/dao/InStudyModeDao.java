package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InStudyModeDao extends GenericDao<Long, InStudyMode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    InStudyMode findByCode(String code);

    List<InStudyMode> find(String filter, Integer offset, Integer limit);


    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
