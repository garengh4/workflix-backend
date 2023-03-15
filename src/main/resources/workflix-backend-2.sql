create schema if not exists workflix;
use workflix;

CREATE TABLE login(
	login_id VARCHAR(50) PRIMARY KEY,
    password VARCHAR(20) NOT NULL);

CREATE TABLE profile(
	profile_id VARCHAR(50) PRIMARY KEY,
    login_id VARCHAR(50),
	FOREIGN KEY (login_id) REFERENCES login(login_id),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL);

INSERT INTO login (login_id, password) VALUES ('doe@example.com', 'Doe@123');
INSERT INTO login (login_id, password) VALUES ('smith@example.com', 'Smith@123');

INSERT INTO profile (profile_id,login_id,first_name,last_name) VALUES (1,'doe@example.com','Jane','Doe');
INSERT INTO profile (profile_id,login_id,first_name,last_name) VALUES (2,'smith@example.com','John','Smith');
INSERT INTO profile (profile_id,login_id,first_name,last_name) VALUES (3,'doe@example.com','Cathy','Doe');
