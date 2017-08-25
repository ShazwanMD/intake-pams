package my.edu.umk.pams.intake.policy.workflow.router;


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
    public String findEvaluatorCandidate() {
        return "GRP_HO_ADM_CPS";
    }

    @Override
    public String findSelectorCandidate() {
        return "GRP_AHO_ADM_CPS";
    }
}
