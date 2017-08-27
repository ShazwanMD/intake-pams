package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InPromoCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InPromoCodeDao extends GenericDao<Long, InPromoCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    InPromoCode findByCode(String code);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================


    boolean isExists(String code);
}
