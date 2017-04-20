package my.edu.umk.pams.intake.web.module.policy.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.common.vo.SupervisorCode;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class SupervisorOffering extends MetaObject{

    private SupervisorCode supervisorCode;

    public SupervisorCode getSupervisorCode() {
        return supervisorCode;
    }

    public void setSupervisorCode(SupervisorCode supervisorCode) {
        this.supervisorCode = supervisorCode;
    }

    @JsonCreator
    public static SupervisorOffering create(String jsonString) {
        SupervisorOffering o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, SupervisorOffering.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}
