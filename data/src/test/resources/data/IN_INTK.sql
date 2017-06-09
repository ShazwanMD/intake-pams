INSERT INTO IN_INTK (ID, AUDIT_NO, CANCEL_COMMENT, DESCRIPTION, END_DATE,
                     AV_TS, AV_ID, CL_ID, CL_TS, CK_TS, CK_ID, DT_TS, DT_ID,
                     EV_TS, EV_ID, PR_TS, PR_ID, PS_TS, PS_ID, RG_TS, RG_ID,
                     RM_TS, RM_ID, RQ_TS, RQ_ID, SL_TS, SL_ID, FD_ST, UP_TS,
                     UP_ID, UV_TS, UV_ID, VF_TS, VF_ID, C_TS, C_ID, D_TS,
                     D_ID, M_TS, M_ID, M_ST,
                     PROJECTION, REFERENCE_NO, REMOVE_COMMENT, SOURCE_NO,
                     START_DATE, PROGRAM_LEVEL_ID, SESSION_ID, GRADUATE_CENTER_ID)
VALUES
  (nextval('SQ_IN_INTK'), '30085BE1-05D1-45EB-AC33-456CD50B7963', NULL, 'INTAKE FOR MASTERS 201720181', '2017-03-11 21:25:01.262000', NULL,
      NULL, NULL, NULL, NULL, NULL, '2017-03-11 21:25:01.264000', 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
    NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, '2017-03-11 21:25:01.264000', 5, NULL,
                                                             NULL, NULL, NULL, 1, 100,
   'MGSEB-201720181-MASTER',
    NULL,
   'MGSEB-MASTER-201720181', '2017-03-11 21:25:01.262000',
   (select ID from IN_PRGM_LEVL where code = 'MASTER'),
   (select ID from IN_INTK_SESN where code = '20052'),
   (select ID from IN_GRDT_CNTR where code = 'MGSEB')
  );


-- add study mode offering FULLTIME and PARTIME
INSERT INTO IN_STDY_MODE_OFRG (ID, INTAKE_ID, STUDY_MODE_ID, C_ID, C_TS, M_ST)
    VALUES (nextval('SQ_IN_STDY_MODE_OFRG'), currval('SQ_IN_INTK'),
            (select ID from IN_STDY_MODE where code = '1'),
            1, CURRENT_TIMESTAMP, 1 );

INSERT INTO IN_STDY_MODE_OFRG (ID, INTAKE_ID, STUDY_MODE_ID, C_ID, C_TS, M_ST)
    VALUES (nextval('SQ_IN_STDY_MODE_OFRG'), currval('SQ_IN_INTK'),
            (select ID from IN_STDY_MODE where code = '2'),
            1, CURRENT_TIMESTAMP, 1 );