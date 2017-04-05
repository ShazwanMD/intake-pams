package my.edu.umk.pams.intake.identity.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static my.edu.umk.pams.intake.identity.model.InPrincipalType.USER;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Entity(name = "InUser")
@Table(name = "IN_USER")
public class InUserImpl extends InPrincipalImpl implements InUser {

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @Column(name = "REAL_NAME", nullable = false)
    private String realName;

    @NotNull
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @OneToOne(targetEntity = InActorImpl.class)
    @JoinColumn(name = "ACTOR_ID", nullable = true)
    private InActor actor;

    public InUserImpl() {
        setPrincipalType(USER);
    }

    @Override
    public String getUsername() {
        return getName();
    }

    @Override
    public void setUsername(String username) {
        setName(username);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getRealName() {
        return realName;
    }

    @Override
    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public InActor getActor() {
        return actor;
    }

    @Override
    public void setActor(InActor actor) {
        this.actor = actor;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InUser.class;
    }

}
