package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.web.module.application.vo.AddressType;

public enum InAddressType {
    MAILING,     //
    OFFICIAL;    //

    public static InAddressType get(int index) {
        return values()[index];
    }
}
