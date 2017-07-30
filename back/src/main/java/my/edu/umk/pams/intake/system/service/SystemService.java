package my.edu.umk.pams.intake.system.service;

import my.edu.umk.pams.intake.system.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface SystemService {

    //====================================================================================================
    // MODULE SUB MODULE
    //====================================================================================================

    InModule findModuleById(Long id);

    InSubModule findSubModuleById(Long id);

    InModule findModuleByCode(String code);

    InSubModule findSubModuleByCode(String code);

    List<InModule> findModules();

    List<InModule> findModules(boolean authorized);

    List<InModule> findModules(Integer offset, Integer limit);

    List<InModule> findModules(boolean authorized, Integer offset, Integer limit);

    List<InSubModule> findSubModules();

    List<InSubModule> findSubModules(boolean authorized);

    List<InSubModule> findSubModules(Integer offset, Integer limit);

    List<InSubModule> findSubModules(InModule module, Integer offset, Integer limit);

    Integer countModule();

    Integer countSubModule();

    Integer countSubModule(InModule module);

    void saveModule(InModule module);

    void updateModule(InModule module);

    void addSubModule(InModule module, InSubModule subModule);

    void updateSubModule(InModule module, InSubModule subModule);

    //====================================================================================================
    // AUDIT
    //====================================================================================================

    InAudit findAuditById(Long id);

    List<InAudit> findAudits(Integer offset, Integer limit);

    List<InAudit> findAudits(String filter, Integer offset, Integer limit);

    Integer countAudit();

    Integer countAudit(String filter);

    //====================================================================================================
    // REFERENCE NO
    //====================================================================================================

    InReferenceNo findReferenceNoById(Long id);

    InReferenceNo findReferenceNoByCode(String code);

    List<InReferenceNo> findReferenceNos(Integer offset, Integer limit);

    List<InReferenceNo> findReferenceNos(String filter, Integer offset, Integer limit);

    Integer countReferenceNo();

    Integer countReferenceNo(String filter);

    String generateReferenceNo(String code);

    String generateFormattedReferenceNo(String code, Map<String, Object> map);

    //====================================================================================================
    // CONFIGURATION
    //====================================================================================================

    InConfiguration findConfigurationById(Long id);

    InConfiguration findConfigurationByKey(String key);

    List<InConfiguration> findConfigurationsByPrefix(String prefix);

    List<InConfiguration> findConfigurations();

    List<InConfiguration> findConfigurations(Integer offset, Integer limit);

    List<InConfiguration> findConfigurations(String filter);

    List<InConfiguration> findConfigurations(String filter, Integer offset, Integer limit);

    Integer countConfiguration();

    Integer countConfiguration(String filter);

    void saveConfiguration(InConfiguration config);

    void updateConfiguration(InConfiguration config);

    void removeConfiguration(InConfiguration config);

    //====================================================================================================
    // EMAIL
    //====================================================================================================

    InEmailTemplate findEmailTemplateById(Long id);

    InEmailTemplate findEmailTemplateByCode(String code);

    List<InEmailTemplate> findEmailTemplates();

    List<InEmailTemplate> findEmailTemplates(Integer offset, Integer limit);

    List<InEmailTemplate> findEmailTemplates(String filter);

    List<InEmailTemplate> findEmailTemplates(String filter, Integer offset, Integer limit);

    Integer countEmailTemplate();

    Integer countEmailTemplate(String filter);

    void saveEmailTemplate(InEmailTemplate config);

    void updateEmailTemplate(InEmailTemplate config);

    void removeEmailTemplate(InEmailTemplate config);

    // TODO:
    void sendWithAttachment(String email, String s, String s1, String s2, String s3, HashMap<String, Object> vars);


    //====================================================================================================
    // EMAIL QUEUE
    //====================================================================================================

    List<InEmailQueue> findEmailQueues();

    List<InEmailQueue> findEmailQueues(InEmailQueueStatus status);

    List<InEmailQueue> findEmailQueues(InEmailQueueStatus status, Integer offset, Integer limit);

    Integer countEmailQueue();

    void saveEmailQueue(InEmailQueue emailQueue);

    void updateEmailQueue(InEmailQueue emailQueue);

	boolean hasEmailQueue(String email);
}
