package my.edu.umk.pams.intake.system.dao;


import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.system.model.InConfiguration;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface InConfigurationDao extends GenericDao<Long, InConfiguration> {

    InConfiguration findByKey(String key);

    List<InConfiguration> findByPrefix(String prefix);

    List<InConfiguration> find(String filter, Integer offset, Integer limit);

    List<InConfiguration> find(String filter);

    List<InConfiguration> findInverse(String filter);

    Integer count(String filter);

}
