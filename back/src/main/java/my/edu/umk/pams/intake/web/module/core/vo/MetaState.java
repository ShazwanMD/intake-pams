package my.edu.umk.pams.intake.web.module.core.vo;

/**
 * @author PAMS
 */
public enum MetaState {

    INACTIVE, // 0
    ACTIVE;   // 1

    public static MetaState get(int index) {
        return values()[index];
    }

}
