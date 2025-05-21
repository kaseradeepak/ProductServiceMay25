CREATE TABLE categories
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    title            VARCHAR(255) NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE instructor
(
    id      BIGINT NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    subject VARCHAR(255) NULL,
    rating DOUBLE NULL,
    CONSTRAINT pk_instructor PRIMARY KEY (id)
);

CREATE TABLE jt_instructors
(
    user_id BIGINT NOT NULL,
    subject VARCHAR(255) NULL,
    rating DOUBLE NULL,
    CONSTRAINT pk_jt_instructors PRIMARY KEY (user_id)
);

CREATE TABLE jt_mentors
(
    user_id      BIGINT NOT NULL,
    company_name VARCHAR(255) NULL,
    CONSTRAINT pk_jt_mentors PRIMARY KEY (user_id)
);

CREATE TABLE jt_tas
(
    user_id      BIGINT NOT NULL,
    number_ofhrs INT    NOT NULL,
    CONSTRAINT pk_jt_tas PRIMARY KEY (user_id)
);

CREATE TABLE jt_users
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_jt_users PRIMARY KEY (id)
);

CREATE TABLE mentor
(
    id           BIGINT NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    company_name VARCHAR(255) NULL,
    CONSTRAINT pk_mentor PRIMARY KEY (id)
);

CREATE TABLE products
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    title            VARCHAR(255) NULL,
    price DOUBLE NULL,
    `description`    VARCHAR(255) NULL,
    image_url        VARCHAR(255) NULL,
    category_id      BIGINT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE st_users
(
    id           BIGINT NOT NULL,
    user_type    INT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    company_name VARCHAR(255) NULL,
    subject      VARCHAR(255) NULL,
    rating DOUBLE NULL,
    number_ofhrs INT    NOT NULL,
    CONSTRAINT pk_st_users PRIMARY KEY (id)
);

CREATE TABLE ta
(
    id           BIGINT NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    number_ofhrs INT    NOT NULL,
    CONSTRAINT pk_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_instructors
(
    id      BIGINT NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    subject VARCHAR(255) NULL,
    rating DOUBLE NULL,
    CONSTRAINT pk_tpc_instructors PRIMARY KEY (id)
);

CREATE TABLE tpc_mentors
(
    id           BIGINT NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    company_name VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_mentors PRIMARY KEY (id)
);

CREATE TABLE tpc_tas
(
    id           BIGINT NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    number_ofhrs INT    NOT NULL,
    CONSTRAINT pk_tpc_tas PRIMARY KEY (id)
);

CREATE TABLE tpc_users
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_users PRIMARY KEY (id)
);

ALTER TABLE jt_instructors
    ADD CONSTRAINT FK_JT_INSTRUCTORS_ON_USER FOREIGN KEY (user_id) REFERENCES jt_users (id);

ALTER TABLE jt_mentors
    ADD CONSTRAINT FK_JT_MENTORS_ON_USER FOREIGN KEY (user_id) REFERENCES jt_users (id);

ALTER TABLE jt_tas
    ADD CONSTRAINT FK_JT_TAS_ON_USER FOREIGN KEY (user_id) REFERENCES jt_users (id);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);