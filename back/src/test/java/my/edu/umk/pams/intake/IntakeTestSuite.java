package my.edu.umk.pams.intake;

import my.edu.umk.pams.intake.admission.AdmissionTestSuite;
import my.edu.umk.pams.intake.identity.IdentityTestSuite;
import my.edu.umk.pams.intake.offering.OfferingTestSuite;
import my.edu.umk.pams.intake.policy.PolicyTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OfferingTestSuite.class,
        AdmissionTestSuite.class,
        PolicyTestSuite.class,
        IdentityTestSuite.class,
})
public class IntakeTestSuite {
}