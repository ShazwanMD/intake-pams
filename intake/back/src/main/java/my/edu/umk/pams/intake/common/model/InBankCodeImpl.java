package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InBankCode")
@Table(name = "IN_BANK_CODE")
public class InBankCodeImpl implements InBankCode {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_BANK_CODE")
    @SequenceGenerator(name = "SQ_IN_BANK_CODE", sequenceName = "SQ_IN_BANK_CODE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "SWIFT_CODE", unique = true, nullable = false)
    private String swiftCode;

    @NotNull
    @Column(name = "IBG_CODE", unique = true, nullable = false)
    private String ibgCode;

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
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getSwiftCode() {
        return swiftCode;
    }

    @Override
    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    @Override
    public String getIbgCode() {
        return ibgCode;
    }

    @Override
    public void setIbgCode(String ibgCode) {
        this.ibgCode = ibgCode;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String description) {
        this.name = description;
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
        return InBankCode.class;
    }
}
