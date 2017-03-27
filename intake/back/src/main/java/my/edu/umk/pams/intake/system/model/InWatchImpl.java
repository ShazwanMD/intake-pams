package my.edu.umk.pams.intake.system.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author canang.technologies
 * @since 7/26/14
 */
@Entity(name = "InWatch")
@Table(name = "IN_WTCH")
public class InWatchImpl implements InWatch {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_WTCH")
    @SequenceGenerator(name = "SQ_IN_WTCH", sequenceName = "SQ_IN_WTCH", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "OBJECT_ID", nullable = false)
    private Long objectId;

    @NotNull
    @Column(name = "OBJECT_CLASS", nullable = false)
    private String objectClass;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Embedded
    private InMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getObjectClass() {
        return objectClass;
    }

    public void setObjectClass(String objectClass) {
        this.objectClass = objectClass;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public InMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }
}
