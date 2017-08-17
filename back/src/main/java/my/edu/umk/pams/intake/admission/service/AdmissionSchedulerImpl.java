package my.edu.umk.pams.intake.admission.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.model.InEmailQueueImpl;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;
import my.edu.umk.pams.intake.system.service.SystemService;

@Component("admissionScheduler")
public class AdmissionSchedulerImpl implements AdmissionScheduler {

	private static final Logger LOG = LoggerFactory.getLogger(AdmissionSchedulerImpl.class);

	@Autowired
	private PolicyService policyService;

	@Autowired
	private AdmissionService admissionService;

	@Autowired
	private SystemService systemService;

	@Scheduled(cron = "*/10 * * * * *")
	public void sendEmail() {
//		this.preapproveCandidate();
//		this.approveCandidate();
//		this.offerCandidate();
//		this.rejectCandidate();
	}

	public void preapproveCandidate() {
		InIntakeSession intakeSession = policyService.findCurrentIntakeSession();

		List<InIntake> intake = policyService.findIntakes(intakeSession);
		for (InIntake inIntake : intake) {

			List<InCandidate> inCandidate = admissionService.findCandidatesByStatus(inIntake,
					InCandidateStatus.PREAPPROVED);
			for (InCandidate candidate : inCandidate) {
				boolean isExists = false;
				isExists = systemService.hasEmailQueue(candidate.getEmail());
				if(isExists = true)
				{
					InEmailQueue emailQueue = new InEmailQueueImpl();
					emailQueue.setCode("EQ/" + System.currentTimeMillis());
					emailQueue.setTo(candidate.getEmail());
					emailQueue.setSubject("Sedang diproses");
					emailQueue.setBody("Permohonan anda pada status " + InCandidateStatus.PREAPPROVED);
					emailQueue.setQueueStatus(InEmailQueueStatus.QUEUED);
					systemService.saveEmailQueue(emailQueue);
				}
			}

		}

	}

	public void approveCandidate() {
		InIntakeSession intakeSession = policyService.findCurrentIntakeSession();

		List<InIntake> intake = policyService.findIntakes(intakeSession);
		for (InIntake inIntake : intake) {
			List<InCandidate> inCandidate = admissionService.findCandidatesByStatus(inIntake,
					InCandidateStatus.APPROVED);
			for (InCandidate candidate : inCandidate) {
				boolean isExists = false;
				isExists = systemService.hasEmailQueue(candidate.getEmail());
				if(isExists == true)
				{
					InEmailQueue emailQueue = new InEmailQueueImpl();
					emailQueue.setCode("EQ/" + System.currentTimeMillis());
					emailQueue.setTo(candidate.getEmail());
					emailQueue.setSubject("Sedang diproses");
					emailQueue.setBody("Permohonan anda pada status " + InCandidateStatus.APPROVED);
					emailQueue.setQueueStatus(InEmailQueueStatus.QUEUED);
					systemService.saveEmailQueue(emailQueue);
				}
			}

		}

	}

	public void offerCandidate() {
		InIntakeSession intakeSession = policyService.findCurrentIntakeSession();

		List<InIntake> intake = policyService.findIntakes(intakeSession);
		for (InIntake inIntake : intake) {
			List<InCandidate> inCandidate = admissionService.findCandidatesByStatus(inIntake,
					InCandidateStatus.OFFERED);
			for (InCandidate candidate : inCandidate) {
				boolean isExists = false;
				isExists = systemService.hasEmailQueue(candidate.getEmail());
				if(isExists == true)
				{
					// generate offer letter and send link offer letter to emel
					String applicationUrl = systemService.findConfigurationByKey("application.url").getValue();
					String offerLetter = applicationUrl + "/servlet/report?report=IN_0001.jrxml&report.pdf";

					// notify candidate
					InEmailQueue emailQueue = new InEmailQueueImpl();
					emailQueue.setCode("EQ/" + System.currentTimeMillis());
					emailQueue.setTo(candidate.getEmail());
					emailQueue.setSubject("Tawaran diterima");
					emailQueue.setBody("Tahniah kerana anda diterima masuk UMK. Sila klik untuk lihat surat tawaran :"
							+ offerLetter);
					emailQueue.setQueueStatus(InEmailQueueStatus.QUEUED);
					systemService.saveEmailQueue(emailQueue);
				}
			}
		}
	}

	public void rejectCandidate() {
		InIntakeSession intakeSession = policyService.findCurrentIntakeSession();

		List<InIntake> intake = policyService.findIntakes(intakeSession);
		for (InIntake inIntake : intake) {
			List<InCandidate> inCandidate = admissionService.findCandidatesByStatus(inIntake,
					InCandidateStatus.REJECTED);
			for (InCandidate candidate : inCandidate) {
				boolean isExists = false;
				isExists = systemService.hasEmailQueue(candidate.getEmail());
				if(isExists == true)
				{
					InEmailQueue emailQueue = new InEmailQueueImpl();
					emailQueue.setCode("EQ/" + System.currentTimeMillis());
					emailQueue.setTo(candidate.getEmail());
					emailQueue.setSubject("Permohonan anda tidak berjaya kerana " + candidate.getReason());
					emailQueue.setQueueStatus(InEmailQueueStatus.QUEUED);
					systemService.saveEmailQueue(emailQueue);
				}
			}
		}
	}
}
