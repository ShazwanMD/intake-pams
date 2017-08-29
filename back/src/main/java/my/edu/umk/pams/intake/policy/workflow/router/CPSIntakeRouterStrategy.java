
 package my.edu.umk.pams.intake.policy.workflow.router;


import java.util.Arrays;
import java.util.List;

import my.edu.umk.pams.intake.common.router.RouterStrategySupport;

public class CPSIntakeRouterStrategy extends RouterStrategySupport {

    public CPSIntakeRouterStrategy() {
    }

    @Override
    public String findVerifierCandidate() {
        return "GRP_KRN_ADM_CPS";  //cps-kerani
    }

    @Override
    public String findPublisherCandidate() {
        return "GRP_PGW_ADM_CPS";  //cps-pegawai
    }
    
    @Override
    public String findEvaluatorCandidate() {
        return "GRP_PGW_PTJ_IO";  //io-pegawai (not in use)
    }

    @Override
    public List<String> findEvaluatorCandidates() {
        return Arrays.asList("GRP_PGW_ADM_CPS", "GRP_PGW_PTJ_IO");   //cps-pegawai , io-pegawai
    }

    @Override
    public String findSelectorCandidate() {
        return "GRP_KRN_FCTY_A01"; //fakulti-kerani-A01
    }
    
    @Override
    public String findPreapproverCandidate() {
        return "GRP_PGW_FCTY_A01";  //fakulti-pegawai-A01
    }
    
    @Override
    public String findUpperCandidate() {
        return "GRP_PGW_FCTY_A01"; //fakulti-pegawai-A01
    }
    
    @Override
    public String findOfferCandidate() {
        return "GRP_PGW_FCTY_A01"; //fakulti-pegawai-A01
    }
    
    @Override
    public String findRegisterCandidate() {
        return "GRP_PGW_FCTY_A01"; //fakulti-pegawai-A01
    }


}



