package my.edu.umk.pams.intake.policy.workflow.router;


import my.edu.umk.pams.intake.common.router.RouterStrategySupport;

public class PPSIntakeRouterStrategy extends RouterStrategySupport {

    public PPSIntakeRouterStrategy() {
    }

    @Override
    public String findRegistererCandidate() {
        return "GRP_KRN_PPS";
    }

    @Override
    public String findVerifierCandidate() {
        return "GRP_PGW_PPS";
    }
}
