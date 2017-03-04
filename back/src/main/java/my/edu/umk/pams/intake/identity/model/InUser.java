package my.edu.umk.pams.intake.identity.model;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface InUser extends InPrincipal {

    String DEFAULT_PASSWORD = "abc123";

    String getUsername();

    void setUsername(String username);

    String getRealName();

    void setRealName(String firstName);

    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    InActor getActor();

    void setActor(InActor actor);
}
