package my.edu.umk.pams.intake.web.module.policy.vo;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.common.vo.ProgramCode;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class ProgramOffering extends MetaObject {

    private Boolean interview;
    private Integer projection;
    private ProgramCode programCode;

    public Boolean getInterview() {
        return interview;
    }

    public void setInterview(Boolean interview) {
        this.interview = interview;
    }

    public Integer getProjection() {
        return projection;
    }

    public void setProjection(Integer projection) {
        this.projection = projection;
    }

    public ProgramCode getProgramCode() {
        return programCode;
    }

    public void setProgramCode(ProgramCode programCode) {
        this.programCode = programCode;
    }

    @JsonCreator
    public static ProgramOffering create(String jsonString) {
        ProgramOffering o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, ProgramOffering.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
