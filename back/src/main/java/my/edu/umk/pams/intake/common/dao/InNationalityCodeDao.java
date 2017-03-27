package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InNationalityCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InNationalityCodeDao extends GenericDao<Long, InNationalityCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InNationalityCode findByCode(String code);

    List<InNationalityCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
