package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
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

    @Pending
    public WhenIAddOffering I_add_a_offering_for_intake_$(String referenceNo) {

    	InIntake intakeRef = policyService.findIntakeByReferenceNo(referenceNo);
        InProgramOffering offering = new InProgramOfferingImpl();
        offering.setProjection(10);
        offering.setGeneralCriteria("TODO ADD GEN CRIT"); //todo
        offering.setSpecificCriteria("TODO ADD SPECIFIC CRIT"); // todo
        offering.setInterview(true);
        // offering.setStudyCenterCode(commonService.findStudyCenterCodeByCode("SC-001")); // todo(uda): need data
        // offering.setProgramCode(commonService.findProgramCodeByCode("MEM")); // todo(uda): need real data
        policyService.addProgramOffering(intakeRef, offering);
        return self();
    }
}