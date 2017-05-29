package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.common.model.InEmploymentFieldCode;
import my.edu.umk.pams.intake.common.model.InEmploymentLevelCode;
import my.edu.umk.pams.intake.common.model.InEmploymentSectorCode;
import my.edu.umk.pams.intake.common.model.InLanguageCode;
import my.edu.umk.pams.intake.core.InMetaObject;

import java.util.Date;

public interface InLanguage extends InMetaObject {


    Integer getOral();

    void setOral(Integer oral);

    InLanguageCode getLanguageCode();

    void setLanguageCode(InLanguageCode languageCode);

    InIntakeApplication getApplication();

    void setApplication(InIntakeApplication application);
    
}
