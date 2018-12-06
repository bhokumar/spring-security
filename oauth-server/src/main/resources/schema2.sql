drop table if exists OAUTH_CLIENT_DETAILS;
create table OAUTH_CLIENT_DETAILS (
  CLIENT_ID VARCHAR(255) PRIMARY KEY,
  RESOURCE_IDS VARCHAR(255),
  CLIENT_SECRET VARCHAR(255),
  SCOPE VARCHAR(255),
  AUTHORIZED_GRANT_TYPES VARCHAR(255),
  WEB_SERVER_REDIRECT_URI VARCHAR(255),
  AUTHORITIES VARCHAR(255),
  ACCESS_TOKEN_VALIDITY INTEGER,
  REFRESH_TOKEN_VALIDITY INTEGER,
  ADDITIONAL_INFORMATION VARCHAR(4096),
  AUTOAPPROVE VARCHAR(255)
);
 
drop table if exists OAUTH_CLIENT_TOKEN;
create table OAUTH_CLIENT_TOKEN (
  TOKEN_ID VARCHAR(255),
  TOKEN LONG VARBINARY,
  AUTHENTICATION_ID VARCHAR(255) PRIMARY KEY,
  USER_NAME VARCHAR(255),
  CLIENT_ID VARCHAR(255)
);
 
drop table if exists OAUTH_ACCESS_TOKEN;
create table OAUTH_ACCESS_TOKEN (
  TOKEN_ID VARCHAR(255),
  TOKEN LONG VARBINARY,
  AUTHENTICATION_ID VARCHAR(255) PRIMARY KEY,
  USER_NAME VARCHAR(255),
  CLIENT_ID VARCHAR(255),
  AUTHENTICATION LONG VARBINARY,
  REFRESH_TOKEN VARCHAR(255)
);
 
drop table if exists OAUTH_REFRESH_TOKEN;
create table OAUTH_REFRESH_TOKEN (
  TOKEN_ID VARCHAR(255),
  TOKEN LONG VARBINARY,
  AUTHENTICATION LONG VARBINARY
);
 
drop table if exists OAUTH_CODE;
create table OAUTH_CODE (
  CODE VARCHAR(255), authentication LONG VARBINARY
);
 
drop table if exists OAUTH_APPROVALS;
create table OAUTH_APPROVALS (
    USERID VARCHAR(255),
    CLIENTID VARCHAR(255),
    SCOPE VARCHAR(255),
    STATUS VARCHAR(10),
    EXPIRESAT TIMESTAMP,
    LASTMODIFIEDAT TIMESTAMP
);
 
drop table if exists CLIENTDETAILS;
create table CLIENTDETAILS (
  APPID VARCHAR(255) PRIMARY KEY,
  RESOURCEIDS VARCHAR(255),
  APPSECRET VARCHAR(255),
  SCOPE VARCHAR(255),
  GRANTTYPES VARCHAR(255),
  REDIRECTURL VARCHAR(255),
  AUTHORITIES VARCHAR(255),
  ACCESS_TOKEN_VALIDITY INTEGER,
  REFRESH_TOKEN_VALIDITY INTEGER,
  ADDITIONALINFORMATION VARCHAR(4096),
  AUTOAPPROVESCOPES VARCHAR(255)
);


drop table if exists USERS_AUTHORITIES;
drop table if exists AUTHORITY;
drop table if exists USER_;

create table USER_(
	ID INTEGER PRIMARY KEY,
	USER_NAME VARCHAR(255),
	PASSWORD VARCHAR(255),
	ACCOUNT_EXPIRED BOOLEAN,
	ACCOUNT_LOCKED  BOOLEAN,
	CREDENTIALS_EXPIRED BOOLEAN,
	ENABLED BOOLEAN
);

create table AUTHORITY(
	ID INTEGER PRIMARY KEY,
	NAME VARCHAR(255)
);

create table USERS_AUTHORITIES(
	USER_ID INTEGER ,
	AUTHORITY_ID INTEGER,
	FOREIGN KEY (USER_ID) REFERENCES USER_(ID),
	FOREIGN KEY (AUTHORITY_ID) REFERENCES AUTHORITY(ID)
);

drop table if exists EMPLOYEE;
drop table if exists DEPARTMENT;
drop table if exists CAR;
drop table if exists COMPANY;
drop table if exists ADDRESS;

create table COMPANY(
	ID INTEGER PRIMARY KEY,
	NAME VARCHAR(255)
);


create table CAR(
	ID INTEGER PRIMARY KEY,
	REGISTRATION_NUMBER INTEGER,
	COMPANY_ID INTEGER,
	FOREIGN KEY(COMPANY_ID) REFERENCES COMPANY(ID)
);

