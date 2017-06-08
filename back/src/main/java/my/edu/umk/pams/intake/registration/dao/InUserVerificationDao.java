package my.edu.umk.pams.intake.registration.dao;

import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.registration.model.InUserVerification;

/**
 * @author PAMS
 */
public interface InUserVerificationDao extends GenericDao<Long, InUserVerification> {

    InUserVerification findByToken(String token);

}
