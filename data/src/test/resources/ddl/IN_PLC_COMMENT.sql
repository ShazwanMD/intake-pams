-- =============================================================================================
--IN_INTK_SESN
-- =============================================================================================
COMMENT ON TABLE IN_INTK_SESN IS 'Represent Intake Session';
COMMENT ON COLUMN IN_INTK_SESN.ID IS 'Intake Session primary key';
COMMENT ON COLUMN IN_INTK_SESN.YEAR IS 'Session Year';
COMMENT ON COLUMN IN_INTK_SESN.CODE IS 'Intake session code';
COMMENT ON COLUMN IN_INTK_SESN.CURRENT_ IS 'Current flag';
COMMENT ON COLUMN IN_INTK_SESN.DESCRIPTION IS 'Description';
COMMENT ON COLUMN IN_INTK_SESN.START_DATE IS 'Start Date';
COMMENT ON COLUMN IN_INTK_SESN.END_DATE IS 'End Date';

-- STANDARD METADATA COLUMN
COMMENT ON COLUMN IN_INTK_SESN.M_ST IS 'Object Status';
COMMENT ON COLUMN IN_INTK_SESN.C_ID IS 'Creator Id';
COMMENT ON COLUMN IN_INTK_SESN.C_TS IS 'Created Timestamp';
COMMENT ON COLUMN IN_INTK_SESN.M_ID IS 'Updated Id';
COMMENT ON COLUMN IN_INTK_SESN.M_TS IS 'Updated Timestamp';
COMMENT ON COLUMN IN_INTK_SESN.D_ID IS 'Deleted Id';
COMMENT ON COLUMN IN_INTK_SESN.D_TS IS 'Deleted Timestamp';
-- =============================================================================================
--END OF IN_INTK_SESN--
-- =============================================================================================