package my.edu.umk.pams.intake.policy.service;

import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.dao.InIntakeCategoryDao;
import my.edu.umk.pams.intake.policy.dao.InIntakeDao;
import my.edu.umk.pams.intake.policy.dao.InIntakeSessionDao;
import my.edu.umk.pams.intake.policy.dao.InProgramOfferingDao;
import my.edu.umk.pams.intake.policy.model.*;
import my.edu.umk.pams.intake.util.Util;
import my.edu.umk.pams.intake.workflow.service.WorkflowConstants;
import my.edu.umk.pams.intake.workflow.service.WorkflowService;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.Validate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static my.edu.umk.pams.intake.core.InFlowState.DRAFTED;

@Service
public class PolicyServiceImpl implements PolicyService{

    @Autowired
    private InIntakeSessionDao intakeSessionDao;

    @Autowired
    private InIntakeCategoryDao intakeCategoryDao;

    @Autowired
    private InIntakeDao intakeDao;

    @Autowired
    private InProgramOfferingDao programOfferingDao;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ApplicationContext applicationContext;

    //====================================================================================================
    // WORKFLOW
    //====================================================================================================

    @Override
    public void completeTask(Task task) {
        workflowService.completeTask(task);
    }

    public void assignTask(Task task, InUser user) {
        workflowService.assignTask(task, user.getName());
    }

    //====================================================================================================
    // INTAKE SESSION
    //====================================================================================================

