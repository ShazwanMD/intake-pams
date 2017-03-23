package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InBumiCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InBumiCodeDao extends GenericDao<Long, InBumiCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InBumiCode findByCode(String code);

    List<InBumiCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
