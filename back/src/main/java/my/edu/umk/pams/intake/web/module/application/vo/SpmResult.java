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

    private String malay;
    private String english;
    private String math;
    private String history;
    private String islamicEduc;
    private Integer year;
    private Integer aggregate;






	public String getMalay() {
		return malay;
	}






	public void setMalay(String malay) {
		this.malay = malay;
	}






	public String getEnglish() {
		return english;
	}






	public void setEnglish(String english) {
		this.english = english;
	}






	public String getMath() {
		return math;
	}






	public void setMath(String math) {
		this.math = math;
	}






	public String getHistory() {
		return history;
	}






	public void setHistory(String history) {
		this.history = history;
	}






	public String getIslamicEduc() {
		return islamicEduc;
	}






	public void setIslamicEduc(String islamicEduc) {
		this.islamicEduc = islamicEduc;
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