package my.edu.umk.pams.intake.system.model;

import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * @author canang technologies
 * @since 4/18/14
 */
public interface InSubModule extends InMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);

    Integer getOrdinal();

    void setOrdinal(Integer ordinal);

    boolean isEnabled();

    void setEnabled(boolean enabled);

    InModule getModule();

    void setModule(InModule module);
}
