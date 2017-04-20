package my.edu.umk.pams.intake.web.module.application.controller;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.web.module.application.vo.IntakeApplication;
import my.edu.umk.pams.intake.web.module.core.vo.MetaState;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PAMS
 */
@Component("applicationTransformer")
public class ApplicationTransformer {
    
    public IntakeApplication toIntakeApplicationVo(InIntakeApplication e){
        IntakeApplication vo = new IntakeApplication();
        vo.setId(e.getId());
        vo.setReferenceNo(e.getReferenceNo());
        vo.setName(e.getName());
        vo.setCredentialNo(e.getCredentialNo());
        // todo(uda): more props
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public List<IntakeApplication> toIntakeApplicationVos(List<InIntakeApplication> e) {
        List<IntakeApplication> vos = e.stream()
                .map((e1) -> toIntakeApplicationVo(e1))
                .collect(Collectors.toList());
        return vos;
    }
}
