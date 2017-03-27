package my.edu.umk.pams.intake.identity.model;


import my.edu.umk.pams.intake.core.InMetaObject;

import java.util.Set;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface InPrincipal extends InMetaObject {

    String getName();

    void setName(String name);

    InPrincipalType getPrincipalType();

    void setPrincipalType(InPrincipalType principalType);

    boolean isLocked();

    void setLocked(boolean locked);

    boolean isEnabled();

    void setEnabled(boolean enabled);

    Set<InPrincipalRole> getRoles();

    void setRoles(Set<InPrincipalRole> roles);

}
