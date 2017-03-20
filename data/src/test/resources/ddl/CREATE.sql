create table IN_ACTR (
  ID int8 not null,
  ACTOR_TYPE int4,
  EMAIL varchar(255),
  FAX varchar(255),
  IDENTITY_NO varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  MOBILE varchar(255),
  NAME varchar(255) not null,
  PHONE varchar(255),
  primary key (ID)
);

create table IN_ADDR (
  ID int8 not null,
  ADDRESS1 varchar(255) not null,
  ADDRESS2 varchar(255),
  ADDRESS3 varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  POSTCODE varchar(255),
  ADDRESS_TYPE int4,
  APPLICATION_ID int8,
  COUNTRY_CODE_ID int8,
  DUN_CODE_ID int8,
  PARLIAMENT_CODE_ID int8,
  STATE_CODE_ID int8,
  primary key (ID)
);

create table IN_APCN (
  ID int8 not null,
  primary key (ID)
);

create table IN_ATMT (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  NAME varchar(255) not null,
  URL varchar(255) not null,
  APPLICATION_ID int8,
  primary key (ID)
);

create table IN_AUDT (
  ID int8 not null,
  CLASS_NAME varchar(255) not null,
  MESSAGE varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  OBJECT_ID int8 not null,
  USER_ID int8 not null,
  primary key (ID)
);

create table IN_BANK_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  IBG_CODE varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  NAME varchar(255) not null,
  SWIFT_CODE varchar(255) not null,
  primary key (ID)
);

create table IN_CITY_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  STATE_CODE_ID int8,
  primary key (ID)
);

create table IN_CLGE_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  CAMPUS_ID int8 not null,
  primary key (ID)
);

create table IN_CMCY_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_CMPS_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_CNDT (
  ID int8 not null,
  EMAIL varchar(255) not null,
  IDENTITY_NO varchar(255) not null,
  MATRIC_NO varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  NAME varchar(255) not null,
  STATUS int4 not null,
  STUDY_MODE_ID bytea not null,
  APPLICANT_ID int8,
  OFFERING_ID int8,
  primary key (ID)
);

create table IN_CNFG (
  ID int8 not null,
  DESCRIPTION varchar(255),
  CONFIG_KEY varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  CONFIG_VALUE varchar(255),
  CONFIG_VALUE_BYTEA bytea,
  CONFIG_VALUE_DOUBLE float8,
  CONFIG_VALUE_LONG int8,
  primary key (ID)
);

create table IN_CNTC (
  ID int8 not null,
  IDENTITY_NO varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  NAME varchar(255) not null,
  SOMETHING varchar(255),
  CONTACT_TYPE int4,
  APPLICATION_ID int8,
  primary key (ID)
);

create table IN_CNTY_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_DBLY_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_DPCY_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_DSCT_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_DUN_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_EMAL_QUEU (
  ID int8 not null,
  EMAIL_BCC varchar(255),
  BODY text,
  EMAIL_CC varchar(255),
  CODE varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  QUEUE_STATUS int4,
  RETRY_COUNT int4,
  SUBJECT varchar(255),
  EMAIL_TO varchar(255),
  primary key (ID)
);

create table IN_EMIL_TMPT (
  ID int8 not null,
  BCC_ADDRESS varchar(255),
  CC_ADDRESS varchar(255),
  CODE varchar(255) not null,
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  SUBJECT varchar(255),
  TEMPLATE TEXT,
  TO_ADDRESS varchar(255),
  primary key (ID)
);

create table IN_EMPT (
  ID int8 not null,
  ACTIVE boolean not null,
  EMPLOYER varchar(255) not null,
  END_DATE timestamp not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  START_DATE timestamp not null,
  APPLICATION_ID int8,
  FIELD_CODE_ID int8,
  LEVEL_CODE_ID int8,
  SECTOR_CODE_ID int8,
  primary key (ID)
);

