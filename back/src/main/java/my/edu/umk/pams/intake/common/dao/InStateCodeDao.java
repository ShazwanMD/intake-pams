package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InCountryCode;
import my.edu.umk.pams.intake.common.model.InStateCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InStateCodeDao extends GenericDao<Long, InStateCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InStateCode findByCode(String code);

    List<InStateCode> find(String filter, Integer offset, Integer limit);

    List<InStateCode> find(InCountryCode countryCode, Integer offset, Integer limit);

    List<InStateCode> find(String filter, InCountryCode countryCode, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    Integer count(InCountryCode countryCode);

    Integer count(String filter, InCountryCode countryCode);

    boolean isExists(String code);


}
