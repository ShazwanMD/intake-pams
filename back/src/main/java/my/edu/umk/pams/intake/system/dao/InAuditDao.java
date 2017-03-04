package my.edu.umk.pams.intake.system.dao;

import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface InAuditDao extends GenericDao<Long, my.edu.umk.pams.intake.system.model.InAudit> {

    List<my.edu.umk.pams.intake.system.model.InAudit> find(String filter, Integer offset, Integer limit);

    Integer count(String filter);
}
