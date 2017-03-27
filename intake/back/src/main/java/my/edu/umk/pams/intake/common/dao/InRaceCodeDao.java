package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InRaceCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InRaceCodeDao extends GenericDao<Long, InRaceCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InRaceCode findByCode(String code);

    List<InRaceCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
