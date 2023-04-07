-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: src/main/resources/db/changelog/db.changelog-master.yaml
-- Ran at: 26/08/2022 20:36
-- Against: postgres@jdbc:postgresql://localhost:5432/clc_contract
-- Liquibase version: 3.4.2
-- *********************************************************************
-- Create Database Lock Table
CREATE TABLE databasechangeloglock (
    ID int NOT NULL,
    LOCKED BOOLEAN NOT NULL,
    LOCKGRANTED timestamp without time zone,
    LOCKEDBY varchar(255),
    CONSTRAINT PK_DATABASECHANGELOGLOCK PRIMARY KEY (ID)
);

-- Initialize Database Lock Table
DELETE FROM databasechangeloglock;

INSERT INTO databasechangeloglock (ID, LOCKED)
    VALUES (1, FALSE);

-- Lock Database
UPDATE
    databasechangeloglock
SET
    LOCKED = TRUE,
    LOCKEDBY = '192.168.1.141 (192.168.1.141)',
    LOCKGRANTED = '2022-08-26 20:36:51.265'
WHERE
    ID = 1
    AND LOCKED = FALSE;

-- Create Database Change Log Table
CREATE TABLE databasechangelog (
    ID varchar(255) NOT NULL,
    AUTHOR varchar(255) NOT NULL,
    FILENAME varchar(255) NOT NULL,
    DATEEXECUTED timestamp without time zone NOT NULL,
    ORDEREXECUTED int NOT NULL,
    EXECTYPE varchar(10) NOT NULL,
    MD5SUM varchar(35),
    DESCRIPTION varchar(255),
    COMMENTS varchar(255),
    TAG varchar(255),
    LIQUIBASE varchar(20),
    CONTEXTS varchar(255),
    LABELS varchar(255)
);

-- Changeset db/changelog/changeset/202207181420-service_configuration.yml::202207181420-service_configuration::lucasveiga
CREATE TABLE service_configuration (
    id uuid NOT NULL,
    company_id varchar(50) NOT NULL,
    workspace_id varchar(50) NOT NULL,
    application_id varchar(50) NOT NULL,
    service_id varchar(50) NOT NULL,
    camus_api_key varchar(50) NOT NULL,
    CONSTRAINT PK_SERVICE_CONFIGURATION PRIMARY KEY (id)
);

CREATE INDEX idx_service_configuration_izzie_tenancy ON service_configuration (company_id, workspace_id, application_id);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE)
    VALUES ('202207181420-service_configuration', 'lucasveiga', 'db/changelog/changeset/202207181420-service_configuration.yml', NOW(), 1, '7:c5e2f566276114adb90a72492ae31477', 'createTable, createIndex', '', 'EXECUTED', NULL, NULL, '3.4.2');

-- Changeset db/changelog/changeset/202207181523-contract_event.yml::202208262031-contract_event::hebertsantos
CREATE TABLE contract_event (
    id uuid NOT NULL,
    event_type varchar(60) NOT NULL,
    contract_id varchar(36) NOT NULL,
    account_id varchar(36) NOT NULL,
    company_id varchar(50) NOT NULL,
    workspace_id varchar(50) NOT NULL,
    application_id varchar(50) NOT NULL,
    environment varchar(50) NOT NULL,
    data varchar(4000) NOT NULL,
    occurrenced_dt timestamp with time zone NOT NULL,
    persisted_dt timestamp with time zone NOT NULL,
    CONSTRAINT PK_CONTRACT_EVENT PRIMARY KEY (id)
);

CREATE INDEX idx_contract_event_izzie_tenancy_contract_id ON contract_event (company_id, workspace_id, contract_id);

CREATE INDEX idx_contract_event_izzie_tenancy_account_id ON contract_event (company_id, workspace_id, account_id);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE)
    VALUES ('202208262031-contract_event', 'hebertsantos', 'db/changelog/changeset/202207181523-contract_event.yml', NOW(), 2, '7:c46b920972d967b68573191a2b3ef07e', 'createTable, createIndex (x2)', '', 'EXECUTED', NULL, NULL, '3.4.2');

-- Release Database Lock
UPDATE
    databasechangeloglock
SET
    LOCKED = FALSE,
    LOCKEDBY = NULL,
    LOCKGRANTED = NULL
WHERE
    ID = 1;

