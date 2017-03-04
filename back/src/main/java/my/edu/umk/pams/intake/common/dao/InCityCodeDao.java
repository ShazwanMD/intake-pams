package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InCityCode;
import my.edu.umk.pams.intake.common.model.InStateCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InCityCodeDao extends GenericDao<Long, InCityCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    InCityCode findByCode(String code);

    List<InCityCode> find(InStateCode stateCode);

    List<InCityCode> find(InStateCode stateCode, Integer offset, Integer limit);

    List<InCityCode> find(String filter, InStateCode stateCode, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(InStateCode stateCode);

    Integer count(String filter, InStateCode stateCode);

    boolean isExists(String code);
}
