package my.edu.umk.pams.intake.policy.dao;

import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.policy.model.InIntakeCategory;

import java.util.List;

public interface InIntakeCategoryDao extends GenericDao<Long, InIntakeCategory> {

    // ===================================================================
    // FINDER
    // ===================================================================

    InIntakeCategory findByCode(String code);

    List<InIntakeCategory> find(String filter, Integer offset, Integer limit);

    // ===================================================================
    // HELPER
    // ===================================================================

    Integer count(String filter);

}
