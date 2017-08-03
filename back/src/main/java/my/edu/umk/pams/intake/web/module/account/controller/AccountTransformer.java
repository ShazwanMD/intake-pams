package my.edu.umk.pams.intake.web.module.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.web.module.account.vo.MyIntakeApplication;
import my.edu.umk.pams.intake.web.module.admission.controller.AdmissionTransformer;
import my.edu.umk.pams.intake.web.module.admission.vo.Candidate;
import my.edu.umk.pams.intake.web.module.identity.vo.User;
import my.edu.umk.pams.intake.web.module.policy.controller.PolicyTransformer;


@Component("accountTransformer")
public class AccountTransformer {

    @Autowired
    private AdmissionTransformer admissionTransformer;

    @Autowired
    private PolicyTransformer policyTransformer;

    @Autowired
    private AdmissionService admissionService;

	// ====================================================================================================
    // USER
    // ====================================================================================================

    public User toUserVo(InUser user) {
    	if(null == user) return null;
        User vo = new User();
        vo.setId(user.getId());
        vo.setEmail(user.getEmail());
        vo.setPassword(user.getPassword());
        vo.setRealName(user.getRealName());
        return vo;
    }

    public MyIntakeApplication toMyIntakeApplicationVo(InIntakeApplication application) {
        InCandidate candidate = admissionService.findCandidateByIntakeApplication(application);
        MyIntakeApplication vo = new MyIntakeApplication();
        vo.setReferenceNo(application.getReferenceNo());
        vo.setIntake(policyTransformer.toIntakeVo(application.getIntake()));
        vo.setCandidate(admissionTransformer.toCandidateVo(candidate));
        return vo;
    }
    
    public List<MyIntakeApplication> toMyIntakeApplicationVos(List<InIntakeApplication> applications) {
        return applications.stream()
                .map((task) -> toMyIntakeApplicationVo(task))
                .collect(toCollection(() -> new ArrayList<MyIntakeApplication>()));
    }    

    public List<User> toUserVos(List<InUser> user) {
        List<User> vos = user.stream().map((user1) -> toUserVo(user1)).collect(Collectors.toList());
        return vos;
    }
}
