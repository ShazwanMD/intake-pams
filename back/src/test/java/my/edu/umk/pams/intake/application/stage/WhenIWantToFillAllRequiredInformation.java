package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InStudyMode;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIWantToFillAllRequiredInformation extends Stage<WhenIWantToFillAllRequiredInformation> {

    private static final InIntakeApplication InIntakeApplication = null;

    @Autowired
    private CommonService commonService;

    @Autowired
    private ApplicationService applicationService;

    @ExpectedScenarioState
    private InApplicant applicant;

    public WhenIWantToFillAllRequiredInformation I_want_to_fill_all_required_information() {
        InIntakeApplication application = new InIntakeApplicationImpl();

        application.setReferenceNo("000001");
        application.setName("Ahmad Radzif Radzol");
        application.setEmail("ahmad.razif@gmail.com");
        application.setPhone("123456789");
        application.setOkuNo("123461654");
        application.setSchoolName("SMKZA");
        application.setStudyMode(InStudyMode.FULLTIME);

        applicationService.draftIntakeApplication((InIntake) applicant, InIntakeApplication);
        return self();
    }
}
