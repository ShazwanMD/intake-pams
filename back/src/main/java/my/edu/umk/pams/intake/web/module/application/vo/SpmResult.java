package my.edu.umk.pams.intake.web.module.application.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;
import java.util.Date;

/**
 * @author PAMS
 */
public class SpmResult extends MetaObject {

    private String grade;
    private String name;
    private Integer year;
    private Integer aggregate;


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}

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


	public Integer getAggregate() {
		return aggregate;
	}

	public void setAggregate(Integer aggregate) {
		this.aggregate = aggregate;
	}

	@JsonCreator
    public static SpmResult create(String jsonString) {
		SpmResult o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, SpmResult.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}