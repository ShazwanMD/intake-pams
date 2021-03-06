-- postgres
DROP DATABASE IF EXISTS intake;
DROP USER IF EXISTS intake;

CREATE USER intake WITH PASSWORD 'intake';
CREATE DATABASE intake WITH ENCODING 'UTF8' LC_COLLATE ='C' LC_CTYPE ='C' TEMPLATE =template0;
GRANT ALL PRIVILEGES ON DATABASE intake to intake;