package my.edu.umk.pams.intake.web.module.common.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class ResidencyCode extends MetaObject {
    private String code;
    private String description;
    //private String descriptionEn;

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

    //public String getDescriptionEn() {
    //    return descriptionEn;
    //}

    //public void setDescriptionEn(String descriptionEn) {
    //    this.descriptionEn = descriptionEn;
    //}
    
    

    @JsonCreator
    public static ResidencyCode create(String jsonString) {
        ResidencyCode o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, ResidencyCode.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
