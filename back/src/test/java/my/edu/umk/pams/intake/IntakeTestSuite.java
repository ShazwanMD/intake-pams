package my.edu.umk.pams.intake;

import my.edu.umk.pams.intake.admission.AdmissionModuleTestSuite;
import my.edu.umk.pams.intake.application.ApplicationModuleTestSuite;
import my.edu.umk.pams.intake.identity.IdentityModuleTestSuite;
import my.edu.umk.pams.intake.policy.PolicyModuleTestSuite;
import my.edu.umk.pams.intake.registration.RegistrationModuleTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RegistrationModuleTestSuite.class,
        PolicyModuleTestSuite.class,
        ApplicationModuleTestSuite.class,
        AdmissionModuleTestSuite.class,
        IdentityModuleTestSuite.class,
})
public class IntakeTestSuite {
}