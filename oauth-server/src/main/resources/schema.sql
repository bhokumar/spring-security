select * from car;


drop table if exists oauth_client_details;
create table oauth_client_details (
  client_id varchar(255) primary key,
  resource_ids varchar(255),
  client_secret varchar(255),
  scope varchar(255),
  authorized_grant_types varchar(255),
  web_server_redirect_uri varchar(255),
  authorities varchar(255),
  access_token_validity integer,
  refresh_token_validity integer,
  additional_information varchar(4096),
  autoapprove varchar(255)
);
 
drop table if exists oauth_client_token;
create table oauth_client_token (
  token_id varchar(255),
  token long varbinary,
  authentication_id varchar(255) primary key,
  user_name varchar(255),
  client_id varchar(255)
);
 
drop table if exists oauth_access_token;
create table oauth_access_token (
  token_id varchar(255),
  token long varbinary,
  authentication_id varchar(255) primary key,
  user_name varchar(255),
  client_id varchar(255),
  authentication long varbinary,
  refresh_token varchar(255)
);
 
drop table if exists oauth_refresh_token;
create table oauth_refresh_token (
  token_id varchar(255),
  token long varbinary,
  authentication long varbinary
);
 
drop table if exists oauth_code;
create table oauth_code (
  code varchar(255), authentication long varbinary
);
 
drop table if exists oauth_approvals;
create table oauth_approvals (
    userid varchar(255),
    clientid varchar(255),
    scope varchar(255),
    status varchar(10),
    expiresat timestamp,
    lastmodifiedat timestamp
);
 
drop table if exists clientdetails;
create table clientdetails (
  appid varchar(255) primary key,
  resourceids varchar(255),
  appsecret varchar(255),
  scope varchar(255),
  granttypes varchar(255),
  redirecturl varchar(255),
  authorities varchar(255),
  access_token_validity integer,
  refresh_token_validity integer,
  additionalinformation varchar(4096),
  autoapprovescopes varchar(255)
);



insert into oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, authorities, access_token_validity, refresh_token_validity)

 VALUES ('spring-security-oauth2-read-client', 'resource-server-rest-api',

 /*spring-security-oauth2-read-client-password1234*/'$2a$04$WGq2P9egiOYoOFemBRfsiO9qTcyJtNRnPKNBl5tokP7IP.eZn93km',

 'read', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);

insert into oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, authorities, access_token_validity, refresh_token_validity)

 VALUES ('spring-security-oauth2-read-write-client', 'resource-server-rest-api',

 /*spring-security-oauth2-read-write-client-password1234*/'$2a$04$soeOR.QFmClXeFIrhJVLWOQxfHjsJLSpWrU1iGxcMGdu.a5hvfY4W',

 'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);

