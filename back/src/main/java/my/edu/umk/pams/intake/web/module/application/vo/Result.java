package my.edu.umk.pams.intake.web.module.application.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.intake.web.module.common.vo.GradeCode;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author PAMS
 */
public class Result extends MetaObject {

    private ResultType resultType;
    private String name;
    private String field;
    private String graduationYear;
    private GradeCode gradeCode;


	public ResultType getResultType() {
		return resultType;
	}

	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}

	public GradeCode getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(GradeCode gradeCode) {
		this.gradeCode = gradeCode;
	}

	@JsonCreator
    public static Result create(String jsonString) {
		Result o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Result.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}