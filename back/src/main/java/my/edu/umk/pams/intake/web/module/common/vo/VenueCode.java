package my.edu.umk.pams.intake.web.module.common.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class VenueCode  extends MetaObject{

    private String code;
    private String registrationDate;
    private String registrationLocation;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
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
