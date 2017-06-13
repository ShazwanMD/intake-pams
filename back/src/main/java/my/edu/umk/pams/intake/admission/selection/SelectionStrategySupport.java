package my.edu.umk.pams.intake.admission.selection;

import my.edu.umk.pams.intake.application.model.*;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.model.InGradeCode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import net.sourceforge.jeval.EvaluationConstants;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author canang technologies
 */
public abstract class SelectionStrategySupport implements SelectionStrategy {

    private static final Logger LOG = LoggerFactory.getLogger(SelectionStrategySupport.class);

    protected final Evaluator evaluator = new Evaluator();

    @Autowired
    protected ApplicationService applicationService;

    @Autowired
    protected CommonService commonService;

    @Autowired
    protected PolicyService policyService;

    //====================================================================================================
    // PROTECTED METHODS
    //====================================================================================================

    protected boolean evaluate(InIntakeApplication application, String expression) {
        LOG.debug("expression: {}", expression);
        boolean result = false;
        prepareVariables(application);
        if (expression == null || expression.isEmpty()) {
            result = false;
        } else {
            try {
                String resultString = evaluator.evaluate(expression);
                if (resultString.equals(EvaluationConstants.BOOLEAN_STRING_TRUE)) result = true;
                if (resultString.equals(EvaluationConstants.BOOLEAN_STRING_FALSE)) result = false;
            } catch (EvaluationException e) {
                // something is wrong expression syntax maybe?
                LOG.debug("Got an Evaluation exception. Please handle me");
            }
        }
        return result;
    }

    protected void prepareVariables(InIntakeApplication application) {
        extractGradeCode();
        extractDiplomaResult(application);
        extractBachelorResult(application);
        extractMuetResult(application);
    }

    protected void extractGradeCode() {
        List<InGradeCode> gradeCodes = commonService.findGradeCodes();
        for (InGradeCode gradeCode : gradeCodes) {
            evaluator.putVariable(gradeCode.getCode(), gradeCode.getOrdinal().toString());
        }
    }

    protected void extractMuetResult(InIntakeApplication application) {
        LOG.debug("extract muet result");
        InResultType type = InResultType.MUET;
        if (applicationService.hasResult(application, type)) {
            InResult result =  applicationService.findResult(application, type);
            evaluator.putVariable(type.getCode() + "." + "Band", result.getResultAlphanumeric().toString());
        }
    }

    protected void extractDiplomaResult(InIntakeApplication application) {
        LOG.debug("extract diploma result");
        InResultType type = InResultType.DIPLOMA;
        if (applicationService.hasResult(application, type)) {
            InResult result =  applicationService.findResult(application, type);
            evaluator.putVariable(type.getCode() + "." + "CPA", result.getResultAlphanumeric().toString());
        }
    }

    protected void extractBachelorResult(InIntakeApplication application) {
        LOG.debug("extract bachelor result");
        InResultType type = InResultType.BACHELOR;
        if (applicationService.hasResult(application, type)) {
            InResult result =  applicationService.findResult(application, type);
            evaluator.putVariable(type.getCode() + "." + "CPA", result.getResultAlphanumeric().toString());
        }
    }
}
