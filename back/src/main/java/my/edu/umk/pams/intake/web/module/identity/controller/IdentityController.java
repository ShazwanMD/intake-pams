package my.edu.umk.pams.intake.web.module.identity.controller;

import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.system.service.SystemService;
import my.edu.umk.pams.intake.web.module.identity.vo.Actor;
import my.edu.umk.pams.intake.web.module.identity.vo.Applicant;
import my.edu.umk.pams.intake.web.module.identity.vo.Staff;
import my.edu.umk.pams.intake.workflow.service.WorkflowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author PAMS
 */
@RestController
@Transactional
@RequestMapping("/api/identity")
public class IdentityController {

    private static final Logger LOG = LoggerFactory.getLogger(IdentityController.class);

    @Autowired
    private IdentityService identityService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private SystemService systemService;

    @Autowired
    private IdentityTransformer identityTransformer;

    @Autowired
    AuthenticationManager authenticationManager;

    // ==================================================================================================== //
    // STAFF
    // ==================================================================================================== //

    @RequestMapping(value = "/actors", method = RequestMethod.GET)
    public ResponseEntity<List<Actor>> findActors() {
        return new ResponseEntity<List<Actor>>(identityTransformer
                .toActorVos(identityService.findActors(0, 100)), HttpStatus.OK);
    }
    
    // ==================================================================================================== //
    // STAFF
    // ==================================================================================================== //

    @RequestMapping(value = "/staffs", method = RequestMethod.GET)
    public ResponseEntity<List<Staff>> findStaffs() {
        return new ResponseEntity<List<Staff>>(identityTransformer
                .toStaffVos(identityService.findStaffs(0, 100)), HttpStatus.OK);
    }

    @RequestMapping(value = "/staffs/{identityNo}", method = RequestMethod.GET)
    public ResponseEntity<Staff> findStaffByIdentityNo(@PathVariable String identityNo) {
        return new ResponseEntity<Staff>(identityTransformer
                .toStaffVo(identityService.findStaffByStaffNo(identityNo)), HttpStatus.OK);
    }
    // ==================================================================================================== //
    // APPLICANT
    // ==================================================================================================== //

    @RequestMapping(value = "/applicants", method = RequestMethod.GET)
    public ResponseEntity<List<Applicant>> findApplicants() {
        return new ResponseEntity<List<Applicant>>(identityTransformer
                .toApplicantVos(identityService.findApplicants(0, 100)), HttpStatus.OK);
    }

    @RequestMapping(value = "/applicants/{identityNo}", method = RequestMethod.GET)
    public ResponseEntity<Applicant> findApplicantByIdentityNo(@PathVariable String identityNo) {
        return new ResponseEntity<Applicant>(identityTransformer
                .toApplicantVo(identityService.findApplicantByApplicantNo(identityNo)), HttpStatus.OK);
    }
}