create table IN_EMPT_FILD_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_EMPT_LEVL_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_EMPT_SCTR_CODE (
  ID int8 not null,
  CODE varchar(2),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_ETNY_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_FCTY_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_FILD_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_GNDR_CODE (
  ID int8 not null,
  CODE varchar(1),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_GRDE_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  ORDINAL int4 not null,
  primary key (ID)
);

create table IN_GRDN (
  ID int8 not null,
  IDENTITY_NO varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  NAME varchar(255) not null,
  SALARY numeric(19, 2) not null,
  GUARDIAN_TYPE int4,
  APPLICATION_ID int8,
  primary key (ID)
);

create table IN_GROP (
  ID int8 not null,
  primary key (ID)
);

create table IN_GROP_MMBR (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  GROUP_ID int8,
  PRINCIPAL_ID int8,
  primary key (GROUP_ID, PRINCIPAL_ID)
);

create table IN_GRTR (
  ID int8 not null,
  IDENTITY_NO varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  NAME varchar(255) not null,
  GUARANTOR_TYPE int4,
  APPLICATION_ID int8,
  primary key (ID)
);

create table IN_INTK (
  ID int8 not null,
  AUDIT_NO varchar(255) not null,
  CANCEL_COMMENT varchar(255),
  DESCRIPTION varchar(255) not null,
  END_DATE timestamp not null,
  AV_TS timestamp,
  AV_ID int8,
  CL_ID int8,
  CL_TS timestamp,
  CK_TS timestamp,
  CK_ID int8,
  DT_TS timestamp,
  DT_ID int8,
  EV_TS timestamp,
  EV_ID int8,
  PR_TS timestamp,
  PR_ID int8,
  PS_TS timestamp,
  PS_ID int8,
  RG_TS timestamp,
  RG_ID int8,
  RM_TS timestamp,
  RM_ID int8,
  RQ_TS timestamp,
  RQ_ID int8,
  SL_TS timestamp,
  SL_ID int8,
  FD_ST int4,
  UP_TS timestamp,
  UP_ID int8,
  UV_TS timestamp,
  UV_ID int8,
  VF_TS timestamp,
  VF_ID int8,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  PROJECTION int4,
  REFERENCE_NO varchar(255) not null,
  REMOVE_COMMENT varchar(255),
  SOURCE_NO varchar(255) not null,
  START_DATE timestamp not null,
  LEVEL_ID int8 not null,
  SESSION_ID int8 not null,
  primary key (ID)
);

create table IN_INTK_APLN (
  ID int8 not null,
  ACCOUNT_NO varchar(255),
  AGE int4,
  BATCH_NO varchar(255),
  BID_RESPONSE int4,
  BID_STATUS int4,
  BID_TYPE int4 not null,
  CREDENTIAL_NO varchar(255),
  EMAIL varchar(255) not null,
  FAX varchar(255),
  MERIT numeric(19, 2) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  NAME varchar(255) not null,
  OKU_NO varchar(255),
  PAID boolean,
  PAYMENT_SOURCE_NO varchar(255),
  PHONE varchar(255),
  RANK int4 not null,
  REASON varchar(255),
  REFERENCE_NO varchar(255) not null,
  SCHOOL_BATCH int4,
  SCHOOL_NAME varchar(255),
  APPLICANT_ID int8,
  BANK_CODE_ID int8,
  DEPENDENCY_CODE_ID int8,
  DISABILITY_CODE_ID int8,
  ETHNICITY_CODE_ID int8,
  GENDER_CODE_ID int8,
  INTAKE_ID int8,
  MARITAL_CODE_ID int8,
  NATIONALITY_CODE_ID int8,
  RACE_CODE_ID int8,
  RELIGION_CODE_ID int8,
  RESIDENCY_CODE_ID int8,
  SCHOOL_CODE_ID int8,
  SELECTION_ID int8,
  STUDY_MODE_ID int8,
  primary key (ID)
);

create table IN_INTK_SESN (
  ID int8 not null,
  CODE varchar(255) not null,
  CURRENT_ boolean not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_INVT (
  ID int8 not null,
  END_DATE timestamp not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  START_DATE timestamp not null,
  APPLICATION_ID int8,
  LEVEL_CODE_ID int8,
  TITLE_CODE_ID int8,
  TYPE_CODE_ID int8,
  primary key (ID)
);

create table IN_INVT_LEVL_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  TYPE_CODE_ID int8,
  primary key (ID)
);

create table IN_INVT_TTLE_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_INVT_TYPE_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_MODL (
  ID int8 not null,
  CANONICAL_CODE varchar(255) not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255),
  ENABLED boolean,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  ORDINAL int4 not null,
  primary key (ID)
);

