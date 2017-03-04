package my.edu.umk.pams.intake.policy.dao;


import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;

import java.util.List;

public interface InProgramOfferingDao extends GenericDao<Long, InProgramOffering> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    InProgramOffering find(InIntake intake, InProgramCode programCode);

    List<InProgramOffering> find(InIntake intake);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(InIntake intake);
}
