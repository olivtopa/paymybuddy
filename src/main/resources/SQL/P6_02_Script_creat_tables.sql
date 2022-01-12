CREATE DATABASE pmb;
USE pmb;
CREATE TABLE user
(
    email    VARCHAR(320) NOT NULL,
    password VARCHAR(110)  NOT NULL,
    solde    DOUBLE      NOT NULL,
    PRIMARY KEY (email)
)
    ENGINE = INNODB;

CREATE TABLE contact
(
    email_origin  VARCHAR(320) NOT NULL,
    email_contact VARCHAR(320) NOT NULL,
    name          VARCHAR(40)  NOT NULL,
    PRIMARY KEY (email_origin, email_contact),
    CONSTRAINT fk_contact_email_origin_user FOREIGN KEY (email_origin) REFERENCES user (email),
    CONSTRAINT fk_contact_email_contact_user FOREIGN KEY (email_contact) REFERENCES user (email)
)
    ENGINE = INNODB;

CREATE TABLE money_transaction
(
    id              BIGINT       NOT NULL AUTO_INCREMENT,
    email_origin    VARCHAR(320) NOT NULL,
    email_recipient VARCHAR(320) NOT NULL,
    description     VARCHAR(100) ,
    creation_date   DATETIME,
    amount          DOUBLE,
    commission      DOUBLE,
    PRIMARY KEY (id),
    CONSTRAINT fk_money_transaction_email_origin_user FOREIGN KEY (email_origin) REFERENCES user (email),
    CONSTRAINT fk_money_transaction_email_recipient_user FOREIGN KEY (email_recipient) REFERENCES user (email)
)
    ENGINE = INNODB;
