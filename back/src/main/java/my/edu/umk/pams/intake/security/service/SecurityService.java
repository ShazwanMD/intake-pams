package my.edu.umk.pams.intake.security.service;

import my.edu.umk.pams.intake.core.InMetaObject;
import my.edu.umk.pams.intake.identity.model.InUser;
import org.springframework.security.core.Authentication;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
public interface SecurityService {

    List<InMetaObject> find(Authentication authentication, Class<?> clazz, Integer offset, Integer limit);

    Integer count(Authentication authentication, Class<?> clazz);

    InUser getCurrentUser();
}
