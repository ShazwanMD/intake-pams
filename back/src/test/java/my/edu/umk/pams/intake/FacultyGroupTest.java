package my.edu.umk.pams.intake;

import org.activiti.engine.task.Task;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.model.InFacultyCode;
import my.edu.umk.pams.intake.common.model.InGraduateCenter;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.common.model.InSupervisorCode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InGroup;
import my.edu.umk.pams.intake.identity.model.InGroupImpl;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeImpl;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.model.InProgramOfferingImpl;
import my.edu.umk.pams.intake.policy.model.InStudyModeOffering;
import my.edu.umk.pams.intake.policy.model.InStudyModeOfferingImpl;
import my.edu.umk.pams.intake.policy.model.InSupervisorOffering;
import my.edu.umk.pams.intake.policy.model.InSupervisorOfferingImpl;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.system.service.SystemService;
import my.edu.umk.pams.intake.workflow.service.WorkflowService;

/**
 * @author PAMS
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestAppConfiguration.class)
public class FacultyGroupTest {

    private static final Logger LOG = LoggerFactory.getLogger(FacultyGroupTest.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private SystemService systemService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private IdentityService identityService;

    @Before
    public void before() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("root", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }

    @Test
    @Rollback(false)
    public void testFacultyGroup() throws Exception {
        List<InFacultyCode> facultyCodes = commonService.findFacultyCodes();
        for (InFacultyCode facultyCode : facultyCodes) {
            InGroup group = new InGroupImpl();
            group.setName("GRP_" + facultyCode.getCode());
            group.setEnabled(true);
            group.setLocked(true);
            identityService.saveGroup(group);
        }
    }
}
