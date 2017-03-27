package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetaObject;

public interface InBankCode extends InMetaObject {

    String getCode();

    void setCode(String code);

    String getSwiftCode();

    void setSwiftCode(String swiftCode);

    String getIbgCode();

    void setIbgCode(String ibgCode);

    String getName();

    void setName(String description);
}
