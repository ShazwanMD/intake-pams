package my.edu.umk.pams.intake.identity;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.intake.TestSupport;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * example
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_ADM_0001 extends TestSupport{

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_ADM_0001.class);

    @Before
    public void before() {
        super.before();
    }

    @After
    public void after(){
    }

    @Test
    @Rollback(true)
    public void testSomething(){
        Assert.notNull(currentUser);
        Assert.notNull("something");
    }
}

