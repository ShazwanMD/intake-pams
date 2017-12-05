package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InSupervisorCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InSupervisorCodeDao extends GenericDao<Long, InSupervisorCode> {

    InSupervisorCode findByCode(String code);

    InSupervisorCode findByName (String name);
    
    List<InSupervisorCode> find(String filter, Integer offset, Integer limit);

    Integer count(String filter);

    boolean isExists(String code);
}
