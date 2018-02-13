package my.edu.umk.pams.intake.web.module.common.vo;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.intake.web.module.application.vo.FieldCode;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;
import my.edu.umk.pams.intake.web.module.policy.vo.ProgramLevel;

public class ProgramFieldCode extends MetaObject{

	private String code;

	private ProgramCode programCode;
	private FieldCode fieldCode;
	private FacultyCode facultyCode;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ProgramCode getProgramCode() {
		return programCode;
	}

	public void setProgramCode(ProgramCode programCode) {
		this.programCode = programCode;
	}

	public FieldCode getFieldCode() {
		return fieldCode;
	}

	public void setFieldCode(FieldCode fieldCode) {
		this.fieldCode = fieldCode;
	}

	public FacultyCode getFacultyCode() {
		return facultyCode;
	}

	public void setFacultyCode(FacultyCode facultyCode) {
		this.facultyCode = facultyCode;
	}

	@JsonCreator
	public static ProgramFieldCode create(String jsonString) {
		ProgramFieldCode o = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			o = mapper.readValue(jsonString, ProgramFieldCode.class);
		} catch (IOException e) {
			// handle
		}
		return o;
	}
}
