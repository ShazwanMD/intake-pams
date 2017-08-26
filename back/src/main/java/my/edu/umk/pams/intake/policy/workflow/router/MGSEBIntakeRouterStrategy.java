package my.edu.umk.pams.intake.policy.workflow.router;


import java.util.Arrays;
import java.util.List;

import my.edu.umk.pams.intake.common.router.RouterStrategySupport;

public class MGSEBIntakeRouterStrategy extends RouterStrategySupport {

    public MGSEBIntakeRouterStrategy() {
    }

    @Override
    public String findVerifierCandidate() {
        return "GRP_PGW_ADM_MGSEB";
    }

    @Override
    public String findPublisherCandidate() {
        return "GRP_PGW_ADM_MGSEB";
    }

    
    @Override
    public String findEvaluatorCandidate() {
        return "GRP_PGW_ADM_MGSEB";
    }
//    @Override
//    public List<String> findEvaluatorCandidates() {
//        return Arrays.asList("GRP_PGW_ADM_CPS", "GRP_KRN_PTJ_IO");
//    }

    @Override
    public String findSelectorCandidate() {
        return "GRP_PGW_ADM_MGSEB";
    }
    
    @Override
    public String findPreapproverCandidate() {
        return "GRP_PGW_ADM_MGSEB";
    }


}
