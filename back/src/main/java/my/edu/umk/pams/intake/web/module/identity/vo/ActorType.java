package my.edu.umk.pams.intake.web.module.identity.vo;

/**
 * @author PAMS
 */
public enum ActorType {

    STAFF, //0
    APPLICANT, //1
    SPONSOR; //2

    public static ActorType get(int index) {
        return values()[index];
    }

}
