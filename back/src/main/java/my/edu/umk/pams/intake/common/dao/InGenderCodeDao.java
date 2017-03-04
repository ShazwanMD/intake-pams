package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InGenderCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InGenderCodeDao extends GenericDao<Long, InGenderCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InGenderCode findByCode(String code);

    List<InGenderCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
