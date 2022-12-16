CREATE TABLE juiceta_product(
	product_no NUMBER PRIMARY KEY,
	product_name VARCHAR2(100) NOT NULL,
	price NUMBER NOT NULL,
	product_count NUMBER NOT NULL,
	product_detail CLOB NOT NULL,
	image VARCHAR2(100) NOT NULL,
	category VARCHAR2(100) NOT NULL
)
CREATE SEQUENCE juiceta_product_seq;
SELECT * FROM juiceta_product;
