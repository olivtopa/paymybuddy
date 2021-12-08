# Les emails font au plus 320 caractères: https://stackoverflow.com/questions/386294/what-is-the-maximum-length-of-a-valid-email-address#:~:text=%22There%20is%20a%20length%20limit,total%20length%20of%20320%20characters.
# Un mot de passe peut faire au max 30 caractères (mais on peut utiliser un mot de passe plus court. Il s'agit uniquement de la taille max)
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

# la colonne name permet à l'utilisateur d'origine de nommer le contact/la connexion. Dans les écrans prototypes il s'agirait de "Hayley" par exemple
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
    description     VARCHAR(100)  NOT NULL,
    creation_date   DATETIME     NOT NULL,
    amount          DOUBLE      NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_money_transaction_email_origin_user FOREIGN KEY (email_origin) REFERENCES user (email),
    CONSTRAINT fk_money_transaction_email_recipient_user FOREIGN KEY (email_recipient) REFERENCES user (email)
)
    ENGINE = INNODB;
