package my.edu.umk.pams.intake.web.module.system.controller;

import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.model.InUserImpl;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.security.integration.InAutoLoginToken;
import my.edu.umk.pams.intake.system.model.InModule;
import my.edu.umk.pams.intake.system.service.SystemService;
import my.edu.umk.pams.intake.web.module.policy.vo.IntakeSession;
import my.edu.umk.pams.intake.web.module.registration.vo.UserRegistration;
import my.edu.umk.pams.intake.web.module.system.vo.Module;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/system")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @Autowired
    private SystemTransformer systemTransformer;
    
    @Autowired
    private AuthenticationManager authenticationManager;


    @RequestMapping(value = "/modules/authorized", method = RequestMethod.GET)
    public ResponseEntity<List<Module>>listModules() {
    	 List<InModule> modules = systemService.findModules(true);
    	return new ResponseEntity<List<Module>>(systemTransformer.toModuleVos(modules), HttpStatus.OK);
    }
    
 // ====================================================================================================
    // PRIVATE METHODS
    // ====================================================================================================

    private void dummyLogin() {
//        Noop
//        InAutoLoginToken token = new InAutoLoginToken("applicant1");
//        Authentication authed = authenticationManager.authenticate(token);
//        SecurityContextHolder.getContext().setAuthentication(authed);
    }
}
