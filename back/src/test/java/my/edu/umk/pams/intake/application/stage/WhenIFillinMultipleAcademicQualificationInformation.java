package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InResult;
import my.edu.umk.pams.intake.application.model.InResultImpl;
import my.edu.umk.pams.intake.application.model.InResultItem;
import my.edu.umk.pams.intake.application.model.InResultItemImpl;
import my.edu.umk.pams.intake.application.model.InResultType;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.model.InGradeCode;
import my.edu.umk.pams.intake.common.model.InGradeCodeImpl;
import my.edu.umk.pams.intake.common.model.InSubjectCode;
import my.edu.umk.pams.intake.common.model.InSubjectCodeImpl;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.security.service.AccessService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIFillinMultipleAcademicQualificationInformation extends Stage<WhenIFillinMultipleAcademicQualificationInformation> {

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
    
    @ProvidedScenarioState
    private InResultType resultType;
	
    public WhenIFillinMultipleAcademicQualificationInformation I_want_to_fill_in_academic_qualification() {
    	
    	
    	//adding result
        InResult result = new InResultImpl();
        result.setResultType(InResultType.DIPLOMA);
        result.setApplication(application);
        applicationService.addResult(application, result);

        
        //adding grade code
        InGradeCode grade = new InGradeCodeImpl();
        grade.setCode("grade123");
        grade.setDescription("test grade desc");
        grade.setOrdinal(1);
        commonService.saveGradeCode(grade);

        
        //adding subject code
        InSubjectCode subject = new InSubjectCodeImpl();
        subject.setCode("subject123");
        subject.setDescriptionEn("test subject description");
        subject.setDescriptionMs("test subject description");
        
        commonService.saveSubjectCode(subject);
        
        
        //adding result item
        InResultItem item = new InResultItemImpl();
        item.setResult(result);
        item.setGradeCode(grade);
        item.setSubjectCode(subject);
        
        applicationService.addResultItem(application, result, item);
      
        
    	
    	
        return self();
	}
}