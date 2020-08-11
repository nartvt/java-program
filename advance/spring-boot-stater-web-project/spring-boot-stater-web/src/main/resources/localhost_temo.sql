
CREATE TABLE USERS (
id NUMBER NOT NULL,
userName nvarchar2(255) NOT NULL,
age NUMBER,
email nvarchar2(255) NOT NULL
);
<!----------------------------------- -->
ALTER TABLE USERS MODIFY age NUMBER NOT NULL;
<!----------------------------------- -->
ALTER TABLE USERS ADD (CONSTRAINT usres_pk PRIMARY KEY (id));
<!----------------------------------- -->
CREATE SEQUENCE users_seq START WITH 1;
<!----------------------------------- -->
CREATE OR REPLACE TRIGGER dept_bir 
BEFORE INSERT ON USERS 
FOR EACH ROW
BEGIN
  SELECT users_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;
<!----------------------------------- -->
INSERT INTO USERS(userName,age,email) VALUES('taitran',25,'tranvantai0011@gmail.com');
INSERT INTO USERS(userName,age,email) VALUES('taitran2',28,'tranvantai0012@gmail.com');
<!----------------------------------- -->