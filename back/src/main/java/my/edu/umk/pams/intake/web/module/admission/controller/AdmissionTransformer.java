package my.edu.umk.pams.intake.web.module.admission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.web.module.admission.vo.Candidate;
import my.edu.umk.pams.intake.web.module.application.controller.ApplicationTransformer;
import my.edu.umk.pams.intake.web.module.common.controller.CommonTransformer;
import my.edu.umk.pams.intake.web.module.policy.controller.PolicyTransformer;

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
}

