package my.edu.umk.pams.intake.web.module.integration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.edu.umk.pams.connector.payload.FacultyCodePayload;
import my.edu.umk.pams.connector.payload.ProgramCodePayload;
import my.edu.umk.pams.intake.common.model.InFacultyCode;
import my.edu.umk.pams.intake.common.model.InFacultyCodeImpl;
import my.edu.umk.pams.intake.common.model.InGraduateCenter;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InProgramCodeImpl;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.integration.InAutoLoginToken;
import my.edu.umk.pams.intake.security.integration.NonSerializableSecurityContext;

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

    // ====================================================================================================
    // CODES
    // ====================================================================================================

    @RequestMapping(value = "/programCodes", method = RequestMethod.POST)
    public ResponseEntity<String> saveProgramCode(@RequestBody ProgramCodePayload payload) {
        SecurityContext ctx = loginAsSystem();

        InProgramCode programCode = new InProgramCodeImpl();
        programCode.setCode(payload.getCode());
        programCode.setDescriptionEn(payload.getDescriptionEn());
        programCode.setDescriptionMs(payload.getDescriptionMs());
        programCode.setFacultyCode(commonService.findFacultyCodeByCode(payload.getFacultyCode().getCode()));
        if (payload.getFacultyCode().getCode().equals("A10")){
        	InGraduateCenter graduateCenter = commonService.findGraduateCenterByCode("MGSEB");
        programCode.setGraduateCenter(graduateCenter);
        }else{
        	InGraduateCenter graduateCenter = commonService.findGraduateCenterByCode("CPS");
        programCode.setGraduateCenter(graduateCenter);   
        }
        programCode.setProgramLevel(policyService.findProgramLevelByCode(payload.getProgramLevel().getCode()));
        commonService.saveProgramCode(programCode);

        logoutAsSystem(ctx);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @RequestMapping(value = "/facultyCodes", method = RequestMethod.POST)
    public ResponseEntity<String> saveFacultyCode(@RequestBody FacultyCodePayload payload) {
        SecurityContext ctx = loginAsSystem();

        InFacultyCode facultyCode = new InFacultyCodeImpl();
        facultyCode.setCode(payload.getCode());
        facultyCode.setPrefix(payload.getCode()); // prefix
        facultyCode.setDescriptionEn(payload.getDescription());
        facultyCode.setDescriptionMs(payload.getDescription());
        commonService.saveFacultyCode(facultyCode);

        logoutAsSystem(ctx);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    private SecurityContext loginAsSystem() {
        SecurityContext savedCtx = SecurityContextHolder.getContext();
        InAutoLoginToken authenticationToken = new InAutoLoginToken("system");
        Authentication authed = authenticationManager.authenticate(authenticationToken);
        SecurityContext system = new NonSerializableSecurityContext();
        system.setAuthentication(authed);
        SecurityContextHolder.setContext(system);
        return savedCtx;
    }

    private void logoutAsSystem(SecurityContext context) {
        SecurityContextHolder.setContext(context);
    }
}
