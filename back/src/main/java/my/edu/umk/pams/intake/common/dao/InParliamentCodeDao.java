package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InParliamentCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InParliamentCodeDao extends GenericDao<Long, InParliamentCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InParliamentCode findByCode(String code);

    List<InParliamentCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
