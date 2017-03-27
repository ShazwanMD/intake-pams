package my.edu.umk.pams.intake.core;

import java.io.Serializable;

/**
 * @author canang technologies
 */
public interface InMetaObject extends Serializable {

    /**
     * entity id
     *
     * @return
     */
    Long getId();

    /**
     * metadata
     *
     * @return
     */
    InMetadata getMetadata();

    void setMetadata(InMetadata metadata);

    /**
     * implementing interface
     *
     * @return
     */
    Class<?> getInterfaceClass();
}

