package my.edu.umk.pams.intake.application.dao;

import my.edu.umk.pams.intake.application.model.*;
import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;

import java.util.List;

public interface InIntakeApplicationDao extends GenericDao<Long, InIntakeApplication> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    InIntakeApplication findByReferenceNo(String referenceNo);

    InIntakeApplication findByNricNoOrPassportNo(String identityNo);

    InIntakeApplication findByIntakeAndApplicant(InIntake intake, InApplicant applicant);

    InResult findResultById(Long id);

    InResult findResult(InIntakeApplication application, InResultType resultType);

    InResultItem findResultItemById(Long id);

    InGuarantor findGuarantorById(Long id);

    InGuardian findGuardianById(Long id);

    InContact findContactById(Long id);

    InAddress findAddressById(Long id);

    InGuarantor findGuarantorByType(InGuarantorType type, InIntakeApplication application);

    InGuardian findGuardianByType(InGuardianType guardianType, InIntakeApplication application);

    InContact findContactByType(InContactType type, InIntakeApplication application);

    InAddress findAddressByType(InAddressType type, InIntakeApplication application);

    InApplicant findApplicant(InIntakeApplication application);

    List<InIntakeApplication> find(InIntake intake);

    List<InIntakeApplication> find(InIntake intake, Integer offset, Integer limit);

    List<InIntakeApplication> find(String filter, InIntake intake, Integer offset, Integer limit);

    List<InIntakeApplication> find(String filter, InBidType bidType, InIntake intake, Integer offset, Integer limit);

    List<InIntakeApplication> findByOrderedMerit(InIntake intake);

    List<InIntakeApplication> findByOrderedRank(InIntake intake);

    List<InIntakeApplication> find(InIntake intake, InBidStatus status);

    List<InResult> findResults(InIntakeApplication application);

    List<InResultItem> findResultItems(InResult result);

    List<InEmployment> findEmployments(InIntakeApplication application);

    List<InInvolvement> findInvolvements(InIntakeApplication application);

    List<InGuarantor> findGuarantors(InIntakeApplication application);

    List<InGuardian> findGuardians(InIntakeApplication application);

    List<InContact> findContacts(InIntakeApplication application);

    List<InAddress> findAddresses(InIntakeApplication application);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(InIntake intake);

    Integer count(String filter, InIntake intake);

    Integer count(String filter, InBidType bidType, InIntake intake);

    boolean hasResult(InIntakeApplication application, InResultType resultType);

    boolean hasEmployment(InIntakeApplication application);

    boolean hasInvolvement(InIntakeApplication application);

    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    void addResult(InIntakeApplication application, InResult result, InUser user);

    void deleteResult(InIntakeApplication application, InResult result, InUser user);

    void addResultItem(InResult result, InResultItem item, InUser user);

    void deleteResultItem(InResult result, InResultItem item, InUser user);

    void addEmployment(InIntakeApplication application, InEmployment employment, InUser user);

    void deleteEmployment(InIntakeApplication application, InEmployment employment, InUser user);

    void addInvolvement(InIntakeApplication application, InInvolvement involvement, InUser user);

    void deleteInvolvement(InIntakeApplication application, InInvolvement involvement, InUser user);

    void addGuardian(InIntakeApplication application, InGuardian guardian, InUser user);

    void deleteGuardian(InIntakeApplication application, InGuardian guardian, InUser user);

    void addGuarantor(InIntakeApplication application, InGuarantor guarantor, InUser user);

    void deleteGuarantor(InIntakeApplication application, InGuarantor guarantor, InUser user);

    void addContact(InIntakeApplication application, InContact contact, InUser user);

    void deleteContact(InIntakeApplication application, InContact contact, InUser user);

    void addAddress(InIntakeApplication application, InAddress address, InUser user);

    void deleteAddress(InIntakeApplication application, InAddress address, InUser user);


}
