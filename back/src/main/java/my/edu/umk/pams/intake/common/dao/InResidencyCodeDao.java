package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InResidencyCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InResidencyCodeDao extends GenericDao<Long, InResidencyCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InResidencyCode findByCode(String code);

    List<InResidencyCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
