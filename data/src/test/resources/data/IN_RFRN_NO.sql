INSERT INTO IN_RFRN_NO (ID, CODE, CURRENT_VALUE, DESCRIPTION, INCREMENT_VALUE, PREFIX, REFERENCE_FORMAT, SEQUENCE_FORMAT, M_ST, C_ID, C_TS )
VALUES (nextval('SQ_IN_RFRN_NO'), 'InIntake.referenceNo', 1, 'Intake Reference No Format', 1, 'IN', '{#intakeSession.getCode()}/{#intakeLevel.getCode()}/{#j}', '000', 1, 0, CURRENT_TIMESTAMP );

INSERT INTO IN_RFRN_NO (ID, CODE, CURRENT_VALUE, DESCRIPTION, INCREMENT_VALUE, PREFIX, REFERENCE_FORMAT, SEQUENCE_FORMAT, M_ST, C_ID, C_TS )
VALUES (nextval('SQ_IN_RFRN_NO'), 'InIntakeApplication.referenceNo', 1, 'Intake Application Reference No Format', 1, 'IAPP', '{#intakeSession.getCode()}/{#intakeLevel.getCode()}/{#j}', '000', 1, 0, CURRENT_TIMESTAMP );