    @Override
    public void saveIntakeSession(InIntakeSession session) {
        intakeSessionDao.save(session, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateIntakeSession(InIntakeSession session) {
        intakeSessionDao.update(session, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeIntakeSession(InIntakeSession session) {
        intakeSessionDao.remove(session, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // INTAKE CATEGORY
    //====================================================================================================

    @Override
    public void saveIntakeCategory(InIntakeCategory category) {
        intakeCategoryDao.save(category, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateIntakeCategory(InIntakeCategory category) {
        intakeCategoryDao.update(category, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeIntakeCategory(InIntakeCategory category) {
        intakeCategoryDao.remove(category, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // INTAKE
    //====================================================================================================

    @Override
    public void startIntakeTask(InIntake intake) {
        intakeDao.save(intake, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(intake);

        // trigger workflow
        workflowService.processWorkflow(intake, prepareVariables(intake));
    }

    @Override
    public void updateIntake(InIntake intake) {
        intakeDao.update(intake, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void cancelIntake(InIntake intake) {
        Validate.notNull(intake, "Intake cannot be null");
        Validate.isTrue(DRAFTED.equals(intake.getFlowdata().getState()), "Intake can only be cancelled in DRAFTED state");
        intakeDao.update(intake, Util.getCurrentUser());

        List<InProgramOffering> offerings = findProgramOfferings(intake);
//        IntakeCancelledEvent event = new IntakeCancelledEvent(intake, offerings);
//        applicationContext.publishEvent(event);
    }

    @Override
    public void addProgramOffering(InIntake intake, InProgramOffering offering) {
        Validate.notNull(intake, "Intake cannot be null");
        Validate.notNull(offering, "Offering cannot be null");
        Validate.isTrue(DRAFTED.equals(intake.getFlowdata().getState()), "Intake can only be configured in DRAFTED state");
        intakeDao.addOffering(intake, offering, Util.getCurrentUser());
    }

    @Override
    public InIntake findIntakeByTaskId(String taskId) {
        Task task = workflowService.findTask(taskId);
        Map<String, Object> map = workflowService.getVariables(task.getExecutionId());
        return intakeDao.findById((Long) map.get(IntakeConstants.INTAKE_ID));
    }

    @Override
    public List<Task> findAssignedIntakeTasks(Integer offset, Integer limit) {
        return workflowService.findAssignedTasks(InIntake.class.getName(), offset, limit);
    }

    @Override
    public List<Task> findPooledIntakeTasks(Integer offset, Integer limit) {
        return workflowService.findPooledTasks(InIntake.class.getName(), offset, limit);
    }

    private static Map<String, Object> prepareVariables(InIntake intake) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(IntakeConstants.INTAKE_ID, intake.getId());
        map.put(WorkflowConstants.USER_CREATOR, Util.getCurrentUser().getName());
        map.put(WorkflowConstants.REFERENCE_NO, intake.getReferenceNo());
        map.put(WorkflowConstants.REMOVE_DECISION, false);
        map.put(WorkflowConstants.CANCEL_DECISION, false);
        return map;
    }

    //    public InGroup getAdminGroup() {
//        return groupDao.findByName();
//    }

    //====================================================================================================
    // INTAKE SESSION
    //====================================================================================================

    @Override
    public InIntakeSession findCurrentIntakeSession() {
        return intakeSessionDao.findCurrent();
    }

    @Override
    public InIntakeSession findIntakeSessionById(Long id) {
        return intakeSessionDao.findById(id);
    }

    @Override
    public InIntakeSession findIntakeSessionByCode(String code) {
        return intakeSessionDao.findByCode(code);
    }

    @Override
    public List<InIntakeSession> findIntakeSessions(Integer offset, Integer limit) {
        return intakeSessionDao.find(offset, limit);
    }

    @Override
    public List<InIntakeSession> findIntakeSessions(String filter, Integer offset, Integer limit) {
        return intakeSessionDao.find(filter, offset, limit);
    }

    @Override
    public Integer countIntakeSession() {
        return intakeSessionDao.count();
    }

    @Override
    public Integer countIntakeSession(String filter) {
        return intakeSessionDao.count(filter);
    }

    //====================================================================================================
    // INTAKE CATEGORY
    //====================================================================================================

    @Override
    public InIntakeCategory findIntakeCategoryById(Long id) {
        return intakeCategoryDao.findById(id);
    }

    @Override
    public InIntakeCategory findIntakeCategoryByCode(String code) {
        return intakeCategoryDao.findByCode(code);
    }

    @Override
    public List<InIntakeCategory> findIntakeCategories() {
        return intakeCategoryDao.find();
    }

    @Override
    public List<InIntakeCategory> findIntakeCategories(Integer offset, Integer limit) {
        return intakeCategoryDao.find(offset, limit);
    }

    @Override
    public List<InIntakeCategory> findIntakeCategories(String filter, Integer offset, Integer limit) {
        return intakeCategoryDao.find(filter, offset, limit);
    }

    @Override
    public Integer countIntakeCategory() {
        return intakeCategoryDao.count();
    }

    @Override
    public Integer countIntakeCategory(String filter) {
        return intakeCategoryDao.count(filter);
    }

//====================================================================================================
    // INTAKE
    //====================================================================================================

    @Override
    public InIntake findIntakeById(Long id) {
        return intakeDao.findById(id);
    }

    @Override
    public InIntake findIntakeByReferenceNo(String referenceNo) {
        return intakeDao.findByReferenceNo(referenceNo);
    }

    @Override
    public InIntake findIntakeBySessionAndCategory(InIntakeSession session, InIntakeCategory category) {
        return intakeDao.findBySessionAndCategory(session, category);
    }

    @Override
    public List<InIntake> findIntakes(InIntakeSession session) {
        return intakeDao.find(session);
    }

    @Override
    public List<InIntake> findIntakes(InIntakeSession session, Integer offset, Integer limit) {
        return intakeDao.find(session, offset, limit);
    }

    @Override
    public List<InIntake> findIntakes(String filter, InIntakeSession session, Integer offset, Integer limit) {
        return intakeDao.find(filter, session, offset, limit);
    }

    @Override
    public Integer countIntake(InIntakeSession session) {
        return intakeDao.count(session);
    }

    @Override
    public Integer countIntake(String filter, InIntakeSession session) {
        return intakeDao.count(filter, session);
    }

    //====================================================================================================
    // PROGRAM OFFERING
    //====================================================================================================

    @Override
    public InProgramOffering findProgramOfferingById(Long id) {
        return intakeDao.findOfferingById(id);
    }

    @Override
    public InProgramOffering findProgramOfferingByIntakeAndProgramCode(InIntake intake, InProgramCode programCode) {
        return intakeDao.findOfferingByIntakeAndProgramCode(intake, programCode);
    }

    @Override
    public List<InProgramOffering> findProgramOfferings(InIntake intake) {
        return programOfferingDao.find(intake);
    }
}
