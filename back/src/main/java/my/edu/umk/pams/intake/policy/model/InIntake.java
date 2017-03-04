package my.edu.umk.pams.intake.policy.model;

import my.edu.umk.pams.intake.core.model.InDocument;

import java.util.Date;
import java.util.List;

public interface InIntake extends InDocument {

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getEndDate();

    void setEndDate(Date endDate);

    Integer getProjection(); // unjuran

    void setProjection(Integer projection);

    InIntakeSession getSession();

    void setSession(InIntakeSession session);

    InIntakeCategory getCategory();

    void setCategory(InIntakeCategory category);

    List<InProgramOffering> getProgramOfferings();

    void setProgramOfferings(List<InProgramOffering> offerings);
}
