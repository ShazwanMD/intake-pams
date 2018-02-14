package my.edu.umk.pams.intake.common.dao;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.model.InSupervisorOffering;

import java.util.List;

public interface InSupervisorOfferingDao extends GenericDao<Long, InSupervisorOffering> {

	InSupervisorOffering findByCode(String code);
	
	List<InSupervisorOffering> find(InProgramLevel inProgramLevel, String filter, Integer offset, Integer limit);

    List<InSupervisorOffering> find(String filter, Integer offset, Integer limit);

    Integer count(String filter);

    boolean isExists(String code);
}
