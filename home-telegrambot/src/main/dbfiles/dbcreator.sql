CREATE SCHEMA botschema;
CREATE USER user1 PASSWORD 'user1';
GRANT ALL ON SCHEMA botschema TO user1;
GRANT ALL ON ALL TABLES IN SCHEMA botschema TO user1;

CREATE SEQUENCE botschema.theme_ids;
CREATE TABLE botschema.theme (
id INTEGER PRIMARY KEY DEFAULT NEXTVAL('botschema.theme_ids'),
name CHAR(100));

CREATE SEQUENCE botschema.words_ids;
CREATE TABLE botschema.word
(
    id numeric(18,0) PRIMARY KEY DEFAULT NEXTVAL('botschema.words_ids'),
    cir_name CHAR(100),
    latin_name CHAR(100),
    theme_id INTEGER REFERENCES theme (id)
);


ALTER TABLE botschema.word
    OWNER to postgres;

GRANT ALL ON SEQUENCE botschema.theme_ids TO user1;

GRANT ALL ON SEQUENCE botschema.words TO user1;

GRANT ALL ON SEQUENCE botschema.words_ids TO user1;
