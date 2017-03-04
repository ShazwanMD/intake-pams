package my.edu.umk.pams.intake.identity.dao;

import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.identity.model.InActorType;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface InActorDao extends GenericDao<Long, my.edu.umk.pams.intake.identity.model.InActor> {

    my.edu.umk.pams.intake.identity.model.InActor findByCode(String code);

    my.edu.umk.pams.intake.identity.model.InActor findByIdentityNo(String identityNo);

    List<my.edu.umk.pams.intake.identity.model.InActor> find(String filter, Integer offset, Integer limit);

    List<my.edu.umk.pams.intake.identity.model.InActor> find(InActorType type, Integer offset, Integer limit);

    List<my.edu.umk.pams.intake.identity.model.InActor> find(String filter, InActorType type, Integer offset, Integer limit);

    Integer count(String filter);

    Integer count(String filter, InActorType type);

    Integer count(InActorType type);

    my.edu.umk.pams.intake.identity.model.InActor findByEmail(String email);
}
