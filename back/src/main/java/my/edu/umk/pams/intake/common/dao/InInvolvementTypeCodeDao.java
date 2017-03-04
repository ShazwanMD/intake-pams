package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InInvolvementTypeCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InInvolvementTypeCodeDao extends GenericDao<Long, InInvolvementTypeCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InInvolvementTypeCode findByCode(String code);

    List<InInvolvementTypeCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
