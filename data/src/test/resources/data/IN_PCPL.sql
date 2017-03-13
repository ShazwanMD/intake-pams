-- USR, PGW, KRN BDR
-- USER, PEGAWAI, KERANI, BENDAHARI
-- abc123 = 6367c48dd193d56ea7b0baad25b19455e529f5ee

-- todo(uda): pps admin, pps pegawai, pps kerani
-- todo(uda): mgseb admin, mgseb pegawai, mgseb kerani
-- todo(uda): bursary admin, bursary pegawai, bursary kerani

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'root', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'Root', 'root@umk.edu.my', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'admin', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS Admin', 'admin@umk.edu.my', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'system', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS System', 'system@umk.edu.my', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'bursary', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS Bursary', 'bursary@umk.edu.my', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'pps', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS PPS', 'pps@umk.edu.my', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'mgseb', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS MGSEB', 'mgseb@umk.edu.my', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'applicant1', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS Applicant 1', 'applicant1@gmail.com', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'applicant2', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS Applicant 2', 'applicant2@gmail.com', 'abc123');

---------------------------------------------------------
-- GROUP START
---------------------------------------------------------

-- user@ROOT
INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'GRP_USR', TRUE, TRUE, 1, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_GROP (ID) VALUES (currval('SQ_IN_PCPL'));
INSERT INTO IN_PCPL_ROLE (ID, PRINCIPAL_ID, ROLE_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL_ROLE'), (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_USR'), 1, 1, 1, CURRENT_TIMESTAMP);

-- ADMIN
INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'GRP_ADM', TRUE, TRUE, 1, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_GROP (ID) VALUES (currval('SQ_IN_PCPL'));
INSERT INTO IN_PCPL_ROLE (ID, PRINCIPAL_ID, ROLE_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL_ROLE'), (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_ADM'), 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_USR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_ADM'), 1, 1, CURRENT_TIMESTAMP);
---------------------------------------------------------
-- GROUP END
---------------------------------------------------------
