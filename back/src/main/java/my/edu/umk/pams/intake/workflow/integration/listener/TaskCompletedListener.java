package my.edu.umk.pams.intake.workflow.integration.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Faizal Abdul Manan on 22/09/2014.
 */
public class TaskCompletedListener implements TaskListener {

    private static final Logger LOG = LoggerFactory.getLogger(TaskCompletedListener.class);


    @Override
    public void notify(DelegateTask delegateTask) {
        LOG.debug("[" + delegateTask.getProcessInstanceId() + "-" + delegateTask.getId() + "] " + delegateTask.getAssignee() + " is completing  " + delegateTask.getTaskDefinitionKey() + " (" + delegateTask.getName() + ")  - " + delegateTask.getVariables());
    }
}
