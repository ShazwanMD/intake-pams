package my.edu.umk.pams.intake.application.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;

@JGivenStage
public class WhenIWantToFillAllRequiredInformation extends Stage<WhenIWantToFillAllRequiredInformation> {

	    @Autowired
	    private CommonService commonService;

	    @Autowired
	    private ApplicationService applicationService;

	    public WhenIWantToFillAllRequiredInformation I_want_to_fill_all_required_information() {
	    	
	    	return self();
	    	
	    }
}
