package my.edu.umk.pams.intake.identity.dao;

import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.identity.model.InActor;
import my.edu.umk.pams.intake.identity.model.InActorType;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface InActorDao extends GenericDao<Long, InActor> {

    InActor findByCode(String code);

    InActor findByIdentityNo(String identityNo);

    InActor findByEmail(String email);

    List<InActor> find(String filter, Integer offset, Integer limit);

    List<InActor> find(InActorType type, Integer offset, Integer limit);

    List<InActor> find(String filter, InActorType type, Integer offset, Integer limit);

    Integer count(String filter);

    Integer count(String filter, InActorType type);

    Integer count(InActorType type);

    boolean isEmailExists(String email);
    
    boolean isIdentityNoExists(String identityNo);
}
