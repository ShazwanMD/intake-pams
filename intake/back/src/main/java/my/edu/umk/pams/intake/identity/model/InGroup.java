package my.edu.umk.pams.intake.identity.model;

import java.util.Set;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface InGroup extends InPrincipal {

    // TODO: move to respective XxxConstants
    String GRP_USR = "UserGroup";
    String GRP_ADM_FIXED = "GRP_ADM_FIXED";
    String GRP_ADM_PURCHASE = "GRP_ADM_PURCHASE";
    String GRP_ADM_INVENTORY = "GRP_ADM_INVENTORY";

    Set<InPrincipal> getMembers();

    void setMembers(Set<InPrincipal> members);
}
