package my.edu.umk.pams.intake.identity.dao;

import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.identity.model.InGroup;
import my.edu.umk.pams.intake.identity.model.InUser;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface InUserDao extends GenericDao<Long, InUser> {

    InUser findByEmail(String email);

    InUser findByUsername(String username);

    InUser findByActor(my.edu.umk.pams.intake.identity.model.InActor actor);

    List<InUser> find(String filter, Integer offset, Integer limit);

    List<InGroup> findGroups(InUser user);

    Integer count(String filter);

    boolean isExists(String username);

    boolean hasUser(my.edu.umk.pams.intake.identity.model.InActor actor);

}
