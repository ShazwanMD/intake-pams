package my.edu.umk.pams.intake.web.module.identity.vo;


import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;

/**
 * @author PAMS
 */
public class Principal extends MetaObject {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
