package my.edu.umk.pams.intake.web.module.common.controller;

import my.edu.umk.pams.intake.common.model.*;
import my.edu.umk.pams.intake.web.module.common.vo.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PAMS
 */
@Component("commonTransformer")
public class CommonTransformer {

    // ====================================================================================================
    // GRADUATE CENTER
    // ====================================================================================================

    public GraduateCentre toGraduateCentreVo(InGraduateCentre e) {
        GraduateCentre vo = new GraduateCentre();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public List<GraduateCentre> toGraduateCentreVos(List<InGraduateCentre> e) {
        List<GraduateCentre> vos = e.stream().map((e1) -> toGraduateCentreVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // STUDY MODE
    // ====================================================================================================

    public StudyMode toStudyModeVo(InStudyMode e) {
        StudyMode vo = new StudyMode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        vo.setPrefix(e.getPrefix());
        return vo;
    }

    public List<StudyMode> toStudyModeVos(List<InStudyMode> e) {
        List<StudyMode> vos = e.stream().map((e1) -> toStudyModeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // GENDER CODE
    // ====================================================================================================

    public GenderCode toGenderCodeVo(InGenderCode e) {
        GenderCode vo = new GenderCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());

        return vo;
    }

    public List<GenderCode> toGenderCodeVos(List<InGenderCode> e) {
        List<GenderCode> vos = e.stream().map((e1) -> toGenderCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // BANK CODE
    // ====================================================================================================

    public BankCode toBankCodeVo(InBankCode e) {
        BankCode vo = new BankCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setName(e.getName());
        return vo;
    }

    public List<BankCode> toBankCodeVos(List<InBankCode> e) {
        List<BankCode> vos = e.stream().map((e1) -> toBankCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // PROGRAM CODE
    // ====================================================================================================

    public ProgramCode toProgramCodeVo(InProgramCode e) {
        ProgramCode vo = new ProgramCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        vo.setFacultyCode(toFacultyCodeVo(e.getFacultyCode()));
        vo.setGraduateCentre(toGraduateCentreVo(e.getGraduateCentre()));
        return vo;
    }

    public List<ProgramCode> toProgramCodeVos(List<InProgramCode> e) {
        List<ProgramCode> vos = e.stream().map((e1) -> toProgramCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // FACULTY CODE
    // ====================================================================================================

    public FacultyCode toFacultyCodeVo(InFacultyCode e) {
        FacultyCode vo = new FacultyCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescription(e.getDescription());
        return vo;
    }

    public List<FacultyCode> toFacultyCodeVos(List<InFacultyCode> e) {
        List<FacultyCode> vos = e.stream().map((e1) -> toFacultyCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // SUPERVISOR CODE
    // ====================================================================================================

    public SupervisorCode toSupervisorCodeVo(InSupervisorCode e) {
        SupervisorCode vo = new SupervisorCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setName(e.getName());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public List<SupervisorCode> toSupervisorCodeVos(List<InSupervisorCode> e) {
        List<SupervisorCode> vos = e.stream().map((e1) -> toSupervisorCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // SCHOOL CODE
    // ====================================================================================================

    public SchoolCode toSchoolCodeVo(InSchoolCode e) {
        SchoolCode vo = new SchoolCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescription(e.getDescription());
        return vo;
    }

    public List<SchoolCode> toSchoolCodeVos(List<InSchoolCode> e) {
        List<SchoolCode> vos = e.stream().map((e1) -> toSchoolCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // MARITAL_CODE
    // ====================================================================================================

    public MaritalCode toMaritalCodeVo(InMaritalCode e) {
        MaritalCode vo = new MaritalCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionEn(e.getDescriptionEn());
        vo.setDescriptionMs(e.getDescriptionMs());
        return vo;
    }

    public List<MaritalCode> toMaritalCodeVos(List<InMaritalCode> e) {
        List<MaritalCode> vos = e.stream().map((e1) -> toMaritalCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // RELIGION CODE
    // ====================================================================================================

    public ReligionCode toReligionCodeVo(InReligionCode e) {
        ReligionCode vo = new ReligionCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public List<ReligionCode> toReligionCodeVos(List<InReligionCode> e) {
        List<ReligionCode> vos = e.stream().map((e1) -> toReligionCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // COUNTRY_CODE
    // ====================================================================================================

    public CountryCode toCountryCodeVo(InCountryCode e) {
        if (null == e) return null;
        CountryCode vo = new CountryCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public List<CountryCode> toCountryCodeVos(List<InCountryCode> e) {
        List<CountryCode> vos = e.stream().map((e1) -> toCountryCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // STATE_CODE
    // ====================================================================================================

    public StateCode toStateCodeVo(InStateCode e) {
        StateCode vo = new StateCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        vo.setCountryCode(toCountryCodeVo(e.getCountryCode()));
        return vo;
    }

    public List<StateCode> toStateCodeVos(List<InStateCode> e) {
        List<StateCode> vos = e.stream()
                .map((e1) -> toStateCodeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // RACE_CODE
    // ====================================================================================================

    public RaceCode toRaceCodeVo(InRaceCode e) {
        RaceCode vo = new RaceCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public List<RaceCode> toRaceCodeVos(List<InRaceCode> e) {
        List<RaceCode> vos = e.stream().map((e1) -> toRaceCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // ETHNICITY CODE
    // ====================================================================================================

    public EthnicityCode toEthnicityCodeVo(InEthnicityCode e) {
        EthnicityCode vo = new EthnicityCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public List<EthnicityCode> toEthnicityCodeVos(List<InEthnicityCode> e) {
        List<EthnicityCode> vos = e.stream().map((e1) -> toEthnicityCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // NATIONALITY CODE
    // ====================================================================================================

    public NationalityCode toNationalityCodeVo(InNationalityCode e) {
        NationalityCode vo = new NationalityCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public List<NationalityCode> toNationalityCodeVos(List<InNationalityCode> e) {
        List<NationalityCode> vos = e.stream().map((e1) -> toNationalityCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // DUN_CODE
    // ====================================================================================================

    public DunCode toDunCodeVo(InDunCode e) {
        DunCode vo = new DunCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescription(e.getDescription());
        //vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public List<DunCode> toDunCodeVos(List<InDunCode> e) {
        List<DunCode> vos = e.stream().map((e1) -> toDunCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // DISTRICT_CODE
    // ====================================================================================================

    public DistrictCode toDistrictCodeVo(InDistrictCode e) {
        DistrictCode vo = new DistrictCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescription(e.getDescription());
        //vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public List<DistrictCode> toDistrictCodeVos(List<InDistrictCode> e) {
        List<DistrictCode> vos = e.stream().map((e1) -> toDistrictCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }


    // ====================================================================================================
    // DISABILITY CODE
    // ====================================================================================================

    public DisabilityCode toDisabilityCodeVo(InDisabilityCode e) {
        DisabilityCode vo = new DisabilityCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public List<DisabilityCode> toDisabilityCodeVos(List<InDisabilityCode> e) {
        List<DisabilityCode> vos = e.stream().map((e1) -> toDisabilityCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // RESIDENCY_CODE
    // ====================================================================================================

    public ResidencyCode toResidencyCodeVo(InResidencyCode e) {
        ResidencyCode vo = new ResidencyCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescription(e.getDescription());
        //vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public List<ResidencyCode> toResidencyCodeVos(List<InResidencyCode> e) {
        List<ResidencyCode> vos = e.stream().map((e1) -> toResidencyCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // STUDY CENTER CODE
    // ====================================================================================================

    public StudyCenterCode toStudyCenterCodeVo(InStudyCenterCode e) {
        StudyCenterCode vo = new StudyCenterCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public List<StudyCenterCode> toStudyCenterCodeVos(List<InStudyCenterCode> e) {
        List<StudyCenterCode> vos = e.stream().map((e1) -> toStudyCenterCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

    // ====================================================================================================
    // PARLIAMENT CODE
    // ====================================================================================================

    public ParliamentCode toParliamentCodeVo(InParliamentCode e) {
        ParliamentCode vo = new ParliamentCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescription(e.getDescription());
        return vo;
    }

    public List<ParliamentCode> toParliamentCodeVos(List<InParliamentCode> e) {
        List<ParliamentCode> vos = e.stream().map((e1) -> toParliamentCodeVo(e1)).collect(Collectors.toList());
        return vos;
    }

}
