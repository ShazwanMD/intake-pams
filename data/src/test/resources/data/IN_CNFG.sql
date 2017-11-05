INSERT INTO IN_CNFG (ID, CONFIG_KEY, CONFIG_VALUE, DESCRIPTION, C_ID, C_TS, M_ST)
    VALUES (nextval('SQ_IN_CNFG'), 'advising.supervisor.limit', '2', 'Supervisor limit configuration', 1, CURRENT_TIMESTAMP, 1);
INSERT INTO IN_CNFG (ID, CONFIG_KEY, CONFIG_VALUE, DESCRIPTION, C_ID, C_TS, M_ST)
    VALUES (nextval('SQ_IN_CNFG'), 'application.url', 'http://119.110.101.17:8082', 'Application Url', 1, CURRENT_TIMESTAMP, 1);
