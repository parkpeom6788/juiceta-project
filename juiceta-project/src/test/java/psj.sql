-- 고객 ( enabled 탈퇴 0, 정상 1 ) 
CREATE TABLE juiceta_customer(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	address VARCHAR2(100)  NOT NULL,
	phone VARCHAR2(100) NOT NULL,
	enabled NUMBER DEFAULT 1 NOT NULL
)
SELECT * FROM juiceta_customer;
ALTER TABLE juiceta_customer DROP COLUMN authority;

INSERT INTO juiceta_customer(id,password,name,address,phone) VALUES ('pjs','a','진수박','독산','01012345678')

-- 권한 ( authority 관리자, 회원, 비회원 )
CREATE TABLE juiceta_authorities(
	authority VARCHAR2(30),
	id VARCHAR2(100) NOT NULL,
	CONSTRAINT fk_authorities_id FOREIGN KEY(id) REFERENCES juiceta_customer(id) ON DELETE CASCADE,
	CONSTRAINT pk_authorities PRIMARY KEY(authority,id)
)
SELECT * FROM juiceta_authorities;
INSERT INTO juiceta_authorities (authority,id) VALUES ('ROLE_ADMIN','pjs');
INSERT INTO juiceta_authorities (authority,id) VALUES ('ROLE_MEMBER','pjs');
INSERT INTO juiceta_authorities (authority,id) VALUES ('ROLE_MEMBER','spring');


-- 리뷰
CREATE TABLE juiceta_review(
	review_no NUMBER PRIMARY KEY,
	review_content CLOB NOT NULL,
	star NUMBER NOT NULL,
	review_time DATE NOT NULL,
	id VARCHAR2(100) NOT NULL,
	order_no NUMBER NOT NULL,
	product_no NUMBER NOT NULL,
	CONSTRAINT fk_review_id FOREIGN KEY(id) REFERENCES juiceta_customer(id) ON DELETE CASCADE,
	CONSTRAINT fk_review_order_no FOREIGN KEY(order_no) REFERENCES juiceta_order(order_no) ON DELETE CASCADE,
	CONSTRAINT fk_review_product_no FOREIGN KEY(product_no) REFERENCES juiceta_product(product_no) ON DELETE CASCADE
)
CREATE SEQUENCE juiceta_review_seq;
SELECT * FROM juiceta_review;

-- 문의사항 ( check_answer 미답변 0 답변 1 )
CREATE TABLE juiceta_question(
	question_no NUMBER PRIMARY KEY,
	question_title VARCHAR2(100) NOT NULL,
	question_content CLOB NOT NULL,
	question_time DATE NOT NULL,
	check_answer NUMBER DEFAULT 0,
	id VARCHAR2(100) NOT NULL,
	product_no NUMBER NOT NULL,
	CONSTRAINT fk_question_id FOREIGN KEY(id) REFERENCES juiceta_customer(id) ON DELETE CASCADE,
	CONSTRAINT fk_question_product_no FOREIGN KEY(product_no) REFERENCES juiceta_product(product_no) ON DELETE CASCADE
)
CREATE SEQUENCE juiceta_question_seq;
SELECT * FROM juiceta_question;

-- 문의사항 답변
CREATE TABLE juiceta_answer(
	question_no NUMBER PRIMARY KEY,
	answer_content CLOB NOT NULL,
	answer_time DATE NOT NULL,
	CONSTRAINT fk_answer_question_no FOREIGN KEY(question_no) REFERENCES juiceta_question(question_no) ON DELETE CASCADE
)
SELECT * FROM juiceta_answer;

-- 주문
CREATE TABLE juiceta_order(
	order_no NUMBER PRIMARY KEY,
	order_time DATE NOT NULL,
	receiver_name VARCHAR2(100) NOT NULL,
	receiver_phone VARCHAR2(100) NOT NULL,
	receiver_address VARCHAR2(100) NOT NULL,
	id VARCHAR2(100) NOT NULL,
	CONSTRAINT fk_order_id FOREIGN KEY(id) REFERENCES juiceta_customer(id) ON DELETE CASCADE
)
SELECT * FROM juiceta_order;

-- 주문상세
CREATE TABLE juiceta_order_detail(
	order_no NUMBER,
	product_no NUMBER,
	order_count NUMBER NOT NULL,
	CONSTRAINT fk_order_detail_order_no FOREIGN KEY(order_no) REFERENCES juiceta_order(order_no) ON DELETE CASCADE,
	CONSTRAINT fk_order_detail_product_no FOREIGN KEY(product_no) REFERENCES juiceta_product(product_no) ON DELETE CASCADE,
	CONSTRAINT pk_order_detail PRIMARY KEY(order_no,product_no)
)
SELECT * FROM juiceta_order_detail;

-- 장바구니
CREATE TABLE juiceta_cart(
	id VARCHAR2(100),
	product_no NUMBER,
	product_count NUMBER NOT NULL,
	CONSTRAINT fk_cart_id FOREIGN KEY(id) REFERENCES juiceta_customer(id) ON DELETE CASCADE,
	CONSTRAINT fk_cart_product_no FOREIGN KEY(product_no) REFERENCES juiceta_product(product_no) ON DELETE CASCADE,
	CONSTRAINT pk_cart PRIMARY KEY(id,product_no)
)
SELECT * FROM juiceta_cart;

-- 찜목록
CREATE TABLE juiceta_wishlist(
	id VARCHAR2(100),
	product_no NUMBER,
	CONSTRAINT fk_wishlist_id FOREIGN KEY(id) REFERENCES juiceta_customer(id) ON DELETE CASCADE,
	CONSTRAINT fk_wishlist_product_no FOREIGN KEY(product_no) REFERENCES juiceta_product(product_no) ON DELETE CASCADE,
	CONSTRAINT pk_wishlist PRIMARY KEY(id,product_no)
)
SELECT * FROM juiceta_wishlist;

-- 상품
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

-- 공지사항
CREATE TABLE juiceta_board(
	board_no NUMBER PRIMARY KEY,
	board_title VARCHAR2(100) NOT NULL,
	board_content CLOB NOT NULL,
	board_time DATE NOT NULL,
	hits NUMBER default 0
)
CREATE SEQUENCE juiceta_board_seq;
SELECT * FROM juiceta_board;



















