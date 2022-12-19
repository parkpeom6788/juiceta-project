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
INSERT INTO juiceta_authorities (authority,id) VALUES ('ROLE_ADMIN','zzzzz');


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

-- 조회된 결과 행 번호를 부여하기 위해 ROW_NUMBER() OVER(정렬) 함수를 이용
SELECT row_number() over(ORDER BY product_no DESC) AS rnum,product_no,product_name,price,product_count FROM juiceta_product

-- Inline View ( FROM 절의 SUBQUERY ) 를 이용하면 된다

SELECT rnum,product_no,product_name,price,product_count
FROM (
	SELECT row_number() over(ORDER BY product_no DESC) AS rnum,product_no,product_name,price,product_count 
	FROM juiceta_product 
)ORDER BY rnum DESC

-- 상품 등록 SQL
INSERT INTO juiceta_product VALUES (juiceta_product_seq.nextval,'파프리카즙',10000,100,'맛있는 파프리카즙','product-1.jpg','과일즙')
INSERT INTO juiceta_product VALUES (juiceta_product_seq.nextval,'딸기즙',11000,100,'맛있는 딸기즙','product-2.jpg','과일즙')
INSERT INTO juiceta_product VALUES (juiceta_product_seq.nextval,'당근즙',7000,100,'맛있는 당근즙','product-7.jpg','과일즙')

-- 상품 수정 SQL
UPDATE juiceta_product 
SET product_no=6,product_name='브로콜asdasd즙',
price=5000,product_count=20,product_detail='맛있는 브ads로콜리즙',
image='product-6.jpg',category='과일즙'
WHERE product_no=21

-- 상품 삭제 SQL
DELETE FROM juiceta_product WHERE product_no=50;

-- 상품명으로 상품 검색 
-- LIKE 연산자 : 데이터의 일부만 포함되어도 정보가 검색되도록 한다 
-- WHERE 컬럼명 LIKE '%키워드%'
-- %: 0개 이상의 문자를 의미
SELECT product_no,product_name,price,product_count,product_detail,image,category
FROM juiceta_product
WHERE product_name LIKE '%차%'

SELECT rnum,product_no,product_name,price,product_count
		FROM (
		SELECT row_number() over(ORDER BY product_no ASC) AS rnum,product_no,product_name,price,product_count 
		FROM juiceta_product
		) WHERE product_name LIKE '%차%' ORDER BY rnum DESC


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

		SELECT rnum,product_no,product_name,price,product_count,product_detail,image,category
		FROM (
		SELECT row_number() over(ORDER BY product_no ASC) AS rnum,product_no,product_name,price,product_count,
		product_detail,image,category
		FROM juiceta_product
		) ORDER BY rnum DESC




SELECT rnum,product_no,product_name,price,product_count
FROM (
SELECT row_number() over(ORDER BY product_no ASC) AS rnum,product_no,product_name,price,product_count 
FROM juiceta_product
) WHERE product_name LIKE '%양배추%' 
AND rnum BETWEEN 1 AND 11
ORDER BY rnum DESC

SELECT rnum,product_no,product_name,price,product_count,product_detail,image,category
FROM(
SELECT ROW_NUMBER() OVER(ORDER BY product_no DESC) AS rnum,product_no,product_name,price,product_count,product_detail,image,category
FROM juiceta_product
)
WHERE rnum BETWEEN 1 AND 11 ORDER BY rnum DESC

SELECT product_no,product_name,price,product_count,product_detail,image,category FROM juiceta_product








