package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InDisabilityCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InDisabilityCodeDao extends GenericDao<Long, InDisabilityCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InDisabilityCode findByCode(String code);

    List<InDisabilityCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
