package my.edu.umk.pams.intake.web.module.policy.controller;

import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.policy.model.*;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.web.module.common.controller.CommonTransformer;
import my.edu.umk.pams.intake.web.module.core.vo.FlowState;
import my.edu.umk.pams.intake.web.module.core.vo.MetaState;
import my.edu.umk.pams.intake.web.module.policy.vo.*;
import my.edu.umk.pams.intake.workflow.service.WorkflowService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

/**
 * @author PAMS
 */
@Component("policyTransformer")
public class PolicyTransformer {

    @Autowired
    private PolicyService policyService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private CommonTransformer commonTransformer;

    public IntakeTask toIntakeTaskVo(Task t) {
        Map<String, Object> vars = workflowService.getVariables(t.getExecutionId());
        InIntake intake = policyService.findIntakeById((Long) vars.get(IntakeConstants.INTAKE_ID));

        IntakeTask task = new IntakeTask();
        task.setId(intake.getId());
        task.setTaskId(t.getId());
        task.setReferenceNo(intake.getReferenceNo());
        task.setSourceNo(intake.getSourceNo());
        task.setDescription(intake.getDescription());
        task.setTaskName(t.getName());
        task.setAssignee(task.getAssignee());
        task.setCandidate(task.getCandidate());
        task.setIntake(toIntakeVo(intake));
        task.setFlowState(FlowState.get(intake.getFlowdata().getState().ordinal()));
        task.setMetaState(MetaState.get(intake.getMetadata().getState().ordinal()));
        return task;
    }

    public IntakeSession toIntakeSessionVo(InIntakeSession e) {
        IntakeSession vo = new IntakeSession();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionEn(e.getDescriptionEn());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setLabel(e.getLabel());
        vo.setYear(e.getYear());
        vo.setCurrent(e.isCurrent());
        return vo;
    }

    public ProgramLevel toProgramLevelVo(InProgramLevel e) {
        ProgramLevel vo = new ProgramLevel();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setPrefix(e.getPrefix());
        vo.setDescription(e.getDescription());
        return vo;
    }

    public Intake toIntakeVo(InIntake e) {
        Intake vo = new Intake();
        vo.setId(e.getId());
        vo.setReferenceNo(e.getReferenceNo());
        vo.setSourceNo(e.getSourceNo());
        vo.setDescription(e.getDescription());
        vo.setProjection(e.getProjection());
        vo.setStarDate(e.getStartDate());
        vo.setEndDate(e.getEndDate());
        vo.setIntakeSession(toIntakeSessionVo(e.getSession()));
        vo.setProgramLevel(toProgramLevelVo(e.getProgramLevel()));
        vo.setFlowState(FlowState.get(e.getFlowdata().getState().ordinal()));
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public ProgramOffering toProgramOfferingVo(InProgramOffering e) {
        ProgramOffering vo = new ProgramOffering();
        vo.setId(e.getId());
        vo.setProgramCode(commonTransformer.toProgramCodeVo(e.getProgramCode()));
        return vo;
    }
    public SupervisorOffering toSupervisorOfferingVo(InSupervisorOffering e) {
        SupervisorOffering vo = new SupervisorOffering();
        vo.setId(e.getId());
        vo.setSupervisorCode(commonTransformer.toSupervisorCodeVo(e.getSupervisorCode()));
        return vo;
    }

    public List<IntakeTask> toIntakeTaskVos(List<Task> tasks) {
        return tasks.stream()
                .map((task) -> toIntakeTaskVo(task))
                .collect(toCollection(() -> new ArrayList<IntakeTask>()));
    }

    public List<Intake> toIntakeVos(List<InIntake> e) {
        List<Intake> vos = e.stream()
                .map((e1) -> toIntakeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    public List<IntakeSession> toIntakeSessionVos(List<InIntakeSession> e) {
        List<IntakeSession> vos = e.stream()
                .map((e1) -> toIntakeSessionVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    public List<ProgramLevel> toProgramLevelVos(List<InProgramLevel> e) {
        List<ProgramLevel> vos = e.stream()
                .map((e1) -> toProgramLevelVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    public List<ProgramOffering> toProgramOfferingVos(List<InProgramOffering> e) {
        List<ProgramOffering> vos = e.stream()
                .map((e1) -> toProgramOfferingVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    public List<SupervisorOffering> toSupervisorOfferingVos(List<InSupervisorOffering> e) {
        List<SupervisorOffering> vos = e.stream()
                .map((e1) -> toSupervisorOfferingVo(e1))
                .collect(Collectors.toList());
        return vos;
    }
}
