package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InCollegeCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

@Deprecated
public interface InCollegeCodeDao extends GenericDao<Long, InCollegeCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    InCollegeCode findByCode(String code);

    List<InCollegeCode> find(String filter, Integer offset, Integer limit);


    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
