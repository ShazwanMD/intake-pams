package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InInvolvementLevelCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InInvolvementLevelCodeDao extends GenericDao<Long, InInvolvementLevelCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InInvolvementLevelCode findByCode(String code);

    List<InInvolvementLevelCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
