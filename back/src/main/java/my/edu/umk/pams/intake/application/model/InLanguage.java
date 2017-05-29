package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.common.model.InLanguageCode;
import my.edu.umk.pams.intake.core.InMetaObject;

public interface InLanguage extends InMetaObject {

    Integer getOral();

    void setOral(Integer oral);

    Integer getWritten();

    void setWritten(Integer written);

    InLanguageCode getLanguageCode();

    void setLanguageCode(InLanguageCode languageCode);

    InIntakeApplication getApplication();

    void setApplication(InIntakeApplication application);
    
}
