package my.edu.umk.pams.intake.security.integration;

import my.edu.umk.pams.intake.identity.dao.InGroupDao;
import my.edu.umk.pams.intake.identity.dao.InPrincipalDao;
import my.edu.umk.pams.intake.identity.dao.InUserDao;
import my.edu.umk.pams.intake.identity.model.InGroup;
import my.edu.umk.pams.intake.identity.model.InPrincipal;
import my.edu.umk.pams.intake.identity.model.InUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.domain.SidRetrievalStrategyImpl;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/13/14
 */
public class InSidRetrievalStrategy extends SidRetrievalStrategyImpl {

    private static final Logger LOG = LoggerFactory.getLogger(my.edu.umk.pams.intake.security.integration.InSidRetrievalStrategy.class);

    @Autowired
    private InPrincipalDao principalDao;

    @Autowired
    private InGroupDao groupDao;

    @Autowired
    private InUserDao userDao;

    @Override
    public List<Sid> getSids(Authentication authentication) {
        // add current sid to collection based
        // on our authentication
        List<Sid> sids = new ArrayList<Sid>();
        sids.addAll(super.getSids(authentication));

        // find all groups by username
        if (authentication.getPrincipal() instanceof UserDetails) {
            String username = ((UserDetails) authentication.getPrincipal()).getUsername();
            InUser user = userDao.findByUsername(username);
            sids.addAll(getSids(user));
        }
        return sids;
    }

    public Set<String> getSidsAsSet(Authentication authentication) {
        Set<String> sidSets = new HashSet<String>();
        List<Sid> sids = super.getSids(authentication);
        for (Sid sid : sids) {
            if (sid instanceof PrincipalSid)
                sidSets.add(((PrincipalSid) sid).getPrincipal());
        }

        if (authentication.getPrincipal() instanceof UserDetails) {
            String username = ((UserDetails) authentication.getPrincipal()).getUsername();
            InUser user = userDao.findByUsername(username);
            List<Sid> sids2 = getSids(user);
            for (Sid sid : sids2) {
                if (sid instanceof PrincipalSid)
                    sidSets.add(((PrincipalSid) sid).getPrincipal());
            }
        }
        return sidSets;
    }

    public List<Sid> getSids(InPrincipal principal) {
        List<Sid> sids = new ArrayList<Sid>();
        sids.add(new PrincipalSid(principal.getName()));
        Set<InGroup> groups = groupDao.findEffectiveAsNative(principal);
        for (InGroup group : groups) {
            sids.add(new PrincipalSid(group.getName()));
        }
        return sids;
    }
}

