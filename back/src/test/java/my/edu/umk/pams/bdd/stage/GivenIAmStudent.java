package my.edu.umk.pams.bdd.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@JGivenStage
public class GivenIAmStudent extends Stage<GivenIAmStudent> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmStudent.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StudyplanService studyplanService;

    @ProvidedScenarioState
    AdAcademicSession academicSession;

    public void I_am_a_student_in_$_academic_session(String academicSessionCode){
        loginAsStudent();
        academicSession = studyplanService.findAcademicSessionByCode(academicSessionCode);
    }

    public void I_am_a_student_in_current_academic_session(){
        loginAsStudent();
        academicSession = studyplanService.findCurrentAcademicSession();
    }

    private void loginAsStudent() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("student1", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }


}
