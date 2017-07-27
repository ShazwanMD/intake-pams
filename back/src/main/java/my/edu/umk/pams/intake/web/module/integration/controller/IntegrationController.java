package my.edu.umk.pams.intake.web.module.integration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.service.PolicyService;

@Transactional
@RestController
@RequestMapping("/api/integration")
public class IntegrationController {

    private static final Logger LOG = LoggerFactory.getLogger(IntegrationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CommonService commonService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private PolicyService policyService;

//    @RequestMapping(value = "/candidate", method = RequestMethod.POST)
//    public ResponseEntity<String> test(@RequestBody CandidatePayload payload) {
//        LOG.info("candidate: " + payload);
//        return new ResponseEntity<String>("success", HttpStatus.OK);
//    }

    // ====================================================================================================
    // COHORT
    // ====================================================================================================

    @RequestMapping(value = "/cohortCode", method = RequestMethod.POST)
    public ResponseEntity<String> saveCohortCode() {
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @RequestMapping(value = "/programCode", method = RequestMethod.POST)
    public ResponseEntity<String> saveprogramCode() {
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @RequestMapping(value = "/facultyCode", method = RequestMethod.POST)
    public ResponseEntity<String> savefacultyCode() {
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
}