create table IN_MRTL_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_NTLY_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_PCPL (
  ID int8 not null,
  ENABLED boolean not null,
  LOCKED boolean not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  NAME varchar(255) not null,
  PRINCIPAL_TYPE int4,
  primary key (ID)
);

create table IN_PCPL_ROLE (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  ROLE_TYPE int4,
  PRINCIPAL_ID int8,
  primary key (ID)
);

create table IN_PLMT_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_PRGM_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_PRGM_LEVL (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_PRGM_OFRG (
  ID int8 not null,
  GENERAL_CRITERIA varchar(255),
  INTERVIEW boolean not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  PROJECTION int4,
  SPECIFIC_CRITERIA varchar(255),
  INTAKE_ID int8,
  PROGRAM_CODE_ID int8,
  STUDY_CENTER_CODE_ID int8,
  primary key (ID)
);

create table IN_RACE_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_RFRN_NO (
  ID int8 not null,
  CODE varchar(255) not null,
  CURRENT_VALUE int4,
  DESCRIPTION varchar(255) not null,
  INCREMENT_VALUE int4,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  PREFIX varchar(255),
  REFERENCE_FORMAT varchar(255),
  SEQUENCE_FORMAT varchar(255),
  primary key (ID)
);

create table IN_RLGN_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_RSCY_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_SBJT_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_SCHL_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_SMDL (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  ENABLED boolean,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  ORDINAL int4,
  MODULE_ID int8,
  primary key (ID)
);

create table IN_STAF (
  ID int8 not null,
  primary key (ID)
);

create table IN_STDY_CNTR_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_STDY_MODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_STDY_MODE_OFRG (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  INTAKE_ID int8,
  STUDY_MODE_ID int8,
  primary key (ID)
);

create table IN_STTE_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  COUNTRY_CODE_ID int8,
  primary key (ID)
);

create table IN_USER (
  EMAIL varchar(255) not null,
  PASSWORD varchar(255),
  REAL_NAME varchar(255) not null,
  TIPU_NAME varchar(255),
  ID int8 not null,
  ACTOR_ID int8,
  primary key (ID)
);

create table IN_VENU_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table IN_WTCH (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  OBJECT_CLASS varchar(255) not null,
  OBJECT_ID int8 not null,
  USER_ID int8 not null,
  primary key (ID)
);

alter table IN_ACTR
  add constraint uc_IN_ACTR_1 unique (IDENTITY_NO);

alter table IN_ADDR
  add constraint FKA01A32CB37A6AAA6
foreign key (APPLICATION_ID)
references IN_INTK_APLN;

alter table IN_ADDR
  add constraint FKA01A32CB62D8843A
foreign key (COUNTRY_CODE_ID)
references IN_CNTY_CODE;

alter table IN_ADDR
  add constraint FKA01A32CB6AB11488
foreign key (DUN_CODE_ID)
references IN_DUN_CODE;

alter table IN_ADDR
  add constraint FKA01A32CBED786CA
foreign key (PARLIAMENT_CODE_ID)
references IN_PLMT_CODE;

alter table IN_ADDR
  add constraint FKA01A32CBAA50E0F0
foreign key (STATE_CODE_ID)
references IN_STTE_CODE;

alter table IN_APCN
  add constraint FKA01A5FB4AB3274F6
foreign key (ID)
references IN_ACTR;

alter table IN_ATMT
  add constraint FKA01A6FF437A6AAA6
foreign key (APPLICATION_ID)
references IN_INTK_APLN;

alter table IN_BANK_CODE
  add constraint uc_IN_BANK_CODE_1 unique (CODE);

alter table IN_BANK_CODE
  add constraint uc_IN_BANK_CODE_2 unique (IBG_CODE);

