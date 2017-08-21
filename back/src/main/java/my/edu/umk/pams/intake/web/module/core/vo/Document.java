package my.edu.umk.pams.intake.web.module.core.vo;

/**
 * @author PAMS
 */
public class Document extends FlowObject {

    private String referenceNo;
    private String sourceNo;
    private String auditNo;
    private String descriptionEn;
    private String descriptionMs;
    private String cancelComment;
    private String removeComment;

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getSourceNo() {
        return sourceNo;
    }

    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo;
    }

    public String getAuditNo() {
        return auditNo;
    }

    public void setAuditNo(String auditNo) {
        this.auditNo = auditNo;
    }

    public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	public String getDescriptionMs() {
		return descriptionMs;
	}

	public void setDescriptionMs(String descriptionMs) {
		this.descriptionMs = descriptionMs;
	}

	public String getCancelComment() {
        return cancelComment;
    }

    public void setCancelComment(String cancelComment) {
        this.cancelComment = cancelComment;
    }

    public String getRemoveComment() {
        return removeComment;
    }

    public void setRemoveComment(String removeComment) {
        this.removeComment = removeComment;
    }
}
