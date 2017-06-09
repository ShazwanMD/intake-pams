package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InGraduateCenter;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

/**
 * @author PAMS
 */
public interface InGraduateCenterDao extends GenericDao<Long, InGraduateCenter> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InGraduateCenter findByCode(String code);

    List<InGraduateCenter> find();

    List<InGraduateCenter> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