alter table IN_BANK_CODE
  add constraint uc_IN_BANK_CODE_3 unique (SWIFT_CODE);

alter table IN_CITY_CODE
  add constraint uc_IN_CITY_CODE_1 unique (CODE);

alter table IN_CITY_CODE
  add constraint FK9C7B91A7AA50E0F0
foreign key (STATE_CODE_ID)
references IN_STTE_CODE;

alter table IN_CLGE_CODE
  add constraint uc_IN_CLGE_CODE_1 unique (CODE);

alter table IN_CLGE_CODE
  add constraint FK24D298B3354D5F4
foreign key (CAMPUS_ID)
references IN_CMPS_CODE;

alter table IN_CMCY_CODE
  add constraint uc_IN_CMCY_CODE_1 unique (CODE);

alter table IN_CMPS_CODE
  add constraint uc_IN_CMPS_CODE_1 unique (CODE);

alter table IN_CNDT
  add constraint FKA01B4115BDADE6E0
foreign key (APPLICANT_ID)
references IN_APCN;

alter table IN_CNDT
  add constraint FKA01B4115E4CD51E5
foreign key (OFFERING_ID)
references IN_STTE_CODE;

alter table IN_CNTC
  add constraint FKA01B42F437A6AAA6
foreign key (APPLICATION_ID)
references IN_INTK_APLN;

alter table IN_CNTY_CODE
  add constraint uc_IN_CNTY_CODE_1 unique (CODE);

alter table IN_DBLY_CODE
  add constraint uc_IN_DBLY_CODE_1 unique (CODE);

alter table IN_DPCY_CODE
  add constraint uc_IN_DPCY_CODE_1 unique (CODE);

alter table IN_DSCT_CODE
  add constraint uc_IN_DSCT_CODE_1 unique (CODE);

alter table IN_DUN_CODE
  add constraint uc_IN_DUN_CODE_1 unique (CODE);

alter table IN_EMAL_QUEU
  add constraint uc_IN_EMAL_QUEU_1 unique (CODE);

alter table IN_EMIL_TMPT
  add constraint uc_IN_EMIL_TMPT_1 unique (CODE);

alter table IN_EMPT
  add constraint FKA01C278637A6AAA6
foreign key (APPLICATION_ID)
references IN_INTK_APLN;

alter table IN_EMPT
  add constraint FKA01C27869429776
foreign key (FIELD_CODE_ID)
references IN_EMPT_FILD_CODE;

alter table IN_EMPT
  add constraint FKA01C2786A87C388A
foreign key (LEVEL_CODE_ID)
references IN_EMPT_LEVL_CODE;

alter table IN_EMPT
  add constraint FKA01C2786665804A0
foreign key (SECTOR_CODE_ID)
references IN_EMPT_SCTR_CODE;

alter table IN_EMPT_FILD_CODE
  add constraint uc_IN_EMPT_FILD_CODE_1 unique (CODE);

alter table IN_EMPT_LEVL_CODE
  add constraint uc_IN_EMPT_LEVL_CODE_1 unique (CODE);

alter table IN_EMPT_SCTR_CODE
  add constraint uc_IN_EMPT_SCTR_CODE_1 unique (CODE);

alter table IN_ETNY_CODE
  add constraint uc_IN_ETNY_CODE_1 unique (CODE);

alter table IN_FCTY_CODE
  add constraint uc_IN_FCTY_CODE_1 unique (CODE);

alter table IN_FILD_CODE
  add constraint uc_IN_FILD_CODE_1 unique (CODE);

alter table IN_GNDR_CODE
  add constraint uc_IN_GNDR_CODE_1 unique (CODE);

alter table IN_GRDE_CODE
  add constraint uc_IN_GRDE_CODE_1 unique (CODE);

alter table IN_GRDE_CODE
  add constraint uc_IN_GRDE_CODE_2 unique (ORDINAL);

alter table IN_GRDN
  add constraint FKA01D218F37A6AAA6
foreign key (APPLICATION_ID)
references IN_INTK_APLN;

