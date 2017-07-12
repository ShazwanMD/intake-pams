package my.edu.umk.pams.intake.system.service;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.integration.InAutoLoginToken;
import my.edu.umk.pams.intake.security.integration.NonSerializableSecurityContext;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.model.InEmailQueueImpl;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 */
@Component("systemScheduler")
public class SystemSchedulerImpl implements SystemScheduler {

    private static final Logger LOG = LoggerFactory.getLogger(SystemSchedulerImpl.class);

    @Autowired
    private SystemService systemService;
    
    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private PolicyService policyService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Scheduled(cron = "*/10 * * * * *")
    public void sendEmail() {
        loginAsSystem();
        InIntakeSession intakeSession = policyService.findCurrentIntakeSession();
        List<InIntake> intake = policyService.findIntakes(intakeSession);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        Calendar cal = Calendar.getInstance();  
        cal.setTime(todayDate);  
        cal.add(Calendar.DATE, 7); // 7 is the days you want to add or subtract   
        todayDate = cal.getTime();
        String warnDate = sdf.format(todayDate); 
        
        for (InIntake inIntake : intake) {
        	
        	String endDate = sdf.format(inIntake.getEndDate());
        	if (warnDate.equals(endDate))
        	{
        		List<InIntakeApplication> draftApplication = applicationService.findIntakeApplications(inIntake, InBidStatus.DRAFTED);
        		LOG.debug("{} reminder email to be sent", draftApplication.size());
        		for (InIntakeApplication inIntakeApplication : draftApplication) {
        			InEmailQueue email= new InEmailQueueImpl();
        	        String subject = "Reminder";
        	        String body = "Please complete your application. You have 7 days to go.. Hurry up times is running up";
        	        //verification.getToken();
        	        email.setTo(inIntakeApplication.getEmail());
        	        email.setSubject(subject);
        	        email.setBody(body);
        	       //method send email 
        	        email.setCode("EQ/" + System.currentTimeMillis());
        	        email.setQueueStatus(InEmailQueueStatus.QUEUED);
        	        systemService.saveEmailQueue(email);
				}
        	}
		}
        try {
            List<InEmailQueue> queues = systemService.findEmailQueues(InEmailQueueStatus.QUEUED);
            LOG.debug("{} email to be sent", queues.size());
            for (InEmailQueue queue : queues) {
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setFrom(queue.getTo());
                helper.setTo(queue.getTo());
                helper.setSubject(queue.getSubject());
                helper.setText(queue.getBody());
                mailSender.send(mimeMessage);

                // update queue
                queue.setQueueStatus(InEmailQueueStatus.SENT);
                systemService.updateEmailQueue(queue);
            }
            
        } catch (MessagingException e) {
            LOG.error("error " + e);
        }

        loginAsSystem();
    }

    private SecurityContext loginAsSystem() {
        SecurityContext savedCtx = SecurityContextHolder.getContext();
        InAutoLoginToken authenticationToken = new InAutoLoginToken("system");
        Authentication authed = authenticationManager.authenticate(authenticationToken);
        SecurityContext system = new NonSerializableSecurityContext();
        system.setAuthentication(authed);
        SecurityContextHolder.setContext(system);
        return savedCtx;
    }

    private void logoutAsSystem(SecurityContext context) {
        SecurityContextHolder.setContext(context);
    }
}

