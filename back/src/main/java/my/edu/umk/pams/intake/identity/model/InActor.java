package my.edu.umk.pams.intake.identity.model;

import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * @author canang.technologies
 * @since 31/10/2014
 */
public interface InActor extends InMetaObject {

    String getIdentityNo();

    void setIdentityNo(String identityNo);

    String getName();

    void setName(String firstName);

    String getPhone();

    void setPhone(String phone);

    String getMobile();

    void setMobile(String mobile);

    String getFax();

    void setFax(String fax);

    String getEmail();

    void setEmail(String email);

    InActorType getActorType();

    void setActorType(InActorType actorType);
}
