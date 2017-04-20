package my.edu.umk.pams.intake.web.module.common.controller;

import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.web.module.common.vo.ProgramCode;
import my.edu.umk.pams.intake.web.module.common.vo.SupervisorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private CommonTransformer commonTransformer;

    @RequestMapping(value = "/programCodes", method = RequestMethod.GET)
    public ResponseEntity<List<ProgramCode>> findProgramCodes() {
        return new ResponseEntity<List<ProgramCode>>(commonTransformer.toProgramCodeVos(commonService.findProgramCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/supervisorCodes", method = RequestMethod.GET)
    public ResponseEntity<List<SupervisorCode>> findSupervisorCodes() {
        return new ResponseEntity<List<SupervisorCode>>(commonTransformer.toSupervisorCodeVos(commonService.findSupervisorCodes()), HttpStatus.OK);
    }
}
