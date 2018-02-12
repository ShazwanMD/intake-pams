package my.edu.umk.pams.intake.admission.workflow.handler;


import org.activiti.engine.*;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.workflow.integration.registry.DocumentHandler;

import javax.annotation.PostConstruct;
import java.util.Map;

import static my.edu.umk.pams.intake.IntakeConstants.*;



/**
 * @author PAMS
 */
@Component
public class CandidateHandler implements DocumentHandler<InCandidate> {

    private static final Logger LOG = LoggerFactory.getLogger(CandidateHandler.class);

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
    public String process(InCandidate candidate, Map<String, Object> variables) {
       LOG.debug("Candidate Handler Start");
    	ProcessInstance instance = runtimeService.startProcessInstanceByKey(
                CANDIDATE_PROCESS_KEY,
                candidate.getReferenceNo(),
                variables);
        LOG.debug("Candidate Handler Start");
        LOG.info("Process started for {} with process instance #{} ", CANDIDATE_PROCESS_KEY, instance.getId());
        return instance.getProcessInstanceId();

    }

    @PostConstruct
    public void deployCandidate() {
        DeploymentBuilder deployment = repositoryService.createDeployment();
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();

        // start only when we don't have one
        long count = query.processDefinitionKey(CANDIDATE_PROCESS_KEY).count();
        if (count < 1) {
            deployment
                    .addClasspathResource(CANDIDATE_RESOURCE_PATH)
                    .name(CANDIDATE_PROCESS_NAME)
                    .deploy();
        }
    }
}
