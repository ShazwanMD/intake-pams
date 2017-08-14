package my.edu.umk.pams.intake;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
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

/**
 * @author PAMS
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestAppConfiguration.class)
public class RejectCandidateAddReasonTest {

	private static final Logger LOG = LoggerFactory.getLogger(IntakeFlowProcessTest.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AdmissionService admissionService;

	@Autowired
	private ApplicationService applicationService;

	@Before
	public void before() {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("root", "abc123");
		Authentication authed = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authed);
	}

	@Test
	@Rollback(false)
	public void testAddingReason() throws Exception {

		InIntakeApplication intakeApplication = applicationService
				.findIntakeApplicationByReferenceNo("201720181-MASTER-004");
		InCandidate candidate = admissionService.findCandidateByIntakeApplication(intakeApplication);

		candidate.setReason("testadd1");
		candidate.setStatus(InCandidateStatus.ACCEPTED);

		admissionService.rejectCandidate(candidate);

	}
}