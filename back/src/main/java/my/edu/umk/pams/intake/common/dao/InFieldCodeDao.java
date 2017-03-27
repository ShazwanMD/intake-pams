package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InFieldCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InFieldCodeDao extends GenericDao<Long, InFieldCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InFieldCode findByCode(String code);

    List<InFieldCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);

}
