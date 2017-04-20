package my.edu.umk.pams.intake.web.module.application.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Attachment extends MetaObject {
    @JsonCreator
    public static Attachment create(String jsonString) {
        Attachment o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Attachment.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