create table DEPARTMENT(
	ID INTEGER PRIMARY KEY,
	NAME VARCHAR(255),
	COMPANY_ID INTEGER,
	FOREIGN KEY(COMPANY_ID) REFERENCES COMPANY(ID)
);

create table ADDRESS(
	ID INTEGER PRIMARY KEY,
	HOUSE_NUMBER VARCHAR(255),
	STREET VARCHAR(255),
	ZIPCODE VARCHAR(255)
);

create table EMPLOYEE(
	ID INTEGER PRIMARY KEY,
	NAME VARCHAR(255),
	SURNAME VARCHAR(255),
	ADDRESS_ID INTEGER,
	DEPARTMENT_ID INTEGER,
	FOREIGN KEY(ADDRESS_ID) REFERENCES ADDRESS(ID),
	FOREIGN KEY(DEPARTMENT_ID) REFERENCES DEPARTMENT(ID)
);

insert into CLIENTDETAILS values('Client2', 'resource', 'secret123','toll_read','password', 'http://localhost:8080', 'toll_read', 45781,45781,null,'true');
insert into OAUTH_CLIENT_DETAILS values('Client2', 'resource', 'secret123','toll_read','password', 'http://localhost:8080', 'toll_read', 45781,45781,null,'true');

INSERT INTO OAUTH_CLIENT_DETAILS(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)

 VALUES ('spring-security-oauth2-read-client', 'resource-server-rest-api',

 /*spring-security-oauth2-read-client-password1234*/'$2a$04$WGq2P9egiOYoOFemBRfsiO9qTcyJtNRnPKNBl5tokP7IP.eZn93km',

 'read', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);

INSERT INTO OAUTH_CLIENT_DETAILS(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)

 VALUES ('spring-security-oauth2-read-write-client', 'resource-server-rest-api',

 /*spring-security-oauth2-read-write-client-password1234*/'$2a$04$soeOR.QFmClXeFIrhJVLWOQxfHjsJLSpWrU1iGxcMGdu.a5hvfY4W',

 'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);
 
 
 insert into authority(id, name) values (1, 'company_create');

insert into authority(id, name) values (2, 'company_read');

insert into authority(id, name) values (3, 'company_update');

insert into authority(id, name) values (4, 'company_delete');

insert into authority(id, name) values (5, 'department_create');

insert into authority(id, name) values (6, 'department_read');

insert into authority(id, name) values (7, 'department_update');

insert into authority(id, name) values (8, 'department_delete');


insert into user_(id, user_name, password, account_expired, account_locked, credentials_expired, enabled)

  values (1, 'admin', /*admin1234*/'$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha', FALSE, FALSE, FALSE, TRUE);

insert into user_(id, user_name, password, account_expired, account_locked, credentials_expired, enabled)

  values (2, 'reader', /*reader1234*/'$2a$08$dwYz8O.qtUXboGosJFsS4u19LHKW7aCQ0LXXuNlRfjjGKwj5NfKSe', FALSE, FALSE, FALSE, TRUE);

insert into user_(id, user_name, password, account_expired, account_locked, credentials_expired, enabled)

  values (3, 'modifier', /*modifier1234*/'$2a$08$kPjzxewXRGNRiIuL4FtQH.mhMn7ZAFBYKB3ROz.J24IX8vDAcThsG', FALSE, FALSE, FALSE, TRUE);

insert into user_(id, user_name, password, account_expired, account_locked, credentials_expired, enabled)

  values (4, 'reader2', /*reader1234*/'$2a$08$vVXqh6S8TqfHMs1SlNTu/.J25iUCrpGBpyGExA.9yI.IlDRadR6Ea', FALSE, FALSE, FALSE, TRUE);

insert into users_authorities(user_id, authority_id) values (1, 1);

insert into users_authorities(user_id, authority_id) values (1, 2);

insert into users_authorities(user_id, authority_id) values (1, 3);

insert into users_authorities(user_id, authority_id) values (1, 4);

insert into users_authorities(user_id, authority_id) values (1, 5);

insert into users_authorities(user_id, authority_id) values (1, 6);

insert into users_authorities(user_id, authority_id) values (1, 7);

insert into users_authorities(user_id, authority_id) values (1, 8);

insert into users_authorities(user_id, authority_id) values (2, 2);

insert into users_authorities(user_id, authority_id) values (2, 6);

insert into users_authorities(user_id, authority_id) values (3, 3);

insert into users_authorities(user_id, authority_id) values (3, 7);

insert into users_authorities(user_id, authority_id) values (4, 8);



 
 
 
