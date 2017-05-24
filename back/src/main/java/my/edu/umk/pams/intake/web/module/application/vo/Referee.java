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
public class Referee extends MetaObject {
    private String name;
    private String officeAddrs;
    private String occupation;
    private String phoneNo;
    
    
   
    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getOfficeAddrs() {
		return officeAddrs;
	}



	public void setOfficeAddrs(String officeAddrs) {
		this.officeAddrs = officeAddrs;
	}



	public String getOccupation() {
		return occupation;
	}



	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}



	public String getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}



	@JsonCreator
    public static Employment create(String jsonString) {
        Employment o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Employment.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
