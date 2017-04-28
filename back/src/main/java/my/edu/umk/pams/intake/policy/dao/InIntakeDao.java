package my.edu.umk.pams.intake.policy.dao;


import my.edu.umk.pams.intake.common.model.InGraduateCentre;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.common.model.InSupervisorCode;
import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.core.InFlowState;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.*;

import java.util.List;

public interface InIntakeDao extends GenericDao<Long, InIntake> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    InIntake findByReferenceNo(String referenceNo);

    InIntake findBySessionAndCategory(InIntakeSession session, InProgramLevel category);

    InProgramOffering findProgramOfferingById(Long id);

    InProgramOffering findProgramOfferingByIntakeAndProgramCode(InIntake intake, InProgramCode programCode);

    InSupervisorOffering findSupervisorOfferingById(Long id);

    InSupervisorOffering findSupervisorOfferingByIntakeAndSupervisorCode(InIntake intake, InSupervisorCode supervisorCode);

    InStudyModeOffering findModeOfferingById(Long id);

    InStudyModeOffering findModeOfferingByIntakeAndMode(InIntake intake, InStudyMode studyMode);

    List<InIntake> find(InFlowState flowState);

    List<InIntake> find(InGraduateCentre graduateCentre);

    List<InIntake> find(InIntakeSession session);

    List<InIntake> find(InIntakeSession session, InGraduateCentre graduateCentre);

    List<InIntake> find(InIntakeSession session, Integer offset, Integer limit);

    List<InIntake> find(InIntakeSession session, InGraduateCentre graduateCentre, Integer offset, Integer limit);

    List<InIntake> find(String filter, InIntakeSession session, Integer offset, Integer limit);

    List<InIntake> find(String filter, InIntakeSession session, InGraduateCentre graduateCentre, Integer offset, Integer limit);

    List<InProgramOffering> findProgramOfferings(InIntake intake);

    List<InSupervisorOffering> findSupervisorOfferings(InIntake intake);

    List<InStudyModeOffering> findModeOfferings(InIntake intake);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(InIntakeSession session);

    Integer count(InIntakeSession session, InGraduateCentre graduateCentre);

    Integer count(String filter, InIntakeSession session);

    Integer count(String filter, InIntakeSession session, InGraduateCentre graduateCentre);

    Integer countProgramOffering(InIntake intake);

    Integer countSupervisorOffering(InIntake intake);

    Integer countModeOffering(InIntake intake);


    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    void addProgramOffering(InIntake intake, InProgramOffering offering, InUser user);

    void deleteProgramOffering(InIntake intake, InProgramOffering offering, InUser user);

    void addSupervisorOffering(InIntake intake, InSupervisorOffering offering, InUser user);

    void deleteSupervisorOffering(InIntake intake, InSupervisorOffering offering, InUser user);

    void addModeOffering(InIntake intake, InStudyModeOffering offering, InUser user);

    void deleteModeOffering(InIntake intake, InStudyModeOffering offering, InUser user);

}
