package my.edu.umk.pams.intake.web.module.policy.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.core.vo.Task;

import java.io.IOException;
import java.util.Date;

/**
 * @author PAMS
 */
public class IntakeTask extends Task {

    private Integer projection;
    private Date startDate;
    private Date endDate;
    private Intake intake;

    public Integer getProjection() {
        return projection;
    }

    public void setProjection(Integer projection) {
        this.projection = projection;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
