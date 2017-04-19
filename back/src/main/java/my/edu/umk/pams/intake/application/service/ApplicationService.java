package my.edu.umk.pams.intake.application.service;

import my.edu.umk.pams.intake.application.model.*;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;

import java.util.List;

public interface ApplicationService {

    //====================================================================================================
    // INTAKE APPLICATION
    //====================================================================================================

    void draftIntakeApplication(InIntake intake, InIntakeApplication application);

    void updateIntakeApplication(InIntakeApplication application);

    void submitIntakeApplication(InIntake intake, InIntakeApplication application); 
    
    void withdrawIntakeApplication(InIntake intake, InIntakeApplication application); 
    
    void draftedIntakeApplication(InIntake intake, InIntakeApplication application); 
    
    void processIntakeApplication(InIntake intake, InIntakeApplication application);
    
    void rejectIntakeApplication(InIntake intake, InIntakeApplication application);

    void addResult(InIntakeApplication application, InResult result);

    void addResultItem(InIntakeApplication application, InResult result, InResultItem item);

    void addEducation(InIntakeApplication application, InEducation education);

    void addEmployment(InIntakeApplication application, InEmployment employment);

    void addInvolvement(InIntakeApplication application, InInvolvement involvement);

    void addAddress(InIntakeApplication application, InAddress address);

    void deleteAddress(InIntakeApplication application, InAddress address);

    void addContact(InIntakeApplication application, InContact contact);

    void deleteContact(InIntakeApplication application, InContact contact);

    void addGuarantor(InIntakeApplication application, InGuarantor guarantor);

    void deleteGuarantor(InIntakeApplication application, InGuarantor guarantor);

    void addGuardian(InIntakeApplication application, InGuardian guardian);

    void deleteGuardian(InIntakeApplication application, InGuardian guardian);

    void addFranchise(InFranchise franchise);
    
    void addAttachment(InIntakeApplication application, InAttachment attachment);

    //====================================================================================================
    // APPLICANT
    //====================================================================================================

    InApplicant findApplicant(InIntakeApplication application);

    List<InApplicant> findApplicants(InIntake intake);

    //====================================================================================================
    // INTAKE APPLICATION
    //====================================================================================================

    InIntakeApplication findIntakeApplicationById(Long id);

    InIntakeApplication findIntakeApplicationByReferenceNo(String referenceNo);

    InIntakeApplication findIntakeApplicationByNricNoOrPassportNo(String identityNo);

    InIntakeApplication findIntakeApplicationByIntakeAndApplicant(InIntake intake, InApplicant applicant);

    InResult findResultById(Long id);

    InResult findResult(InIntakeApplication application, InResultType resultType);

    InResultItem findResultItemById(Long id);

    InGuardian findGuardianById(Long id);

    InGuarantor findGuarantorById(Long id);

    InAddress findAddressById(Long id);

    InContact findContactById(Long id);

    InGuardian findGuardianByType(InGuardianType guardianType, InIntakeApplication application);
    
    InGuarantor findGuarantorByType(InGuarantorType guarantorType, InIntakeApplication application);

    InAddress findAddressByType(InAddressType addressType, InIntakeApplication application);

    InContact findContactByType(InContactType contactType, InIntakeApplication application);

    List<InIntakeApplication> findIntakeApplications(InIntake intake);

    List<InIntakeApplication> findIntakeApplications(InIntake intake, InBidStatus status);

    List<InIntakeApplication> findIntakeApplications(InIntake intake, Integer offset, Integer limit);

    List<InIntakeApplication> findIntakeApplications(String filter, InIntake intake, Integer offset, Integer limit);

    List<InIntakeApplication> findIntakeApplications(String filter, InBidType bidType, InIntake intake, Integer offset, Integer limit);

    List<InIntakeApplication> findIntakeApplicationsOrderedByMerit(InIntake intake);

    List<InIntakeApplication> findIntakeApplicationsOrderedByRank(InIntake intake);
    
    List<InIntakeApplication> findIntakeApplicationsByPaidStatus (InIntake intake, Boolean paid);

    List<InResult> findResults(InIntakeApplication application);

    List<InResultItem> findResultItems(InResult result);

    List<InEducation> findEducations(InIntakeApplication application);

    List<InEmployment> findEmployments(InIntakeApplication application);

    List<InInvolvement> findInvolvements(InIntakeApplication application);

    List<InGuardian> findGuardians(InIntakeApplication application);
    
    List<InGuarantor> findGuarantors(InIntakeApplication application);

    List<InContact> findContacts(InIntakeApplication application);

    List<InAddress> findAddresses(InIntakeApplication application);

    Integer countIntakeApplication(InIntake intake);

    Integer countIntakeApplication(String filter, InIntake intake);

    Integer countIntakeApplication(String filter, InBidType bidType, InIntake intake);

    boolean hasResult(InIntakeApplication application, InResultType resultType);

    boolean hasEducation(InIntakeApplication application);
    
    boolean hasEmployment(InIntakeApplication application);

    boolean hasInvolvement(InIntakeApplication application);

	void addReferee(InIntakeApplication application, InReferee referee);

	

	

}

