INSERT INTO IN_PRGM_CODE(ID, CODE, DESCRIPTION_EN, DESCRIPTION_MS,GRADUATE_CENTER_ID, PROGRAM_LEVEL_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_IN_PRGM_CODE'),   'MGSEB-MBPA',
   'MASTER OF BUSINESS ADMINISTRATION',
   'SARJANA PENTADBIRAN PERNIAGAAN',
   (SELECT ID FROM IN_GRDT_CNTR PL WHERE PL.CODE = 'MGSEB'),
   (SELECT ID FROM IN_PRGM_LEVL PL WHERE PL.CODE = 'MASTER'),
CURRENT_TIMESTAMP, 0, 1);
INSERT INTO IN_PRGM_CODE(ID, CODE, DESCRIPTION_EN, DESCRIPTION_MS,GRADUATE_CENTER_ID, PROGRAM_LEVEL_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_IN_PRGM_CODE'),   'MGSEB-DBPA',
   'DOCTOR OF BUSINESS ADMINISTRATION',
   'DOKTOR PENTADBIRAN PERNIAGAAN',
   (SELECT ID FROM IN_GRDT_CNTR PL WHERE PL.CODE = 'MGSEB'),
   (SELECT ID FROM IN_PRGM_LEVL PL WHERE PL.CODE = 'PHD'),
CURRENT_TIMESTAMP, 0, 1);