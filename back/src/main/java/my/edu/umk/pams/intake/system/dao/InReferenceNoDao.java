package my.edu.umk.pams.intake.system.dao;

import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.system.model.InReferenceNo;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface InReferenceNoDao extends GenericDao<Long, InReferenceNo> {

    InReferenceNo findByCode(String code);

    List<InReferenceNo> find(String filter, Integer offset, Integer limit);

    Integer count(String filter);
}
