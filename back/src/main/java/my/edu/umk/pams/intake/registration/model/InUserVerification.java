package my.edu.umk.pams.intake.registration.model;

import my.edu.umk.pams.intake.core.InMetaObject;
import my.edu.umk.pams.intake.identity.model.InUser;

import java.util.Date;

/**
 * @author PAMS
 */
public interface InUserVerification extends InMetaObject {

    String getToken();

    void setToken(String token);

    Date getExpiryDate();

    void setExpiryDate(Date expiryDate);

    InUser getUser();

    void setUser(InUser user);
}