alter table IN_GROP
  add constraint FKA01D22E65E0DF3AF
foreign key (ID)
references IN_PCPL;

alter table IN_GROP_MMBR
  add constraint FK7CA19FA95ACED640
foreign key (GROUP_ID)
references IN_GROP;

alter table IN_GROP_MMBR
  add constraint FK7CA19FA9944FD160
foreign key (PRINCIPAL_ID)
references IN_PCPL;

alter table IN_GRTR
  add constraint FKA01D238337A6AAA6
foreign key (APPLICATION_ID)
references IN_INTK_APLN;

alter table IN_INTK
  add constraint uc_IN_INTK_1 unique (AUDIT_NO);

alter table IN_INTK
  add constraint uc_IN_INTK_2 unique (CANCEL_COMMENT);

alter table IN_INTK
  add constraint uc_IN_INTK_3 unique (DESCRIPTION);

alter table IN_INTK
  add constraint uc_IN_INTK_4 unique (REFERENCE_NO);

alter table IN_INTK
  add constraint uc_IN_INTK_5 unique (REMOVE_COMMENT);

alter table IN_INTK
  add constraint uc_IN_INTK_6 unique (SOURCE_NO);

alter table IN_INTK
  add constraint FKA01DFD3632D87A7C
foreign key (LEVEL_ID)
references IN_PRGM_LEVL;

alter table IN_INTK
  add constraint FKA01DFD36BD0FD208
foreign key (SESSION_ID)
references IN_INTK_SESN;

alter table IN_INTK_APLN
  add constraint uc_IN_INTK_APLN_1 unique (REFERENCE_NO);

alter table IN_INTK_APLN
  add constraint FK5974F5ABDADE6E0
foreign key (APPLICANT_ID)
references IN_APCN;

alter table IN_INTK_APLN
  add constraint FK5974F5AA35FEC0
foreign key (BANK_CODE_ID)
references IN_BANK_CODE;

alter table IN_INTK_APLN
  add constraint FK5974F5AE944DD1E
foreign key (DEPENDENCY_CODE_ID)
references IN_DPCY_CODE;

alter table IN_INTK_APLN
  add constraint FK5974F5A1A001E40
foreign key (DISABILITY_CODE_ID)
references IN_DBLY_CODE;

alter table IN_INTK_APLN
  add constraint FK5974F5A8BB6434C
foreign key (ETHNICITY_CODE_ID)
references IN_ETNY_CODE;

alter table IN_INTK_APLN
  add constraint FK5974F5A481F1E8A
foreign key (GENDER_CODE_ID)
references IN_GNDR_CODE;

alter table IN_INTK_APLN
  add constraint FK5974F5A3AD22420
foreign key (INTAKE_ID)
references IN_INTK;

alter table IN_INTK_APLN
  add constraint FK5974F5A4F03DAF6
foreign key (MARITAL_CODE_ID)
references IN_MRTL_CODE;

alter table IN_INTK_APLN
  add constraint FK5974F5AACBE2306
foreign key (NATIONALITY_CODE_ID)
references IN_NTLY_CODE;

alter table IN_INTK_APLN
  add constraint FK5974F5AEE5BDEA
foreign key (RACE_CODE_ID)
references IN_RACE_CODE;

alter table IN_INTK_APLN
  add constraint FK5974F5AD47AB42A
foreign key (RELIGION_CODE_ID)
references IN_RLGN_CODE;

alter table IN_INTK_APLN
  add constraint FK5974F5A60E65A82
foreign key (RESIDENCY_CODE_ID)
references IN_RSCY_CODE;

alter table IN_INTK_APLN
  add constraint FK5974F5A4CB929F0
foreign key (SCHOOL_CODE_ID)
references IN_SCHL_CODE;

alter table IN_INTK_APLN
  add constraint FK5974F5A8B4C0DB2
foreign key (SELECTION_ID)
references IN_PRGM_OFRG;

alter table IN_INTK_APLN
  add constraint FK5974F5AAF5A14A0
foreign key (STUDY_MODE_ID)
references IN_STDY_MODE;

