package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InLanguageCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InLanguageCodeDao extends GenericDao<Long, InLanguageCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InLanguageCode findByCode(String code);

    List<InLanguageCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
