package my.edu.umk.pams.intake.web.module.registration.controller;

import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.model.InUserImpl;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.web.module.registration.vo.UserRegistration;
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
    private RegistrationTransformer registrationTransformer;

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

    @RequestMapping(value = "/verifyUser/{token}", method = RequestMethod.POST)
    public ResponseEntity<Boolean> verifyUser(@PathVariable String token) {
        registrationService.verifyUser(token);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
}
