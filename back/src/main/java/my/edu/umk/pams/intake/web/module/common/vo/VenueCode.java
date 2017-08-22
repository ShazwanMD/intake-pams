package my.edu.umk.pams.intake.web.module.common.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;
import java.util.Date;

/**
 * @author PAMS
 */
public class VenueCode  extends MetaObject{

    private String code;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date registrationDate;
    private String registrationLocation;
    private String startTimeEn;
    private String startTimeMs;
    private String endTimeEn;
    private String endTimeMs;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getStartTimeEn() {
		return startTimeEn;
	}

	public void setStartTimeEn(String startTimeEn) {
		this.startTimeEn = startTimeEn;
	}

	public String getStartTimeMs() {
		return startTimeMs;
	}

	public void setStartTimeMs(String startTimeMs) {
		this.startTimeMs = startTimeMs;
	}

	public String getEndTimeEn() {
		return endTimeEn;
	}

	public void setEndTimeEn(String endTimeEn) {
		this.endTimeEn = endTimeEn;
	}

	public String getEndTimeMs() {
		return endTimeMs;
	}

	public void setEndTimeMs(String endTimeMs) {
		this.endTimeMs = endTimeMs;
	}

	public String getRegistrationLocation() {
		return registrationLocation;
	}

	public void setRegistrationLocation(String registrationLocation) {
		this.registrationLocation = registrationLocation;
	}

	@JsonCreator
    public static VenueCode create(String jsonString) {
        VenueCode o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, VenueCode.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

	

}
