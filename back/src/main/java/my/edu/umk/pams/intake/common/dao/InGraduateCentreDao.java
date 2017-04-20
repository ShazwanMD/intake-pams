package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InGraduateCentre;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

/**
 * @author PAMS
 */
public interface InGraduateCentreDao extends GenericDao<Long, InGraduateCentre> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InGraduateCentre findByCode(String code);

    List<InGraduateCentre> find();

    List<InGraduateCentre> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
