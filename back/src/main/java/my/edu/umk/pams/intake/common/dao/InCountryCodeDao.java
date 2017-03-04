package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InCountryCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InCountryCodeDao extends GenericDao<Long, InCountryCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InCountryCode findByCode(String code);

    List<InCountryCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
