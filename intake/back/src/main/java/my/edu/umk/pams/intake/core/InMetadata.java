package my.edu.umk.pams.intake.core;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author canang technologies
 * @since 1/27/14
 */
@Embeddable
public class InMetadata implements Serializable {

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "M_ST")
    private InMetaState state;

    @Column(name = "C_ID")
    private Long creatorId;

    @Column(name = "M_ID")
    private Long modifierId;

    @Column(name = "D_ID")
    private Long deleterId;

    @Column(name = "C_TS")
    private Timestamp createdDate;

    @Column(name = "M_TS")
    private Timestamp modifiedDate;

    @Column(name = "D_TS")
    private Timestamp deletedDate;

    public InMetaState getState() {
        return state;
    }

    public void setState(InMetaState state) {
        this.state = state;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getModifierId() {
        return modifierId;
    }

    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    public Long getDeleterId() {
        return deleterId;
    }

    public void setDeleterId(Long deleterId) {
        this.deleterId = deleterId;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Timestamp getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Timestamp deletedDate) {
        this.deletedDate = deletedDate;
    }

    @Transient
    public boolean isActive() {
        return InMetaState.ACTIVE.equals(getState());
    }
}
