package my.edu.umk.pams.intake.core;


import my.edu.umk.pams.intake.identity.model.InUser;

import java.util.List;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface GenericDao<K, I> {

    I newInstance();

    I refresh(I i);

    I findById(K k);

    List<I> find();

    List<I> find(Integer offset, Integer limit);

    List<I> findAuthorized(Set<String> sids);

    List<I> findAuthorized(Set<String> sids, Integer offset, Integer limit);

    List<Long> findAuthorizedIds(Set<String> sids);

    Integer count();

    Integer countAuthorized(Set<String> sids);

    void save(I entity, InUser user);

    void saveOrUpdate(I entity, InUser user);

    void update(I entity, InUser user);

    void deactivate(I entity, InUser user);

    void remove(I entity, InUser user);

    void delete(I entity, InUser user);
}
