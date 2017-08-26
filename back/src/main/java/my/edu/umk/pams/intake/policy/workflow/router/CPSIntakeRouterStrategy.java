package my.edu.umk.pams.intake.policy.workflow.router;


import java.util.Arrays;
import java.util.List;

import my.edu.umk.pams.intake.common.router.RouterStrategySupport;

public class CPSIntakeRouterStrategy extends RouterStrategySupport {

    public CPSIntakeRouterStrategy() {
    }

    @Override
    public String findVerifierCandidate() {
        return "GRP_KRN_ADM_CPS";
    }

    @Override
    public String findPublisherCandidate() {
        return "GRP_PGW_ADM_CPS";
    }

    @Override
    public List<String> findEvaluatorCandidates() {
        return Arrays.asList("GRP_PGW_ADM_MGSEB", "GRP_KRN_PTJ_IO");
    }

    @Override
    public String findSelectorCandidate() {
        return "GRP_PGW_ADM_CPS";
    }
}
