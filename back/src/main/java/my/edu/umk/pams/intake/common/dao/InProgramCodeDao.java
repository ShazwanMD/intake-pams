package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InProgramCodeDao extends GenericDao<Long, InProgramCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InProgramCode findByCode(String code);

    InProgramCode findByUpuCode(String upuCode);

    List<InProgramCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);

}
