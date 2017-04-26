package my.edu.umk.pams.intake.web.module.admission.controller;

import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.web.module.admission.vo.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping("/api/admission")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private AdmissionTransformer admissionTransformer;

    @RequestMapping(value = "/intake/{referenceNo}/candidates", method = RequestMethod.GET)
    public ResponseEntity<List<Candidate>> findCandidates(@PathVariable String referenceNo) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        return new ResponseEntity<List<Candidate>>(
                admissionTransformer.toCandidateVos(admissionService.findCandidates(intake)), HttpStatus.OK);
    }

    @RequestMapping(value = "/intake/{referenceNo}/candidates/selected", method = RequestMethod.GET)
    public ResponseEntity<List<Candidate>> findSelecedCandidates(@PathVariable String referenceNo) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        return new ResponseEntity<List<Candidate>>(
                admissionTransformer.toCandidateVos(
                        admissionService.findCandidatesByStatus(intake, InCandidateStatus.SELECTED)), HttpStatus.OK);
    }

    @RequestMapping(value = "/intake/{referenceNo}/candidates/rejected", method = RequestMethod.GET)
    public ResponseEntity<List<Candidate>> findRejectedCandidates(@PathVariable String referenceNo) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        return new ResponseEntity<List<Candidate>>(
                admissionTransformer.toCandidateVos(
                        admissionService.findCandidatesByStatus(intake, InCandidateStatus.REJECTED)), HttpStatus.OK);
    }

    @RequestMapping(value = "/intake/{referenceNo}/candidates/accepted", method = RequestMethod.GET)
    public ResponseEntity<List<Candidate>> findAcceptedCandidates(@PathVariable String referenceNo) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        return new ResponseEntity<List<Candidate>>(
                admissionTransformer.toCandidateVos(
                        admissionService.findCandidatesByStatus(intake, InCandidateStatus.ACCEPTED)), HttpStatus.OK);
    }
}
