package my.edu.umk.pams.intake.identity.service;

import my.edu.umk.pams.intake.identity.dao.*;
import my.edu.umk.pams.intake.identity.event.StaffCreatedEvent;
import my.edu.umk.pams.intake.identity.event.StaffUpdatedEvent;
import my.edu.umk.pams.intake.identity.model.*;
import my.edu.umk.pams.intake.util.Util;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/30/14
 */
@Transactional
@Service("inIdentityService")
public class IdentityServiceImpl implements IdentityService {

    private static final String GROUP_ROOT = "GRP_ADMN";

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private InPrincipalDao principalDao;

    @Autowired
    private InUserDao userDao;

    @Autowired
    private InGroupDao groupDao;

    @Autowired
    private InActorDao actorDao;

    @Autowired
    private InStaffDao staffDao;

    @Autowired
    private InApplicantDao applicantDao;

    //====================================================================================================
    // PRINCIPAL
    //====================================================================================================

    @Override
    public InPrincipal findPrincipalById(Long id) {
        return null;
    }

    @Override
    public InPrincipal findPrincipalByName(String name) {
        return principalDao.findByName(name);
    }

    @Override
    public List<InPrincipal> findPrincipals(String filter, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public Set<String> findSids(InPrincipal principal) {
        return null;
    }

    @Override
    public Integer countPrincipal(String filter) {
        return principalDao.count(filter);
    }

    @Override
    public void addPrincipalRole(InPrincipal principal, InPrincipalRole principalRole) {
        principalDao.addRole(principal, principalRole, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deletePrincipalRole(InPrincipal principal, InPrincipalRole principalRole) {
        principalDao.deleteRole(principal, principalRole, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // USER
    //====================================================================================================

    @Override
    public InUser findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public InUser findUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public InUser findUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public InUser findUserByActor(InActor actor) {
        return userDao.findByActor(actor);
    }

    @Override
    public List<InUser> findUsers(Integer offset, Integer limit) {
        return userDao.find(offset, limit);
    }

    @Override
    public List<InUser> findUsers(String filter, Integer offset, Integer limit) {
        return userDao.find(filter, offset, limit);
    }

    @Override
    public Integer countUser() {
        return userDao.count();
    }

    @Override
    public Integer countUser(String filter) {
        return userDao.count(filter);
    }

    @Override
    public boolean hasUser(InActor actor) {
        return userDao.hasUser(actor);
    }

    @Override
    public boolean isUserExists(String username) {
        return userDao.isExists(username);
    }

    @Override
    public void saveUser(InUser user) {
        userDao.save(user, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateUser(InUser user) {
        userDao.update(user, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeUser(InUser user) {
        userDao.remove(user, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void changePassword(InUser user, String newPassword) {
        user.setPassword(newPassword);
        userDao.update(user, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // GROUP
    //====================================================================================================

    @Override
    public InGroup getRootGroup() {
        return groupDao.findByName(GROUP_ROOT);
    }

    @Override
    public InGroup findGroupByName(String name) {
        return groupDao.findByName(name);
    }

    @Override
    public InGroup findOrCreateGroupByName(String name) {
        InGroup group = null;
        if (groupDao.isExists(name))
            group = groupDao.findByName(name);
        else {
            group = new InGroupImpl();
            group.setName(name);
            group.setEnabled(true);
            group.setLocked(false);
            groupDao.save(group, Util.getCurrentUser());
        }
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(group);
        return group;
    }

    @Override
    public InGroup findGroupById(Long id) {
        return groupDao.findById(id);
    }

    @Override
    public List<InGroup> findGroups(Integer offset, Integer limit) {
        return groupDao.find(offset, limit);
    }

    @Override
    public List<InGroup> findImmediateGroups(InPrincipal principal) {
        return groupDao.findImmediate(principal);
    }

    @Override
    public List<InGroup> findImmediateGroups(InPrincipal principal, Integer offset, Integer limit) {
        return groupDao.findImmediate(principal, offset, limit);
    }

    @Override
    public Set<InGroup> findEffectiveGroups(InPrincipal principal) {
        return groupDao.findEffectiveAsNative(principal);
    }

    @Override
    public Set<String> findEffectiveGroupsAsString(InPrincipal principal) {
        Set<String> groups = new HashSet<>();
        Set<InGroup> groupSet = groupDao.findEffectiveAsNative(principal);
        for (InGroup inGroup : groupSet) {
            groups.add(inGroup.getName());
        }
        return groups;
    }

    @Override
    public List<InGroup> findAvailableUserGroups(InUser user) {
        return groupDao.findAvailableGroups(user);
    }

    @Override
    public List<InPrincipal> findAvailableGroupMembers(InGroup group) {
        return groupDao.findAvailableMembers(group);
    }

    @Override
    public List<InPrincipal> findGroupMembers(InGroup group) {
        return groupDao.findMembers(group);
    }

    @Override
    public List<InPrincipal> findGroupMembers(InGroup group, Integer offset, Integer limit) {
        return groupDao.findMembers(group, offset, limit);
    }

    @Override
    public Integer countGroup() {
        return groupDao.count();
    }

    @Override
    public Integer countGroupMember(InGroup group) {
        return groupDao.countMember(group);
    }

    @Override
    public boolean isGroupExists(String name) {
        return groupDao.isExists(name);
    }

    @Override
    public boolean hasMembership(InGroup group, InPrincipal principal) {
        return groupDao.hasMembership(group, principal);
    }

    @Override
    public InGroup createGroupWithRole(String name, InRoleType... types) {
        InGroup group = new InGroupImpl();
        group.setName(name);
        group.setEnabled(true);
        group.setLocked(false);
        groupDao.save(group, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(group);

        for (InRoleType type : types) {
            InPrincipalRole role = new InPrincipalRoleImpl();
            role.setRole(type);
            principalDao.addRole(group, role, Util.getCurrentUser());
            sessionFactory.getCurrentSession().flush();
        }
        sessionFactory.getCurrentSession().refresh(group);
        return group;
    }

    @Override
    public void saveGroup(InGroup group) {
        groupDao.save(group, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateGroup(InGroup group) {
        groupDao.update(group, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeGroup(InGroup group) {
        groupDao.remove(group, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addGroupMember(InGroup group, InPrincipal principal) throws RecursiveGroupException {
        groupDao.addMember(group, principal, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteGroupMember(InGroup group, InPrincipal principal) {
        groupDao.deleteMember(group, principal);
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // ACTOR
    //====================================================================================================

    @Override
    public InActor findActorById(Long id) {
        return actorDao.findById(id);
    }

    @Override
    public InActor findActorByIdentityNo(String identityNo) {
        return actorDao.findByIdentityNo(identityNo);
    }

    @Override
    public List<InActor> findActors(Integer offset, Integer limit) {
        return actorDao.find(offset, limit);
    }

    @Override
    public List<InActor> findActors(InActorType type, Integer offset, Integer limit) {
        return actorDao.find(type, offset, limit);
    }

    @Override
    public List<InActor> findActors(String filter, Integer offset, Integer limit) {
        return actorDao.find(filter, offset, limit);
    }

    @Override
    public List<InActor> findActors(String filter, InActorType type, Integer offset, Integer limit) {
        return actorDao.find(filter, type, offset, limit);
    }

    @Override
    public Integer countActor() {
        return actorDao.count();
    }

    @Override
    public Integer countActor(InActorType type) {
        return actorDao.count(type);
    }

    @Override
    public Integer countActor(String filter) {
        return actorDao.count(filter);
    }

    @Override
    public Integer countActor(String filter, InActorType type) {
        return actorDao.count(filter, type);
    }


    //====================================================================================================
    // STAFF
    //====================================================================================================

    @Override
    public InStaff findStaffById(Long id) {
        return staffDao.findById(id);
    }

    @Override
    public InStaff findStaffByStaffNo(String StaffNo) {
        return staffDao.findByStaffNo(StaffNo);
    }

    @Override
    public InStaff findStaffByNricNo(String nricNo) {
        return staffDao.findByStaffNo(nricNo);
    }

    @Override
    public List<InStaff> findStaffs(Integer offset, Integer limit) {
        return staffDao.find(offset, limit);
    }

    @Override
    public List<InStaff> findStaffs(String filter, Integer offset, Integer limit) {
        return staffDao.find(filter, offset, limit);
    }

    @Override
    public Integer countStaff() {
        return staffDao.count();
    }

    @Override
    public Integer countStaff(String filter) {
        return staffDao.count(filter);
    }

    @Override
    public boolean isStaffEmailExists(String email) {
        return staffDao.isEmailExists(email);
    }

    @Override
    public boolean isStaffNoExists(String staffNo) {
        return staffDao.isExists(staffNo);
    }

    @Override
    public void saveStaff(InStaff staff) {
        staffDao.save(staff, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateStaff(InStaff staff) {
        staffDao.update(staff, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteStaff(InStaff staff) {
        staffDao.delete(staff, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void broadcastCreated(InStaff staff) {
        StaffCreatedEvent event = new StaffCreatedEvent(staff);
        applicationContext.publishEvent(event);
    }

    @Override
    public void broadcastUpdated(InStaff staff) {
        StaffUpdatedEvent event = new StaffUpdatedEvent(staff);
        applicationContext.publishEvent(event);
    }


    //====================================================================================================
    // VENDOR
    //====================================================================================================

    @Override
    public InApplicant findApplicantById(Long id) {
        return applicantDao.findById(id);
    }

    @Override
    public InApplicant findApplicantByApplicantNo(String ApplicantNo) {
        return applicantDao.findByApplicantNo(ApplicantNo);
    }

    @Override
    public List<InApplicant> findApplicants(Integer offset, Integer limit) {
        return applicantDao.find(offset, limit);
    }

    @Override
    public List<InApplicant> findApplicants(String filter, Integer offset, Integer limit) {
        return applicantDao.find(filter, offset, limit);
    }

    @Override
    public Integer countApplicant() {
        return applicantDao.count();
    }

    @Override
    public Integer countApplicant(String filter) {
        return applicantDao.count(filter);
    }

    @Override
    public void saveApplicant(InApplicant applicant) {
        applicantDao.save(applicant, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateApplicant(InApplicant applicant) {
        applicantDao.update(applicant, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }
}
