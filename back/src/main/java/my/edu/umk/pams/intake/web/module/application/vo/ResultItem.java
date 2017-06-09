package my.edu.umk.pams.intake.web.module.application.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.intake.web.module.common.vo.GradeCode;
import my.edu.umk.pams.intake.web.module.common.vo.SubjectCode;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class ResultItem extends MetaObject {

    private SubjectCode subjectCode;
    private GradeCode gradeCode;
	private Result result;
	
	



	public SubjectCode getSubjectCode() {
		return subjectCode;
	}





	public void setSubjectCode(SubjectCode subjectCode) {
		this.subjectCode = subjectCode;
	}





	public GradeCode getGradeCode() {
		return gradeCode;
	}





	public void setGradeCode(GradeCode gradeCode) {
		this.gradeCode = gradeCode;
	}





	public Result getResult() {
		return result;
	}





	public void setResult(Result result) {
		this.result = result;
	}



	@JsonCreator
    public static ResultItem create(String jsonString) {
		ResultItem o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, ResultItem.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}