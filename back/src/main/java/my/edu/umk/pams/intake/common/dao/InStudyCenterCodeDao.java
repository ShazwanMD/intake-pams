package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InStudyCenterCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InStudyCenterCodeDao extends GenericDao<Long, InStudyCenterCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    InStudyCenterCode findByCode(String code);

    List<InStudyCenterCode> find(String filter, Integer offset, Integer limit);


    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
