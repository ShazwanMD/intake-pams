INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MCK', 'SARJANA SAINS KEMANUSIAAN (KERJA SOSIAL)',
        'MASTER IN HUMANITY SCIENCE (SOCIAL WORK)', (SELECT ID
                                                     FROM IN_GRDT_CNTR
                                                     WHERE CODE = 'CPS'), (SELECT ID
                                                                             FROM IN_FCTY_CODE
                                                                             WHERE CODE = 'A04'), (SELECT ID
                                                                                                   FROM IN_PRGM_LEVL
                                                                                                   WHERE
                                                                                                     CODE = 'MASTER'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MCN', 'SARJANA SAINS KEMANUSIAAN (PEMBANGUNAN DAN PENDIDIKAN NILAI)',
        'MASTER IN HUMANITY SCIENCE (DEVELOPMENT AND EDUCATIONAL VALUES)', (SELECT ID
                                                                            FROM IN_GRDT_CNTR
                                                                            WHERE CODE = 'CPS'), (SELECT ID
                                                                                                    FROM IN_FCTY_CODE
                                                                                                    WHERE CODE = 'A04'),
        (SELECT ID
         FROM IN_PRGM_LEVL
         WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MCO', 'SARJANA SAINS KEMANUSIAAN (PSIKOLOGI INDUSTRI ORGANISASI)',
        'MASTER IN HUMANITY SCIENCE (INDUSTRIAL PYSCHOLOGICAL ORGANIZATION)', (SELECT ID
                                                                               FROM IN_GRDT_CNTR
                                                                               WHERE CODE = 'CPS'), (SELECT ID
                                                                                                       FROM IN_FCTY_CODE
                                                                                                       WHERE
                                                                                                         CODE = 'A04'),
        (SELECT ID
         FROM IN_PRGM_LEVL
         WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MCS', 'SARJANA SAINS KEMANUSIAAN (PENGAJIAN SEJARAH DAN PERADABAN)',
        'MASTER IN HUMANITY SCIENCE (STUDIES OF HISTORY AND CIVILIZATION)', (SELECT ID
                                                                             FROM IN_GRDT_CNTR
                                                                             WHERE CODE = 'CPS'), (SELECT ID
                                                                                                     FROM IN_FCTY_CODE
                                                                                                     WHERE
                                                                                                       CODE = 'A04'),
        (SELECT ID
         FROM IN_PRGM_LEVL
         WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PCA', 'DOKTOR FALSAFAH (AGAMA DAN KONTEMPORARI)',
        'DOCTOR OF PHILOSOPHY  (RELIGION AND CONTEMPORARY)', (SELECT ID
                                                              FROM IN_GRDT_CNTR
                                                              WHERE CODE = 'CPS'), (SELECT ID
                                                                                      FROM IN_FCTY_CODE
                                                                                      WHERE CODE = 'A02'), (SELECT ID
                                                                                                            FROM
                                                                                                              IN_PRGM_LEVL
                                                                                                            WHERE CODE =
                                                                                                                  'PHD'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'PCK', 'DOKTOR FALSAFAH (KERJA SOSIAL)', 'DOCTOR OF PHILOSOPHY (SOCIAL WORK)', (SELECT ID
                                                                                                               FROM
                                                                                                                 IN_GRDT_CNTR
                                                                                                               WHERE
                                                                                                                 CODE =
                                                                                                                 'CPS'),
   (SELECT ID
    FROM IN_FCTY_CODE
    WHERE CODE = 'A02'), (SELECT ID
                          FROM IN_PRGM_LEVL
                          WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PCN', 'DOKTOR FALSAFAH (PEMBANGUNAN DAN PENDIDIKAN NILAI)',
        'DOCTOR OF PHILOSOPHY  (DEVELOPMENT AND EDUCATIONAL VALUES)', (SELECT ID
                                                                       FROM IN_GRDT_CNTR
                                                                       WHERE CODE = 'CPS'), (SELECT ID
                                                                                               FROM IN_FCTY_CODE
                                                                                               WHERE CODE = 'A02'),
        (SELECT ID
         FROM IN_PRGM_LEVL
         WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PCO', 'DOKTOR FALSAFAH (PSIKOLOGI INDUSTRI ORGANISASI)',
        'DOCTOR OF PHILOSOPHY (INDUSTRIAL PYSCHOLOGICAL ORGANIZATION)', (SELECT ID
                                                                         FROM IN_GRDT_CNTR
                                                                         WHERE CODE = 'CPS'), (SELECT ID
                                                                                                 FROM IN_FCTY_CODE
                                                                                                 WHERE CODE = 'A02'),
        (SELECT ID
         FROM IN_PRGM_LEVL
         WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PCS', 'DOKTOR FALSAFAH (PENGAJIAN SEJARAH DAN PERADABAN)',
        'DOCTOR OF PHILOSOPHY (STUDIES OF HISTORY AND CIVILIZATION)', (SELECT ID
                                                                       FROM IN_GRDT_CNTR
                                                                       WHERE CODE = 'CPS'), (SELECT ID
                                                                                               FROM IN_FCTY_CODE
                                                                                               WHERE CODE = 'A02'),
        (SELECT ID
         FROM IN_PRGM_LEVL
         WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'MAA', 'SARJANA KEUSAHAWANAN (PERAKAUNAN)', 'MASTER OF ENTREPRENEURSHIP (ACCOUNTING)',
   (SELECT ID
    FROM IN_GRDT_CNTR
    WHERE CODE = 'CPS'), (SELECT ID
                            FROM IN_FCTY_CODE
                            WHERE CODE = 'A01'), (SELECT ID
                                                  FROM IN_PRGM_LEVL
                                                  WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MAF', 'SARJANA KEUSAHAWANAN (KEWANGAN)', 'MASTER OF ENTREPRENEURSHIP (FINANCE)',
        (SELECT ID
         FROM IN_GRDT_CNTR
         WHERE CODE = 'CPS'), (SELECT ID
                                 FROM IN_FCTY_CODE
                                 WHERE CODE = 'A01'), (SELECT ID
                                                       FROM IN_PRGM_LEVL
                                                       WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'MAH', 'SARJANA KEUSAHAWANAN (HOSPITALITI)', 'MASTER OF ENTREPRENEURSHIP (HOSPITALITY)',
   (SELECT ID
    FROM IN_GRDT_CNTR
    WHERE CODE = 'CPS'), (SELECT ID
                            FROM IN_FCTY_CODE
                            WHERE CODE = 'A01'), (SELECT ID
                                                  FROM IN_PRGM_LEVL
                                                  WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'MAK', 'SARJANA KEUSAHAWANAN (PERDAGANGAN)', 'MASTER OF ENTREPRENEURSHIP (COMMERCE)',
   (SELECT ID
    FROM IN_GRDT_CNTR
    WHERE CODE = 'CPS'), (SELECT ID
                            FROM IN_FCTY_CODE
                            WHERE CODE = 'A01'), (SELECT ID
                                                  FROM IN_PRGM_LEVL
                                                  WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'MAM', 'SARJANA KEUSAHAWANAN (PENGURUSAN)', 'MASTER OF ENTREPRENEURSHIP (MANAGEMENT)',
   (SELECT ID
    FROM IN_GRDT_CNTR
    WHERE CODE = 'CPS'), (SELECT ID
                            FROM IN_FCTY_CODE
                            WHERE CODE = 'A01'), (SELECT ID
                                                  FROM IN_PRGM_LEVL
                                                  WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MAP', 'SARJANA KEUSAHAWANAN (PELANCONGAN)', 'MASTER OF ENTREPRENEURSHIP (TOURISM)',
        (SELECT ID
         FROM IN_GRDT_CNTR
         WHERE CODE = 'CPS'), (SELECT ID
                                 FROM IN_FCTY_CODE
                                 WHERE CODE = 'A01'), (SELECT ID
                                                       FROM IN_PRGM_LEVL
                                                       WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'MAR', 'SARJANA KEUSAHAWANAN (PERUNCITAN)', 'MASTER OF ENTREPRENEURSHIP (RETAILING)',
   (SELECT ID
    FROM IN_GRDT_CNTR
    WHERE CODE = 'CPS'), (SELECT ID
                            FROM IN_FCTY_CODE
                            WHERE CODE = 'A01'), (SELECT ID
                                                  FROM IN_PRGM_LEVL
                                                  WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MAW', 'SARJANA KEUSAHAWANAN (KEUSAHAWANAN KESIHATAN)',
        'MASTER OF ENTREPRENEURSHIP (HEALTH ENTREPRENEURSHIP)', (SELECT ID
                                                                 FROM IN_GRDT_CNTR
                                                                 WHERE CODE = 'CPS'), (SELECT ID
                                                                                         FROM IN_FCTY_CODE
                                                                                         WHERE CODE = 'A01'), (SELECT ID
                                                                                                               FROM
                                                                                                                 IN_PRGM_LEVL
                                                                                                               WHERE
                                                                                                                 CODE =
                                                                                                                 'MASTER'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'PAA', 'DOKTOR FALSAFAH (PERAKAUNAN)', 'DOCTOR OF PHILOSOPHY (ACCOUNTING)',
   (SELECT ID
    FROM IN_GRDT_CNTR
    WHERE CODE = 'CPS'), (SELECT ID
                            FROM IN_FCTY_CODE
                            WHERE CODE = 'A01'), (SELECT ID
                                                  FROM IN_PRGM_LEVL
                                                  WHERE CODE = 'PHD'), 1, 0,
   CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PAF', 'DOKTOR FALSAFAH (KEWANGAN)', 'DOCTOR OF PHILOSOPHY (FINANCE)', (SELECT ID
                                                                                                            FROM
                                                                                                              IN_GRDT_CNTR
                                                                                                            WHERE CODE =
                                                                                                                  'CPS'),
        (SELECT ID
         FROM IN_FCTY_CODE
         WHERE CODE = 'A01'), (SELECT ID
                               FROM IN_PRGM_LEVL
                               WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'PAH', 'DOKTOR FALSAFAH (HOSPITALITI)', 'DOCTOR OF PHILOSOPHY (HOSPITALITY)', (SELECT ID
                                                                                                              FROM
                                                                                                                IN_GRDT_CNTR
                                                                                                              WHERE
                                                                                                                CODE =
                                                                                                                'CPS'),
   (SELECT ID
    FROM IN_FCTY_CODE
    WHERE CODE = 'A01'), (SELECT ID
                          FROM IN_PRGM_LEVL
                          WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'PAK', 'DOKTOR FALSAFAH (PERDAGANGAN)', 'DOCTOR OF PHILOSOPHY (COMMERCE)', (SELECT ID
                                                                                                           FROM
                                                                                                             IN_GRDT_CNTR
                                                                                                           WHERE CODE =
                                                                                                                 'CPS'),
   (SELECT ID
    FROM IN_FCTY_CODE
    WHERE CODE = 'A01'), (SELECT ID
                          FROM IN_PRGM_LEVL
                          WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'PAM', 'DOKTOR FALSAFAH (PENGURUSAN)', 'DOCTOR OF PHILOSOPHY (MANAGEMENT)', (SELECT ID
                                                                                                            FROM
                                                                                                              IN_GRDT_CNTR
                                                                                                            WHERE CODE =
                                                                                                                  'CPS'),
   (SELECT ID
    FROM IN_FCTY_CODE
    WHERE CODE = 'A01'), (SELECT ID
                          FROM IN_PRGM_LEVL
                          WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PAP', 'DOKTOR FALSAFAH (PELANCONGAN)', 'DOCTOR OF PHILOSOPHY (TOURISM)', (SELECT ID
                                                                                                               FROM
                                                                                                                 IN_GRDT_CNTR
                                                                                                               WHERE
                                                                                                                 CODE =
                                                                                                                 'CPS'),
        (SELECT ID
         FROM IN_FCTY_CODE
         WHERE CODE = 'A01'), (SELECT ID
                               FROM IN_PRGM_LEVL
                               WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'PAR', 'DOKTOR FALSAFAH (PERUNCITAN)', 'DOCTOR OF PHILOSOPHY (RETAILING)', (SELECT ID
                                                                                                           FROM
                                                                                                             IN_GRDT_CNTR
                                                                                                           WHERE CODE =
                                                                                                                 'CPS'),
   (SELECT ID
    FROM IN_FCTY_CODE
    WHERE CODE = 'A01'), (SELECT ID
                          FROM IN_PRGM_LEVL
                          WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PAW', 'DOKTOR FALSAFAH (KEUSAHAWANAN KESIHATAN)',
        'DOCTOR OF PHILOSOPHY (HEALTH ENTREPRENEURSHIP)', (SELECT ID
                                                           FROM IN_GRDT_CNTR
                                                           WHERE CODE = 'CPS'), (SELECT ID
                                                                                   FROM IN_FCTY_CODE
                                                                                   WHERE CODE = 'A01'), (SELECT ID
                                                                                                         FROM
                                                                                                           IN_PRGM_LEVL
                                                                                                         WHERE CODE =
                                                                                                               'PHD'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MBB', 'SARJANA SAINS (BIOTEKNOLOGI PERTANIAN)',
        'MASTER OF SCIENCE (AGRICULTURE BIOTECHNOLOGY)', (SELECT ID
                                                          FROM IN_GRDT_CNTR
                                                          WHERE CODE = 'CPS'), (SELECT ID
                                                                                  FROM IN_FCTY_CODE
                                                                                  WHERE CODE = 'A03'), (SELECT ID
                                                                                                        FROM
                                                                                                          IN_PRGM_LEVL
                                                                                                        WHERE CODE =
                                                                                                              'MASTER'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MBG', 'SARJANA SAINS (GEOSAINS)', 'MASTER OF SCIENCE (GEOSCIENCE)', (SELECT ID
                                                                                                          FROM
                                                                                                            IN_GRDT_CNTR
                                                                                                          WHERE CODE =
                                                                                                                'CPS'),
        (SELECT ID
         FROM IN_FCTY_CODE
         WHERE CODE = 'A03'), (SELECT ID
                               FROM IN_PRGM_LEVL
                               WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MBH', 'SARJANA SAINS (SAINS PETERNAKAN)', 'MASTER OF SCIENCE (HUSBANDARY SCIENCE)',
        (SELECT ID
         FROM IN_GRDT_CNTR
         WHERE CODE = 'CPS'), (SELECT ID
                                 FROM IN_FCTY_CODE
                                 WHERE CODE = 'A03'), (SELECT ID
                                                       FROM IN_PRGM_LEVL
                                                       WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'MBK', 'SARJANA SAINS (SAINS KELESTARIAN)', 'MASTER OF SCIENCE (SUSTAINABLE SCIENCE)',
   (SELECT ID
    FROM IN_GRDT_CNTR
    WHERE CODE = 'CPS'), (SELECT ID
                            FROM IN_FCTY_CODE
                            WHERE CODE = 'A03'), (SELECT ID
                                                  FROM IN_PRGM_LEVL
                                                  WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MBN', 'SARJANA SAINS (PENGURUSAN SUMBER ASLI)',
        'MASTER OF SCIENCE (NATURAL RESOURCES MANAGEMENT)', (SELECT ID
                                                             FROM IN_GRDT_CNTR
                                                             WHERE CODE = 'CPS'), (SELECT ID
                                                                                     FROM IN_FCTY_CODE
                                                                                     WHERE CODE = 'A03'), (SELECT ID
                                                                                                           FROM
                                                                                                             IN_PRGM_LEVL
                                                                                                           WHERE CODE =
                                                                                                                 'MASTER'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MBP', 'SARJANA SAINS (TEKNOLOGI PEMBANGUNAN PRODUK)',
        'MASTER OF SCIENCE (PRODUCT DEVELOPMENT TECHNOLOGY)', (SELECT ID
                                                               FROM IN_GRDT_CNTR
                                                               WHERE CODE = 'CPS'), (SELECT ID
                                                                                       FROM IN_FCTY_CODE
                                                                                       WHERE CODE = 'A03'), (SELECT ID
                                                                                                             FROM
                                                                                                               IN_PRGM_LEVL
                                                                                                             WHERE
                                                                                                               CODE =
                                                                                                               'MASTER'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MBR', 'SARJANA SAINS (TEKNOLOGI ALAM SEKITAR)',
        'MASTER OF SCIENCE (ENVIRONMENTAL TECHNOLOGY)', (SELECT ID
                                                         FROM IN_GRDT_CNTR
                                                         WHERE CODE = 'CPS'), (SELECT ID
                                                                                 FROM IN_FCTY_CODE
                                                                                 WHERE CODE = 'A03'), (SELECT ID
                                                                                                       FROM IN_PRGM_LEVL
                                                                                                       WHERE CODE =
                                                                                                             'MASTER'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MBS', 'SARJANA SAINS (KEUSAHAWANAN TEKNOLOGI PERTANIAN)',
        'MASTER OF SCIENCE (AGRO TECHNOPRENEURSHIP)', (SELECT ID
                                                       FROM IN_GRDT_CNTR
                                                       WHERE CODE = 'CPS'), (SELECT ID
                                                                               FROM IN_FCTY_CODE
                                                                               WHERE CODE = 'A03'), (SELECT ID
                                                                                                     FROM IN_PRGM_LEVL
                                                                                                     WHERE
                                                                                                       CODE = 'MASTER'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MBT', 'SARJANA SAINS (TEKNOLOGI BIOINDUSTRI)',
        'MASTER OF SCIENCE (BIO-INDUSTRIAL TECHNOLOGY)', (SELECT ID
                                                          FROM IN_GRDT_CNTR
                                                          WHERE CODE = 'CPS'), (SELECT ID
                                                                                  FROM IN_FCTY_CODE
                                                                                  WHERE CODE = 'A03'), (SELECT ID
                                                                                                        FROM
                                                                                                          IN_PRGM_LEVL
                                                                                                        WHERE CODE =
                                                                                                              'MASTER'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'MBU', 'SARJANA SAINS (SAINS TUMBUHAN)', 'MASTER OF SCIENCE (PLANT SCIENCE)', (SELECT ID
                                                                                                              FROM
                                                                                                                IN_GRDT_CNTR
                                                                                                              WHERE
                                                                                                                CODE =
                                                                                                                'CPS'),
   (SELECT ID
    FROM IN_FCTY_CODE
    WHERE CODE = 'A03'), (SELECT ID
                          FROM IN_PRGM_LEVL
                          WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PBB', 'DOKTOR FALSAFAH (BIOTEKNOLOGI PERTANIAN)',
        'DOCTOR OF PHILOSOPHY (AGRICULTURAL BIOTECHNOLOGY)', (SELECT ID
                                                              FROM IN_GRDT_CNTR
                                                              WHERE CODE = 'CPS'), (SELECT ID
                                                                                      FROM IN_FCTY_CODE
                                                                                      WHERE CODE = 'A03'), (SELECT ID
                                                                                                            FROM
                                                                                                              IN_PRGM_LEVL
                                                                                                            WHERE CODE =
                                                                                                                  'PHD'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PBG', 'DOKTOR FALSAFAH (GEOSAINS)', 'DOCTOR OF PHILOSOPHY (GEOSCIENCE)', (SELECT ID
                                                                                                               FROM
                                                                                                                 IN_GRDT_CNTR
                                                                                                               WHERE
                                                                                                                 CODE =
                                                                                                                 'CPS'),
        (SELECT ID
         FROM IN_FCTY_CODE
         WHERE CODE = 'A03'), (SELECT ID
                               FROM IN_PRGM_LEVL
                               WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'PBH', 'DOKTOR FALSAFAH (SAINS PETERNAKAN)', 'DOCTOR OF PHILOSOPHY (HUSBANDARY SCIENCE)',
   (SELECT ID
    FROM IN_GRDT_CNTR
    WHERE CODE = 'CPS'), (SELECT ID
                            FROM IN_FCTY_CODE
                            WHERE CODE = 'A03'), (SELECT ID
                                                  FROM IN_PRGM_LEVL
                                                  WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PBK', 'DOKTOR FALSAFAH (SAINS KELESTARIAN)',
        'DOCTOR OF PHILOSOPHY (SUSTAINABLE SCIENCE)', (SELECT ID
                                                       FROM IN_GRDT_CNTR
                                                       WHERE CODE = 'CPS'), (SELECT ID
                                                                               FROM IN_FCTY_CODE
                                                                               WHERE CODE = 'A03'), (SELECT ID
                                                                                                     FROM IN_PRGM_LEVL
                                                                                                     WHERE
                                                                                                       CODE = 'PHD'), 1,
        0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PBN', 'DOKTOR FALSAFAH (PENGURUSAN SUMBER ASLI)',
        'DOCTOR OF PHILOSOPHY (NATURAL RESOURCES MANAGEMENT)', (SELECT ID
                                                                FROM IN_GRDT_CNTR
                                                                WHERE CODE = 'CPS'), (SELECT ID
                                                                                        FROM IN_FCTY_CODE
                                                                                        WHERE CODE = 'A03'), (SELECT ID
                                                                                                              FROM
                                                                                                                IN_PRGM_LEVL
                                                                                                              WHERE
                                                                                                                CODE =
                                                                                                                'PHD'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PBP', 'DOKTOR FALSAFAH (TEKNOLOGI PEMBANGUNAN PRODUK)',
        'DOCTOR OF PHILOSOPHY (PRODUCT DEVELOPMENT TECHNOLOGY)', (SELECT ID
                                                                  FROM IN_GRDT_CNTR
                                                                  WHERE CODE = 'CPS'), (SELECT ID
                                                                                          FROM IN_FCTY_CODE
                                                                                          WHERE CODE = 'A03'),
        (SELECT ID
         FROM IN_PRGM_LEVL
         WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PBR', 'DOKTOR FALSAFAH (TEKNOLOGI ALAM SEKITAR)',
        'DOCTOR OF PHILOSOPHY (ENVIRONMENTAL TECHNOLOGY)', (SELECT ID
                                                            FROM IN_GRDT_CNTR
                                                            WHERE CODE = 'CPS'), (SELECT ID
                                                                                    FROM IN_FCTY_CODE
                                                                                    WHERE CODE = 'A03'), (SELECT ID
                                                                                                          FROM
                                                                                                            IN_PRGM_LEVL
                                                                                                          WHERE CODE =
                                                                                                                'PHD'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PBS', 'DOKTOR FALSAFAH (KEUSAHAWANAN TEKNOLOGI PERTANIAN)',
        'DOCTOR OF PHILOSOPHY (AGRO TECHNOPRENEURSHIP)', (SELECT ID
                                                          FROM IN_GRDT_CNTR
                                                          WHERE CODE = 'CPS'), (SELECT ID
                                                                                  FROM IN_FCTY_CODE
                                                                                  WHERE CODE = 'A03'), (SELECT ID
                                                                                                        FROM
                                                                                                          IN_PRGM_LEVL
                                                                                                        WHERE
                                                                                                          CODE = 'PHD'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PBT', 'DOKTOR FALSAFAH (TEKNOLOGI BIOINDUSTRI)',
        'DOCTOR OF PHILOSOPHY  (BIO-INDUSTRIAL TECHNOLOGY)', (SELECT ID
                                                              FROM IN_GRDT_CNTR
                                                              WHERE CODE =
                                                                    'CPS'), (SELECT ID
                                                                               FROM IN_FCTY_CODE
                                                                               WHERE CODE = 'A03'),
        (SELECT ID
         FROM IN_PRGM_LEVL
         WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PBU', 'DOKTOR FALSAFAH (SAINS TUMBUHAN)', 'DOCTOR OF PHILOSOPHY (PLANT SCIENCE)',
        (SELECT ID
         FROM IN_GRDT_CNTR
         WHERE CODE = 'CPS'), (SELECT ID
                                 FROM IN_FCTY_CODE
                                 WHERE CODE = 'A03'), (SELECT ID
                                                       FROM IN_PRGM_LEVL
                                                       WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'DBPA', 'DOKTOR PENTADBIRAN PERNIAGAAN ', 'DOCTORATE IN BUSINESS ADMINISTRATION',
        (SELECT ID
         FROM IN_GRDT_CNTR
         WHERE CODE = 'CPS'), (SELECT ID
                                 FROM IN_FCTY_CODE
                                 WHERE CODE = 'A10'), (SELECT ID
                                                       FROM IN_PRGM_LEVL
                                                       WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MCA', 'SARJANA SASTERA (AGAMA DAN KOTEMPORARI)',
        'MASTER OF ARTS (RELIGION AND CONTEMPORARY)', (SELECT ID
                                                       FROM IN_GRDT_CNTR
                                                       WHERE CODE = 'CPS'), (SELECT ID
                                                                               FROM IN_FCTY_CODE
                                                                               WHERE CODE = 'A01'), (SELECT ID
                                                                                                     FROM IN_PRGM_LEVL
                                                                                                     WHERE
                                                                                                       CODE = 'MASTER'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MCM', 'SARJANA SASTERA (MULTIMEDIA)', 'MASTER OF ARTS (MULTIMEDIA)', (SELECT ID
                                                                                                           FROM
                                                                                                             IN_GRDT_CNTR
                                                                                                           WHERE CODE =
                                                                                                                 'CPS'),
        (SELECT ID
         FROM IN_FCTY_CODE
         WHERE CODE = 'A02'), (SELECT ID
                               FROM IN_PRGM_LEVL
                               WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MCP', 'SARJANA SASTERA (REKABENTUK PRODUK)', 'MASTER OF ARTS (PRODUCT DESIGN)',
        (SELECT ID
         FROM IN_GRDT_CNTR
         WHERE CODE = 'CPS'), (SELECT ID
                                 FROM IN_FCTY_CODE
                                 WHERE CODE = 'A02'), (SELECT ID
                                                       FROM IN_PRGM_LEVL
                                                       WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'MCT', 'SARJANA SASTERA (TEKSTIL DAN FESYEN)', 'MASTER OF ARTS (TEXTILE AND FASHION)',
   (SELECT ID
    FROM IN_GRDT_CNTR
    WHERE CODE = 'CPS'), (SELECT ID
                            FROM IN_FCTY_CODE
                            WHERE CODE = 'A02'), (SELECT ID
                                                  FROM IN_PRGM_LEVL
                                                  WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'MCV', 'SARJANA SASTERA (KOMUNIKASI VISUAL)', 'MASTER OF ARTS (VISUAL COMMUNICATION)',
   (SELECT ID
    FROM IN_GRDT_CNTR
    WHERE CODE = 'CPS'), (SELECT ID
                            FROM IN_FCTY_CODE
                            WHERE CODE = 'A02'), (SELECT ID
                                                  FROM IN_PRGM_LEVL
                                                  WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MCW', 'SARJANA SASTERA (PENGAJIAN WARISAN)', 'MASTER OF ARTS (HERITAGE  STUDIES)',
        (SELECT ID
         FROM IN_GRDT_CNTR
         WHERE CODE = 'CPS'), (SELECT ID
                                 FROM IN_FCTY_CODE
                                 WHERE CODE = 'A02'), (SELECT ID
                                                       FROM IN_PRGM_LEVL
                                                       WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'PCM', 'DOKTOR FALSAFAH (MULTIMEDIA)', 'DOCTOR OF PHILOSOPHY (MULTIMEDIA)', (SELECT ID
                                                                                                            FROM
                                                                                                              IN_GRDT_CNTR
                                                                                                            WHERE CODE =
                                                                                                                  'CPS'),
   (SELECT ID
    FROM IN_FCTY_CODE
    WHERE CODE = 'A02'), (SELECT ID
                          FROM IN_PRGM_LEVL
                          WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'PCP', 'DOKTOR FALSAFAH (REKABENTUK PRODUK)', 'DOCTOR OF PHILOSOPHY (PRODUCT DESIGN)',
   (SELECT ID
    FROM IN_GRDT_CNTR
    WHERE CODE = 'CPS'), (SELECT ID
                            FROM IN_FCTY_CODE
                            WHERE CODE = 'A02'), (SELECT ID
                                                  FROM IN_PRGM_LEVL
                                                  WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PCT', 'DOKTOR FALSAFAH (TEKSTIL DAN FESYEN)',
        'DOCTOR OF PHILOSOPHY (TEXTILE AND FASHION)', (SELECT ID
                                                       FROM IN_GRDT_CNTR
                                                       WHERE CODE = 'CPS'), (SELECT ID
                                                                               FROM IN_FCTY_CODE
                                                                               WHERE CODE = 'A02'), (SELECT ID
                                                                                                     FROM IN_PRGM_LEVL
                                                                                                     WHERE
                                                                                                       CODE = 'PHD'), 1,
        0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PCV', 'DOKTOR FALSAFAH (KOMUNIKASI VISUAL)',
        'DOCTOR OF PHILOSOPHY (VISUAL COMMUNICATION)', (SELECT ID
                                                        FROM IN_GRDT_CNTR
                                                        WHERE CODE = 'CPS'), (SELECT ID
                                                                                FROM IN_FCTY_CODE
                                                                                WHERE CODE = 'A02'), (SELECT ID
                                                                                                      FROM IN_PRGM_LEVL
                                                                                                      WHERE
                                                                                                        CODE = 'PHD'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'PCW', 'DOKTOR FALSAFAH (PENGAJIAN WARISAN)', 'DOCTOR OF PHILOSOPHY (HERITAGE  STUDIES)',
   (SELECT ID
    FROM IN_GRDT_CNTR
    WHERE CODE = 'CPS'), (SELECT ID
                            FROM IN_FCTY_CODE
                            WHERE CODE = 'A02'), (SELECT ID
                                                  FROM IN_PRGM_LEVL
                                                  WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MDA', 'SARJANA SAINS (ANATOMI)', 'MASTER OF SCIENCE (ANATOMY)', (SELECT ID
                                                                                                      FROM IN_GRDT_CNTR
                                                                                                      WHERE
                                                                                                        CODE = 'CPS'),
        (SELECT ID
         FROM IN_FCTY_CODE
         WHERE CODE = 'A06'), (SELECT ID
                               FROM IN_PRGM_LEVL
                               WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MDF', 'SARJANA SAINS (FISIOLOGI)', 'MASTER OF SCIENCE (PHYSIOLOGY)', (SELECT ID
                                                                                                           FROM
                                                                                                             IN_GRDT_CNTR
                                                                                                           WHERE CODE =
                                                                                                                 'CPS'),
        (SELECT ID
         FROM IN_FCTY_CODE
         WHERE CODE = 'A06'), (SELECT ID
                               FROM IN_PRGM_LEVL
                               WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'MDM', 'SARJANA SAINS (MIKROBIOLOGI)', 'MASTER OF SCIENCE (MICROBIOLOGY)', (SELECT ID
                                                                                                           FROM
                                                                                                             IN_GRDT_CNTR
                                                                                                           WHERE CODE =
                                                                                                                 'CPS'),
   (SELECT ID
    FROM IN_FCTY_CODE
    WHERE CODE = 'A06'), (SELECT ID
                          FROM IN_PRGM_LEVL
                          WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MDN', 'SARJANA SAINS (NUTRISI)', 'MASTER OF SCIENCE (NUTRITION)', (SELECT ID
                                                                                                        FROM
                                                                                                          IN_GRDT_CNTR
                                                                                                        WHERE CODE =
                                                                                                              'CPS'),
        (SELECT ID
         FROM IN_FCTY_CODE
         WHERE CODE = 'A06'), (SELECT ID
                               FROM IN_PRGM_LEVL
                               WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MDP', 'SARJANA SAINS (PATOLOGI)', 'MASTER OF SCIENCE (PATHOLOGY)', (SELECT ID
                                                                                                         FROM
                                                                                                           IN_GRDT_CNTR
                                                                                                         WHERE CODE =
                                                                                                               'CPS'),
        (SELECT ID
         FROM IN_FCTY_CODE
         WHERE CODE = 'A06'), (SELECT ID
                               FROM IN_PRGM_LEVL
                               WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'MDR', 'SARJANA SAINS (PARASITOLOGI)', 'MASTER OF SCIENCE (PARASITOLOGY)', (SELECT ID
                                                                                                           FROM
                                                                                                             IN_GRDT_CNTR
                                                                                                           WHERE CODE =
                                                                                                                 'CPS'),
   (SELECT ID
    FROM IN_FCTY_CODE
    WHERE CODE = 'A06'), (SELECT ID
                          FROM IN_PRGM_LEVL
                          WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PDA', 'DOKTOR FALSAFAH (ANATOMI)', 'DOCTOR OF PHILOSOPHY  (ANATOMY)', (SELECT ID
                                                                                                            FROM
                                                                                                              IN_GRDT_CNTR
                                                                                                            WHERE CODE =
                                                                                                                  'CPS'),
        (SELECT ID
         FROM IN_FCTY_CODE
         WHERE CODE = 'A06'), (SELECT ID
                               FROM IN_PRGM_LEVL
                               WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'PDF', 'DOKTOR FALSAFAH (FISIOLOGI)', 'DOCTOR OF PHILOSOPHY (PHYSIOLOGY)', (SELECT ID
                                                                                                           FROM
                                                                                                             IN_GRDT_CNTR
                                                                                                           WHERE CODE =
                                                                                                                 'CPS'),
   (SELECT ID
    FROM IN_FCTY_CODE
    WHERE CODE = 'A06'), (SELECT ID
                          FROM IN_PRGM_LEVL
                          WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PDM', 'DOKTOR FALSAFAH (MIKROBIOLOGI)', 'DOCTOR OF PHILOSOPHY  (MICROBIOLOGY)',
        (SELECT ID
         FROM IN_GRDT_CNTR
         WHERE CODE = 'CPS'), (SELECT ID
                                 FROM IN_FCTY_CODE
                                 WHERE CODE = 'A06'), (SELECT ID
                                                       FROM IN_PRGM_LEVL
                                                       WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PDN', 'DOKTOR FALSAFAH (NUTRISI)', 'DOCTOR OF PHILOSOPHY  (NUTRITION)', (SELECT ID
                                                                                                              FROM
                                                                                                                IN_GRDT_CNTR
                                                                                                              WHERE
                                                                                                                CODE =
                                                                                                                'CPS'),
        (SELECT ID
         FROM IN_FCTY_CODE
         WHERE CODE = 'A06'), (SELECT ID
                               FROM IN_PRGM_LEVL
                               WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PDP', 'DOKTOR FALSAFAH (PATOLOGI)', 'DOCTOR OF PHILOSOPHY  (PATHOLOGY)', (SELECT ID
                                                                                                               FROM
                                                                                                                 IN_GRDT_CNTR
                                                                                                               WHERE
                                                                                                                 CODE =
                                                                                                                 'CPS'),
        (SELECT ID
         FROM IN_FCTY_CODE
         WHERE CODE = 'A06'), (SELECT ID
                               FROM IN_PRGM_LEVL
                               WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PDR', 'DOKTOR FALSAFAH (PARASITOLOGI)', 'DOCTOR OF PHILOSOPHY (PARASITOLOGY)',
        (SELECT ID
         FROM IN_GRDT_CNTR
         WHERE CODE = 'CPS'), (SELECT ID
                                 FROM IN_FCTY_CODE
                                 WHERE CODE = 'A06'), (SELECT ID
                                                       FROM IN_PRGM_LEVL
                                                       WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'MBPA', 'SARJANA PENTADBIRAN PERNIAGAAN', 'MASTER IN BUSINESS ADMINISTRATION', (SELECT ID
                                                                                                               FROM
                                                                                                                 IN_GRDT_CNTR
                                                                                                               WHERE
                                                                                                                 CODE =
                                                                                                                 'CPS'),
   (SELECT ID
    FROM IN_FCTY_CODE
    WHERE CODE = 'A10'), (SELECT ID
                          FROM IN_PRGM_LEVL
                          WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MCC', 'SARJANA SASTERA (KOMUNIKASI)', 'MASTER OF ARTS (COMMUNICATION)', (SELECT ID
                                                                                                              FROM
                                                                                                                IN_GRDT_CNTR
                                                                                                              WHERE
                                                                                                                CODE =
                                                                                                                'CPS'),
        (SELECT ID
         FROM IN_FCTY_CODE
         WHERE CODE = 'A04'), (SELECT ID
                               FROM IN_PRGM_LEVL
                               WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'PCC', 'DOKTOR FALSAFAH (KOMUNIKASI)', 'DOCTOR OF PHILOSOPHY (COMMUNICATION)', (SELECT ID
                                                                                                               FROM
                                                                                                                 IN_GRDT_CNTR
                                                                                                               WHERE
                                                                                                                 CODE =
                                                                                                                 'CPS'),
   (SELECT ID
    FROM IN_FCTY_CODE
    WHERE CODE = 'A04'), (SELECT ID
                          FROM IN_PRGM_LEVL
                          WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'MFB', 'SARJANA SAINS (TEKNOLOGI BAHAN)', 'MASTER OF SCIENCE (MATERIALS TECHNOLOGY)',
   (SELECT ID
    FROM IN_GRDT_CNTR
    WHERE CODE = 'CPS'), (SELECT ID
                            FROM IN_FCTY_CODE
                            WHERE CODE = 'A03'), (SELECT ID
                                                  FROM IN_PRGM_LEVL
                                                  WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PFB', 'DOKTOR FALSAFAH (TEKNOLOGI BAHAN)',
        'DOCTOR OF PHILOSOPHY (MATERIALS TECHNOLOGY)', (SELECT ID
                                                        FROM IN_GRDT_CNTR
                                                        WHERE CODE = 'CPS'), (SELECT ID
                                                                                FROM IN_FCTY_CODE
                                                                                WHERE CODE = 'A03'), (SELECT ID
                                                                                                      FROM IN_PRGM_LEVL
                                                                                                      WHERE
                                                                                                        CODE = 'PHD'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MFS', 'SARJANA SAINS (TEKNOLOGI SUMBER HUTAN)',
        'MASTER OF SCIENCE (FOREST RESOURCES TECHNOLOGY)', (SELECT ID
                                                            FROM IN_GRDT_CNTR
                                                            WHERE CODE = 'CPS'), (SELECT ID
                                                                                    FROM IN_FCTY_CODE
                                                                                    WHERE CODE = 'A03'), (SELECT ID
                                                                                                          FROM
                                                                                                            IN_PRGM_LEVL
                                                                                                          WHERE CODE =
                                                                                                                'MASTER'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PFS', 'DOKTOR FALSAFAH (TEKNOLOGI SUMBER HUTAN)',
        'DOCTOR OF PHILOSOPHY (FOREST RESOURCES TECHNOLOGY)', (SELECT ID
                                                               FROM IN_GRDT_CNTR
                                                               WHERE CODE = 'CPS'), (SELECT ID
                                                                                       FROM IN_FCTY_CODE
                                                                                       WHERE CODE = 'A03'), (SELECT ID
                                                                                                             FROM
                                                                                                               IN_PRGM_LEVL
                                                                                                             WHERE
                                                                                                               CODE =
                                                                                                               'PHD'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PDBA', 'DOKTOR FALSAFAH (PENTADBIRAN PERNIAGAAN)',
        'DOCTOR OF PHILOSOPHY (BUSINESS ADMINISTRATION) ', (SELECT ID
                                                            FROM IN_GRDT_CNTR
                                                            WHERE CODE = 'CPS'), (SELECT ID
                                                                                    FROM IN_FCTY_CODE
                                                                                    WHERE CODE = 'A10'), (SELECT ID
                                                                                                          FROM
                                                                                                            IN_PRGM_LEVL
                                                                                                          WHERE CODE =
                                                                                                                'PHD'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'PAU', 'DOKTOR FALSAFAH (KEUSAHAWANAN)', 'DOCTOR OF PHILOSOPHY (ENTREPRENEURSHIP)',
        (SELECT ID
         FROM IN_GRDT_CNTR
         WHERE CODE = 'CPS'), (SELECT ID
                                 FROM IN_FCTY_CODE
                                 WHERE CODE = 'A01'), (SELECT ID
                                                       FROM IN_PRGM_LEVL
                                                       WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MAS', 'SARJANA KEUSAHAWANAN (SAINS MATEMATIK)',
        'MASTER OF ENTREPRENEURSHIP (MATHEMATIC SCIENCE)', (SELECT ID
                                                            FROM IN_GRDT_CNTR
                                                            WHERE CODE = 'CPS'), (SELECT ID
                                                                                    FROM IN_FCTY_CODE
                                                                                    WHERE CODE = 'A01'), (SELECT ID
                                                                                                          FROM
                                                                                                            IN_PRGM_LEVL
                                                                                                          WHERE CODE =
                                                                                                                'MASTER'),
        1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'PAS', 'DOKTOR FALSAFAH (SAINS MATEMATIK)', 'DOCTOR OF PHILOSOPHY (MATHEMATIC SCIENCE)',
   (SELECT ID
    FROM IN_GRDT_CNTR
    WHERE CODE = 'CPS'), (SELECT ID
                            FROM IN_FCTY_CODE
                            WHERE CODE = 'A01'), (SELECT ID
                                                  FROM IN_PRGM_LEVL
                                                  WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MBA', 'SARJANA SAINS (AKUAKULTUR)', 'MASTER OF SCIENCE (AQUACULTURE)', (SELECT ID
                                                                                                             FROM
                                                                                                               IN_GRDT_CNTR
                                                                                                             WHERE
                                                                                                               CODE =
                                                                                                               'CPS'),
        (SELECT ID
         FROM IN_FCTY_CODE
         WHERE CODE = 'A03'), (SELECT ID
                               FROM IN_PRGM_LEVL
                               WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_IN_PRGM_CODE'), 'MCB', 'SARJANA SASTERA (PENGAJIAN BAHASA)', 'MASTER OF ARTS (LANGUAGE STUDIES)',
        (SELECT ID
         FROM IN_GRDT_CNTR
         WHERE CODE = 'CPS'), (SELECT ID
                                 FROM IN_FCTY_CODE
                                 WHERE CODE = 'A04'), (SELECT ID
                                                       FROM IN_PRGM_LEVL
                                                       WHERE CODE = 'MASTER'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'PCB', 'DOKTOR FALSAFAH (PENGAJIAN BAHASA)', 'DOCTOR OF PHILOSOPHY (LANGUAGE STUDIES)',
   (SELECT ID
    FROM IN_GRDT_CNTR
    WHERE CODE = 'CPS'), (SELECT ID
                            FROM IN_FCTY_CODE
                            WHERE CODE = 'A04'), (SELECT ID
                                                  FROM IN_PRGM_LEVL
                                                  WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
INSERT INTO IN_PRGM_CODE (ID, CODE, DESCRIPTION_MS, DESCRIPTION_EN, GRADUATE_CENTER_ID, FACULTY_CODE_ID, PROGRAM_LEVEL_ID, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_IN_PRGM_CODE'), 'PBA', 'DOKTOR FALSAFAH (AKUAKULTUR)', 'DOCTOR OF PHILOSOPHY (AQUACULTURE)', (SELECT ID
                                                                                                             FROM
                                                                                                               IN_GRDT_CNTR
                                                                                                             WHERE
                                                                                                               CODE =
                                                                                                               'CPS'),
   (SELECT ID
    FROM IN_FCTY_CODE
    WHERE CODE = 'A03'), (SELECT ID
                          FROM IN_PRGM_LEVL
                          WHERE CODE = 'PHD'), 1, 0, CURRENT_TIMESTAMP);
