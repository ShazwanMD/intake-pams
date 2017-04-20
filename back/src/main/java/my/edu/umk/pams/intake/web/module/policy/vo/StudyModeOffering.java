package my.edu.umk.pams.intake.web.module.policy.vo;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.common.vo.StudyMode;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class StudyModeOffering extends MetaObject {

    private StudyMode studyMode;

    public StudyMode getStudyMode() {
        return studyMode;
    }

    public void setStudyMode(StudyMode studyMode) {
        this.studyMode = studyMode;
    }

    @JsonCreator
    public static StudyModeOffering create(String jsonString) {
        StudyModeOffering o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, StudyModeOffering.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
