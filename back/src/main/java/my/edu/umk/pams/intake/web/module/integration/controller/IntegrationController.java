package my.edu.umk.pams.intake.web.module.integration.controller;

import java.util.List;

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
import my.edu.umk.pams.connector.payload.StaffPayload;
import my.edu.umk.pams.intake.common.model.InFacultyCode;
import my.edu.umk.pams.intake.common.model.InFacultyCodeImpl;
import my.edu.umk.pams.intake.common.model.InGraduateCenter;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InProgramCodeImpl;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.dao.RecursiveGroupException;
import my.edu.umk.pams.intake.identity.model.InActorType;
import my.edu.umk.pams.intake.identity.model.InStaff;
import my.edu.umk.pams.intake.identity.model.InStaffImpl;
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
    
 // ====================================================================================================
 // STAFF
 // ====================================================================================================
 	@RequestMapping(value = "/staff/nonAcademicActive", method = RequestMethod.POST)
 	public ResponseEntity<String> saveStaff(@RequestBody List<StaffPayload> staffPayload)
 			throws RecursiveGroupException {
 		SecurityContext ctx = loginAsSystem();

 		LOG.info("Start Receive Staff From IMS");
 		for (StaffPayload payload : staffPayload) {

 			boolean staffReceive = identityService.isStaffNoExists(payload.getStaffId());
 			
 			if (staffReceive ) {
 				
 				LOG.info("Staff already exists");
 				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
 				LOG.debug("Staff Name:{}", payload.getStaffName());
 				
 				String facultyCode = payload.getStaffDepartmentCode();
 				InFacultyCode faculty = commonService.findFacultyCodeByCode(facultyCode);
 				
 				InStaff staff = identityService.findStaffByStaffNo(payload.getStaffId());
 				staff.setIdentityNo(payload.getStaffId());
 				staff.setName(payload.getStaffName());
 				staff.setActorType(InActorType.STAFF);
 				staff.setPhone(payload.getStaffPhoneNo());
 				staff.setFacultyCode(faculty);
 				staff.setStaffCategory(payload.getStaffCategory());
 				staff.setEmail(payload.getStaffEmail());
 				identityService.updateStaff(staff);

 			}else{
 				
 				
 				LOG.info("Staff not exists");
 				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
 				LOG.debug("Staff Name:{}", payload.getStaffName());
 				LOG.debug("Staff Department_Code:{}", payload.getStaffDepartmentCode());
 				LOG.debug("Staff Category:{}", payload.getStaffCategory());
 				
 				String facultyCode = payload.getStaffDepartmentCode();
 				InFacultyCode faculty = commonService.findFacultyCodeByCode(facultyCode);
 				
 				InStaff staff = new InStaffImpl();
 				staff.setIdentityNo(payload.getStaffId());
 				staff.setName(payload.getStaffName());
 				staff.setActorType(InActorType.STAFF);
 				staff.setPhone(payload.getStaffPhoneNo());
 				staff.setFacultyCode(faculty);
 				staff.setStaffCategory(payload.getStaffCategory());
 				staff.setEmail(payload.getStaffEmail());
 				if (commonService.isFacultyCodeExists(payload.getStaffDepartmentCode()))
 				{	
 					LOG.info("if faculty exists");
 					identityService.saveStaffIMSNonAcademicActive(staff);
 				
 				}
 				else
 				{
 					LOG.info("if faculty not exists");
 					identityService.saveStaff(staff);
 				
 				}
 			}
 		}
 		LOG.info("Finish Receive Staff From IMS");

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
