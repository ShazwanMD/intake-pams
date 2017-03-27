package my.edu.umk.pams.intake.identity.dao;


import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.identity.model.InStaff;

import java.util.List;

/**
 * @author team canang
 * @since 6/6/2015.
 */
public interface InStaffDao extends GenericDao<Long, InStaff> {

    InStaff findByStaffNo(String staffNo);

    InStaff findByNricNo(String nricNo);

    InStaff findByEmail(String email);

    InStaff findByName(String name);

    List<InStaff> find(String filter, Integer offset, Integer limit);

    Integer count(String filter);

    boolean isExists(String staffNo);

    boolean isEmailExists(String email);

}
