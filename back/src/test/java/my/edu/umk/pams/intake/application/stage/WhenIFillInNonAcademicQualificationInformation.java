package my.edu.umk.pams.intake.application.stage;


import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InInvolvement;
import my.edu.umk.pams.intake.application.model.InInvolvementImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.model.InInvolvementLevelCode;
import my.edu.umk.pams.intake.identity.model.InApplicant;

@JGivenStage
public class WhenIFillInNonAcademicQualificationInformation extends Stage<WhenIFillInNonAcademicQualificationInformation> {
	
	@Autowired
    private ApplicationService applicationService;
    
    @ExpectedScenarioState
    private InApplicant applicant;
    
    @ProvidedScenarioState
    private InInvolvement involvement;
    
    @ProvidedScenarioState
    private InIntakeApplication application;
    
    @ProvidedScenarioState
    private InInvolvementLevelCode involvementLevelCode;

	public WhenIFillInNonAcademicQualificationInformation I_want_to_fill_in_non_academic_qualification() {
		
		Date endDate = new Date();
    	Date startDate = new Date();
    	
		//adding involvement
		InInvolvement involvement = new InInvolvementImpl();
		involvement.setStartDate(startDate);
		involvement.setEndDate(endDate);

        applicationService.addInvolvement(application, involvement);
		return self();
	}

}
