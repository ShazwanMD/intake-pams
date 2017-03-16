package my.edu.umk.pams.intake.policy.dao;

import org.springframework.stereotype.Repository;

import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.policy.model.InStudyMode;

@Repository("inStudyModeDao")
public interface InStudyModeDao extends GenericDao<Long, InStudyMode> {

	InStudyMode findByCode(String code);

}
