package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InEthnicityCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InEthnicityCodeDao extends GenericDao<Long, InEthnicityCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InEthnicityCode findByCode(String code);

    List<InEthnicityCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
