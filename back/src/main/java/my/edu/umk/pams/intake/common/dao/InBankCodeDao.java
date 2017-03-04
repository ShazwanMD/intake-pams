package my.edu.umk.pams.intake.common.dao;


import my.edu.umk.pams.intake.common.model.InBankCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InBankCodeDao extends GenericDao<Long, InBankCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InBankCode findByCode(String code);

    List<InBankCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
