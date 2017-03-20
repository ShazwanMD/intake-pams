package my.edu.umk.pams.intake.policy.dao;


import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;

import java.util.List;

public interface InIntakeDao extends GenericDao<Long, InIntake> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    InIntake findByReferenceNo(String referenceNo);

    InIntake findBySessionAndCategory(InIntakeSession session, InProgramLevel category);

    InProgramOffering findOfferingById(Long id);

    InProgramOffering findOfferingByIntakeAndProgramCode(InIntake intake, InProgramCode programCode);

    List<InIntake> find(InIntakeSession session);

    List<InIntake> find(InIntakeSession session, Integer offset, Integer limit);

    List<InIntake> find(String filter, InIntakeSession session, Integer offset, Integer limit);

    List<InProgramOffering> findOfferings(InIntake intake);

    List<InApplicant> findApplicants(InIntake intake);


    // ====================================================================================================
    // HELPER
    // ====================================================================================================


    Integer count(InIntakeSession session);

    Integer count(String filter, InIntakeSession session);


    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    void addOffering(InIntake intake, InProgramOffering offering, InUser user);

    void deleteOffering(InIntake intake, InProgramOffering offering, InUser user);

}
