package my.edu.umk.pams.intake.web.module.common.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class StateCode  extends MetaObject{

    private String code;
    private String descriptionMs;
    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescriptionMs() {
        return descriptionMs;
    }

    public void setDescriptionMs(String descriptionMs) {
        this.descriptionMs = descriptionMs;
    }

    @JsonCreator
    public static StateCode create(String jsonString) {
        StateCode o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, StateCode.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}
