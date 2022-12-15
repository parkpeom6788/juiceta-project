-- 고객 ( enabled 탈퇴 0, 정상 1 ) 
CREATE TABLE juiceta_customer(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	address VARCHAR2(100)  NOT NULL,
	phone VARCHAR2(100) NOT NULL,
	enabled NUMBER DEFAULT 1 NOT NULL
)
INSERT INTO juiceta_customer(id,password,name,address,phone) VALUES ('spring','a','프링이','오리','01011112222');
SELECT * FROM juiceta_customer;


CREATE TABLE juiceta_authorities(
	authority VARCHAR2(30) PRIMARY KEY,
	id VARCHAR2(100) NOT NULL,
	CONSTRAINT fk_authorities_id FOREIGN KEY(id) REFERENCES juiceta_customer(id) ON DELETE CASCADE
)
SELECT * FROM juiceta_authorities