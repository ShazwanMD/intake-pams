package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InCampusCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InCampusCodeDao extends GenericDao<Long, InCampusCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    InCampusCode findByCode(String code);

    List<InCampusCode> find(String filter, Integer offset, Integer limit);


    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
