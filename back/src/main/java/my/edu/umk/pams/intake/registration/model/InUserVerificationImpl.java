package my.edu.umk.pams.intake.registration.model;

import my.edu.umk.pams.intake.core.InMetadata;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.model.InUserImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author PAMS
 */
@Entity(name = "InUserVerification")
@Table(name = "IN_USER_VRFN")
public class InUserVerificationImpl implements InUserVerification {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_USER_VRFN")
    @SequenceGenerator(name = "SQ_IN_USER_VRFN", sequenceName = "SQ_IN_USER_VRFN", allocationSize = 1)
    private Long id;

    @Column(name = "TOKEN", unique = true, nullable = false)
    private String token;

    @Column(name = "EXPIRY_DATE", unique = true, nullable = false)
    private Date expiryDate;

    @OneToOne(targetEntity = InUserImpl.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = false)
    private InUser user;

    @Embedded
    private InMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public InUser getUser() {
        return user;
    }

    public void setUser(InUser user) {
        this.user = user;
    }

    public InMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InUserVerification.class;
    }
}
