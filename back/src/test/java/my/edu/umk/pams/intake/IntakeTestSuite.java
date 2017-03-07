package my.edu.umk.pams.intake;

import my.edu.umk.pams.intake.admission.AdmissionModuleTestSuite;
import my.edu.umk.pams.intake.identity.IdentityModuleTestSuite;
import my.edu.umk.pams.intake.offering.OfferingModuleTestSuite;
import my.edu.umk.pams.intake.policy.PolicyModuleTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OfferingModuleTestSuite.class,
        AdmissionModuleTestSuite.class,
        PolicyModuleTestSuite.class,
        IdentityModuleTestSuite.class,
})
public class IntakeTestSuite {
}