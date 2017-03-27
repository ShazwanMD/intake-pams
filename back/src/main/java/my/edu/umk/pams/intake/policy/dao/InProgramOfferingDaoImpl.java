package my.edu.umk.pams.intake.policy.dao;

import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.policy.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository("inProgramOfferingDao")
public class InProgramOfferingDaoImpl extends GenericDaoSupport<Long, InProgramOffering> implements InProgramOfferingDao {

    public InProgramOfferingDaoImpl() {
        super(InProgramOfferingImpl.class);
    }

    @Override
    public InProgramOffering find(InIntake intake, InProgramCode programCode) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InProgramOffering p where " +
                "p.intake = :intake " +
                "and p.programCode = :programCode");
        query.setEntity("intake", intake);
        query.setEntity("programCode", programCode);
        return (InProgramOffering) query.uniqueResult();
    }

    @Override
    public List<InProgramOffering> find(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InProgramOffering p where " +
                "p.intake = :intake");
        query.setEntity("intake", intake);
        return (List<InProgramOffering>) query.list();
    }

    @Override
    public Integer count(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InProgramOffering p " +
                "where p.intake = :intake");
        query.setEntity("intake", intake);
        return (Integer) query.uniqueResult();
    }
}
