package my.edu.umk.pams.intake.policy.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.policy.model.InStudyMode;
import my.edu.umk.pams.intake.policy.model.InStudyModeImpl;

@Repository("inStudyModeDao")
public class InStudyModeDaoImpl extends GenericDaoSupport<Long, InStudyMode> implements InStudyModeDao {

	 public InStudyModeDaoImpl() {
	        super(InStudyModeImpl.class);
	    }

	@Override
	public InStudyMode findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
