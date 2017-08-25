package my.edu.umk.pams.intake.policy.workflow.router;


import my.edu.umk.pams.intake.common.router.RouterStrategySupport;

public class MGSEBIntakeRouterStrategy extends RouterStrategySupport {

    public MGSEBIntakeRouterStrategy() {
    }

    @Override
    public String findVerifierCandidate() {
        return "GRP_KRN_ADM_MGSEB";
    }

    @Override
    public String findPublisherCandidate() {
        return "GRP_PGW_ADM_MGSEB";
    }

    @Override
    public String findEvaluatorCandidate() {
        return "GRP_HO_ADM_MGSEB";
    }

    @Override
    public String findSelectorCandidate() {
        return "GRP_AHO_ADM_MGSEB";
    }
}
