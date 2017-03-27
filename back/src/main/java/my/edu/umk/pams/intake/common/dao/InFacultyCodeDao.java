package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InFacultyCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InFacultyCodeDao extends GenericDao<Long, InFacultyCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    InFacultyCode findByCode(String code);

    List<InFacultyCode> find(String filter, Integer offset, Integer limit);


    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