-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: src/main/resources/db/changelog/db.changelog-master.yaml
-- Ran at: 31/08/2022 17:30
-- Against: postgres@jdbc:postgresql://localhost:5432/clc_contract
-- Liquibase version: 3.4.2
-- *********************************************************************
-- Lock Database
UPDATE
    databasechangeloglock
SET
    LOCKED = TRUE,
    LOCKEDBY = '192.168.1.141 (192.168.1.141)',
    LOCKGRANTED = '2022-08-31 17:30:52.517'
WHERE
    ID = 1
    AND LOCKED = FALSE;

-- Changeset db/changelog/changeset/202208311709-contract_event_rename_additional_information.yml::202208311709-contract_event_rename_additional_information::hebertsantos
ALTER TABLE contract_event RENAME COLUMN data TO additional_information;

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE)
    VALUES ('202208311709-contract_event_rename_additional_information', 'hebertsantos', 'db/changelog/changeset/202208311709-contract_event_rename_additional_information.yml', NOW(), 3, '7:e7c9e84991cd918f0360183fb1b218aa', 'renameColumn', '', 'EXECUTED', NULL, NULL, '3.4.2');

-- Release Database Lock
UPDATE
    databasechangeloglock
SET
    LOCKED = FALSE,
    LOCKEDBY = NULL,
    LOCKGRANTED = NULL
WHERE
    ID = 1;

-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: src/main/resources/db/changelog/db.changelog-master.yaml
-- Ran at: 22/09/2022 10:50
-- Against: postgres@jdbc:postgresql://localhost:5432/clc_contract
-- Liquibase version: 3.4.2
-- *********************************************************************
-- Lock Database
UPDATE
    databasechangeloglock
SET
    LOCKED = TRUE,
    LOCKEDBY = '192.168.1.141 (192.168.1.141)',
    LOCKGRANTED = '2022-09-22 10:50:50.295'
WHERE
    ID = 1
    AND LOCKED = FALSE;

-- Changeset db/changelog/changeset/202209221045-service_configuration_add_fields.yml::202209221045-service_configuration_add_fields::hebertsantos
ALTER TABLE service_configuration
    ADD my_plan_api_key VARCHAR(50);

ALTER TABLE service_configuration
    ADD digipay_client_id VARCHAR(50);

ALTER TABLE service_configuration
    ADD digipay_secret VARCHAR(50);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE)
    VALUES ('202209221045-service_configuration_add_fields', 'hebertsantos', 'db/changelog/changeset/202209221045-service_configuration_add_fields.yml', NOW(), 4, '7:4e82962218ce137bbcea766c71c211da', 'addColumn', '', 'EXECUTED', NULL, NULL, '3.4.2');

-- Release Database Lock
UPDATE
    databasechangeloglock
SET
    LOCKED = FALSE,
    LOCKEDBY = NULL,
    LOCKGRANTED = NULL
WHERE
    ID = 1;

-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: src/main/resources/db/changelog/db.changelog-master.yaml
-- Ran at: 22/09/2022 12:17
-- Against: postgres@jdbc:postgresql://localhost:5432/clc_contract
-- Liquibase version: 3.4.2
-- *********************************************************************
-- Lock Database
UPDATE
    databasechangeloglock
SET
    LOCKED = TRUE,
    LOCKEDBY = '192.168.1.141 (192.168.1.141)',
    LOCKGRANTED = '2022-09-22 12:17:12.918'
WHERE
    ID = 1
    AND LOCKED = FALSE;

-- Changeset db/changelog/changeset/202209221216-service_configuration_add_fields.yml::202209221216-service_configuration_add_fields::hebertsantos
ALTER TABLE service_configuration
    ADD my_plan_client_id VARCHAR(50);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE)
    VALUES ('202209221216-service_configuration_add_fields', 'hebertsantos', 'db/changelog/changeset/202209221216-service_configuration_add_fields.yml', NOW(), 5, '7:5057b631d4aa42a0e6db8e4bf75d4233', 'addColumn', '', 'EXECUTED', NULL, NULL, '3.4.2');

-- Release Database Lock
UPDATE
    databasechangeloglock
SET
    LOCKED = FALSE,
    LOCKEDBY = NULL,
    LOCKGRANTED = NULL
WHERE
    ID = 1;

