package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InEmployment;
import my.edu.umk.pams.intake.application.model.InEmploymentImpl;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InInvolvement;
import my.edu.umk.pams.intake.application.model.InInvolvementImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.model.InFieldCode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.security.service.AccessService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIWantToFillinMultipleInformationOnMyWorkingExperience extends Stage<WhenIWantToFillinMultipleInformationOnMyWorkingExperience> {

    @Autowired
    private CommonService commonService;

    @Autowired
    private ApplicationService applicationService;
    
    @ExpectedScenarioState
    private InApplicant applicant;
    
    @ExpectedScenarioState
    private InIntakeApplication application;
	
    public WhenIWantToFillinMultipleInformationOnMyWorkingExperience I_want_to_fill_in_multiple_information_on_my_history_of_working_experience() {

    	Date endDate = new Date();
    	Date startDate = new Date();
    	
    	
    	
    	InEmployment employment = new InEmploymentImpl();
    	employment.setApplication(application);
   // 	employment.setCurrent(current);
    	employment.setEmployer("somthingSHNBHD");
    	employment.setEndDate(endDate);
    	employment.setStartDate(startDate);
//    	employment.setFieldCode(commonService.findEmploymentFieldCodeByCode(""));
//    	employment.setLevelCode(commonService.findEmploymentLevelCodeByCode(""));
//    	employment.setSectorCode(commonService.findEmploymentSectorCodeByCode(""));
    	
    	

        applicationService.addEmployment(application, employment);
        
        return self();
	}
}
