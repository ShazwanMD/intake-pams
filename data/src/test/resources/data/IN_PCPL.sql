-- USR, PGW, KRN BDR
-- USER, PEGAWAI, KERANI, BENDAHARI
-- abc123 = 6367c48dd193d56ea7b0baad25b19455e529f5ee

-- todo(uda): cps admin, cps pegawai, cps kerani
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

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'cps', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS cps', 'cps@umk.edu.my', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'cps-kerani', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS cps Kerani', 'cps-kerani@umk.edu.my', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'cps-pegawai', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS cps Pegawai', 'cps-pegawai@umk.edu.my', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'mgseb', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS MGSEB', 'mgseb@umk.edu.my', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'mgseb-kerani', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS MGSEB Kerani', 'mgseb-kerani@umk.edu.my', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'mgseb-pegawai', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS MGSEB Pegawai', 'mgseb-pegawai@umk.edu.my', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'applicant1', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS Applicant 1', 'applicant1@gmail.com', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'applicant2', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS Applicant 2', 'applicant2@gmail.com', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'applicant3', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS Applicant 3', 'applicant3@gmail.com', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'applicant4', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS Applicant 4', 'applicant4@gmail.com', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'candidate1', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS Candidate1', 'candidate1@gmail.com', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'registrar', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS Registrar', 'registrar@gmail.com', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'io-kerani', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS International Officer Kerani', 'international-officer@gmail.com', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'fakulti-kerani', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS FAKULTI KERANI', 'fakulti-kerani@gmail.com', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'fakulti-pegawai', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS FAKULTI PEGAWAI', 'fakulti-pegawai@gmail.com', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'io-pegawai', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS INTERNATIONAL OFFICER PEGAWAI', 'mgseb-pegawai@gmail.com', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'fakulti-td', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS FAKULTI TD', 'fakulti-td@gmail.com', 'abc123');

INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'fakulti-dekan', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_IN_PCPL'), 'PAMS FAKULTI DEKAN', 'fakulti-dekan@gmail.com', 'abc123');
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

-- PEGAWAI
INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'GRP_PGW', TRUE, TRUE, 1, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_GROP (ID) VALUES (currval('SQ_IN_PCPL'));
INSERT INTO IN_PCPL_ROLE (ID, PRINCIPAL_ID, ROLE_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL_ROLE'), (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_PGW'), 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_USR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_PGW'), 1, 1, CURRENT_TIMESTAMP);

-- USER PEGAWAI
INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_PGW'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'cps-pegawai'), 1, 1, CURRENT_TIMESTAMP);	

INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_PGW'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'mgseb-pegawai'), 1, 1, CURRENT_TIMESTAMP);

INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_PGW'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'fakulti-pegawai'), 1, 1, CURRENT_TIMESTAMP);

INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_PGW'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'io-pegawai'), 1, 1, CURRENT_TIMESTAMP);																						 
		
-- KERANI
INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'GRP_KRN', TRUE, TRUE, 1, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_GROP (ID) VALUES (currval('SQ_IN_PCPL'));
INSERT INTO IN_PCPL_ROLE (ID, PRINCIPAL_ID, ROLE_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL_ROLE'), (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_KRN'), 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_USR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_KRN'), 1, 1, CURRENT_TIMESTAMP);	
-- USER KERANI
INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_KRN'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'cps-kerani'), 1, 1, CURRENT_TIMESTAMP);	
																				 
INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_KRN'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'mgseb-kerani'), 1, 1, CURRENT_TIMESTAMP);
											
INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_KRN'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'fakulti-kerani'), 1, 1, CURRENT_TIMESTAMP);		

INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_KRN'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'io-kerani'), 1, 1, CURRENT_TIMESTAMP);
																				 
-- MENAGEMENT
INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'GRP_MGT', TRUE, TRUE, 1, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_GROP (ID) VALUES (currval('SQ_IN_PCPL'));
INSERT INTO IN_PCPL_ROLE (ID, PRINCIPAL_ID, ROLE_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL_ROLE'), (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_MGT'), 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_USR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_MGT'), 1, 1, CURRENT_TIMESTAMP);		

--USER MENAGEMENT
INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_MGT'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'registrar'), 1, 1, CURRENT_TIMESTAMP);	

INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_MGT'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'fakulti-td'), 1, 1, CURRENT_TIMESTAMP);

INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_MGT'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'fakulti-dekan'), 1, 1, CURRENT_TIMESTAMP);

INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_MGT'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'bursary'), 1, 1, CURRENT_TIMESTAMP);																					 
		
-- APPLICANT
INSERT INTO IN_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL'), 'GRP_APCN', TRUE, TRUE, 1, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_GROP (ID) VALUES (currval('SQ_IN_PCPL'));
INSERT INTO IN_PCPL_ROLE (ID, PRINCIPAL_ID, ROLE_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_PCPL_ROLE'), (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_APCN'), 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_USR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_APCN'), 1, 1, CURRENT_TIMESTAMP);		

--USER APPLICANT
INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_APCN'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'applicant1'), 1, 1, CURRENT_TIMESTAMP);	

INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_APCN'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'applicant2'), 1, 1, CURRENT_TIMESTAMP);

INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_APCN'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'applicant3'), 1, 1, CURRENT_TIMESTAMP);

INSERT INTO IN_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_IN_GROP_MMBR'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'GRP_APCN'),
                                                                                 (SELECT ID FROM IN_PCPL WHERE NAME = 'applicant4'), 1, 1, CURRENT_TIMESTAMP);	
																				 
---------------------------------------------------------
-- GROUP END
---------------------------------------------------------


---------------------------------------------------------
-- MODUL
---------------------------------------------------------
INSERT INTO IN_MODL (ID, CODE, CANONICAL_CODE, DESCRIPTION, ORDINAL, ENABLED, M_ST, C_ID, C_TS)
VALUES (NEXTVAL('SQ_IN_MODL'), 'M001', 'M001', 'POLICY', 1, TRUE, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_MODL (ID, CODE, CANONICAL_CODE, DESCRIPTION, ORDINAL, ENABLED, M_ST, C_ID, C_TS)
VALUES (NEXTVAL('SQ_IN_MODL'), 'M002', 'M002', 'APPLICATION', 2, TRUE, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_MODL (ID, CODE, CANONICAL_CODE, DESCRIPTION, ORDINAL, ENABLED, M_ST, C_ID, C_TS)
VALUES (NEXTVAL('SQ_IN_MODL'), 'M003', 'M003', 'ADMISSION', 3, TRUE, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO IN_MODL (ID, CODE, CANONICAL_CODE, DESCRIPTION, ORDINAL, ENABLED, M_ST, C_ID, C_TS)
VALUES (NEXTVAL('SQ_IN_MODL'), 'M004', 'M004', 'REGISTRATION', 3, TRUE, 1, 1, CURRENT_TIMESTAMP);

---------------------------------------------------------
-- MODUL END
---------------------------------------------------------