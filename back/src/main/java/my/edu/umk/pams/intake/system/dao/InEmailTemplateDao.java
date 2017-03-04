package my.edu.umk.pams.intake.system.dao;

import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.system.model.InEmailTemplate;

import java.util.List;

/**
 * @author canang technologies
 * @since 9/4/2016.
 */
public interface InEmailTemplateDao extends GenericDao<Long, InEmailTemplate> {

    InEmailTemplate findByCode(String code);

    Integer count(String filter);

    List<InEmailTemplate> find(String filter);

    List<InEmailTemplate> find(String filter, Integer offset, Integer limit);
}
