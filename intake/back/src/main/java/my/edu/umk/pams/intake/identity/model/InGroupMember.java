package my.edu.umk.pams.intake.identity.model;


import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface InGroupMember extends InMetaObject {

    InGroup getGroup();

    void setGroup(InGroup group);

    InPrincipal getPrincipal();

    void setPrincipal(InPrincipal principal);
}
