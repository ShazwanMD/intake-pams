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

    public GraduateCentre toGraduateCentreVo(InGraduateCentre e) {
        GraduateCentre vo = new GraduateCentre();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public StudyMode toStudyModeVo(InStudyMode e) {
        StudyMode vo = new StudyMode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public ProgramCode toProgramCodeVo(InProgramCode e) {
        ProgramCode vo = new ProgramCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public FacultyCode toFacultyCodeVo(InFacultyCode e) {
        FacultyCode vo = new FacultyCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescription(e.getDescription());
        return vo;
    }

    public SupervisorCode toSupervisorCodeVo(InSupervisorCode e) {
        SupervisorCode vo = new SupervisorCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescriptionMs(e.getDescriptionMs());
        vo.setDescriptionEn(e.getDescriptionEn());
        return vo;
    }

    public SchoolCode toSchoolCodeVo(InSchoolCode e) {
        SchoolCode vo = new SchoolCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescription(e.getDescription());
        return vo;
    }

    public List<GraduateCentre> toGraduateCentreVos(List<InGraduateCentre> e) {
        List<GraduateCentre> vos = e.stream()
                .map((e1) -> toGraduateCentreVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    public List<ProgramCode> toProgramCodeVos(List<InProgramCode> e) {
        List<ProgramCode> vos = e.stream()
                .map((e1) -> toProgramCodeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    public List<FacultyCode> toFacultyCodeVos(List<InFacultyCode> e) {
        List<FacultyCode> vos = e.stream()
                .map((e1) -> toFacultyCodeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    public List<SupervisorCode> toSupervisorCodeVos(List<InSupervisorCode> e) {
        List<SupervisorCode> vos = e.stream()
                .map((e1) -> toSupervisorCodeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    public List<SchoolCode> toSchoolCodeVos(List<InSchoolCode> e) {
        List<SchoolCode> vos = e.stream()
                .map((e1) -> toSchoolCodeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }

    public List<StudyMode> toStudyModeVos(List<InStudyMode> e) {
        List<StudyMode> vos = e.stream()
                .map((e1) -> toStudyModeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }
}
