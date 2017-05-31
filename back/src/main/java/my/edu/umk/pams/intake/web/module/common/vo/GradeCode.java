package my.edu.umk.pams.intake.web.module.common.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class GradeCode extends MetaObject {
    private String code;
    private String description;
    private Integer ordinal;



    public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
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



	@JsonCreator
    public static GradeCode create(String jsonString) {
        GradeCode o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, GradeCode.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}