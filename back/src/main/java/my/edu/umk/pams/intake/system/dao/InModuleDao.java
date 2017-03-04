package my.edu.umk.pams.intake.system.dao;


import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.system.model.InModule;
import my.edu.umk.pams.intake.system.model.InSubModule;

import java.util.List;

/**
 * @author canang technologies
 * @since 4/18/14
 */
public interface InModuleDao extends GenericDao<Long, InModule> {

    InModule findByCode(String code);

    List<InModule> find();

    Integer count(String filter);

    boolean isExists(String code);

    boolean isSubModuleExists(String code);

    void addSubModule(InModule module, InSubModule subModule, InUser user);

    void updateSubModule(InModule module, InSubModule subModule, InUser user);

    void removeSubModule(InModule module, InSubModule subModule, InUser user);
}
