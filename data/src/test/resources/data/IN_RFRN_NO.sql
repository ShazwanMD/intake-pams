INSERT INTO IN_RFRN_NO (ID, CODE, CURRENT_VALUE, DESCRIPTION, INCREMENT_VALUE, PREFIX, REFERENCE_FORMAT, SEQUENCE_FORMAT, M_ST, C_ID, C_TS )
VALUES (nextval('SQ_IN_RFRN_NO'), 'InIntake.referenceNo', 1, 'Intake Reference No Format', 1, 'IN', '{#graduateCenter.getCode()}-{#programLevel.getCode()}-{#j}', '000', 1, 0, CURRENT_TIMESTAMP );

INSERT INTO IN_RFRN_NO (ID, CODE, CURRENT_VALUE, DESCRIPTION, INCREMENT_VALUE, PREFIX, REFERENCE_FORMAT, SEQUENCE_FORMAT, M_ST, C_ID, C_TS )
VALUES (nextval('SQ_IN_RFRN_NO'), 'InIntakeApplication.referenceNo', 1, 'Intake Application Reference No Format', 1, 'IAPP', '{#intakeSession.getCode()}-{#programLevel.getCode()}-{#j}', '000', 1, 0, CURRENT_TIMESTAMP );

INSERT INTO IN_RFRN_NO (ID, CODE, CURRENT_VALUE, DESCRIPTION, INCREMENT_VALUE, PREFIX, REFERENCE_FORMAT, SEQUENCE_FORMAT, M_ST, C_ID, C_TS )
VALUES (nextval('SQ_IN_RFRN_NO'), 'InCandidate.matricNo', 1, 'Candidate Matric No', 1, '', '{#facultyCode.getPrefix()}{#intakeSession.getYear().toString().substring(2,4)}{#programLevel.getPrefix()}{#j}{#studyMode.getPrefix()}', '0000', 1, 0, CURRENT_TIMESTAMP );
