package my.edu.umk.pams.intake.web.module.application.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.common.vo.LanguageCode;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Language extends MetaObject {
    private Integer oral ;
    private Integer written ;
    private LanguageCode languageCode;

    public Integer getOral() {
        return oral;
    }

    public void setOral(Integer oral) {
        this.oral = oral;
    }

    public Integer getWritten() {
        return written;
    }

    public void setWritten(Integer written) {
        this.written = written;
    }

    public LanguageCode getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(LanguageCode languageCode) {
        this.languageCode = languageCode;
    }

    @JsonCreator
    public static Language create(String jsonString) {
        Language o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Language.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
