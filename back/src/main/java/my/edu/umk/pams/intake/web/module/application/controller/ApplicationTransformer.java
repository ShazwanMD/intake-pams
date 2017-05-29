package my.edu.umk.pams.intake.web.module.application.controller;

import my.edu.umk.pams.intake.application.model.*;
import my.edu.umk.pams.intake.web.module.application.vo.*;
import my.edu.umk.pams.intake.web.module.common.controller.CommonTransformer;
import my.edu.umk.pams.intake.web.module.core.vo.MetaState;
import my.edu.umk.pams.intake.web.module.policy.controller.PolicyTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PAMS
 */
@Component("applicationTransformer")
public class ApplicationTransformer {

    @Autowired
    private PolicyTransformer policyTransformer;
    
    @Autowired
    private CommonTransformer commonTransformer;

    public IntakeApplication toIntakeApplicationVo(InIntakeApplication e) {
        IntakeApplication vo = new IntakeApplication();
        vo.setId(e.getId());
        vo.setReferenceNo(e.getReferenceNo());
        vo.setName(e.getName());
        vo.setCredentialNo(e.getCredentialNo());
        vo.setEmail(e.getEmail());
        vo.setPhone(e.getPhone());
        vo.setMobile(e.getMobile());
        vo.setFax(e.getFax());
        vo.setAge(e.getAge());
        vo.setBirthDate(e.getBirthDate());
        vo.setVerified(e.isVerified());
        vo.setPaid(e.isPaid());
        vo.setSponsored(e.isSponsored());
        vo.setSelfSponsored(e.isSelfSponsored());

        vo.setIntake(policyTransformer.toIntakeVo(e.getIntake()));
        vo.setProgramSelection(policyTransformer.toProgramOfferingVo(e.getProgramSelection()));
        vo.setStudyModeSelection(policyTransformer.toStudyModeOfferingVo(e.getStudyModeSelection()));
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public IntakeApplication toSimpleIntakeApplicationVo(InIntakeApplication e) {
        IntakeApplication vo = new IntakeApplication();
        vo.setId(e.getId());
        vo.setReferenceNo(e.getReferenceNo());
        vo.setName(e.getName());
        vo.setCredentialNo(e.getCredentialNo());
        vo.setEmail(e.getEmail());
        vo.setPhone(e.getPhone());
        vo.setFax(e.getFax());
        vo.setVerified(e.isVerified());
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public Guardian toGuardianVo(InGuardian e) {
        Guardian vo = new Guardian();
        vo.setId(e.getId());
        // todo(uda): more props
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public Guarantor toGuarantorVo(InGuarantor e) {
        Guarantor vo = new Guarantor();
        vo.setId(e.getId());
        // todo(uda): more props
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public Address toAddressVo(InAddress e) {
        Address vo = new Address();
        vo.setId(e.getId());
        vo.setAddress1(e.getAddress1());
        vo.setAddress2(e.getAddress2());
        vo.setAddress3(e.getAddress3());
        vo.setPostcode(e.getPostCode());
        vo.setCountryCode(commonTransformer.toCountryCodeVo(e.getCountryCode()));
        vo.setStateCode(commonTransformer.toStateCodeVo(e.getStateCode()));     
        vo.setAddressType(AddressType.get(e.getType().ordinal()));
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public List<Address> toAddressVos(List<InAddress> e) {
        List<Address> vos = e.stream()
                .map((e1) -> toAddressVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    public Contact toContactVo(InContact e) {
        Contact vo = new Contact();
        vo.setId(e.getId());
        // todo(uda): more props
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public Attachment toAttachmentVo(InAttachment e) {
        Attachment vo = new Attachment();
        vo.setId(e.getId());
        // todo(uda): more props
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public Education toEducationVo(InEducation e) {
        Education vo = new Education();
        vo.setId(e.getId());
        vo.setProvider(e.getProvider());
        vo.setStartDate(e.getStartDate());
        vo.setEndDate(e.getEndDate());
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public List<Education> toEducationVos(List<InEducation> e) {
        List<Education> vos = e.stream()
                .map((e1) -> toEducationVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    public Employment toEmploymentVo(InEmployment e) {
        Employment vo = new Employment();
        vo.setId(e.getId());
        vo.setCurrent(e.isCurrent());
        vo.setEmployer(e.getEmployer());
        vo.setDesignation(e.getDesignation());
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

    public Involvement toInvolvementVo(InInvolvement e) {
        Involvement vo = new Involvement();
        vo.setId(e.getId());
        // todo(uda): more props
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public Referee toRefereeVo(InReferee e) {
        Referee vo = new Referee();
        vo.setId(e.getId());
        vo.setName(e.getName());
        vo.setOfficeAddrs(e.getOfficeAddrs());
        vo.setOccupation(e.getOccupation());
        vo.setPhoneNo(e.getPhoneNo());
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public List<Referee> toRefereeVos(List<InReferee> e) {
        List<Referee> vos = e.stream()
                .map((e1) -> toRefereeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    public SpmResult toSpmResultVo(InSpmResult e) {
        SpmResult vo = new SpmResult();
        vo.setId(e.getId());
        vo.setMalay(e.getMalay());
        vo.setMath(e.getMath());
        vo.setEnglish(e.getEnglish());
        vo.setIslamicEduc(e.getIslamEduc());
        vo.setHistory(e.getHistory());
        vo.setYear(e.getYear());
        vo.setAggregate(e.getAggregate());
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public List<SpmResult> toSpmResultVos(List<InSpmResult> e) {
        List<SpmResult> vos = e.stream()
                .map((e1) -> toSpmResultVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    public List<IntakeApplication> toIntakeApplicationVos(List<InIntakeApplication> e) {
        List<IntakeApplication> vos = e.stream()
                .map((e1) -> toIntakeApplicationVo(e1))
                .collect(Collectors.toList());
        return vos;
    }


    public List<IntakeApplication> toSimpleIntakeApplicationVos(List<InIntakeApplication> e) {
        List<IntakeApplication> vos = e.stream()
                .map((e1) -> toSimpleIntakeApplicationVo(e1))
                .collect(Collectors.toList());
        return vos;
    }


    public BachelorResult toBachelorResultVo(InBachelorResult e) {
    	BachelorResult vo = new BachelorResult();
        vo.setId(e.getId());
        vo.setName(e.getName());
        vo.setYear(e.getYear());
        vo.setCgpa(e.getCgpa());
        vo.setResultType(ResultType.get(e.getResultType().ordinal()));
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public List<BachelorResult> toBachelorResultVos(List<InBachelorResult> e) {
        List<BachelorResult> vos = e.stream()
                .map((e1) -> toBachelorResultVo(e1))
                .collect(Collectors.toList());
        return vos;
    }
    
}
