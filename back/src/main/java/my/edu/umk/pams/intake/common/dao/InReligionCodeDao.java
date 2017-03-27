package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InReligionCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InReligionCodeDao extends GenericDao<Long, InReligionCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InReligionCode findByCode(String code);

    List<InReligionCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
