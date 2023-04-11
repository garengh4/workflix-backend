CREATE DATABASE IF NOT EXIST workflix;
USE workflix;

CREATE TABLE login(
	login_id VARCHAR(50) PRIMARY KEY,
    password NVARCHAR(514) NOT NULL);

CREATE TABLE profile(
	profile_id VARCHAR(50) PRIMARY KEY,
    login_id VARCHAR(50),
	FOREIGN KEY (login_id) REFERENCES login(login_id),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL);

CREATE TABLE files(
	file_id BIGINT AUTO_INCREMENT PRIMARY KEY,
	file_name VARCHAR(50) NOT NULL,
    profile_id VARCHAR(50),
	FOREIGN KEY (profile_id) REFERENCES profile(profile_id),
	category_name VARCHAR(50),
	descriptions VARCHAR(100),
	file_url VARCHAR(255));

INSERT INTO login (login_id, password) VALUES ('doe@example.com', 'Doe@123');
INSERT INTO login (login_id, password) VALUES ('smith@example.com', 'Smith@123');

INSERT INTO profile (profile_id,login_id,first_name,last_name) VALUES ('1','doe@example.com','Jane','Doe');
INSERT INTO profile (profile_id,login_id,first_name,last_name) VALUES ('2','smith@example.com','John','Smith');
INSERT INTO profile (profile_id,login_id,first_name,last_name) VALUES ('3','doe@example.com','Cathy','Doe');