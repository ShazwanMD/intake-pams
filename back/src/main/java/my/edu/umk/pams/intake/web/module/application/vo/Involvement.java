package my.edu.umk.pams.intake.web.module.application.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Involvement extends MetaObject {
    @JsonCreator
    public static Involvement create(String jsonString) {
        Involvement o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Involvement.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
