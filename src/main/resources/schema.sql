--Create an Oracle realm
SET DATABASE SQL SYNTAX ORA TRUE;

--User
CREATE TABLE IF NOT EXISTS user(
  id INTEGER PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  email  VARCHAR(50) UNIQUE,
);
--ALTER TABLE user ADD CONSTRAINT email_unique unique (email);

INSERT INTO user (id, first_name, last_name, email) VALUES (1, 'Omar', 'Gaye', 'omar@gmail.com');
INSERT INTO user (id, first_name, last_name, email) VALUES (2, 'Bill', 'Smith', 'bill@gmail.com');


CREATE TABLE IF NOT EXISTS CLAIM(
  id INTEGER PRIMARY KEY,
  fname VARCHAR(30),
  lname VARCHAR(30),
  providerid  VARCHAR(80),
  providerdisplayname VARCHAR(80),
  patientid VARCHAR(80),
  diagnosiscode VARCHAR(30),
  diagnosisdescription VARCHAR(150),
  amount VARCHAR(10),
  currency VARCHAR(10)
);

insert into claim(id, fname, lname, providerid, providerdisplayname, patientid, diagnosiscode, diagnosisdescription, amount, currency)
values ('5000', 'Jane', 'smith', 'ADD86DF5-ECEC-3535-A92E-C2BBEBC9342B', 'HALLMARK HEALTH SYSTEM', '8FEB07FD-F1D9-1CA7-D150-F558E1A7F462', '4728',
'Stuffy Nose', '$17.59', '$17.59');
--insert into claim(id, fname, lname, email, phone) values (2, 'Bill', 'Smith', 'bill@ibm.com', '4045811893');



COMMIT WORK;