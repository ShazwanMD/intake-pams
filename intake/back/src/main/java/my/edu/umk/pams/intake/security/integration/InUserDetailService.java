package my.edu.umk.pams.intake.security.integration;

import my.edu.umk.pams.intake.identity.dao.InGroupDao;
import my.edu.umk.pams.intake.identity.dao.InUserDao;
import my.edu.umk.pams.intake.identity.model.InGroup;
import my.edu.umk.pams.intake.identity.model.InPrincipalRole;
import my.edu.umk.pams.intake.identity.model.InUser;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/30/14
 */
@Service("userDetailService")
@Transactional
public class InUserDetailService implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(my.edu.umk.pams.intake.security.integration.InUserDetailService.class);

    @Autowired
    protected SessionFactory sessionFactory;

    @Autowired
    private InUserDao userDao;

    @Autowired
    private InGroupDao groupDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        InUser user = userDao.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("No such user");
//        LOG.debug("loading #{} {}", user.getId(), user.getUsername());
        return new InUserDetails(user, loadGrantedAuthoritiesFor(user));
    }

    private Set<GrantedAuthority> loadGrantedAuthoritiesFor(InUser user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        for (InPrincipalRole role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().name()));
        }

        Set<InGroup> groups = groupDao.findEffectiveAsNative(user);
        for (InGroup group : groups) {
            for (InPrincipalRole role : group.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().name()));
            }
        }

//        LOG.info("load auth for #{}{}", user.getId(), user.getUsername());
        return grantedAuthorities;
    }
}
