package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InDependencyCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InDependencyCodeDao extends GenericDao<Long, InDependencyCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    InDependencyCode findByCode(String code);

    List<InDependencyCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
