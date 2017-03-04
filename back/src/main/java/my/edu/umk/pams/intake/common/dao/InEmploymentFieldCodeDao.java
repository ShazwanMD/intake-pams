package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InEmploymentFieldCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InEmploymentFieldCodeDao extends GenericDao<Long, InEmploymentFieldCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InEmploymentFieldCode findByCode(String code);

    List<InEmploymentFieldCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
