package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InCompetencyCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InCompetencyCodeDao extends GenericDao<Long, InCompetencyCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    InCompetencyCode findByCode(String code);

    List<InCompetencyCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
