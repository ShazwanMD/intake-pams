package my.edu.umk.pams.intake.policy.workflow.router;


import my.edu.umk.pams.intake.common.router.RouterStrategySupport;

public class MGSEBIntakeRouterStrategy extends RouterStrategySupport {

    public MGSEBIntakeRouterStrategy() {
    }

    @Override
    public String findRegistererCandidate() {
        return "GRP_KRN_MGSEB";
    }

    @Override
    public String findVerifierCandidate() {
        return "GRP_PGW_MGSEB";
    }
}
