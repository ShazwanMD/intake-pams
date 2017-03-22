package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.model.InProgramOfferingImpl;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIAddOffering extends Stage<WhenIAddOffering> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIAddOffering.class);

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

    @ProvidedScenarioState
    private InIntake intake;

    public WhenIAddOffering I_add_a_offering_for_intake_$(String referenceNo) {
    	
    	WhenIWantToSetupCompetenciesMatrix setupCmptncy = new WhenIWantToSetupCompetenciesMatrix();
        intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
        InProgramOffering offering = new InProgramOfferingImpl();
        offering.setProjection(10);
        offering.setGeneralCriteria(setupCmptncy.getGeneralCriteria());
        offering.setSpecificCriteria(setupCmptncy.getSpecificCriteria());
        offering.setInterview(true);
       // offering.setStudyCenterCode(commonService.findStudyCenterCodeByCode("SC-001")); // todo(uda): need data
       // offering.setProgramCode(commonService.findProgramCodeByCode("MEM")); // todo(uda): need real data
        policyService.addProgramOffering(intake, offering);
        return self();
    }
}