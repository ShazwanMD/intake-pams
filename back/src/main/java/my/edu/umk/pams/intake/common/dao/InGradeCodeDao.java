package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InGradeCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InGradeCodeDao extends GenericDao<Long, InGradeCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    InGradeCode findByCode(String code);

    List<InGradeCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
