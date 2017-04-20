package my.edu.umk.pams.intake.web.module.policy.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.core.vo.Task;

import java.io.IOException;

/**
 * @author PAMS
 */
public class IntakeTask extends Task {

    private String referenceNo;
    private Intake intake;

    @Override
    public String getReferenceNo() {
        return referenceNo;
    }

    @Override
    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public Intake getIntake() {
        return intake;
    }

    public void setIntake(Intake intake) {
        this.intake = intake;
    }

    @JsonCreator
    public static IntakeTask create(String jsonString) {
        IntakeTask o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, IntakeTask.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
