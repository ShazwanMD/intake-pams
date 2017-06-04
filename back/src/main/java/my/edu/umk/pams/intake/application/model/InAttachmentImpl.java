package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InAttachment")
@Table(name = "IN_ATMT")
public class InAttachmentImpl implements InAttachment {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_ATMT")
    @SequenceGenerator(name = "SQ_IN_ATMT", sequenceName = "SQ_IN_ATMT", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "DATA", nullable = false)
    private byte[] bytes;

    @NotNull
    @Column(name = "MIME_TYPE", nullable = false)
    private String mimeType;

    @NotNull
    @Column(name = "SIZE", nullable = false)
    private Long size;

    @ManyToOne(targetEntity = InIntakeApplicationImpl.class)
    @JoinColumn(name = "APPLICATION_ID")
    private InIntakeApplication application;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ATTACHMENT_TYPE")
    private InAttachmentType attachmentType;
    
    @Embedded
    private InMetadata metadata;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public byte[] getBytes() {
        return bytes;
    }

    @Override
    public String getMimeType() {
        return mimeType;
    }

    @Override
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @Override
    public Long getSize() {
        return size;
    }

    @Override
    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public InIntakeApplication getApplication() {
        return application;
    }

    public void setApplication(InIntakeApplication application) {
        this.application = application;
    }
    
    @Override
    public InAttachmentType getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(InAttachmentType attachmentType) {
		this.attachmentType = attachmentType;
	}

	@Override
    public InMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InAttachment.class;
    }
}
