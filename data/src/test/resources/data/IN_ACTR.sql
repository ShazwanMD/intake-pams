-- applicant1
INSERT INTO IN_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_IN_ACTR'), '760607145591', 'APPLICANT ONE', 'applicant1@gmail.com', NULL, NULL, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO IN_APCN (ID) VALUES (currval('SQ_IN_ACTR'));

UPDATE in_user
SET actor_id = currval('SQ_IN_ACTR')
WHERE email = 'applicant1@gmail.com';


-- applicant2
INSERT INTO IN_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_IN_ACTR'), '860607145592', 'APPLICANT TWO', 'applicant2@gmail.com', NULL, NULL, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO IN_APCN (ID) VALUES (currval('SQ_IN_ACTR'));

UPDATE in_user
SET actor_id = currval('SQ_IN_ACTR')
WHERE email = 'applicant2@gmail.com';