alter table IN_INTK_SESN
  add constraint uc_IN_INTK_SESN_1 unique (CODE);

alter table IN_INVT
  add constraint FKA01DFD7D37A6AAA6
foreign key (APPLICATION_ID)
references IN_INTK_APLN;

alter table IN_INVT
  add constraint FKA01DFD7D703951F5
foreign key (LEVEL_CODE_ID)
references IN_INVT_LEVL_CODE;

alter table IN_INVT
  add constraint FKA01DFD7D82AA379D
foreign key (TITLE_CODE_ID)
references IN_INVT_TTLE_CODE;

alter table IN_INVT
  add constraint FKA01DFD7DACA22BBD
foreign key (TYPE_CODE_ID)
references IN_INVT_TYPE_CODE;

alter table IN_INVT_LEVL_CODE
  add constraint uc_IN_INVT_LEVL_CODE_1 unique (CODE);

alter table IN_INVT_LEVL_CODE
  add constraint FK8FD6A1FBACA22BBD
foreign key (TYPE_CODE_ID)
references IN_INVT_TYPE_CODE;

alter table IN_INVT_TTLE_CODE
  add constraint uc_IN_INVT_TTLE_CODE_1 unique (CODE);

alter table IN_INVT_TYPE_CODE
  add constraint uc_IN_INVT_TYPE_CODE_1 unique (CODE);

alter table IN_MODL
  add constraint uc_IN_MODL_1 unique (CANONICAL_CODE);

alter table IN_MODL
  add constraint uc_IN_MODL_2 unique (CODE);

alter table IN_MRTL_CODE
  add constraint uc_IN_MRTL_CODE_1 unique (CODE);

alter table IN_NTLY_CODE
  add constraint uc_IN_NTLY_CODE_1 unique (CODE);

alter table IN_PCPL
  add constraint uc_IN_PCPL_1 unique (NAME);

alter table IN_PCPL_ROLE
  add constraint FKCAED0CEC944FD160
foreign key (PRINCIPAL_ID)
references IN_PCPL;

alter table IN_PLMT_CODE
  add constraint uc_IN_PLMT_CODE_1 unique (CODE);

alter table IN_PRGM_CODE
  add constraint uc_IN_PRGM_CODE_1 unique (CODE);

alter table IN_PRGM_LEVL
  add constraint uc_IN_PRGM_LEVL_1 unique (CODE);

alter table IN_PRGM_OFRG
  add constraint FK6B9F3293AD22420
foreign key (INTAKE_ID)
references IN_INTK;

alter table IN_PRGM_OFRG
  add constraint FK6B9F32988BA7616
foreign key (PROGRAM_CODE_ID)
references IN_PRGM_CODE;

alter table IN_PRGM_OFRG
  add constraint FK6B9F3295C8D6997
foreign key (STUDY_CENTER_CODE_ID)
references IN_STDY_CNTR_CODE;

alter table IN_RACE_CODE
  add constraint uc_IN_RACE_CODE_1 unique (CODE);

alter table IN_RFRN_NO
  add constraint uc_IN_RFRN_NO_1 unique (CODE);

alter table IN_RLGN_CODE
  add constraint uc_IN_RLGN_CODE_1 unique (CODE);

alter table IN_RSCY_CODE
  add constraint uc_IN_RSCY_CODE_1 unique (CODE);

alter table IN_SBJT_CODE
  add constraint uc_IN_SBJT_CODE_1 unique (CODE);

alter table IN_SCHL_CODE
  add constraint uc_IN_SCHL_CODE_1 unique (CODE);

alter table IN_SMDL
  add constraint FKA022833C43EFCC03
foreign key (MODULE_ID)
references IN_MODL;

alter table IN_STAF
  add constraint FKA0229D20AB3274F6
foreign key (ID)
references IN_ACTR;

alter table IN_STDY_CNTR_CODE
  add constraint uc_IN_STDY_CNTR_CODE_1 unique (CODE);

alter table IN_STDY_MODE
  add constraint uc_IN_STDY_MODE_1 unique (CODE);

