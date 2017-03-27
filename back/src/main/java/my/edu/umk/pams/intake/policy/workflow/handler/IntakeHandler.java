package my.edu.umk.pams.intake.policy.workflow.handler;

import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.workflow.integration.registry.DocumentHandler;
import org.activiti.engine.*;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

import static my.edu.umk.pams.intake.IntakeConstants.*;

/**
 * @author PAMS
 */
@Component
public class IntakeHandler implements DocumentHandler<InIntake> {

    private static final Logger LOG = LoggerFactory.getLogger(IntakeHandler.class);

    @Autowired
    protected ProcessEngine processEngine;

    @Autowired
    protected RuntimeService runtimeService;

    @Autowired
    protected TaskService taskService;

    @Autowired
    protected HistoryService historyService;

    @Autowired
    protected RepositoryService repositoryService;

    @Override
    public String process(InIntake intake, Map<String, Object> variables) {
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(
                INTAKE_PROCESS_KEY,
                intake.getReferenceNo(),
                variables);
        LOG.info("Process started for {} with process instance #{} ", INTAKE_PROCESS_KEY, instance.getId());
        return instance.getProcessInstanceId();
    }

    @PostConstruct
    public void deployIntake() {
        DeploymentBuilder deployment = repositoryService.createDeployment();
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();

        // start only when we don't have one
        long count = query.processDefinitionKey(INTAKE_PROCESS_KEY).count();
        if (count < 1) {
            deployment
                    .addClasspathResource(INTAKE_RESOURCE_PATH)
                    .name(INTAKE_PROCESS_NAME)
                    .deploy();
        }
    }
}
