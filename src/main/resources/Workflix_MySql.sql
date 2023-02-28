create schema if not exists workflix;
use workflix;

CREATE TABLE email(
	email_id VARCHAR(50) PRIMARY KEY,
    passwords VARCHAR(20) NOT NULL);

CREATE TABLE user_profile (
	user_profile_id VARCHAR(50) PRIMARY KEY,
	FOREIGN KEY (email_id) REFERENCES email(email_id),
    user_first_name VARCHAR(50) NOT NULL,
    user_last_name VARCHAR(50) NOT NULL);

CREATE TABLE files(
	file_id LONG PRIMARY KEY,
	file_name VARCHAR(50) NOT NULL,
	FOREIGN KEY (user_profile_id) REFERENCES user_profile (user_profile_id),
	descriptions VARCHAR(50),
	file_data LONGBLOB NOT NULL);
    
-- CREATE TABLE file_comment(
-- 	comment_id LONG AUTO_INCREMENT PRIMARY KEY,
--     comment_text VARCHAR(200),
--     FOREIGN KEY (comment_file) REFERENCES upload(file_id),
--     FOREIGN KEY (comment_user) REFERENCES user_profile(user_name));



INSERT INTO email (email_id, passwords) VALUES ('janeDoe@example.com', '123456789');
INSERT INTO email (email_id, passwords) VALUES ('johnSmith@example.com', '123456789');
    