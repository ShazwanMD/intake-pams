package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.core.InMetaObject;

import java.util.List;

/**
 * @author PAMS
 */
public interface InResult extends InMetaObject {

    InResultType getResultType();

    void setResultType(InResultType resultType);

    InIntakeApplication getApplication();

    void setApplication(InIntakeApplication application);

    List<InResultItem> getItems();

    void setItems(List<InResultItem> items);
}
