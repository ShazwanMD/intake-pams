package my.edu.umk.pams.intake.web.module.application.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author PAMS
 */
public class DiplomaResult extends MetaObject {

    private String name;
    private Integer year;
    private BigDecimal cgpa = BigDecimal.ZERO;
    private ResultType resultType;


    



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getYear() {
		return year;
	}



	public void setYear(Integer year) {
		this.year = year;
	}


	public BigDecimal getCgpa() {
		return cgpa;
	}



	public void setCgpa(BigDecimal cgpa) {
		this.cgpa = cgpa;
	}



	public ResultType getResultType() {
		return resultType;
	}



	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}



	@JsonCreator
    public static DiplomaResult create(String jsonString) {
		DiplomaResult o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, DiplomaResult.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}