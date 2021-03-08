DROP TABLE IF EXISTS branch;

CREATE TABLE branch (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  branch_name VARCHAR(250) NOT NULL,
  branch_location VARCHAR(250) NOT NULL,
  vaccine_count INT DEFAULT 0,
  time_availability_for_vaccine TIMESTAMP
);

INSERT INTO branch (branch_name, branch_location, vaccine_count,time_availability_for_vaccine) VALUES
  ('Covid Vaccine Center', 'Sec- 19,Gurgaon', 2400,'2021-04-17'),
  ('Covid Vaccine Center', 'Munirka,New Delhi',5400,'2021-04-15'),
  ('Covid Vaccine Center', 'Sec-62 ,Noida', 10000,'2021-04-18');
  
DROP TABLE IF EXISTS schedule_vaccine;  
CREATE TABLE schedule_vaccine
(
    id INT AUTO_INCREMENT  PRIMARY KEY,
	user_id Int NOT NULL ,
    branch_id Int NOT NULL,
    time_slot timestamp NOT NULL,
	payment_mode varchar(50)  NOT NULL,
	notified char(1)
   
); 


-- Table: user

-- DROP TABLE user;

CREATE TABLE user
(
    id INT AUTO_INCREMENT  PRIMARY KEY,
    username varchar(24) NOT NULL,
    email varchar(255)  NOT NULL,
    enabled boolean NOT NULL,
    account_expired boolean NOT NULL
);

INSERT INTO user (username, email, enabled, account_expired) VALUES
  ('ankit.gupta', 'ankit.gupta@nagarro.com', true,'N'),
  ('shadab.khan', 'shadab.khan@nagarro.com',true,'N'),
  ('anil.tiwari', 'anil.tiwari@nagarro.com', true,'N'); 

