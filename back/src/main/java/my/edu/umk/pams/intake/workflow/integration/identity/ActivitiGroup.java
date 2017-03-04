package my.edu.umk.pams.intake.workflow.integration.identity;

import my.edu.umk.pams.intake.identity.model.InGroup;
import org.activiti.engine.impl.persistence.entity.GroupEntity;

/**
 * @author canang technologies
 * @since 1/19/14
 */
public class ActivitiGroup extends GroupEntity {

    private InGroup group;

    public ActivitiGroup(InGroup group) {
        this.group = group;
    }

    @Override
    public String getId() {
        return group.getName();
    }

    @Override
    public void setId(String id) {
    }

    @Override
    public String getName() {
        return group.getName();
    }

    @Override
    public void setName(String name) {
        group.setName(name);
    }

    @Override
    public String getType() {
        return "group";
    }

    @Override
    public void setType(String string) {
    }
}
