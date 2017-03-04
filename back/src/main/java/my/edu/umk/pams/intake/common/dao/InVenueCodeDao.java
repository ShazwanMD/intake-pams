package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InVenueCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InVenueCodeDao extends GenericDao<Long, InVenueCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    InVenueCode findByCode(String code);

    List<InVenueCode> find(String filter, Integer offset, Integer limit);


    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
