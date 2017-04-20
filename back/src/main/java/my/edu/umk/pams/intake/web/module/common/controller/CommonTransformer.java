package my.edu.umk.pams.intake.web.module.common.controller;

import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InSchoolCode;
import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.common.model.InSupervisorCode;
import my.edu.umk.pams.intake.web.module.common.vo.ProgramCode;
import my.edu.umk.pams.intake.web.module.common.vo.SchoolCode;
import my.edu.umk.pams.intake.web.module.common.vo.StudyMode;
import my.edu.umk.pams.intake.web.module.common.vo.SupervisorCode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PAMS
 */
@Component("commonTransformer")
public class CommonTransformer {

    public StudyMode toStudyModeVo(InStudyMode e) {
        StudyMode m = new StudyMode();
        m.setId(e.getId());
        m.setCode(e.getCode());
        m.setDescriptionMs(e.getDescriptionMs());
        m.setDescriptionEn(e.getDescriptionEn());
        return m;
    }

    public ProgramCode toProgramCodeVo(InProgramCode e) {
        ProgramCode m = new ProgramCode();
        m.setId(e.getId());
        m.setCode(e.getCode());
        m.setDescriptionMs(e.getDescriptionMs());
        m.setDescriptionEn(e.getDescriptionEn());
        return m;
    }

    public SupervisorCode toSupervisorCodeVo(InSupervisorCode e) {
        SupervisorCode m = new SupervisorCode();
        m.setId(e.getId());
        m.setCode(e.getCode());
        m.setDescriptionMs(e.getDescriptionMs());
        m.setDescriptionEn(e.getDescriptionEn());
        return m;
    }

    public SchoolCode toSchoolCodeVo(InSchoolCode e) {
        SchoolCode m = new SchoolCode();
        m.setId(e.getId());
        m.setCode(e.getCode());
        m.setDescription(e.getDescription());
        return m;
    }

    public List<ProgramCode> toProgramCodeVos(List<InProgramCode> e) {
        List<ProgramCode> vos = e.stream()
                .map((e1) -> toProgramCodeVo(e1))
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
