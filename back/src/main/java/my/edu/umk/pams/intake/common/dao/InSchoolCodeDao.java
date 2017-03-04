package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InSchoolCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InSchoolCodeDao extends GenericDao<Long, InSchoolCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InSchoolCode findByCode(String code);

    List<InSchoolCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
