package my.edu.umk.pams.intake.admission.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.policy.stage.WhenIListProgrammes;

@JGivenStage
public class WhenIWantToSelectSuitableApplicants extends Stage<WhenIWantToSelectSuitableApplicants> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToSelectSuitableApplicants.class);
    
    @ProvidedScenarioState
    private InCandidate candidate;
    
    @ExpectedScenarioState
    InIntakeSession intakeSession;
    
    @ExpectedScenarioState
    private InIntake intake;
    
    @Autowired
    private ApplicationService applicationService;
    
    @ProvidedScenarioState
    private InIntakeApplication selectedApplication;
 

    
    public WhenIWantToSelectSuitableApplicants I_want_to_select_suitable_applicants() {
    	

            List<InIntakeApplication> applications = applicationService.findIntakeApplications(intake,InBidStatus.PROCESSING);

            for (InIntakeApplication application : applications) {
            	
            	//Fromm the list, we selected one application and set the data to selectedApplication
                selectedApplication = application;
            }

            return self();
    }

}
