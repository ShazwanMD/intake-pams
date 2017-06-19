package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InFacultyCode;
import my.edu.umk.pams.intake.common.model.InGraduateCenter;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;

import java.util.List;

public interface InProgramCodeDao extends GenericDao<Long, InProgramCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InProgramCode findByCode(String code);

    List<InProgramCode> find(InFacultyCode facultyCode);

    List<InProgramCode> find(InGraduateCenter graduateCenter);

    List<InProgramCode> find(InFacultyCode facultyCode, InProgramLevel programLevel);

    List<InProgramCode> find(InGraduateCenter graduateCenter, InProgramLevel programLevel);

    List<InProgramCode> find(String filter, Integer offset, Integer limit);
    
	List<InProgramCode> find(InProgramLevel inProgramLevel, String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    Integer count(InFacultyCode facultyCode);

    Integer count(InGraduateCenter graduateCenter);

    Integer count(InFacultyCode facultyCode, InProgramLevel programLevel);

    Integer count(InGraduateCenter graduateCenter, InProgramLevel programLevel);

    boolean isExists(String code);

}
