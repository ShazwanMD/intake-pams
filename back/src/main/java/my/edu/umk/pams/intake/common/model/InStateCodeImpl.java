package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InStateCode")
@Table(name = "IN_STTE_CODE")
public class InStateCodeImpl implements InStateCode {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SQ_IN_STTE_CODE")
    @SequenceGenerator(name = "SQ_IN_STTE_CODE", sequenceName = "SQ_IN_STTE_CODE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "DESCRIPTION_MS")
    private String descriptionMs;

    @NotNull
    @Column(name = "DESCRIPTION_EN")
    private String descriptionEn;

    @ManyToOne(targetEntity = InCountryCodeImpl.class)
    @JoinColumn(name = "COUNTRY_CODE_ID")
    private InCountryCode countryCode;

    @Embedded
    private InMetadata metadata;

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
    public String getDescriptionMs() {
        return descriptionMs;
    }

    @Override
    public void setDescriptionMs(String descriptionMs) {
        this.descriptionMs = descriptionMs;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    @Override
    public InCountryCode getCountryCode() {
        return countryCode;
    }

    @Override
    public void setCountryCode(InCountryCode countryCode) {
        this.countryCode = countryCode;
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
        return InStateCode.class;
    }
}
