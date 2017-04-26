package my.edu.umk.pams.intake.policy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author PAMS
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        US_IN_PLC_1000.class,
        US_IN_PLC_1001.class, 
        US_IN_PLC_1002.class,
        US_IN_PLC_2000.class,
        US_IN_PLC_2001.class,
        US_IN_PLC_2002.class,
        US_IN_PLC_2003.class,
        US_IN_PLC_2004.class,
        US_IN_PLC_2005.class, //pending
        US_IN_PLC_3000.class,
        US_IN_PLC_3001.class,
        US_IN_PLC_3002.class, 
        US_IN_PLC_3003.class,
        US_IN_PLC_3004.class,
        US_IN_PLC_3005.class, //pending
        US_IN_PLC_5000.class,
        US_IN_PLC_5001.class, //pending, no data for MGSEB programs


})
public class PolicyModuleTestSuite {
}
