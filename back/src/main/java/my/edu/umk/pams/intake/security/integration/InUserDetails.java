package my.edu.umk.pams.intake.security.integration;

import my.edu.umk.pams.intake.identity.model.InUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public class InUserDetails implements UserDetails {

    private InUser user;
    private Set<GrantedAuthority> grantedAuthorities;

    public InUserDetails() {
    }

    public InUserDetails(InUser user, Set<GrantedAuthority> grantedAuthorities) {
        this.user = user;
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getName();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return user.isLocked();
    }

    public void setUser(InUser user) {
        this.user = user;
    }

    public InUser getUser() {
        return user;
    }

    public String getRealName() {
        return user.getRealName();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public Long getId() {
        return user.getId();
    }
}
