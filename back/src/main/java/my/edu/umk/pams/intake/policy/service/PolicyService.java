package my.edu.umk.pams.intake.policy.service;

import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeCategory;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import org.activiti.engine.task.Task;

import java.util.List;

public interface PolicyService {

    //====================================================================================================
    // WORKFLOW
    //====================================================================================================

    void completeTask(Task task);

    void assignTask(Task task, InUser user);

    //====================================================================================================
    // INTAKE SESSION
    //====================================================================================================

    InIntakeSession findCurrentIntakeSession();

    InIntakeSession findIntakeSessionById(Long id);

    InIntakeSession findIntakeSessionByCode(String code);

    List<InIntakeSession> findIntakeSessions(Integer offset, Integer limit);

    List<InIntakeSession> findIntakeSessions(String filter, Integer offset, Integer limit);

    Integer countIntakeSession();

    Integer countIntakeSession(String filter);

    void saveIntakeSession(InIntakeSession session);

    void updateIntakeSession(InIntakeSession session);

    void removeIntakeSession(InIntakeSession session);

    //====================================================================================================
    // INTAKE CATEGORY
    //====================================================================================================

    InIntakeCategory findIntakeCategoryById(Long id);

    InIntakeCategory findIntakeCategoryByCode(String code);

    List<InIntakeCategory> findIntakeCategories();

    List<InIntakeCategory> findIntakeCategories(Integer offset, Integer limit);

    List<InIntakeCategory> findIntakeCategories(String filter, Integer offset, Integer limit);

    Integer countIntakeCategory();

    Integer countIntakeCategory(String filter);

    void saveIntakeCategory(InIntakeCategory category);

    void updateIntakeCategory(InIntakeCategory category);

    void removeIntakeCategory(InIntakeCategory category);

    //====================================================================================================
    // INTAKE
    //====================================================================================================

    InIntake findIntakeByTaskId(String taskId);

    List<Task> findAssignedIntakeTasks(Integer offset, Integer limit);

    List<Task> findPooledIntakeTasks(Integer offset, Integer limit);

    void startIntakeTask(InIntake intake);

    void updateIntake(InIntake intake);

    void cancelIntake(InIntake intake);

    void addProgramOffering(InIntake intake, InProgramOffering offering);

    //====================================================================================================
    // INTAKE
    //====================================================================================================

    InIntake findIntakeById(Long id);

    InIntake findIntakeByReferenceNo(String referenceNo);

    InIntake findIntakeBySessionAndCategory(InIntakeSession session, InIntakeCategory category);

    List<InIntake> findIntakes(InIntakeSession session);

    List<InIntake> findIntakes(InIntakeSession session, Integer offset, Integer limit);

    List<InIntake> findIntakes(String filter, InIntakeSession session, Integer offset, Integer limit);

    Integer countIntake(InIntakeSession session);

    Integer countIntake(String filter, InIntakeSession session);

    //====================================================================================================
    // PROGRAM OFFERING
    //====================================================================================================

    InProgramOffering findProgramOfferingById(Long id);

    InProgramOffering findProgramOfferingByIntakeAndProgramCode(InIntake intake, InProgramCode programCode);

    List<InProgramOffering> findProgramOfferings(InIntake intake);

}
