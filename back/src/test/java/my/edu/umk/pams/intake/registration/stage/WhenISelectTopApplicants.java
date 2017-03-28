package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenISelectTopApplicants extends Stage<WhenISelectTopApplicants> {


    @Autowired
    private CommonService commonService;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private ApplicationService applicationService;

    @ProvidedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InApplicant applicant;

    public WhenISelectTopApplicants I_select_top_applicants() {

        // 	InIntakeApplication application = new InIntakeApplicationImpl();

        //	applicationService.findIntakeApplicationsOrderedByRank(intake);
        //List<InIntakeApplication>findIntakeApplicationsOrderedByRank(InIntake intake);

        return self();

    }
}



