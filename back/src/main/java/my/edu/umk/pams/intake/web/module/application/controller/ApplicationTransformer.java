package my.edu.umk.pams.intake.web.module.application.controller;

import my.edu.umk.pams.intake.application.model.*;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.web.module.application.vo.*;
import my.edu.umk.pams.intake.web.module.core.vo.FlowState;
import my.edu.umk.pams.intake.web.module.core.vo.MetaState;
import my.edu.umk.pams.intake.web.module.policy.vo.Intake;

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
    
    public Guardian toGuardianVo(InGuardian e){
        Guardian vo = new Guardian();
        vo.setId(e.getId());
        // todo(uda): more props
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }
    
    public Guarantor toGuarantorVo(InGuarantor e){
        Guarantor vo = new Guarantor();
        vo.setId(e.getId());
        // todo(uda): more props
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }
    
    public Address toAddressVo(InAddress e){
        Address vo = new Address();
        vo.setId(e.getId());
        // todo(uda): more props
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public Contact toContactVo(InContact e){
        Contact vo = new Contact();
        vo.setId(e.getId());
        // todo(uda): more props
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public Attachment toAttachmentVo(InAttachment e){
        Attachment vo = new Attachment();
        vo.setId(e.getId());
        // todo(uda): more props
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }


    public Education toEducationVo(InEducation e){
        Education vo = new Education();
        vo.setId(e.getId());
        // todo(uda): more props
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public Employment toEmploymentVo(InEmployment e){
        Employment vo = new Employment();
        vo.setId(e.getId());
  //      vo.setCurrent(true);
        vo.setEmployer(e.getEmployer());
        vo.setStartDate(e.getStartDate());
        vo.setEndDate(e.getEndDate());
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public List<Employment> toEmploymentVos(List<InEmployment> e) {
        List<Employment> vos = e.stream()
                .map((e1) -> toEmploymentVo(e1))
                .collect(Collectors.toList());
        return vos;
    }
    
    public Involvement toInvolvementVo(InInvolvement e){
        Involvement vo = new Involvement();
        vo.setId(e.getId());
        // todo(uda): more props
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public Referee toRefereeVo(InReferee e){
        Referee vo = new Referee();
        vo.setId(e.getId());
        // todo(uda): more props
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public Result toResultVo(InResult e){
        Result vo = new Result();
        vo.setId(e.getId());
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
