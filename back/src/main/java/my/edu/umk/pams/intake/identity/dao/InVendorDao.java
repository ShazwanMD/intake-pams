package my.edu.umk.pams.intake.identity.dao;


import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.identity.model.InApplicant;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface InVendorDao extends GenericDao<Long, InApplicant> {

    InApplicant findByVendorNo(String vendorNo);

    List<InApplicant> find(String filter, Integer offset, Integer limit);

    Integer count(String filter);
}
