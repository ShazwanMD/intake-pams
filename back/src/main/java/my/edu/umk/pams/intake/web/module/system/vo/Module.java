package my.edu.umk.pams.intake.web.module.system.vo;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.common.vo.StudyMode;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Module extends MetaObject {

	private String code;
	private String canonicalCode;
	private String description;
	private Integer ordinal = 0;
	private boolean enabled = true;

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCanonicalCode() {
		return canonicalCode;
	}

	public void setCanonicalCode(String canonicalCode) {
		this.canonicalCode = canonicalCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@JsonCreator
    public static Module create(String jsonString) {
        Module o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Module.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
