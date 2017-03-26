package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;


import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InInvolvement;
import my.edu.umk.pams.intake.application.model.InInvolvementImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.security.service.AccessService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIWantToFillinMultipleInformationOnMyExtraCurricularExperience extends Stage<WhenIWantToFillinMultipleInformationOnMyExtraCurricularExperience> {

    @Autowired
    private CommonService commonService;

    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private AccessService accessService;
    
    @ExpectedScenarioState
    private InApplicant applicant;
    
    @ExpectedScenarioState
    private InIntakeApplication application;
	
    public WhenIWantToFillinMultipleInformationOnMyExtraCurricularExperience I_want_to_fill_in_multiple_information_on_my_history_of_curricular_experience() {
    	
    	Date endDate = new Date();
    	Date startDate = new Date();
    	
        InInvolvement involvement = new InInvolvementImpl();
        involvement.setTypeCode(commonService.findInvolvementTypeCodeByCode("SPORTS"));
        involvement.setLevelCode(commonService.findInvolvementLevelCodeByCode("NATIONAL"));
        involvement.setTitleCode(commonService.findInvolvementTitleCodeByCode("ATHLETE"));
        involvement.setEndDate(endDate);
        involvement.setStartDate(startDate);
        involvement.setApplication(application);
        applicationService.addInvolvement(application, involvement);
        return self();
	}
}
