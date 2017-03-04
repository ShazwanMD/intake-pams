package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InInvolvementTitleCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InInvolvementTitleCodeDao extends GenericDao<Long, InInvolvementTitleCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InInvolvementTitleCode findByCode(String code);

    List<InInvolvementTitleCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
