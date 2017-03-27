package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.common.model.InInvolvementLevelCode;
import my.edu.umk.pams.intake.common.model.InInvolvementTitleCode;
import my.edu.umk.pams.intake.common.model.InInvolvementTypeCode;
import my.edu.umk.pams.intake.core.InMetaObject;

import java.util.Date;

public interface InInvolvement extends InMetaObject {

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getEndDate();

    void setEndDate(Date endDate);

    InInvolvementTypeCode getTypeCode();  // persatuan ekonomi

    void setTypeCode(InInvolvementTypeCode typeCode);

    InInvolvementLevelCode getLevelCode(); // international

    void setLevelCode(InInvolvementLevelCode levelCode);

    InInvolvementTitleCode getTitleCode(); // jawatan

    void setTitleCode(InInvolvementTitleCode titleCode);

    InIntakeApplication getApplication();

    void setApplication(InIntakeApplication application);

}