alter table IN_STDY_MODE_OFRG
  add constraint FK367FF3793AD22420
foreign key (INTAKE_ID)
references IN_INTK;

alter table IN_STDY_MODE_OFRG
  add constraint FK367FF379AF5A14A0
foreign key (STUDY_MODE_ID)
references IN_STDY_MODE;

alter table IN_STTE_CODE
  add constraint uc_IN_STTE_CODE_1 unique (CODE);

alter table IN_STTE_CODE
  add constraint FK354E82E062D8843A
foreign key (COUNTRY_CODE_ID)
references IN_CNTY_CODE;

alter table IN_USER
  add constraint uc_IN_USER_1 unique (EMAIL);

alter table IN_USER
  add constraint FKA02382A548D0EF80
foreign key (ACTOR_ID)
references IN_ACTR;

alter table IN_USER
  add constraint FKA02382A55E0DF3AF
foreign key (ID)
references IN_PCPL;

alter table IN_VENU_CODE
  add constraint uc_IN_VENU_CODE_1 unique (CODE);

create sequence SQ_IN_ACTR;

create sequence SQ_IN_ADDR;

create sequence SQ_IN_ATMT;

create sequence SQ_IN_AUDT;

create sequence SQ_IN_BANK_CODE;

create sequence SQ_IN_CITY_CODE;

create sequence SQ_IN_CLGE_CODE;

create sequence SQ_IN_CMCY_CODE;

create sequence SQ_IN_CMPS_CODE;

create sequence SQ_IN_CNDT;

create sequence SQ_IN_CNFG;

create sequence SQ_IN_CNTC;

create sequence SQ_IN_CNTY_CODE;

create sequence SQ_IN_DBLY_CODE;

create sequence SQ_IN_DPCY_CODE;

create sequence SQ_IN_DSCT_CODE;

create sequence SQ_IN_DUN_CODE;

create sequence SQ_IN_EMAL_QUEU;

create sequence SQ_IN_EMIL_TMPT;

create sequence SQ_IN_EMPT;

create sequence SQ_IN_EMPT_FILD_CODE;

create sequence SQ_IN_EMPT_LEVL_CODE;

create sequence SQ_IN_EMPT_SCTR_CODE;

create sequence SQ_IN_ETNY_CODE;

create sequence SQ_IN_FCTY_CODE;

create sequence SQ_IN_FILD_CODE;

create sequence SQ_IN_GNDR_CODE;

create sequence SQ_IN_GRDE_CODE;

create sequence SQ_IN_GRDN;

create sequence SQ_IN_GROP_MMBR;

create sequence SQ_IN_GRTR;

create sequence SQ_IN_INTK;

create sequence SQ_IN_INTK_APLN;

create sequence SQ_IN_INTK_SESN;

create sequence SQ_IN_INVT;

create sequence SQ_IN_INVT_LEVL_CODE;

create sequence SQ_IN_INVT_TTLE_CODE;

create sequence SQ_IN_INVT_TYPE_CODE;

create sequence SQ_IN_MODL;

create sequence SQ_IN_MRTL_CODE;

create sequence SQ_IN_NTLY_CODE;

create sequence SQ_IN_PCPL;

create sequence SQ_IN_PCPL_ROLE;

create sequence SQ_IN_PLMT_CODE;

create sequence SQ_IN_PRGM_CODE;

create sequence SQ_IN_PRGM_LEVL;

create sequence SQ_IN_PRGM_OFRG;

create sequence SQ_IN_RACE_CODE;

create sequence SQ_IN_RFRN_NO;

create sequence SQ_IN_RLGN_CODE;

create sequence SQ_IN_RSCY_CODE;

create sequence SQ_IN_SBJT_CODE;

create sequence SQ_IN_SCHL_CODE;

create sequence SQ_IN_SMDL;

create sequence SQ_IN_STDY_CNTR_CODE;

create sequence SQ_IN_STDY_MODE;

create sequence SQ_IN_STDY_MODE_OFRG;

create sequence SQ_IN_STTE_CODE;

create sequence SQ_IN_VENU_CODE;

create sequence SQ_IN_WTCH;
