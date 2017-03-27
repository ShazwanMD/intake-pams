package my.edu.umk.pams.intake.policy.workflow.router;


import my.edu.umk.pams.intake.common.router.RouterStrategySupport;

public class CPSIntakeRouterStrategy extends RouterStrategySupport {

    public CPSIntakeRouterStrategy() {
    }

    @Override
    public String findRegistererCandidate() {
        return "GRP_KRN_CPS";
    }

    @Override
    public String findVerifierCandidate() {
        return "GRP_PGW_CPS";
    }
}
