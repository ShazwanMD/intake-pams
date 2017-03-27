package my.edu.umk.pams.intake.workflow.integration.identity;

import my.edu.umk.pams.intake.identity.dao.InGroupDao;
import my.edu.umk.pams.intake.identity.dao.InUserDao;
import my.edu.umk.pams.intake.identity.model.InGroup;
import my.edu.umk.pams.intake.identity.model.InUser;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author canang technologies
 * @since 1/19/14
 */
@Component("activitiGroupManager")
public class ActivitiGroupManager extends GroupEntityManager {

    private static final Logger log = LoggerFactory.getLogger(ActivitiGroupManager.class);

    @Autowired
    private InGroupDao groupDao;

    @Autowired
    private InUserDao userDao;


    @Override
    public Group createNewGroup(String groupId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void insertGroup(Group group) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteGroup(String groupId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public GroupQuery createNewGroupQuery() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Group> findGroupsByUser(String userId) {
        InUser user = userDao.findByUsername(userId);
        List<Group> groups = new ArrayList<Group>();
        try {
            List<InGroup> cgroups = groupDao.findMemberships(user);
            for (InGroup cgroup : cgroups) {
                ActivitiGroup g = new ActivitiGroup(cgroup);
                groups.add(g);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groups;
    }
}
