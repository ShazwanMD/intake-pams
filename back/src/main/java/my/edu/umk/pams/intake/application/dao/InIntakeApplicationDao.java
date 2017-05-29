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
    
    InFranchise findFranchiseById(Long id);

    InContact findContactById(Long id);

    InAddress findAddressById(Long id);
    
    InBachelorResult findBachelorResultById(Long id);
    
    InDiplomaResult findDiplomaResultById(Long id);
    
    InSpmResult findSpmResultById(Long id);

    InGuarantor findGuarantorByType(InGuarantorType type, InIntakeApplication application);

    InGuardian findGuardianByType(InGuardianType guardianType, InIntakeApplication application);

    InContact findContactByType(InContactType type, InIntakeApplication application);

    InAddress findAddressByType(InAddressType type, InIntakeApplication application);
    
    InBachelorResult findBachelorResultByResultType(InResultType resultType, InIntakeApplication application);

    InDiplomaResult findDiplomaResultByResultType(InResultType resultType, InIntakeApplication application);
    
    InApplicant findApplicant(InIntakeApplication application);


    List<InIntakeApplication> find(InIntake intake);

    List<InIntakeApplication> find(InIntake intake, Integer offset, Integer limit);

    List<InIntakeApplication> find(String filter, InIntake intake, Integer offset, Integer limit);

    List<InIntakeApplication> find(String filter, InBidType bidType, InIntake intake, Integer offset, Integer limit);

    List<InIntakeApplication> find(InApplicant applicant, InBidStatus bidStatus);

    List<InIntakeApplication> findByOrderedMerit(InIntake intake);

    List<InIntakeApplication> findByOrderedRank(InIntake intake);

    List<InIntakeApplication> find(InIntake intake, InBidStatus bidStatus);

    List<InApplicant> findApplicants(InIntake intake);

    List<InResult> findResults(InIntakeApplication application);

    List<InResultItem> findResultItems(InResult result);

    List<InEducation> findEducations(InIntakeApplication application);

    List<InEmployment> findEmployments(InIntakeApplication application);
    
    List<InLanguage> findLanguages(InIntakeApplication application);
    
    List<InReferee> findReferees(InIntakeApplication application);

    List<InInvolvement> findInvolvements(InIntakeApplication application);

    List<InGuarantor> findGuarantors(InIntakeApplication application);

    List<InGuardian> findGuardians(InIntakeApplication application);

    List<InFranchise> findFranchises(InIntakeApplication application);
    
    List<InContact> findContacts(InIntakeApplication application);

    List<InAddress> findAddresses(InIntakeApplication application);
    
    List<InBachelorResult> findBachelorResults(InIntakeApplication application);
    
    List<InDiplomaResult> findDiplomaResults(InIntakeApplication application);
    
    List<InSpmResult> findSpmResults (InIntakeApplication application);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(InIntake intake);

    Integer count(String filter, InIntake intake);

    Integer count(String filter, InBidType bidType, InIntake intake);

    boolean hasResult(InIntakeApplication application, InResultType resultType);

    boolean hasEducation(InIntakeApplication application);

    boolean hasEmployment(InIntakeApplication application);

    boolean hasLanguage(InIntakeApplication application);

    boolean hasInvolvement(InIntakeApplication application);
    
    boolean hasReferee(InIntakeApplication application);

    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    void addResult(InIntakeApplication application, InResult result, InUser user);

    void deleteResult(InIntakeApplication application, InResult result, InUser user);

    void addResultItem(InResult result, InResultItem item, InUser user);

    void deleteResultItem(InResult result, InResultItem item, InUser user);

    void addEducation(InIntakeApplication application, InEducation education, InUser user);

    void deleteEducation(InIntakeApplication application, InEducation education, InUser user);

    void addEmployment(InIntakeApplication application, InEmployment employment, InUser user);

    void deleteEmployment(InIntakeApplication application, InEmployment employment, InUser user);

    void addLanguage(InIntakeApplication application, InLanguage language, InUser user);

    void deleteLanguage(InIntakeApplication application, InLanguage language, InUser user);

    void addInvolvement(InIntakeApplication application, InInvolvement involvement, InUser user);

    void deleteInvolvement(InIntakeApplication application, InInvolvement involvement, InUser user);

    void addGuardian(InIntakeApplication application, InGuardian guardian, InUser user);

    void deleteGuardian(InIntakeApplication application, InGuardian guardian, InUser user);

    void addGuarantor(InIntakeApplication application, InGuarantor guarantor, InUser user);

    void deleteGuarantor(InIntakeApplication application, InGuarantor guarantor, InUser user);

    void addContact(InIntakeApplication application, InContact contact, InUser user);

    void deleteContact(InIntakeApplication application, InContact contact, InUser user);

    void addAddress(InIntakeApplication application, InAddress address, InUser user);
    
    void addBachelorResult(InIntakeApplication application, InBachelorResult bachelorResult, InUser user);
    
    void addDiplomaResult(InIntakeApplication application, InDiplomaResult diplomaResult, InUser user);

    void deleteAddress(InIntakeApplication application, InAddress address, InUser user);
    
    void deleteBachelorResult(InIntakeApplication application, InBachelorResult bachelorResult, InUser user);
    
    void deleteDiplomaResult(InIntakeApplication application, InDiplomaResult diplomaResult, InUser user);
    
    void addSpmResult(InIntakeApplication application, InSpmResult spmResult, InUser user);
    
    void deleteSpmResult(InIntakeApplication application, InSpmResult spmResult, InUser user);

	void addAttachment(InIntakeApplication application,InAttachment attachment, InUser currentUser);

	void addReferee(InIntakeApplication application, InReferee referee, InUser currentUser);

	List<InIntakeApplication> findIntakeApplicationsByPaidStatus(InIntake intake, Boolean paid);
	
	List<InIntakeApplication> findIntakeApplicationsByVerificationStatus(InIntake intake, Boolean verification);

}
