package my.edu.umk.pams.intake.web.module.application.controller;

import my.edu.umk.pams.intake.application.model.*;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.core.InFlowState;
import my.edu.umk.pams.intake.identity.model.InActor;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.model.InStudyModeOffering;
import my.edu.umk.pams.intake.policy.model.InSupervisorOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.integration.InAutoLoginToken;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.web.module.application.vo.*;
import my.edu.umk.pams.intake.web.module.policy.controller.PolicyTransformer;
import my.edu.umk.pams.intake.web.module.policy.vo.Intake;
import my.edu.umk.pams.intake.web.module.policy.vo.ProgramOffering;
import my.edu.umk.pams.intake.web.module.policy.vo.StudyModeOffering;
import my.edu.umk.pams.intake.web.module.policy.vo.SupervisorOffering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private PolicyTransformer policyTransformer;

    @Autowired
    private ApplicationTransformer applicationTransformer;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private AuthenticationManager authenticationManager;

    // ====================================================================================================
    // INTAKE
    // ====================================================================================================

    @RequestMapping(value = "/intakes", method = RequestMethod.GET)
    public ResponseEntity<List<Intake>> findIntakes() {
        List<InIntake> intakes = policyService.findIntakes();
        return new ResponseEntity<List<Intake>>(policyTransformer.toIntakeVos(intakes), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/state/{state}", method = RequestMethod.GET)
    public ResponseEntity<List<Intake>> findIntakesByState(@PathVariable String state) {
        List<InIntake> intakes = policyService.findIntakesByFlowState(InFlowState.valueOf(state));
        return new ResponseEntity<List<Intake>>(policyTransformer.toIntakeVos(intakes), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}", method = RequestMethod.GET)
    public ResponseEntity<Intake> findIntakeByReferenceNo(@PathVariable String referenceNo) {
        InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
        return new ResponseEntity<Intake>(policyTransformer.toIntakeVo(intake), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/apply", method = RequestMethod.POST)
    public ResponseEntity<IntakeApplication> applyIntake(@PathVariable String referenceNo) {
        dummyLogin();

        // user & applicant
        InUser currentUser = securityService.getCurrentUser();
        InActor actor = currentUser.getActor();
        InApplicant applicant = identityService.findApplicantById(actor.getId());
        if (actor instanceof InApplicant)
            applicant = (InApplicant) actor;

        InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
        InIntakeApplication application = new InIntakeApplicationImpl();
        application.setName(applicant.getName());
        application.setEmail(applicant.getEmail());
        application.setApplicant(applicant);

        String intakeApplicationReferenceNo = applicationService.applyIntake(intake, application);
        LOG.debug("application referenceNo: " + intakeApplicationReferenceNo);
        InIntakeApplication generatedApplication = applicationService
                .findIntakeApplicationByReferenceNo(intakeApplicationReferenceNo);
        return new ResponseEntity<IntakeApplication>(applicationTransformer.toIntakeApplicationVo(generatedApplication),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/intakeApplications", method = RequestMethod.POST)
    public ResponseEntity<List<IntakeApplication>> findIntakeApplicationsByIntake(@PathVariable String referenceNo) {
        dummyLogin();

        InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
        List<InIntakeApplication> applications = applicationService.findIntakeApplications(intake);
        return new ResponseEntity<List<IntakeApplication>>(applicationTransformer.toIntakeApplicationVos(applications),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/programOfferings", method = RequestMethod.GET)
    public ResponseEntity<List<ProgramOffering>> findProgramOfferings(@PathVariable String referenceNo) {
        dummyLogin();

        InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
        List<InProgramOffering> programOfferings = policyService.findProgramOfferings(intake);
        return new ResponseEntity<List<ProgramOffering>>(policyTransformer.toProgramOfferingVos(programOfferings),
                HttpStatus.OK);
    }


    @RequestMapping(value = "/intakes/{referenceNo}/supervisorOfferings", method = RequestMethod.GET)
    public ResponseEntity<List<SupervisorOffering>> findSupervisorOfferings(@PathVariable String referenceNo) {
        dummyLogin();

        InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
        List<InSupervisorOffering> supervisorOfferings = policyService.findSupervisorOfferings(intake);
        return new ResponseEntity<List<SupervisorOffering>>(policyTransformer.toSupervisorOfferingVos(supervisorOfferings),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/studyModeOfferings", method = RequestMethod.GET)
    public ResponseEntity<List<StudyModeOffering>> findStudyModeOfferings(@PathVariable String referenceNo) {
        dummyLogin();

        InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
        List<InStudyModeOffering> studyModeOfferings = policyService.findStudyModeOfferings(intake);
        return new ResponseEntity<List<StudyModeOffering>>(policyTransformer.toStudyModeOfferingVos(studyModeOfferings),
                HttpStatus.OK);
    }

    // ====================================================================================================
    // INTAKE APPLICATION
    // ====================================================================================================

    @RequestMapping(value = "/intakeApplications", method = RequestMethod.GET)
    public ResponseEntity<List<IntakeApplication>> findIntakeApplications() {
        dummyLogin();

        // user & applicant
        InUser currentUser = securityService.getCurrentUser();
        InActor actor = currentUser.getActor();
        InApplicant applicant = identityService.findApplicantById(actor.getId());
        if (actor instanceof InApplicant)
            applicant = (InApplicant) actor;
        List<InIntakeApplication> applications = applicationService.findIntakeApplications(applicant);
        List<IntakeApplication> applicationVos = applicationTransformer.toIntakeApplicationVos(applications);
        return new ResponseEntity<List<IntakeApplication>>(applicationVos, HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplication/{referenceNo}", method = RequestMethod.GET)
    public ResponseEntity<IntakeApplication> findIntakeApplicationByReferenceNo(@PathVariable String referenceNo) {
        InIntakeApplication intakeApplication = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        return new ResponseEntity<IntakeApplication>(applicationTransformer.toIntakeApplicationVo(intakeApplication),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateIntakeApplication(@PathVariable String referenceNo,
                                                          @RequestBody IntakeApplication vo) {
        dummyLogin();

        // todo: more properties
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        application.setResearchTitle(vo.getResearchTitle());
        application.setName(vo.getName());
        application.setPhone(vo.getPhone());
        application.setMobile(vo.getMobile());
        application.setFax(vo.getFax());
        application.setEmail(vo.getEmail());
        application.setAge(vo.getAge());

        application.setCredentialNo(vo.getCredentialNo());
        application.setBirthDate(vo.getBirthDate());
        application.setSelfSponsored(vo.getSelfSponsored());
        application.setSponsored(vo.getSponsored());

        applicationService.updateIntakeApplication(application);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/submit", method = RequestMethod.POST)
    public ResponseEntity<String> submitIntakeApplication(@PathVariable String referenceNo,
                                                          @RequestBody IntakeApplication vo) {
        dummyLogin();

        // update and submit
        InIntakeApplication application = applicationService.findIntakeApplicationById(vo.getId());
        InIntake intake = application.getIntake();
        updateIntakeApplication(referenceNo, vo);
        applicationService.submitIntakeApplication(intake, application);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/programOfferingSelection", method = RequestMethod.POST)
    public ResponseEntity<String> submitIntakeApplication(@PathVariable String referenceNo,
                                                          @RequestBody ProgramOffering vo) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InProgramOffering programOffering = policyService.findProgramOfferingById(vo.getId());
        application.setProgramSelection(programOffering);
        applicationService.updateIntakeApplication(application);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/studyModeOfferingSelection", method = RequestMethod.POST)
    public ResponseEntity<String> submitIntakeApplication(@PathVariable String referenceNo,
                                                          @RequestBody StudyModeOffering vo) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InStudyModeOffering studyModeOffering = policyService.findStudyModeOfferingById(vo.getId());
        application.setStudyModeSelection(studyModeOffering);
        applicationService.updateIntakeApplication(application);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/supervisorOfferingSelection", method = RequestMethod.POST)
    public ResponseEntity<String> submitIntakeApplication(@PathVariable String referenceNo,
                                                          @RequestBody SupervisorOffering vo) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InSupervisorOffering supervisorOffering = policyService.findSupervisorOfferingById(vo.getId());
        application.setSupervisorSelection(supervisorOffering);
        applicationService.updateIntakeApplication(application);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    // ====================================================================================================
    // EMPLOYMENTS
    // ====================================================================================================

    @RequestMapping(value = "/intakeApplications/{referenceNo}/employments", method = RequestMethod.GET)
    public ResponseEntity<List<Employment>> findEmploymentsByIntakeApplication(@PathVariable String referenceNo) {
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        List<InEmployment> employments = applicationService.findEmployments(application);
        return new ResponseEntity<List<Employment>>(applicationTransformer.toEmploymentVos(employments), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/employments", method = RequestMethod.POST)
    public ResponseEntity<String> addEmployment(@PathVariable String referenceNo, @RequestBody Employment vo) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InEmployment employment = new InEmploymentImpl();
        employment.setEmployer(vo.getEmployer());
        employment.setDesignation(vo.getDesignation());
        employment.setStartDate(vo.getStartDate());
        employment.setEndDate(vo.getEndDate());
        // employment.setFieldCode(commonService.findEmploymentFieldCodeById(vo.getFieldCode().getId()));
        // employment.setLevelCode(commonService.findEmploymentLevelCodeById(vo.getLevelCode().getId()));
        // employment.setSectorCode(commonService.findEmploymentSectorCodeById(vo.getSectorCode().getId()));
        employment.setCurrent(false);
        applicationService.addEmployment(application, employment);

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/employments/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteEmployment(@PathVariable String referenceNo, @PathVariable Long id) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InEmployment employment = (InEmployment) applicationService.findEmploymentById(id);
        applicationService.deleteEmployment(application, employment);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/intakeApplications/{referenceNo}/employments/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateEmployment(@PathVariable String referenceNo, @PathVariable Long id, @RequestBody Employment vo) {
        dummyLogin();
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InEmployment employment = (InEmployment) applicationService.findEmploymentById(id);
        employment.setEmployer(vo.getEmployer());
        employment.setDesignation(vo.getDesignation());
        employment.setStartDate(vo.getStartDate());
        employment.setEndDate(vo.getEndDate());
        // employment.setFieldCode(commonService.findEmploymentFieldCodeById(vo.getFieldCode().getId()));
        // employment.setLevelCode(commonService.findEmploymentLevelCodeById(vo.getLevelCode().getId()));
        // employment.setSectorCode(commonService.findEmploymentSectorCodeById(vo.getSectorCode().getId()));
        employment.setCurrent(false);
        applicationService.updateEmployment(application, employment);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    // ====================================================================================================
    // LANGUAGES
    // ====================================================================================================

    @RequestMapping(value = "/intakeApplications/{referenceNo}/languages", method = RequestMethod.GET)
    public ResponseEntity<List<Language>> findLanguagesByIntakeApplication(@PathVariable String referenceNo) {
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        List<InLanguage> languages = applicationService.findLanguages(application);
        return new ResponseEntity<List<Language>>(applicationTransformer.toLanguageVos(languages), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/languages", method = RequestMethod.POST)
    public ResponseEntity<String> addLanguage(@PathVariable String referenceNo, @RequestBody Language vo) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InLanguage language = new InLanguageImpl();
        language.setOral(vo.getOral());
        language.setWritten(vo.getWritten());
        language.setLanguageCode(commonService.findLanguageCodeById(vo.getLanguageCode().getId()));
        applicationService.addLanguage(application, language);

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/intakeApplications/{referenceNo}/languages/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateLanguage(@PathVariable String referenceNo, @PathVariable Long id, @RequestBody Language vo) {
        dummyLogin();
        
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InLanguage language = (InLanguage) applicationService.findLanguageById(id);
        language.setOral(vo.getOral());
        language.setWritten(vo.getWritten());
        language.setLanguageCode(commonService.findLanguageCodeById(vo.getLanguageCode().getId()));
        applicationService.updateLanguage(application, language);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/languages/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteLanguage(@PathVariable String referenceNo, @PathVariable Long id) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InLanguage language = (InLanguage) applicationService.findLanguageById(id);
        applicationService.deleteLanguage(application, language);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    // ====================================================================================================
    // EDUCATIONS
    // ====================================================================================================

    @RequestMapping(value = "/intakeApplications/{referenceNo}/educations", method = RequestMethod.GET)
    public ResponseEntity<List<Education>> findEducationsByIntakeApplication(@PathVariable String referenceNo) {
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        List<InEducation> educations = applicationService.findEducations(application);
        return new ResponseEntity<List<Education>>(applicationTransformer.toEducationVos(educations), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/educations", method = RequestMethod.POST)
    public ResponseEntity<String> addEducation(@PathVariable String referenceNo, @RequestBody Education vo) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InEducation education = new InEducationImpl();
        education.setProvider(vo.getProvider());
        education.setStartDate(vo.getStartDate());
        education.setEndDate(vo.getEndDate());
        education.setCurrent(false);
        applicationService.addEducation(application, education);

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    // ====================================================================================================
    // ATTACHMENTS
    // ====================================================================================================

    @RequestMapping(value = "/intakeApplications/{referenceNo}/attachments", method = RequestMethod.GET)
    public ResponseEntity<List<Attachment>> findAttachmentsByIntakeApplication(@PathVariable String referenceNo) {
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        List<InAttachment> attachments = applicationService.findAttachments(application);
        return new ResponseEntity<List<Attachment>>(applicationTransformer.toAttachmentVos(attachments), HttpStatus.OK);
    }

    // note: http://www.codejava.net/coding/upload-files-to-database-with-spring-mvc-and-hibernate
    @RequestMapping(value = "/intakeApplications/{referenceNo}/attachments", method = RequestMethod.POST)
    public ResponseEntity<String> addAttachment(@PathVariable String referenceNo, @RequestParam("file") MultipartFile file, @RequestParam("attachmentType") String attachmentType) {
        dummyLogin();

        LOG.debug("files is empty? : {}", file.isEmpty());
        LOG.debug("name: {}", file.getName());
        LOG.debug("original file name: {}", file.getOriginalFilename());
        LOG.debug("content type: {}", file.getContentType());
        LOG.debug("size: {}", file.getSize());
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        try {
            if (!file.isEmpty()) {
                InAttachment attachment = new InAttachmentImpl();
                attachment.setMimeType("application/pdf"); // todo(switch)
                attachment.setName(file.getOriginalFilename());
                attachment.setSize(file.getSize());
                attachment.setBytes(file.getBytes());
                attachment.setAttachmentType(InAttachmentType.valueOf(attachmentType));
                applicationService.addAttachment(application, attachment);
            }
        } catch (IOException e) {
            return new ResponseEntity<String>("Failed", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/attachment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteAttachment(@PathVariable String referenceNo, @PathVariable Long id) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InAttachment attachment = (InAttachment) applicationService.findAttachmentById(id);
        applicationService.deleteAttachment(application, attachment);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }


    // ====================================================================================================
    // SPM RESULTS
    // ====================================================================================================

    @RequestMapping(value = "/intakeApplications/{referenceNo}/spmResults", method = RequestMethod.GET)
    public ResponseEntity<List<SpmResult>> findSpmResultsByIntakeApplication(@PathVariable String referenceNo) {
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);

        List<InSpmResult> spmResults = applicationService.findSpmResults(application);

        return new ResponseEntity<List<SpmResult>>(applicationTransformer.toSpmResultVos(spmResults), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/spmResults", method = RequestMethod.POST)
    public ResponseEntity<String> addSpmResult(@PathVariable String referenceNo, @RequestBody SpmResult vo) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InSpmResult spmResult = new InSpmResultImpl();
        spmResult.setGrade(vo.getGrade());
        spmResult.setName(vo.getName());
        spmResult.setYear(vo.getYear());
        spmResult.setAggregate(vo.getAggregate());

        applicationService.addSpmResult(application, spmResult);

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    // ====================================================================================================
    // REFEREES
    // ====================================================================================================

    @RequestMapping(value = "/intakeApplications/{referenceNo}/referees", method = RequestMethod.GET)
    public ResponseEntity<List<Referee>> findRefereesByIntakeApplication(@PathVariable String referenceNo) {
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        List<InReferee> referees = applicationService.findReferees(application);
        return new ResponseEntity<List<Referee>>(applicationTransformer.toRefereeVos(referees), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/referees", method = RequestMethod.POST)
    public ResponseEntity<String> addReferee(@PathVariable String referenceNo, @RequestBody Referee vo) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InReferee referee = new InRefereeImpl();
        referee.setName(vo.getName());
        referee.setOfficeAddrs(vo.getOfficeAddrs());
        referee.setOccupation(vo.getOccupation());
        referee.setPhoneNo(vo.getPhoneNo());
        referee.setType(InRefereeType.get(vo.getRefereeType().ordinal()));
        applicationService.addReferee(application, referee);

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/referees/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateReferee(@PathVariable String referenceNo, @PathVariable Long id, @RequestBody Referee vo) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InReferee referee = (InReferee) applicationService.findRefereeById(id);
        referee.setName(vo.getName());
        referee.setOfficeAddrs(vo.getOfficeAddrs());
        referee.setOccupation(vo.getOccupation());
        referee.setPhoneNo(vo.getPhoneNo());
        referee.setType(InRefereeType.get(vo.getRefereeType().ordinal()));
        applicationService.updateReferee(application, referee);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/referees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteReferee(@PathVariable String referenceNo, @PathVariable Long id) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InReferee referee = (InReferee) applicationService.findRefereeById(id);
        applicationService.deleteReferee(application, referee);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    // ====================================================================================================
    // ADDRESS
    // ====================================================================================================

    @RequestMapping(value = "/intakeApplications/{referenceNo}/addresses", method = RequestMethod.GET)
    public ResponseEntity<List<Address>> findAddressesByIntakeApplication(@PathVariable String referenceNo) {
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        List<InAddress> address = applicationService.findAddresses(application);
        return new ResponseEntity<List<Address>>(applicationTransformer.toAddressVos(address), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/addresses", method = RequestMethod.POST)
    public ResponseEntity<String> addAddress(@PathVariable String referenceNo, @RequestBody Address vo) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InAddress address = new InAddressImpl();
        address.setAddress1(vo.getAddress1());
        address.setAddress2(vo.getAddress2());
        address.setAddress3(vo.getAddress3());
        address.setPostCode(vo.getPostcode());
        address.setType(InAddressType.get(vo.getAddressType().ordinal()));
        address.setCountryCode(commonService.findCountryCodeById(vo.getCountryCode().getId()));
        address.setStateCode(commonService.findStateCodeById(vo.getStateCode().getId()));
        applicationService.addAddress(application, address);

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/intakeApplications/{referenceNo}/addresses/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateAddress(@PathVariable String referenceNo, @PathVariable Long id, @RequestBody Address vo) {
        dummyLogin();
        
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InAddress address = (InAddress) applicationService.findAddressById(id);
        address.setAddress1(vo.getAddress1());
        address.setAddress2(vo.getAddress2());
        address.setAddress3(vo.getAddress3());
        address.setPostCode(vo.getPostcode());
        address.setType(InAddressType.get(vo.getAddressType().ordinal()));
        address.setCountryCode(commonService.findCountryCodeById(vo.getCountryCode().getId()));
        address.setStateCode(commonService.findStateCodeById(vo.getStateCode().getId()));
        applicationService.updateAddress(application, address);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/addresses/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteAddress(@PathVariable String referenceNo, @PathVariable Long id) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InAddress address = (InAddress) applicationService.findAddressById(id);
        applicationService.deleteAddress(application, address);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    // ====================================================================================================
    // BACHELOR RESULT
    // ====================================================================================================

    @RequestMapping(value = "/intakeApplications/{referenceNo}/bachelorResults", method = RequestMethod.GET)
    public ResponseEntity<List<BachelorResult>> findBachelorResultsByIntakeApplication(
            @PathVariable String referenceNo) {
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        List<InBachelorResult> bachelorResults = applicationService.findBachelorResults(application);
        return new ResponseEntity<List<BachelorResult>>(applicationTransformer.toBachelorResultVos(bachelorResults),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/bachelorResults", method = RequestMethod.POST)
    public ResponseEntity<String> addBachelorResult(@PathVariable String referenceNo, @RequestBody BachelorResult vo) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InBachelorResult bachelorResult = new InBachelorResultImpl();
        bachelorResult.setName(vo.getName());
        bachelorResult.setCgpa(vo.getCgpa());
        bachelorResult.setYear(vo.getYear());
        bachelorResult.setResultType(InResultType.get(vo.getResultType().ordinal()));
        applicationService.addBachelorResult(application, bachelorResult);

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/bachelorResults/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteBachelorResult(@PathVariable String referenceNo, @PathVariable Long id) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InBachelorResult bachelorResult = (InBachelorResult) applicationService.findBachelorResultById(id);
        applicationService.deleteBachelorResult(application, bachelorResult);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    // ====================================================================================================
    // DIPLOMA RESULT
    // ====================================================================================================

    @RequestMapping(value = "/intakeApplications/{referenceNo}/diplomaResults", method = RequestMethod.GET)
    public ResponseEntity<List<DiplomaResult>> findDiplomaResultsByIntakeApplication(@PathVariable String referenceNo) {
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        List<InDiplomaResult> diplomaResults = applicationService.findDiplomaResults(application);
        return new ResponseEntity<List<DiplomaResult>>(applicationTransformer.toDiplomaResultVos(diplomaResults),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/diplomaResults", method = RequestMethod.POST)
    public ResponseEntity<String> addDiplomaResult(@PathVariable String referenceNo, @RequestBody DiplomaResult vo) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InDiplomaResult diplomaResult = new InDiplomaResultImpl();
        diplomaResult.setName(vo.getName());
        diplomaResult.setCgpa(vo.getCgpa());
        diplomaResult.setYear(vo.getYear());
        diplomaResult.setResultType(InResultType.get(vo.getResultType().ordinal()));
        applicationService.addDiplomaResult(application, diplomaResult);

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/diplomaResults/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteDiplomaResult(@PathVariable String referenceNo, @PathVariable Long id) {
        dummyLogin();

        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InDiplomaResult diplomaResult = (InDiplomaResult) applicationService.findDiplomaResultById(id);
        applicationService.deleteDiplomaResult(application, diplomaResult);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    // ====================================================================================================
    // RESULT ITEM
    // ====================================================================================================

    @RequestMapping(value = "/intakeApplications/{referenceNo}/resultItems", method = RequestMethod.GET)
    public ResponseEntity<List<ResultItem>> findResultItemsByIntakeApplication(@PathVariable String referenceNo,
                                                                               @PathVariable InResultType resultType) {
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InResult result = applicationService.findResult(application, resultType);
        List<InResultItem> resultItems = applicationService.findResultItems(result);
        return new ResponseEntity<List<ResultItem>>(applicationTransformer.toResultItemVos(resultItems), HttpStatus.OK);
    }

    // ====================================================================================================
    // PRIVATE METHODS
    // ====================================================================================================

    private void dummyLogin() {
        InAutoLoginToken token = new InAutoLoginToken("applicant1");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }
}
