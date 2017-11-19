
 package my.edu.umk.pams.intake.policy.workflow.router;


import java.util.Arrays;
import java.util.List;

import my.edu.umk.pams.intake.common.router.RouterStrategySupport;

public class MGSEBIntakeRouterStrategy extends RouterStrategySupport {

    public MGSEBIntakeRouterStrategy() {
    }

    @Override
    public String findVerifierCandidate() {
        return "GRP_KRN_ADM_MGSEB";  //cps-kerani
    }

    @Override
    public String findPublisherCandidate() {
        return "GRP_PGW_ADM_MGSEB";  //cps-pegawai
    }
    
    @Override
    public String findEvaluatorCandidate() {
        return "GRP_PGW_PTJ_IO";  //io-pegawai (not in use)
    }

    @Override
    public String findSelectorCandidate() {
        return "GRP_PGW_ADM_MGSEB"; //cps-pegawai
    }
    
    @Override
    public String findPreapproverCandidate() {
        return "GRP_KRN_FCTY_A01";  //fakulti-kerani-A01
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

    @Override
    public List<String> findVerifierCandidates() {
        return Arrays.asList("GRP_KRN_ADM_MGSEB", "GRP_ADM");   //mgseb-kerani , root
    }

    @Override
    public List<String> findPublisherCandidates() {
        return Arrays.asList("GRP_PGW_ADM_MGSEB", "GRP_ADM");   //mgseb-pegawai , root
    }
    
//    @Override
//    public String findEvaluatorCandidate() {
//        return "GRP_PGW_PTJ_IO";  //io-pegawai (not in use)
//    }

    @Override
    public List<String> findEvaluatorCandidates() {
        return Arrays.asList("GRP_PGW_ADM_MGSEB", "GRP_PGW_PTJ_IO", "GRP_ADM");   //mgseb-pegawai , io-pegawai, root
    }

    @Override
    public List<String> findSelectorCandidates() {
        return Arrays.asList("GRP_KRN_FCTY_A01", "GRP_KRN_ADM_MGSEB", "GRP_PGW_ADM_MGSEB", "GRP_ADM");   //fakulti-kerani-A01 , root
    } 
    
    @Override
    public List<String> findPreapproverCandidates() {
        return Arrays.asList("GRP_PGW_FCTY_A01", "GRP_KRN_ADM_MGSEB", "GRP_PGW_ADM_MGSEB", "GRP_ADM");   //fakulti-pegawai-A01 , root
    }
    
    @Override
    public List<String> findUpperCandidates() {
        return Arrays.asList("GRP_PGW_FCTY_A01", "GRP_KRN_ADM_MGSEB", "GRP_PGW_ADM_MGSEB", "GRP_ADM");   //fakulti-pegawai-A01 , root
    }
    
    @Override
    public List<String> findOfferCandidates() {
        return Arrays.asList("GRP_PGW_FCTY_A01", "GRP_KRN_ADM_MGSEB", "GRP_PGW_ADM_MGSEB", "GRP_ADM");   //fakulti-pegawai-A01 , root
    }
    
    @Override
    public List<String> findRegisterCandidates() {
        return Arrays.asList("GRP_PGW_FCTY_A01", "GRP_KRN_ADM_MGSEB", "GRP_PGW_ADM_MGSEB", "GRP_ADM");   //fakulti-pegawai-A01 , root
    }    

}



