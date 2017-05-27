package my.edu.umk.pams.intake.web.module.application.vo;

/**
 * @author PAMS
 */
public enum AddressType {
    MAILING,     //0
    OFFICIAL;    //1

    public static AddressType get(int index) {
        return values()[index];
    }
}
