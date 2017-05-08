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

    //====================================================================================================
    // GRADUATE CENTER
    //====================================================================================================

    public GraduateCentre toGraduateCentreVo(InGraduateCentre e) {
        GraduateCentre vo = new GraduateCentre();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public List<GraduateCentre> toGraduateCentreVos(List<InGraduateCentre> e) {
        List<GraduateCentre> vos = e.stream()
                .map((e1) -> toGraduateCentreVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    //====================================================================================================
    // GRADUATE CENTER
    //====================================================================================================

    public StudyMode toStudyModeVo(InStudyMode e) {
        StudyMode vo = new StudyMode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public List<StudyMode> toStudyModeVos(List<InStudyMode> e) {
        List<StudyMode> vos = e.stream()
                .map((e1) -> toStudyModeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    //====================================================================================================
    // GRADUATE CENTER
    //====================================================================================================

    public GenderCode toGenderCodeVo(InGenderCode e) {
    	GenderCode vo = new GenderCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }


    public List<GenderCode> toGenderCodeVos(List<InGenderCode> e) {
        List<GenderCode> vos = e.stream()
                .map((e1) -> toGenderCodeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    //====================================================================================================
    // GRADUATE CENTER
    //====================================================================================================

    public BankCode toBankCodeVo(InBankCode e) {
        BankCode vo = new BankCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setName(e.getName());
        return vo;
    }

    public List<BankCode> toBankCodeVos(List<InBankCode> e) {
        List<BankCode> vos = e.stream()
                .map((e1) -> toBankCodeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }


    //====================================================================================================
    // GRADUATE CENTER
    //====================================================================================================

    public ProgramCode toProgramCodeVo(InProgramCode e) {
        ProgramCode vo = new ProgramCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }


    public List<ProgramCode> toProgramCodeVos(List<InProgramCode> e) {
        List<ProgramCode> vos = e.stream()
                .map((e1) -> toProgramCodeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    //====================================================================================================
    // GRADUATE CENTER
    //====================================================================================================

    public FacultyCode toFacultyCodeVo(InFacultyCode e) {
        FacultyCode vo = new FacultyCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescription(e.getDescription());
        return vo;
    }

    public List<FacultyCode> toFacultyCodeVos(List<InFacultyCode> e) {
        List<FacultyCode> vos = e.stream()
                .map((e1) -> toFacultyCodeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }



    //====================================================================================================
    // GRADUATE CENTER
    //====================================================================================================

    public SupervisorCode toSupervisorCodeVo(InSupervisorCode e) {
        SupervisorCode vo = new SupervisorCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public List<SupervisorCode> toSupervisorCodeVos(List<InSupervisorCode> e) {
        List<SupervisorCode> vos = e.stream()
                .map((e1) -> toSupervisorCodeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }


    //====================================================================================================
    // GRADUATE CENTER
    //====================================================================================================

    public SchoolCode toSchoolCodeVo(InSchoolCode e) {
        SchoolCode vo = new SchoolCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescription(e.getDescription());
        return vo;
    }

    public List<SchoolCode> toSchoolCodeVos(List<InSchoolCode> e) {
        List<SchoolCode> vos = e.stream()
                .map((e1) -> toSchoolCodeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }


  //====================================================================================================
 // MARITAL_CODE
 //====================================================================================================

    public MaritalCode toMaritalCodeVo(InMaritalCode e) {
     MaritalCode vo = new MaritalCode();
         vo.setId(e.getId());
         vo.setCode(e.getCode());
         vo.setDescriptionEn(e.getDescriptionEn());
         vo.setDescriptionMs(e.getDescriptionMs());
         return vo;
         }

    public List<MaritalCode> toMaritalCodeVos(List<InMaritalCode> e) {
         List<MaritalCode> vos = e.stream()
         .map((e1) -> toMaritalCodeVo(e1))
         .collect(Collectors.toList());
         return vos;
         }

  //====================================================================================================
  // IN_RELIGION_CODE
  //====================================================================================================

	public ReligionCode toReligionCodeVo(InReligionCode e) {
		ReligionCode vo = new ReligionCode();
		vo.setId(e.getId());
		vo.setCode(e.getCode());
		vo.setName(e.getName());
		vo.setDescriptionMs(e.getDescriptionMs());
		vo.setDescriptionEn(e.getDescriptionEn());
		return vo;
	}

    public List<ReligionCode> toReligionCodeVos(List<InReligionCode> e) {
        List<ReligionCode> vos = e.stream()
                .map((e1) -> toReligionCodeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }
}
