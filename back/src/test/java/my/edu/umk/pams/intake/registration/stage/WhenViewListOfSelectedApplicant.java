package my.edu.umk.pams.intake.registration.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.stage.WhenIWantToSelectSuitableAppealedApplicants;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.policy.stage.WhenIListProgrammes;

@JGivenStage
public class WhenViewListOfSelectedApplicant extends Stage<WhenViewListOfSelectedApplicant> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenViewListOfSelectedApplicant.class);
	
	@ExpectedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InCandidate candidate;

    @ExpectedScenarioState
    private InIntake intake;
    
    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
    
    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private PolicyService policyService;
    
    public WhenViewListOfSelectedApplicant View_List_Of_Selected_Applicant() {

    	intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
	   	List<InIntakeApplication> intakeApplications  =  applicationService.findIntakeApplications(intake,InBidStatus.SELECTED);
	   	
	    for (InIntakeApplication application : intakeApplications) {
	    	LOG.debug("application : {} ", application.getBidStatus());
        }
	    Assert.notNull(intakeApplication, "intakeApplication is empty");
	    return self(); 
	}
}

	
