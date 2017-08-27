package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InPromoCode;
import my.edu.umk.pams.intake.common.model.InPromoCodeImpl;
import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("promoCodeDao")
public class InPromoCodeDaoImpl extends GenericDaoSupport<Long, InPromoCode> implements InPromoCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(InPromoCodeDaoImpl.class);

    public InPromoCodeDaoImpl() {
        super(InPromoCodeImpl.class);
    }

    @Override
    public InPromoCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InPromoCode s where s.code = :code and  " +
                " s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return (InPromoCode) query.uniqueResult();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from InPromoCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
