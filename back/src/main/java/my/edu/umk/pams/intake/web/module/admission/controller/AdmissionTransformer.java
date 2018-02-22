package my.edu.umk.pams.intake.web.module.admission.controller;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.web.module.admission.vo.Candidate;
import my.edu.umk.pams.intake.web.module.admission.vo.CandidateTask;
import my.edu.umk.pams.intake.web.module.application.controller.ApplicationTransformer;
import my.edu.umk.pams.intake.web.module.application.vo.IntakeApplication;
import my.edu.umk.pams.intake.web.module.common.controller.CommonTransformer;
import my.edu.umk.pams.intake.web.module.core.vo.FlowState;
import my.edu.umk.pams.intake.web.module.core.vo.MetaState;
import my.edu.umk.pams.intake.web.module.policy.controller.PolicyTransformer;
import my.edu.umk.pams.intake.web.module.policy.vo.Intake;
import my.edu.umk.pams.intake.web.module.policy.vo.IntakeTask;
import my.edu.umk.pams.intake.web.module.policy.vo.ProgramOffering;
import my.edu.umk.pams.intake.web.module.policy.vo.StudyModeOffering;
import my.edu.umk.pams.intake.workflow.service.WorkflowService;

import static java.util.stream.Collectors.toCollection;
/**
 * @author PAMS
 */
@Component("admissionTransformer")
public class AdmissionTransformer {

    @Autowired
    private CommonTransformer commonTransformer;
    
    @Autowired
    private PolicyTransformer policyTransformer;
    
    @Autowired
    private ApplicationTransformer applicationTransformer;
    
    @Autowired
    private WorkflowService workflowService;
    
    @Autowired
    private AdmissionService admissionService;
    

    public Candidate toCandidateVo(InCandidate e) {
        if(null == e) return null;
        Candidate vo = new Candidate();
        vo.setId(e.getId());
        vo.setName(e.getName());
        vo.setEmail(e.getEmail());
        vo.setReason(e.getReason());
        vo.setStatus(InCandidateStatus.get(e.getStatus().ordinal()));
        vo.setIdentityNo(e.getIdentityNo());
        vo.setMatricNo(e.getMatricNo());
        vo.setStudyModeOffering(policyTransformer.toStudyModeOfferingVo(e.getStudyModeSelection()));
        vo.setApplication(applicationTransformer.toIntakeApplicationVo(e.getApplication()));
        vo.setProgramSelection(policyTransformer.toProgramOfferingVo(e.getProgramSelection()));
        vo.setAcception(e.getAcception());
        
        return vo;
    }

    public List<Candidate> toCandidateVos(List<InCandidate> candidates) {
        return candidates.stream()
                .map((task) -> toCandidateVo(task))
                .collect(toCollection(() -> new ArrayList<Candidate>()));
    }
    
    
    public CandidateTask toCandidateTaskVo(Task t){
    	Map<String, Object> vars = workflowService.getVariables(t.getExecutionId());
    	InCandidate candidate = admissionService.findCandidateById((Long) vars.get(IntakeConstants.CANDIDATE_ID));
    	
  //  	if (null == t) return null;
    	
    	CandidateTask task = new CandidateTask();
        task.setId(candidate.getId());
        task.setTaskId(t.getId());
        task.setReferenceNo(candidate.getReferenceNo());
        task.setSourceNo(candidate.getSourceNo());
        task.setTaskName(t.getName());
        task.setAssignee(task.getAssignee());
        task.setDescriptionEn(candidate.getDescriptionEn());
        task.setDescriptionMs(candidate.getDescriptionMs());
        task.setCandidate(task.getCandidate());
        task.setCandidateIntake(toCandidateVo(candidate));
        task.setFlowState(FlowState.get(candidate.getFlowdata().getState().ordinal()));
        task.setMetaState(MetaState.get(candidate.getMetadata().getState().ordinal()));
        task.setStudyMode(policyTransformer.toStudyModeOfferingVo(candidate.getStudyModeSelection()));
        task.setProgramSelection(policyTransformer.toProgramOfferingVo(candidate.getProgramSelection()));
        task.setIntakeSession(policyTransformer.toIntakeSessionVo(candidate.getIntake().getSession()));
        return task;
    }
    

    
    
    public List<CandidateTask> toCandidateTaskVos(List<Task> tasks){
    	return tasks.stream()
    			.map((task) -> toCandidateTaskVo(task))
    			.collect(toCollection(() -> new ArrayList<CandidateTask>()));
    	
    }
    

}

