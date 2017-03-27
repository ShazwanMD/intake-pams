package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InSubjectCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

public interface InSubjectCodeDao extends GenericDao<Long, InSubjectCode> {

    InSubjectCode findByCode(String code);

    List<InSubjectCode> find(String filter, Integer offset, Integer limit);

    Integer count(String filter);

    boolean isExists(String code);
}
