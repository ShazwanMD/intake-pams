package my.edu.umk.pams.intake.application.stage;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO;

import java.util.HashMap;
import java.util.Map;

import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.system.service.SystemService;

@JGivenStage
public class WhenIWantToFillInMultipleInformationOnMyHistoryOfEducation 
			extends Stage <WhenIWantToFillInMultipleInformationOnMyHistoryOfEducation> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToFillInMultipleInformationOnMyHistoryOfEducation.class);

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private SystemService systemService;

    @ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InIntakeSession intakeSession;

    @ExpectedScenarioState
    private InApplicant applicant;

    @ProvidedScenarioState
    private InIntakeApplication intakeApplication;


	public WhenIWantToFillInMultipleInformationOnMyHistoryOfEducation 
			I_want_to_fill_in_multiple_information_on_my_history_of_education() {

	    Map<String, Object> map = new HashMap<>();
        map.put("intakeSession", intakeSession);
        map.put("programLevel", intake.getProgramLevel());
        String referenceNo = systemService.generateFormattedReferenceNo(INTAKE_APPLICATION_REFERENCE_NO, map);
        
        intakeApplication = new InIntakeApplicationImpl();
        intakeApplication.setIntake(this.intake);
        intakeApplication.setName("whatever");
        intakeApplication.setEmail("msyahrul@umk.edu.my");
        intakeApplication.setReferenceNo(referenceNo);
        intakeApplication.setSchoolCode(commonService.findSchoolCodeByCode("SMA"));
        intakeApplication.setSchoolName("Sekolah Agama Berasrama Penuh Ceruk Tok Kun");
        intakeApplication.setSchoolBatch(2001);
        applicationService.draftIntakeApplication(intake, intakeApplication);
		
		return self();
	}

}
