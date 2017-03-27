package my.edu.umk.pams.intake.system.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author canang technologies
 * @since 3/8/14
 */
@Entity(name = "InAudit")
@Table(name = "IN_AUDT")
public class InAuditImpl implements InAudit {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_AUDT")
    @SequenceGenerator(name = "SQ_IN_AUDT", sequenceName = "SQ_IN_AUDT", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "MESSAGE", nullable = false)
    private String message;

    //    @NotNull
    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    //    @NotNull
    @Column(name = "OBJECT_ID", nullable = false)
    private Long objectId;

    @NotNull
    @Column(name = "CLASS_NAME", nullable = false)
    private String className;

    @Embedded
    private InMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public InMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InAudit.class;
    }
}
