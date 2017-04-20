package my.edu.umk.pams.intake.web.module.application.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Referee extends MetaObject {
    @JsonCreator
    public static Referee create(String jsonString) {
        Referee o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Referee.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
