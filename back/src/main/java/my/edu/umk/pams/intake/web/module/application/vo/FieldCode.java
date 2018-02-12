package my.edu.umk.pams.intake.web.module.application.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.intake.common.model.InFacultyCode;
import my.edu.umk.pams.intake.web.module.common.vo.FacultyCode;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class FieldCode extends MetaObject {
    private String code;
    private String descriptionEn;
    private String descriptionMs;
    private FacultyCode facultyCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return descriptionEn;
    }

    public void setDescription(String descriptionEn) {
        this.descriptionEn = descriptionEn;
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

	public FacultyCode getFacultyCode() {
		return facultyCode;
	}

	public void setFacultyCode(FacultyCode facultyCode) {
		this.facultyCode = facultyCode;
	}

	@JsonCreator
    public static FieldCode create(String jsonString) {
        FieldCode o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, FieldCode.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}