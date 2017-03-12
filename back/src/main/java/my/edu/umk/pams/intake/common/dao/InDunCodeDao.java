package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InDunCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InDunCodeDao extends GenericDao<Long, InDunCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InDunCode findByCode(String code);

    List<InDunCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
