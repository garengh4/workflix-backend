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
CREATE TABLE category (
    category_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50),
    profile_id VARCHAR(50),
    FOREIGN KEY (profile_id) REFERENCES profile(profile_id));
CREATE TABLE post (
    post_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content longtext,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES category(category_id),
    title varchar(255));



CREATE TABLE defect(
    defect_id INT PRIMARY KEY,
    category VARCHAR(50),
    priority INT,
    status VARCHAR(50),
    description VARCHAR(1000)
);


INSERT INTO login (login_id, password) VALUES ('doe@example.com', 'Doe@123');
INSERT INTO login (login_id, password) VALUES ('smith@example.com', 'Smith@123');

INSERT INTO profile (profile_id,login_id,first_name,last_name) VALUES ('1','doe@example.com','Jane','Doe');
INSERT INTO profile (profile_id,login_id,first_name,last_name) VALUES ('2','smith@example.com','John','Smith');
INSERT INTO profile (profile_id,login_id,first_name,last_name) VALUES ('3','doe@example.com','Cathy','Doe');

INSERT INTO defect (defect_id, category, priority, status, description ) VALUES (3423, 'UI',1,'open','slider bar not working in homepage');
INSERT INTO defect (defect_id, category, priority, status, description ) VALUES (2952, 'Functional',3,'open','pdf image not centering');
