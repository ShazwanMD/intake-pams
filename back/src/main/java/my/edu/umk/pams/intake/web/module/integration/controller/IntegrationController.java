package my.edu.umk.pams.intake.web.module.integration.controller;

import java.util.List;

import org.jfree.util.Log;
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
import my.edu.umk.pams.intake.common.model.InSupervisorCode;
import my.edu.umk.pams.intake.common.model.InSupervisorCodeImpl;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.dao.RecursiveGroupException;
import my.edu.umk.pams.intake.identity.model.InActorType;
import my.edu.umk.pams.intake.identity.model.InGroup;
import my.edu.umk.pams.intake.identity.model.InGroupMember;
import my.edu.umk.pams.intake.identity.model.InGroupMemberImpl;
import my.edu.umk.pams.intake.identity.model.InPrincipal;
import my.edu.umk.pams.intake.identity.model.InPrincipalRole;
import my.edu.umk.pams.intake.identity.model.InPrincipalRoleImpl;
import my.edu.umk.pams.intake.identity.model.InPrincipalType;
import my.edu.umk.pams.intake.identity.model.InRoleType;
import my.edu.umk.pams.intake.identity.model.InStaff;
import my.edu.umk.pams.intake.identity.model.InStaffImpl;
import my.edu.umk.pams.intake.identity.model.InStaffType;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.model.InUserImpl;
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
		if (payload.getFacultyCode().getCode().equals("A10")) {
			InGraduateCenter graduateCenter = commonService.findGraduateCenterByCode("MGSEB");
			programCode.setGraduateCenter(graduateCenter);
		} else {
			InGraduateCenter graduateCenter = commonService.findGraduateCenterByCode("CPS");
			programCode.setGraduateCenter(graduateCenter);
		}
		programCode.setProgramLevel(policyService.findProgramLevelByCode(payload.getProgramLevel().getCode()));
		commonService.saveProgramCode(programCode);

		logoutAsSystem(ctx);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@RequestMapping(value = "/facultyCodes", method = RequestMethod.POST)
	public ResponseEntity<String> saveFacultyCode(@RequestBody List<FacultyCodePayload> facultyCodePayload) {
		SecurityContext ctx = loginAsSystem();

		LOG.info("Start Receive Faculty");
		for (FacultyCodePayload payload : facultyCodePayload) {

			// check faculty existence
			if (commonService.isFacultyCodeExists(payload.getCode())) {

				LOG.info("DepartmentCode Already Exists");
				InFacultyCode faculty = commonService.findFacultyCodeByCode(payload.getCode());
				faculty.setCode(payload.getCode());
				faculty.setPrefix(payload.getPrefix()); // prefix
				faculty.setDescriptionMs(payload.getDescription());
				faculty.setDescriptionEn(payload.getDescription());
				commonService.updateFacultyCode(faculty);

			} else {
				LOG.info("DepartmentCode Not Exists");
				InFacultyCode faculty = new InFacultyCodeImpl();
				faculty.setCode(payload.getCode());
				faculty.setPrefix(payload.getCode()); // prefix
				faculty.setDescriptionMs(payload.getDescription());
				faculty.setDescriptionEn(payload.getDescription());
				commonService.saveFacultyCode(faculty);
			}
		}
		 LOG.info("Finish Receive Faculty");
		logoutAsSystem(ctx);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	// ====================================================================================================
	// STAFF BUKAN AKADEMIK AKTIF
	// ====================================================================================================
	@RequestMapping(value = "/staff/nonAcademicActive", method = RequestMethod.POST)
	public ResponseEntity<String> saveStaff(@RequestBody List<StaffPayload> staffPayload)
			throws RecursiveGroupException {
		SecurityContext ctx = loginAsSystem();

		LOG.info("Start Receive Staff From IMS");
		for (StaffPayload payload : staffPayload) {

			boolean staffReceive = identityService.isStaffNoExists(payload.getStaffId());

			if (staffReceive) {

				LOG.info("Staff already exists");
				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
				LOG.debug("Staff Name:{}", payload.getStaffName());
				// Find Staff
				InStaff staff = identityService.findStaffByStaffNo(payload.getStaffId());

				// Find Department Code
				if (commonService.isFacultyCodeExists(payload.getStaffDepartmentCode())) {

					LOG.debug("Has Faculty 1");
					InFacultyCode departmentCode = commonService
							.findFacultyCodeByCode(staff.getFacultyCode().getCode());
					LOG.debug("Has Faculty 2");
					// Find User
					InUser user = identityService.findUserByUsername(staff.getEmail());
					LOG.debug("Has Faculty 3");
					// Find Group
					InGroup group = identityService.findGroupByUser(user);
					LOG.debug("Has Faculty 4");

					if (departmentCode.equals(payload.getStaffDepartmentCode())
							&& identityService.isGroupExists(group.getName())) {

						InFacultyCode faculty = commonService.findFacultyCodeByCode(payload.getStaffDepartmentCode());

						InStaff staffUpdate = identityService.findStaffByStaffNo(payload.getStaffId());
						staffUpdate.setIdentityNo(payload.getStaffId());
						staffUpdate.setName(payload.getStaffName());
						staffUpdate.setActorType(InActorType.STAFF);
						staff.setStaffType(InStaffType.NON_ACADEMIC);
						staffUpdate.setPhone(payload.getStaffPhoneNo());
						staffUpdate.setFacultyCode(faculty);
						staffUpdate.setStaffCategory(payload.getStaffCategory());
						staffUpdate.setEmail(payload.getStaffEmail());
						identityService.updateStaff(staffUpdate);

					} else if ((!departmentCode.equals(payload.getStaffDepartmentCode()))) {

						InFacultyCode faculty = commonService.findFacultyCodeByCode(payload.getStaffDepartmentCode());

						InStaff staffUpdate = identityService.findStaffByStaffNo(payload.getStaffId());
						LOG.debug("staffUpdate:{}", staffUpdate.getIdentityNo());
						staffUpdate.setIdentityNo(payload.getStaffId());
						staffUpdate.setName(payload.getStaffName());
						staffUpdate.setActorType(InActorType.STAFF);
						staffUpdate.setStaffType(InStaffType.NON_ACADEMIC);
						staffUpdate.setPhone(payload.getStaffPhoneNo());
						staffUpdate.setFacultyCode(faculty);
						staffUpdate.setStaffCategory(payload.getStaffCategory());
						staffUpdate.setEmail(payload.getStaffEmail());

						LOG.debug("payloadEmail:{}", payload.getStaffEmail());
						InUser updateUser = identityService.findUserByUsername(payload.getStaffEmail());
						LOG.debug("updateUser:{}", updateUser);
						updateUser.setActor(staffUpdate);
						updateUser.setEmail(payload.getStaffEmail());
						updateUser.setUsername(payload.getStaffEmail());
						updateUser.setPassword(payload.getStaffId());
						updateUser.setRealName(payload.getStaffName());
						updateUser.setName(payload.getStaffEmail());
						updateUser.setEnabled(true);
						updateUser.setLocked(true);
						updateUser.setPrincipalType(InPrincipalType.USER);
						identityService.saveUser(updateUser);

						InPrincipal principal = identityService.findPrincipalByName(payload.getStaffEmail());

						// Check Group Existence
						if (identityService.isGroupExists(group.getName())) {

							// setting roles of MGSEB
							if (payload.getStaffDepartmentCode().equals("A10")) {

								if (payload.getStaffCategory().equals("A")) {

									// Principal Role
									InPrincipalRole roleA10 = new InPrincipalRoleImpl();
									roleA10.setPrincipal(principal);
									roleA10.setRole(InRoleType.ROLE_ADMINISTRATOR);
									identityService.addPrincipalRole(principal, roleA10);

									try {
										// Group
										InGroup groupPegawaiA10 = identityService.findGroupByName("GRP_PGW_ADM_A10");
										// GroupMember
										if (!identityService.isGroupExists(groupPegawaiA10.getName())) {

											identityService.addGroupMember(groupPegawaiA10, principal);
										}

									} catch (RecursiveGroupException e) {

										e.printStackTrace();
									}

								} else {

									// Principal Role
									InPrincipalRole roleKRNA10 = new InPrincipalRoleImpl();
									roleKRNA10.setPrincipal(principal);
									roleKRNA10.setRole(InRoleType.ROLE_ADMINISTRATOR);
									identityService.addPrincipalRole(principal, roleKRNA10);

									try {
										// Group
										InGroup groupKRNA10 = identityService.findGroupByName("GRP_KRN_ADM_A10");
										// GroupMember
										if (!identityService.isGroupExists(groupKRNA10.getName())) {

											identityService.addGroupMember(groupKRNA10, principal);
										}

									} catch (RecursiveGroupException e) {

										e.printStackTrace();
									}

								}
							}
							// Setting roles of CPS
							else if (payload.getStaffDepartmentCode().equals("A09")) {

								if (payload.getStaffCategory().equals("A")) {

									// Principal Role
									InPrincipalRole roleA09 = new InPrincipalRoleImpl();
									roleA09.setPrincipal(principal);
									roleA09.setRole(InRoleType.ROLE_ADMINISTRATOR);
									identityService.addPrincipalRole(principal, roleA09);

									try {
										// Group
										InGroup groupPegawaiA09 = identityService.findGroupByName("GRP_PGW_ADM_A09");
										// GroupMember
										if (!identityService.isGroupExists(groupPegawaiA09.getName())) {

											identityService.addGroupMember(groupPegawaiA09, principal);
										}
									} catch (RecursiveGroupException e) {

										e.printStackTrace();
									}

								} else {

									// Principal Role
									InPrincipalRole roleKRNA09 = new InPrincipalRoleImpl();
									roleKRNA09.setPrincipal(principal);
									roleKRNA09.setRole(InRoleType.ROLE_ADMINISTRATOR);
									identityService.addPrincipalRole(principal, roleKRNA09);

									try {
										// Group
										InGroup groupKRNA09 = identityService.findGroupByName("GRP_KRN_ADM_A09");
										// GroupMember
										if (!identityService.isGroupExists(groupKRNA09.getName())) {

											identityService.addGroupMember(groupKRNA09, principal);
										}

									} catch (RecursiveGroupException e) {

										e.printStackTrace();
									}

								}
							}
							// Setting roles of Others Faculty
							else {
								if (payload.getStaffCategory().equals("A")) {
									LOG.info("If All Faculty and Category A Only");

									// Principal Role
									InPrincipalRole roleAllFac = new InPrincipalRoleImpl();
									roleAllFac.setPrincipal(principal);
									roleAllFac.setRole(InRoleType.ROLE_FCTY);
									identityService.addPrincipalRole(principal, roleAllFac);
									LOG.debug("roleAllFac:{}", roleAllFac);
									try {
										// Group
										InGroup groupAllFac = identityService
												.findGroupByName("GRP_PGW_FCTY_" + payload.getStaffDepartmentCode());
										LOG.debug("Group:{}", groupAllFac);
										// GroupMember
										if (!identityService.isGroupExists(groupAllFac.getName())) {

											identityService.addGroupMember(groupAllFac, principal);
										}
									} catch (RecursiveGroupException e) {

										e.printStackTrace();
									}
								} else {
									LOG.info("If All Faculty Only");

									// Principal Role
									InPrincipalRole roleAllFaculty = new InPrincipalRoleImpl();
									roleAllFaculty.setPrincipal(principal);
									roleAllFaculty.setRole(InRoleType.ROLE_FCTY);
									identityService.addPrincipalRole(principal, roleAllFaculty);

									try {
										// Group
										InGroup groupAllFaculty = identityService
												.findGroupByName("GRP_KRN_FCTY_" + payload.getStaffDepartmentCode());
										LOG.debug("Group:{}", groupAllFaculty);
										// GroupMember
										if (!identityService.isGroupExists(groupAllFaculty.getName())) {

											identityService.addGroupMember(groupAllFaculty, principal);
										}

									} catch (RecursiveGroupException e) {

										e.printStackTrace();
									}
								}
							}
						}

						identityService.updateStaff(staffUpdate);
					}

				} else {

					LOG.debug("NoFaculty");

					InStaff staffUpdate = identityService.findStaffByStaffNo(payload.getStaffId());
					staffUpdate.setIdentityNo(payload.getStaffId());
					staffUpdate.setName(payload.getStaffName());
					staffUpdate.setActorType(InActorType.STAFF);
					staffUpdate.setStaffType(InStaffType.NON_ACADEMIC);
					staffUpdate.setPhone(payload.getStaffPhoneNo());
					staffUpdate.setStaffCategory(payload.getStaffCategory());
					staffUpdate.setEmail(payload.getStaffEmail());
					identityService.updateStaff(staffUpdate);
				}

			} else {

				LOG.info("Staff not exists");
				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
				LOG.debug("Staff Name:{}", payload.getStaffName());
				LOG.debug("Staff Department_Code:{}", payload.getStaffDepartmentCode());
				LOG.debug("Staff Category:{}", payload.getStaffCategory());

				String facultyCode = payload.getStaffDepartmentCode();
				InFacultyCode faculty = commonService.findFacultyCodeByCode(facultyCode);

				InStaff staff = new InStaffImpl();
				staff.setIdentityNo(payload.getStaffId());
				staff.setStaffType(InStaffType.NON_ACADEMIC);
				staff.setName(payload.getStaffName());
				staff.setActorType(InActorType.STAFF);
				staff.setPhone(payload.getStaffPhoneNo());
				staff.setFacultyCode(faculty);
				staff.setStaffCategory(payload.getStaffCategory());
				staff.setEmail(payload.getStaffEmail());
				if (commonService.isFacultyCodeExists(payload.getStaffDepartmentCode())) {
					LOG.info("if faculty exists");
					identityService.saveStaffIMSNonAcademicActive(staff);

				} else {
					LOG.info("if faculty not exists");
					identityService.saveStaff(staff);

				}
			}
		}
		LOG.info("Finish Receive Staff From IMS");

		logoutAsSystem(ctx);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	// ====================================================================================================
	// STAFF BUKAN AKADEMIK TIDAK AKTIF
	// ====================================================================================================
	
	@RequestMapping(value = "/staff/nonAcademicInActive", method = RequestMethod.POST)
	public ResponseEntity<String> saveStaffInActive(@RequestBody List<StaffPayload> staffPayload)
			throws RecursiveGroupException {
		SecurityContext ctx = loginAsSystem();

		LOG.info("Start Receive Staff From IMS");
		for (StaffPayload payload : staffPayload) {

			boolean staffReceive = identityService.isStaffNoExists(payload.getStaffId());

			if (staffReceive) {

				LOG.info("Staff already exists");
				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
				LOG.debug("Staff Name:{}", payload.getStaffName());
				// Find Staff
				InStaff staff = identityService.findStaffByStaffNo(payload.getStaffId());

				// Find Department Code
				if (commonService.isFacultyCodeExists(payload.getStaffDepartmentCode())) {

					LOG.debug("Has Faculty 1");
					InFacultyCode departmentCode = commonService
							.findFacultyCodeByCode(staff.getFacultyCode().getCode());
					LOG.debug("Has Faculty 2");
					// Find User
					InUser user = identityService.findUserByUsername(staff.getEmail());
					LOG.debug("Has Faculty 3");
					// Find Group
					InGroup group = identityService.findGroupByUser(user);
					LOG.debug("Has Faculty 4");

					if (departmentCode.equals(payload.getStaffDepartmentCode())
							&& identityService.isGroupExists(group.getName())) {

						InFacultyCode faculty = commonService.findFacultyCodeByCode(payload.getStaffDepartmentCode());

						InStaff staffUpdate = identityService.findStaffByStaffNo(payload.getStaffId());
						staffUpdate.setIdentityNo(payload.getStaffId());
						staffUpdate.setName(payload.getStaffName());
						staffUpdate.setActorType(InActorType.STAFF);
						staff.setStaffType(InStaffType.NON_ACADEMIC);
						staffUpdate.setPhone(payload.getStaffPhoneNo());
						staffUpdate.setFacultyCode(faculty);
						staffUpdate.setStaffCategory(payload.getStaffCategory());
						staffUpdate.setEmail(payload.getStaffEmail());
						identityService.updateStaff(staffUpdate);

					} else if ((!departmentCode.equals(payload.getStaffDepartmentCode()))) {

						InFacultyCode faculty = commonService.findFacultyCodeByCode(payload.getStaffDepartmentCode());

						InStaff staffUpdate = identityService.findStaffByStaffNo(payload.getStaffId());
						LOG.debug("staffUpdate:{}", staffUpdate.getIdentityNo());
						staffUpdate.setIdentityNo(payload.getStaffId());
						staffUpdate.setName(payload.getStaffName());
						staffUpdate.setActorType(InActorType.STAFF);
						staffUpdate.setStaffType(InStaffType.NON_ACADEMIC);
						staffUpdate.setPhone(payload.getStaffPhoneNo());
						staffUpdate.setFacultyCode(faculty);
						staffUpdate.setStaffCategory(payload.getStaffCategory());
						staffUpdate.setEmail(payload.getStaffEmail());

						LOG.debug("payloadEmail:{}", payload.getStaffEmail());
						InUser updateUser = identityService.findUserByUsername(payload.getStaffEmail());
						LOG.debug("updateUser:{}", updateUser);
						updateUser.setActor(staffUpdate);
						updateUser.setEmail(payload.getStaffEmail());
						updateUser.setUsername(payload.getStaffEmail());
						updateUser.setPassword(payload.getStaffId());
						updateUser.setRealName(payload.getStaffName());
						updateUser.setName(payload.getStaffEmail());
						updateUser.setEnabled(false);
						updateUser.setLocked(true);
						updateUser.setPrincipalType(InPrincipalType.USER);
						identityService.saveUser(updateUser);

						InPrincipal principal = identityService.findPrincipalByName(payload.getStaffEmail());

						// Check Group Existence
						if (identityService.isGroupExists(group.getName())) {

							// setting roles of MGSEB
							if (payload.getStaffDepartmentCode().equals("A10")) {

								if (payload.getStaffCategory().equals("A")) {

									// Principal Role
									InPrincipalRole roleA10 = new InPrincipalRoleImpl();
									roleA10.setPrincipal(principal);
									roleA10.setRole(InRoleType.ROLE_ADMINISTRATOR);
									identityService.addPrincipalRole(principal, roleA10);

									try {
										// Group
										InGroup groupPegawaiA10 = identityService.findGroupByName("GRP_PGW_ADM_A10");
										// GroupMember
										if (!identityService.isGroupExists(groupPegawaiA10.getName())) {

											identityService.addGroupMember(groupPegawaiA10, principal);
										}

									} catch (RecursiveGroupException e) {

										e.printStackTrace();
									}

								} else {

									// Principal Role
									InPrincipalRole roleKRNA10 = new InPrincipalRoleImpl();
									roleKRNA10.setPrincipal(principal);
									roleKRNA10.setRole(InRoleType.ROLE_ADMINISTRATOR);
									identityService.addPrincipalRole(principal, roleKRNA10);

									try {
										// Group
										InGroup groupKRNA10 = identityService.findGroupByName("GRP_KRN_ADM_A10");
										// GroupMember
										if (!identityService.isGroupExists(groupKRNA10.getName())) {

											identityService.addGroupMember(groupKRNA10, principal);
										}

									} catch (RecursiveGroupException e) {

										e.printStackTrace();
									}

								}
							}
							// Setting roles of CPS
							else if (payload.getStaffDepartmentCode().equals("A09")) {

								if (payload.getStaffCategory().equals("A")) {

									// Principal Role
									InPrincipalRole roleA09 = new InPrincipalRoleImpl();
									roleA09.setPrincipal(principal);
									roleA09.setRole(InRoleType.ROLE_ADMINISTRATOR);
									identityService.addPrincipalRole(principal, roleA09);

									try {
										// Group
										InGroup groupPegawaiA09 = identityService.findGroupByName("GRP_PGW_ADM_A09");
										// GroupMember
										if (!identityService.isGroupExists(groupPegawaiA09.getName())) {

											identityService.addGroupMember(groupPegawaiA09, principal);
										}
									} catch (RecursiveGroupException e) {

										e.printStackTrace();
									}

								} else {

									// Principal Role
									InPrincipalRole roleKRNA09 = new InPrincipalRoleImpl();
									roleKRNA09.setPrincipal(principal);
									roleKRNA09.setRole(InRoleType.ROLE_ADMINISTRATOR);
									identityService.addPrincipalRole(principal, roleKRNA09);

									try {
										// Group
										InGroup groupKRNA09 = identityService.findGroupByName("GRP_KRN_ADM_A09");
										// GroupMember
										if (!identityService.isGroupExists(groupKRNA09.getName())) {

											identityService.addGroupMember(groupKRNA09, principal);
										}

									} catch (RecursiveGroupException e) {

										e.printStackTrace();
									}

								}
							}
							// Setting roles of Others Faculty
							else {
								if (payload.getStaffCategory().equals("A")) {
									LOG.info("If All Faculty and Category A Only");

									// Principal Role
									InPrincipalRole roleAllFac = new InPrincipalRoleImpl();
									roleAllFac.setPrincipal(principal);
									roleAllFac.setRole(InRoleType.ROLE_FCTY);
									identityService.addPrincipalRole(principal, roleAllFac);
									LOG.debug("roleAllFac:{}", roleAllFac);
									try {
										// Group
										InGroup groupAllFac = identityService
												.findGroupByName("GRP_PGW_FCTY_" + payload.getStaffDepartmentCode());
										LOG.debug("Group:{}", groupAllFac);
										// GroupMember
										if (!identityService.isGroupExists(groupAllFac.getName())) {

											identityService.addGroupMember(groupAllFac, principal);
										}
									} catch (RecursiveGroupException e) {

										e.printStackTrace();
									}
								} else {
									LOG.info("If All Faculty Only");

									// Principal Role
									InPrincipalRole roleAllFaculty = new InPrincipalRoleImpl();
									roleAllFaculty.setPrincipal(principal);
									roleAllFaculty.setRole(InRoleType.ROLE_FCTY);
									identityService.addPrincipalRole(principal, roleAllFaculty);

									try {
										// Group
										InGroup groupAllFaculty = identityService
												.findGroupByName("GRP_KRN_FCTY_" + payload.getStaffDepartmentCode());
										LOG.debug("Group:{}", groupAllFaculty);
										// GroupMember
										if (!identityService.isGroupExists(groupAllFaculty.getName())) {

											identityService.addGroupMember(groupAllFaculty, principal);
										}

									} catch (RecursiveGroupException e) {

										e.printStackTrace();
									}
								}
							}
						}

						identityService.updateStaff(staffUpdate);
					}

				} else {

					LOG.debug("NoFaculty");

					InStaff staffUpdate = identityService.findStaffByStaffNo(payload.getStaffId());
					staffUpdate.setIdentityNo(payload.getStaffId());
					staffUpdate.setName(payload.getStaffName());
					staffUpdate.setActorType(InActorType.STAFF);
					staffUpdate.setStaffType(InStaffType.NON_ACADEMIC);
					staffUpdate.setPhone(payload.getStaffPhoneNo());
					staffUpdate.setStaffCategory(payload.getStaffCategory());
					staffUpdate.setEmail(payload.getStaffEmail());
					identityService.updateStaff(staffUpdate);
				}

			} else {

				LOG.info("Staff not exists");
				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
				LOG.debug("Staff Name:{}", payload.getStaffName());
				LOG.debug("Staff Department_Code:{}", payload.getStaffDepartmentCode());
				LOG.debug("Staff Category:{}", payload.getStaffCategory());

				String facultyCode = payload.getStaffDepartmentCode();
				InFacultyCode faculty = commonService.findFacultyCodeByCode(facultyCode);

				InStaff staff = new InStaffImpl();
				staff.setIdentityNo(payload.getStaffId());
				staff.setStaffType(InStaffType.NON_ACADEMIC);
				staff.setName(payload.getStaffName());
				staff.setActorType(InActorType.STAFF);
				staff.setPhone(payload.getStaffPhoneNo());
				staff.setFacultyCode(faculty);
				staff.setStaffCategory(payload.getStaffCategory());
				staff.setEmail(payload.getStaffEmail());
				if (commonService.isFacultyCodeExists(payload.getStaffDepartmentCode())) {
					LOG.info("if faculty exists");
					identityService.saveStaffIMSNonAcademicInActive(staff);

				} else {
					LOG.info("if faculty not exists");
					identityService.saveStaff(staff);

				}
			}
		}
		LOG.info("Finish Receive Staff From IMS");

		logoutAsSystem(ctx);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	// ====================================================================================================
	// ACADEMIK STAFF FROM IMS
	// ====================================================================================================

	@RequestMapping(value = "/staff/academicActive", method = RequestMethod.POST)
	public ResponseEntity<String> saveStaffAcademic(@RequestBody List<StaffPayload> staffPayload) {
		SecurityContext ctx = loginAsSystem();
		

		LOG.info("Start Receiving active Academic Staff From IMS");
		for (StaffPayload payload : staffPayload) {

			boolean supervisorExist = commonService.isSupervisorCodeExists(payload.getStaffId());
			
			if (supervisorExist) {
				
				LOG.info("Supervisor aready exists");
				LOG.debug("Supervisor Name:{}", payload.getStaffName());
				
				// Find Supervisor By Name
				InSupervisorCode supervisorUpdate = commonService.findSupervisorCodeByCode(payload.getStaffId());
				
				supervisorUpdate.setName(payload.getStaffName());
				supervisorUpdate.setCode(payload.getStaffId());
				supervisorUpdate.setDescriptionEn(payload.getStaffName());
				supervisorUpdate.setDescriptionMs(payload.getStaffName());
				commonService.updateSupervisorCode(supervisorUpdate);
				
			} else {
				LOG.info("Supervisor not exists");
				LOG.debug("Supervisor Name:{}", payload.getStaffName());
				
				//Adding staff info into supervisor code	
				InSupervisorCode supervisor = new InSupervisorCodeImpl();
				supervisor.setCode(payload.getStaffId());
				supervisor.setDescriptionEn(payload.getStaffName());
				supervisor.setDescriptionMs(payload.getStaffName());
				supervisor.setName(payload.getStaffName());
				commonService.saveSupervisorCode(supervisor);
				LOG.debug("supervisor :{}", supervisor);			
			}
		

		boolean staffReceive = identityService.isStaffNoExists(payload.getStaffId());
		
		if (staffReceive) {

			LOG.info("Staff already exists");
			LOG.debug("Staff Staff_No:{}", payload.getStaffId());
			LOG.debug("Staff Name:{}", payload.getStaffName());
			
	    // Find Staff By Identity No
		InStaff staffUpdate = identityService.findStaffByStaffNo(payload.getStaffId());	
		
		staffUpdate.setIdentityNo(payload.getStaffId());
		staffUpdate.setName(payload.getStaffName());
		staffUpdate.setActorType(InActorType.STAFF);
		staffUpdate.setStaffType(InStaffType.ACADEMIC);
		staffUpdate.setPhone(payload.getStaffPhoneNo());
		//does academic staff need faculty?	
	    //staffUpdate.setFaculty(faculty);
		staffUpdate.setEmail(payload.getStaffEmail());
		identityService.updateStaff(staffUpdate);
		
		} else {
		
			LOG.info("Staff not exists");
			LOG.debug("Staff Staff_No:{}", payload.getStaffId());
			LOG.debug("Staff Name:{}", payload.getStaffName());
			LOG.debug("Staff Department_Code:{}", payload.getStaffDepartmentCode());
			
		InStaff staff = new InStaffImpl();
		staff.setIdentityNo(payload.getStaffId());
		staff.setStaffType(InStaffType.ACADEMIC);
		staff.setName(payload.getStaffName());
		staff.setActorType(InActorType.STAFF);
		staff.setPhone(payload.getStaffPhoneNo());
		//does academic staff need faculty?	
	    //staff.setFaculty(faculty);
		staff.setEmail(payload.getStaffEmail());
		identityService.saveStaff(staff);
		
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
