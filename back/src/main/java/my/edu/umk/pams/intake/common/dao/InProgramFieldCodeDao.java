package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InFacultyCode;
import my.edu.umk.pams.intake.common.model.InGraduateCenter;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InProgramFieldCode;
import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;

import java.util.List;

public interface InProgramFieldCodeDao extends GenericDao<Long, InProgramFieldCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    InProgramFieldCode findByCode(String code);



	List<InProgramFieldCode> find(InFacultyCode facultyCode);


	List<InProgramFieldCode> find(InGraduateCenter graduateCenter);


	List<InProgramFieldCode> find(InFacultyCode facultyCode, InProgramLevel programLevel);


	List<InProgramFieldCode> find(InGraduateCenter graduateCenter, InProgramLevel programLevel);


	List<InProgramFieldCode> find(String filter, Integer offset, Integer limit);


	List<InProgramFieldCode> find(InProgramLevel inProgramLevel);

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
