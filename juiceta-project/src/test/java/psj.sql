CREATE TABLE juiceta_authorities(
	authority VARCHAR2(30) PRIMARY KEY
)
CREATE TABLE juiceta_customer(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	address VARCHAR2(100)  NOT NULL,
	phone VARCHAR2(100) NOT NULL,
	enabled NUMBER DEFAULT 1 NOT NULL,
	authority VARCHAR2(30) NOT NULL,
	CONSTRAINT fk_authority FOREIGN KEY(authority) REFERENCES juiceta_authorities(authority) ON DELETE CASCADE
)

INSERT INTO juiceta_authorities(authority) VALUES ('회원');

INSERT INTO juiceta_customer (id,password,name,address,phone,authority) 
VALUES ('javakong','a','자바콩','오리','01012345678','회원')
COMMIT
-- 전체 고객 조회 SQL
SELECT * FROM juiceta_customer
-- id password로 회원찾기 SQL
SELECT id,password,name,address,phone,enabled,a.authority
FROM juiceta_customer c
INNER JOIN juiceta_authorities a ON c.authority=a.authority
WHERE c.id='javakong' AND c.password='a'

















