package my.edu.umk.pams.intake.web.module.registration.controller;

import my.edu.umk.pams.intake.IntakeFlowProcessTest;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.model.InUserImpl;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
//import my.edu.umk.pams.intake.web.module.account.controller.AccountTransformer;
import my.edu.umk.pams.intake.web.module.common.vo.BankCode;
import my.edu.umk.pams.intake.web.module.identity.vo.User;
import my.edu.umk.pams.intake.web.module.registration.vo.UserRegistration;

import java.util.List;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;
    
    @Autowired
    private IdentityService identityService;

    @Autowired
    private RegistrationTransformer registrationTransformer;
    
//    @Autowired
//    private AccountTransformer accountTransformer;
    
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);
    

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@RequestBody UserRegistration registration) {
        InUser user = new InUserImpl();
        user.setUsername(registration.getEmail());
        user.setEmail(registration.getEmail());
        user.setRealName(registration.getName());
        user.setPassword(registration.getPassword());
        user.setEnabled(false);
        user.setLocked(true);

        InApplicant applicant = new InApplicantImpl();
        applicant.setIdentityNo(registration.getIdentityNo());
        applicant.setName(registration.getName());
        applicant.setEmail(registration.getEmail());

        registrationService.registerUser(user, applicant);

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/verifyUser/{token}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> verifyUser(@PathVariable String token) {
        registrationService.verifyUser(token);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
    
/*    @RequestMapping(value = "/users/{email}", method = RequestMethod.GET)
    public ResponseEntity<User> findUser(@PathVariable String email) {
        return new ResponseEntity<User>(accountTransformer.toUserVo(identityService.findUserByEmail(email)),HttpStatus.OK);           
    }*/
    
//    @RequestMapping(value = "/forgetPassword/{email}", method = RequestMethod.GET)
//    public ResponseEntity<String> forgetPassword(@PathVariable String email) {
//    	email = "samiya.cm@umk.edu.my";
//    	LOG.debug("My email value is: " + email);
//    	if (email == null) LOG.debug("Email is null");
//    	if (!"samiya.cm@umk.edu.my".equals(email)) LOG.debug("Email has no match:" + email);
//
//    	InUser user=identityService.findUserByEmail(email);
//    	if (user == null) LOG.debug("UserA is null");
//    	LOG.debug("user check ",user);
//
//    	LOG.debug("email",email);
//    	LOG.debug("user",user);
//        registrationService.forgetPassword(user);
//        LOG.debug("after forget");
//        return new ResponseEntity<String>("Success", HttpStatus.OK);
//    }
}
