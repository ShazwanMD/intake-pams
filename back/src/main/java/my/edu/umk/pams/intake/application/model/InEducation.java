package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.common.model.InEducationLevelCode;
import my.edu.umk.pams.intake.common.model.InEducationSectorCode;
import my.edu.umk.pams.intake.core.InMetaObject;

import java.util.Date;

public interface InEducation extends InMetaObject {

    Boolean isCurrent();

    void setCurrent(Boolean current);

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getEndDate();

    void setEndDate(Date endDate);

    String getProvider();

    void setProvider(String provider);

    InEducationLevelCode getLevelCode();

    void setLevelCode(InEducationLevelCode levelCode);

    InEducationSectorCode getSectorCode();

    void setSectorCode(InEducationSectorCode sectorCode);

    InIntakeApplication getApplication();

    void setApplication(InIntakeApplication application);

}
