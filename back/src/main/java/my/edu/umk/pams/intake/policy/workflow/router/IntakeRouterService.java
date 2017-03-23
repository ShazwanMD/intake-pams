package my.edu.umk.pams.intake.policy.workflow.router;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.router.RouterServiceSupport;
import my.edu.umk.pams.intake.common.router.RouterStrategy;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Supply Application Router
 */
@Component("applicationRouterService")
public class IntakeRouterService extends RouterServiceSupport {

    private static final Logger log = LoggerFactory.getLogger(IntakeRouterService.class);

    private static Map<String, RouterStrategy> strategies = new HashMap<String, RouterStrategy>();

    static {
        strategies.put("MGSEB", new MGSEBIntakeRouterStrategy());
        strategies.put("PPS", new CPSIntakeRouterStrategy());
    }

    @Autowired
    private ApplicationService applicationService;

    public List<String> findRegistererCandidates(Long applicationId) {
        // validate
        Validate.notNull(applicationId, "Id must not be null");

        InIntakeApplication application = applicationService.findIntakeApplicationById(applicationId);
        RouterStrategy strategy = strategies.get("MGSEB");
        String candidate = strategy.findRegistererCandidate();

        // todo(uda): permission publishing

        return Arrays.asList(candidate);
    }
}
