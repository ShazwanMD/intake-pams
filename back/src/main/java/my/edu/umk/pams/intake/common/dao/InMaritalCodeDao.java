package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InMaritalCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InMaritalCodeDao extends GenericDao<Long, InMaritalCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InMaritalCode findByCode(String code);

    List<InMaritalCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
