package my.edu.umk.pams.intake.identity.model;

import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface InPrincipalRole extends InMetaObject {

    InPrincipal getPrincipal();

    void setPrincipal(InPrincipal principal);

    InRoleType getRole();

    void setRole(InRoleType role);
}
