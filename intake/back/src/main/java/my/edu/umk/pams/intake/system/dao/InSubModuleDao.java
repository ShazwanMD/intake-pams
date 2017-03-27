package my.edu.umk.pams.intake.system.dao;


import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.system.model.InModule;
import my.edu.umk.pams.intake.system.model.InSubModule;

import java.util.List;

/**
 * @author canang technologies
 * @since 4/18/14
 */
public interface InSubModuleDao extends GenericDao<Long, InSubModule> {

    InSubModule findByCode(String code);

    List<InSubModule> find();

    List<InSubModule> find(InModule module, Integer offset, Integer limit);

    Integer count();

    Integer count(InModule module);

    Integer count(String filter);

    boolean isExists(String code);
}
