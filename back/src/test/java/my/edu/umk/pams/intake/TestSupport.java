package my.edu.umk.pams.intake;

import my.edu.umk.pams.intake.core.InMetaState;
import my.edu.umk.pams.intake.core.InMetadata;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.model.InUserImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

public class TestSupport {

    private static final Logger LOG = LoggerFactory.getLogger(TestSupport.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected InUser currentUser;

    public void before() {
        Session session = sessionFactory.getCurrentSession();

        // prepare currentUser
        currentUser = new InUserImpl();
        currentUser.setUsername("root");
        currentUser.setRealName("Root Admin");
        currentUser.setPassword("abc123");
        currentUser.setEmail("root@umk.edu.my");

        // prepare metadata
        InMetadata metadata = new InMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(0L);
        metadata.setState(InMetaState.ACTIVE);
        currentUser.setMetadata(metadata);

        session.save(currentUser);
        session.flush();
        session.refresh(currentUser);
    }

    public void after() {
    }
}