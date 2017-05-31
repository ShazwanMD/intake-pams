package my.edu.umk.pams.intake.web.module.application.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author PAMS
 */
public class Result extends MetaObject {


    private List<ResultItem> resultItem;
    private ResultType resultType;


	public List<ResultItem> getResultItem() {
		return resultItem;
	}



	public void setResultItem(List<ResultItem> resultItem) {
		this.resultItem = resultItem;
	}




	public ResultType getResultType() {
		return resultType;
	}



	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
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