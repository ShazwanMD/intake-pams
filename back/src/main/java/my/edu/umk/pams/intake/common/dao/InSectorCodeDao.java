package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InEmploymentSectorCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InSectorCodeDao extends GenericDao<Long, InEmploymentSectorCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InEmploymentSectorCode findByCode(String code);

    List<InEmploymentSectorCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
