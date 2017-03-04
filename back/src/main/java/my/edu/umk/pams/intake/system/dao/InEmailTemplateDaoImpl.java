package my.edu.umk.pams.intake.system.dao;

import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import my.edu.umk.pams.intake.system.model.InEmailTemplate;
import my.edu.umk.pams.intake.system.model.InEmailTemplateImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 9/4/2016.
 */
@Repository("emailTemplateDao")
public class InEmailTemplateDaoImpl extends GenericDaoSupport<Long, InEmailTemplate> implements InEmailTemplateDao {

    public InEmailTemplateDaoImpl() {
        super(InEmailTemplateImpl.class);
    }

    @Override
    public InEmailTemplate findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InEmailTemplate s where " +
                "s.code = :code and  " +
                " s.metadata.state = :state");
        query.setString("code", code);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (InEmailTemplate) query.uniqueResult();
    }

    @Override
    public Integer count(String filter) {
        return null;
    }

    @Override
    public List<InEmailTemplate> find(String filter) {
        return null;
    }

    @Override
    public List<InEmailTemplate> find(String filter, Integer offset, Integer limit) {
        return null;
    }
}
