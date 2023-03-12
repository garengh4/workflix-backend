create schema if not exists Workflix;
use Workflix;

CREATE TABLE email(
	email_id VARCHAR(50) PRIMARY KEY,
    passwords VARCHAR(20) NOT NULL);

CREATE TABLE user_profile(
	user_profile_id VARCHAR(50) PRIMARY KEY,
    email_id VARCHAR(50),
	FOREIGN KEY (email_id) REFERENCES email(email_id),
    user_first_name VARCHAR(50) NOT NULL,
    user_last_name VARCHAR(50) NOT NULL);

CREATE TABLE files(
	file_id BIGINT AUTO_INCREMENT PRIMARY KEY,
	file_name VARCHAR(50) NOT NULL,
    user_profile_id VARCHAR(50),
	FOREIGN KEY (user_profile_id) REFERENCES user_profile(user_profile_id),
	category_name VARCHAR(50),
	descriptions VARCHAR(100),
	file_url VARCHAR(255));

-- CREATE TABLE file_comment(
-- 	comment_id LONG AUTO_INCREMENT PRIMARY KEY,
--     comment_text VARCHAR(200),
--     FOREIGN KEY (comment_file) REFERENCES upload(file_id),
--     FOREIGN KEY (comment_user) REFERENCES user_profile(user_name));

INSERT INTO email (email_id, passwords) VALUES ('janedoe@example.com', '123456789');
INSERT INTO email (email_id, passwords) VALUES ('johnsmith@example.com', '123456789');

Select * FROM email;

INSERT INTO user_profile (user_profile_id, email_id,user_first_name,user_last_name) VALUES ('jane1','janedoe@example.com','Jane','Doe');
INSERT INTO user_profile (user_profile_id, email_id,user_first_name,user_last_name) VALUES ('jane2','janedoe@example.com','Jane','Doe');
INSERT INTO user_profile (user_profile_id, email_id,user_first_name,user_last_name) VALUES ('jane','janedoe@example.com','Jane','Doe');

Select * FROM user_profile;