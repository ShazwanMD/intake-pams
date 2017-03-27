package my.edu.umk.pams.intake.core;

/**
 * @author canang technologies
 * @since 4/2/2016.
 */
public interface InFlowObject extends InMetaObject {
    /**
     * get flow data
     *
     * @return
     */
    InFlowdata getFlowdata();

    /**
     * set flow data
     *
     * @param flowdata
     */
    void setFlowdata(InFlowdata flowdata);

}
