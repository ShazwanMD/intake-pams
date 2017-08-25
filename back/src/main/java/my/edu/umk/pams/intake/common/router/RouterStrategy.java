package my.edu.umk.pams.intake.common.router;

import java.math.BigDecimal;
import java.util.List;


/**
 */
public interface RouterStrategy {

    public String findDrafterCandidate();

    public List<String> findDrafterCandidates();

    public String findDrafterCandidate(BigDecimal amount, Enum type);

    public List<String> findDrafterCandidates(BigDecimal amount, Enum type);

    public String findRequesterCandidate();

    public String findRequesterCandidate(BigDecimal amount, Enum type);

    public String findRegistererCandidate();

    public String findRegistererCandidate(BigDecimal amount, Enum Type);

    public String findVerifierCandidate();

    public String findUpperVerifierCandidate();

    public String findVerifierCandidate(BigDecimal amount);

    public String findUpperCheckerCandidate();

    public String findUpperCheckerCandidate(BigDecimal amount);

    public String findCheckerCandidate();

    public String findCheckerCandidate(BigDecimal amount);

    public String findQuerierCandidate();

    public String findUpperQuerierCandidate();

    public String findUpperQuerierCandidate(BigDecimal amount);

    public String findApproverCandidate();

    public String findApproverCandidate(BigDecimal amount);

    public String findPreparerCandidate();

    public List<String> findPreparerCandidates();

    public String findPreparerCandidate(BigDecimal amount, Enum type);

    public List<String> findPreparerCandidates(BigDecimal amount, Enum type);

    public String findEvaluatorCandidate();

    public String findEvaluatorCandidate(BigDecimal amount, Enum type);

    public String findSelectorCandidate();

    public String findPublisherCandidate();

}
