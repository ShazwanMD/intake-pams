package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InEmploymentLevelCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InEmploymentLevelCodeDao extends GenericDao<Long, InEmploymentLevelCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InEmploymentLevelCode findByCode(String code);

    List<InEmploymentLevelCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
