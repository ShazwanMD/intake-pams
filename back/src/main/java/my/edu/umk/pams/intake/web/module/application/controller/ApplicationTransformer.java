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

	@Autowired
	private ApplicationTransformer applicationTransformer;

	
	public IntakeApplication toIntakeApplicationVo(InIntakeApplication e)
	{
		if(null == e) return null;
		IntakeApplication vo = new IntakeApplication();	
		vo.setId(e.getId());
		vo.setReferenceNo(e.getReferenceNo());
	//	vo.setPromoCode(commonTransformer.toPromoCodeVo(e.getPromoCode()));
		vo.setResearchTitle(e.getResearchTitle());
		vo.setName(e.getName());
		vo.setCredentialNo(e.getCredentialNo());
		vo.setEmail(e.getEmail());
		vo.setPhone(e.getPhone());
		vo.setMobile(e.getMobile());
		vo.setFax(e.getFax());
		vo.setAge(e.getAge());
		vo.setMerit(e.getMerit());
		vo.setPassExpDate(e.getPassportExpDate());
		vo.setBirthDate(e.getBirthDate());
		vo.setReason(e.getReason());
		vo.setVerified(e.isVerified());
		vo.setPaid(e.isPaid());
		vo.setDeclared(e.isDeclared());
		vo.setSponsored(e.isSponsored());
		vo.setMerit(e.getMerit());
		vo.setSelfSponsored(e.isSelfSponsored());
		
		vo.setSpmResultAttached(e.isSpmResultAttached());
		vo.setStpmResultAttached(e.isStpmResultAttached());
		vo.setDiplomaResultAttached(e.isDiplomaResultAttached());
		vo.setBachelorResultAttached(e.isBachelorResultAttached());
		vo.setToeflResultAttached(e.isToeflResultAttached());
		vo.setIeltsResultAttached(e.isIeltsResultAttached());
		vo.setMuetResultAttached(e.isMuetResultAttached());
		vo.setStamResultAttached(e.isStamResultAttached());
		vo.setLanguageResultAttached(e.isLanguageResultAttached());
		vo.setResearchProposalAttached(e.isResearchProposalAttached());
		vo.setSponsorLetterAttached(e.isSponsorLetterAttached());
		vo.setRefereeFormAttached(e.isRefereeFormAttached());
		vo.setProcessingFeeAttached(e.isProcessingFeeAttached());
		vo.setBankStatementAttached(e.isBankStatementAttached());
		vo.setIcCopyAttached(e.isIcCopyAttached());
		vo.setPassportCopyAttached(e.isPassportCopyAttached());
		vo.setMasterResultAttached(e.isMasterResultAttached());
		vo.setPhdResultAttached(e.isPhdResultAttached());

		// address
		vo.setMailingAddress1(e.getMailingAddress1());
		vo.setMailingAddress2(e.getMailingAddress2());
		vo.setMailingAddress3(e.getMailingAddress3());
		vo.setMailingPostcode(e.getMailingPostcode());
		vo.setMailingStateCode(commonTransformer.toStateCodeVo(e.getMailingStateCode()));
		vo.setMailingCountryCode(commonTransformer.toCountryCodeVo(e.getMailingCountryCode()));
		vo.setOfficialAddress1(e.getOfficialAddress1());
		vo.setOfficialAddress2(e.getOfficialAddress2());
		vo.setOfficialAddress3(e.getOfficialAddress3());
		vo.setOfficialPostcode(e.getOfficialPostcode());
		vo.setOfficialStateCode(commonTransformer.toStateCodeVo(e.getOfficialStateCode()));
		vo.setOfficialCountryCode(commonTransformer.toCountryCodeVo(e.getOfficialCountryCode()));
		
		
		
		vo.setBidType(BidType.get(e.getBidType().ordinal()));
		vo.setBidStatus(InCandidateStatus.get(e.getBidStatus().ordinal()));
				
		vo.setGenderCode(commonTransformer.toGenderCodeVo(e.getGenderCode()));
		vo.setRaceCode(commonTransformer.toRaceCodeVo(e.getRaceCode()));
		vo.setReligionCode(commonTransformer.toReligionCodeVo(e.getReligionCode()));
		vo.setEthnicityCode(commonTransformer.toEthnicityCodeVo(e.getEthnicityCode()));
		vo.setMaritalCode(commonTransformer.toMaritalCodeVo(e.getMaritalCode()));
		vo.setNationalityCode(commonTransformer.toNationalityCodeVo(e.getNationalityCode()));
		vo.setResidencyCode(commonTransformer.toResidencyCodeVo(e.getResidencyCode()));
		vo.setStudyCenterCode(commonTransformer.toStudyCenterCodeVo(e.getStudyCenterCode()));
		vo.setIntake(policyTransformer.toIntakeVo(e.getIntake()));
		vo.setProgramSelection(policyTransformer.toProgramOfferingVo(e.getProgramSelection()));
		vo.setStudyModeSelection(policyTransformer.toStudyModeOfferingVo(e.getStudyModeSelection()));
		vo.setSupervisorSelection(policyTransformer.toSupervisorOfferingVo(e.getSupervisorSelection()));
		// vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
	    commonTransformer.decorateMeta(e,vo);


		return vo;
	}

	public IntakeApplication toSimpleIntakeApplicationVo(InIntakeApplication e) {
		IntakeApplication vo = new IntakeApplication();
		vo.setId(e.getId());
		vo.setReferenceNo(e.getReferenceNo());
	//	vo.setPromoCode(commonTransformer.toPromoCodeVo(e.getPromoCode()));
		vo.setName(e.getName());
		vo.setCredentialNo(e.getCredentialNo());
		vo.setEmail(e.getEmail());
		vo.setPhone(e.getPhone());
		vo.setFax(e.getFax());
		vo.setVerified(e.isVerified());
		vo.setResearchTitle(e.getResearchTitle());
		vo.setReason(e.getReason());
		vo.setMerit(e.getMerit());
		
		vo.setMaritalCode(commonTransformer.toMaritalCodeVo(e.getMaritalCode()));
		vo.setNationalityCode(commonTransformer.toNationalityCodeVo(e.getNationalityCode()));
		vo.setResidencyCode(commonTransformer.toResidencyCodeVo(e.getResidencyCode()));
		vo.setProgramSelection(policyTransformer.toProgramOfferingVo(e.getProgramSelection()));
		vo.setStudyModeSelection(policyTransformer.toStudyModeOfferingVo(e.getStudyModeSelection()));
		vo.setSupervisorSelection(policyTransformer.toSupervisorOfferingVo(e.getSupervisorSelection()));
		vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
		vo.setIntake(policyTransformer.toIntakeVo(e.getIntake()));
		
		// address
		vo.setMailingAddress1(e.getMailingAddress1());
		vo.setMailingAddress2(e.getMailingAddress2());
		vo.setMailingAddress3(e.getMailingAddress3());
		vo.setMailingPostcode(e.getMailingPostcode());
		vo.setMailingStateCode(commonTransformer.toStateCodeVo(e.getMailingStateCode()));
		vo.setMailingCountryCode(commonTransformer.toCountryCodeVo(e.getMailingCountryCode()));
		vo.setOfficialAddress1(e.getOfficialAddress1());
		vo.setOfficialAddress2(e.getOfficialAddress2());
		vo.setOfficialAddress3(e.getOfficialAddress3());
		vo.setOfficialPostcode(e.getOfficialPostcode());
		vo.setOfficialStateCode(commonTransformer.toStateCodeVo(e.getOfficialStateCode()));
		vo.setOfficialCountryCode(commonTransformer.toCountryCodeVo(e.getOfficialCountryCode()));
		commonTransformer.decorateMeta(e,vo);
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
		vo.setName(e.getName());
		vo.setSize(e.getSize());
		vo.setMimeType(e.getMimeType());
		vo.setAttachmentType(AttachmentType.get(e.getAttachmentType().ordinal()));

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
		List<Education> vos = e.stream().map((e1) -> toEducationVo(e1)).collect(Collectors.toList());
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
		vo.setEmploymentType(EmploymentType.get(e.getEmploymentType().ordinal()));
		vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
		return vo;
	}

	public Language toLanguageVo(InLanguage e) {
		Language vo = new Language();
		vo.setId(e.getId());
		vo.setOral(e.getOral());
		vo.setWritten(e.getWritten());
		vo.setLanguageCode(commonTransformer.toLanguageCodeVo(e.getLanguageCode()));
		vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
		return vo;
	}

	public List<Employment> toEmploymentVos(List<InEmployment> e) {
		List<Employment> vos = e.stream().map((e1) -> toEmploymentVo(e1)).collect(Collectors.toList());
		return vos;
	}

	public List<Language> toLanguageVos(List<InLanguage> e) {
		List<Language> vos = e.stream().map((e1) -> toLanguageVo(e1)).collect(Collectors.toList());
		return vos;
	}

	public List<Attachment> toAttachmentVos(List<InAttachment> e) {
		List<Attachment> vos = e.stream().map((e1) -> toAttachmentVo(e1)).collect(Collectors.toList());
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
		vo.setRefereeType(RefereeType.get(e.getType().ordinal()));
		vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
		return vo;
	}

	public List<Referee> toRefereeVos(List<InReferee> e) {
		List<Referee> vos = e.stream().map((e1) -> toRefereeVo(e1)).collect(Collectors.toList());
		return vos;
	}

	public List<IntakeApplication> toIntakeApplicationVos(List<InIntakeApplication> e) {
		List<IntakeApplication> vos = e.stream().map((e1) -> toIntakeApplicationVo(e1)).collect(Collectors.toList());
		return vos;
	}

	public List<IntakeApplication> toSimpleIntakeApplicationVos(List<InIntakeApplication> e) {
		List<IntakeApplication> vos = e.stream().map((e1) -> toSimpleIntakeApplicationVo(e1))
				.collect(Collectors.toList());
		return vos;
	}

	public Result toResultVo(InResult e) {
		Result vo = new Result();
		vo.setId(e.getId());
		vo.setResultType(ResultType.get(e.getResultType().ordinal()));
		vo.setName(e.getName());
		vo.setField(e.getField());
		vo.setGraduationYear(e.getGraduationYear());
		vo.setResultAlphanumeric(e.getResultAlphanumeric());
		vo.setResultNumeric(e.getResultNumeric());
		vo.setMalayResult(e.getMalayResult());
		vo.setEnglishResult(e.getEnglishResult());
		vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
		return vo;
	}

	public List<Result> toResultVos(List<InResult> e) {
		List<Result> vos = e.stream().map((e1) -> toResultVo(e1)).collect(Collectors.toList());
		return vos;
	}
}
