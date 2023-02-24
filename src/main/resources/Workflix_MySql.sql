create schema if not exists workflix;
use workflix;

CREATE TABLE email(
	email_id VARCHAR(50) PRIMARY KEY,
    password VARCHAR(20) NOT NULL,

CREATE TABLE user_profile (
	user_profile_id VARCHAR(50) PRIMARY KEY,
	FOREIGN KEY (email_id) REFERENCES email(email_id),
    user_first_name VARCHAR(50) NOT NULL,
    user_last_name VARCHAR(50) NOT NULL);
--     user_gender VARCHAR(3) NOT NULL,
--     phone_number LONG UNIQUE,
--     user_dob DATE NOT NULL);

-- CREATE TABLE workflix_access(
-- 	FOREIGN KEY (user_id) REFERENCES workflix_user(user_id),
--     FOREIGN KEY (friend_id) REFERENCES workflix_user(user_id));
    
CREATE TABLE files(
	file_id LONG AUTO_INCREMENT PRIMARY KEY,
	file_name VARCHAR(50) NOT NULL,
	FOREIGN KEY (user_profile_id) REFERENCES user_profile (user_profile_id),
	descriptions VARCHAR(50),
	file_data LONGBLOB NOT NULL);
    
-- CREATE TABLE file_comment(
-- 	comment_id LONG AUTO_INCREMENT PRIMARY KEY,
--     comment_text VARCHAR(200),
--     FOREIGN KEY (comment_file) REFERENCES upload(file_id),
--     FOREIGN KEY (comment_user) REFERENCES user_profile(user_name));

    