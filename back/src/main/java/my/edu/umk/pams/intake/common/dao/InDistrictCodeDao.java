package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InDistrictCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InDistrictCodeDao extends GenericDao<Long, InDistrictCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InDistrictCode findByCode(String code);

    List<InDistrictCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
