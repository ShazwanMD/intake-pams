package my.edu.umk.pams.intake.system.service;

import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 */
@Component("systemScheduler")
public class SystemSchedulerImpl implements SystemScheduler {

    private static final Logger LOG = LoggerFactory.getLogger(SystemSchedulerImpl.class);

    @Autowired
    private SystemService systemService;

    @Autowired
    private JavaMailSender mailSender;

    @Scheduled(cron = "*/5 * * * * *")
    public void sendEmail() {
        try {
            List<InEmailQueue> queues = systemService.findEmailQueues(InEmailQueueStatus.QUEUED);
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
    }
}
