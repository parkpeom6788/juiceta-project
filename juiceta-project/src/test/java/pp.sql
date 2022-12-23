SELECT * FROM juiceta_customer;

SELECT * FROM juiceta_authorities;

SELECT * FROM juiceta_question;

SELECT * FROM juiceta_product

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,check_answer,id,product_no) 
VALUES (juiceta_question_seq.nextval,'제목입니다1','문의내용 입니다1','2022-12-18',0,'pjs',1)

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,check_answer,id,product_no) 
VALUES (2,'제목입니다2','답변입니다2','2022-12-16',0,'pjs',1)

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,check_answer,id,product_no) 
VALUES (3,'제목입니다3','답변입니다3','2022-12-16',0,'pjs',1)

SELECT QUESTION_NO,QUESTION_TITLE,QUESTION_CONTENT,QUESTION_TIME , CHECK_ANSWER , ID , PRODUCT_NO
 FROM juiceta_question
WHERE product_no=1;

delete from juiceta_question;

SELECT * FROM juiceta_question;

commit

SELECT COUNT(*) FROM juiceta_cart WHERE id='jtest3'; 

CREATE SEQUENCE juiceta_question_seq;

SELECT QUESTION_NO,QUESTION_TITLE,QUESTION_CONTENT,QUESTION_TIME , CHECK_ANSWER , ID , PRODUCT_NO
 FROM juiceta_question
WHERE product_no=1;

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,check_answer,id,product_no) 
VALUES (1,'제목입니다1','문의내용 입니다1','2022-12-16',0,'pjs',64)

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,id,product_no) 
VALUES (juiceta_question_seq.nextval,'제목입니다3','문의내용 입니다3',sysdate,'pjs',64)

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,check_answer,id,product_no) 
VALUES (2,'제목입니다2','답변입니다2','2022-12-16',0,'pjs',1)

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,check_answer,id,product_no) 
VALUES (3,'제목입니다3','답변입니다3','2022-12-16',0,'pjs',1)

SELECT QUESTION_NO,QUESTION_TITLE,QUESTION_CONTENT,QUESTION_TIME , CHECK_ANSWER , ID , PRODUCT_NO
 FROM juiceta_question
WHERE product_no=1;

INSERT INTO juiceta_question(QUESTION_NO,QUESTION_TITLE,QUESTION_CONTENT,QUESTION_TIME , CHECK_ANSWER ,
PRODUCT_NO,id) VALUES(2,'제목입니다2','문의사항 입니다2','2022-12-18',0,64,'pjs');

DELETE FROM juiceta_question;

SELECT * FROM juiceta_answer;

SELECT * FROM juiceta_authorities;

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,id,product_no) 
VALUES (juiceta_question_seq.nextval,'제목입니다4','문의내용 입니다4',sysdate,'pjs',64)

SELECT QUESTION_NO,QUESTION_TITLE,QUESTION_CONTENT,QUESTION_TIME , CHECK_ANSWER , ID , PRODUCT_NO
 FROM juiceta_question
WHERE product_no=1;

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,check_answer,id,product_no) 
VALUES (1,'제목입니다1','문의내용 입니다1','2022-12-16',0,'pjs',64)

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,id,product_no) 
VALUES (juiceta_question_seq.nextval,'제목입니다3','문의내용 입니다3',sysdate,'pjs',64)

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,check_answer,id,product_no) 
VALUES (2,'제목입니다2','답변입니다2','2022-12-16',0,'pjs',1)

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,check_answer,id,product_no) 
VALUES (3,'제목입니다3','답변입니다3','2022-12-16',0,'pjs',1)

SELECT QUESTION_NO,QUESTION_TITLE,QUESTION_CONTENT,QUESTION_TIME , CHECK_ANSWER , ID , PRODUCT_NO
 FROM juiceta_question
WHERE product_no=1;

INSERT INTO juiceta_question(QUESTION_NO,QUESTION_TITLE,QUESTION_CONTENT,QUESTION_TIME , CHECK_ANSWER ,
PRODUCT_NO,id) VALUES(2,'제목입니다2','문의사항 입니다2','2022-12-18',0,64,'pjs');

DELETE FROM juiceta_question;

SELECT * FROM juiceta_answer;

DELETE FROM juiceta_answer;

SELECT * FROM juiceta_authorities;

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,id,product_no) 
VALUES (juiceta_question_seq.nextval,'제목입니다4','문의내용 입니다4',sysdate,'pjs',64)

SELECT * FROM juiceta_answer;

SELECT QUESTION_NO , ANSWER_CONTENT , ANSWER_TIME
FROM juiceta_answer;

DELETE FROM juiceta_answer;

SELECT QUESTION_NO , ANSWER_CONTENT , ANSWER_TIME  FROM juiceta_answer;
-----------------------------------------------------------------------------------------------------------
-- 장바구니
CREATE TABLE juiceta_cart(
	id VARCHAR2(100),
	product_no NUMBER,
	product_count NUMBER NOT NULL,
	CONSTRAINT fk_cart_id FOREIGN KEY(id) REFERENCES juiceta_customer(id) ON DELETE CASCADE,
	CONSTRAINT fk_cart_product_no FOREIGN KEY(product_no) REFERENCES juiceta_product(product_no) ON DELETE CASCADE,
	CONSTRAINT pk_cart PRIMARY KEY(id,product_no)
)
SELECT * FROM juiceta_car;

SELECT * FROM juiceta_cart WHERE id='jtest3';

SELECT COUNT(*) FROM juiceta_cart WHERE id='jtest3'; // 24

DELETE FROM juiceta_cart WHERE id='jtest3' and product_no = '332';

SELECT * FROM juiceta_cart;

SELECT * FROM juiceta_cart;
commit

SELECT * FROM juiceta_question;

UPDATE juiceta_question SET CHECK_ANSWER = 1 WHERE question_no = 109; 

SELECT PRODUCT_NO,PRODUCT_COUNT FROM juiceta_cart WHERE id='jtest3'; 

SELECT * FROM JUICETA_CUSTOMER;

SELECT P.PRODUCT_NO,P.PRODUCT_NAME , P.PRODUCT_NAME , P.PRICE , P.PRODUCT_COUNT , P.PRODUCT_DETAIL , P.IMAGE , P.CATEGORY
FROM juiceta_product P INNER JOIN juiceta_cart C ON P.PRODUCT_NO = C.PRODUCT_NO
WHERE C.ID='jtest3';

SELECT * FROM JUICETA_CUSTOMER;

DELETE FROM juiceta_cart WHERE id='jtest3' and product_no = '332';

SELECT * FROM juiceta_question;

SELECT COUNT(*) FROM juiceta_question WHERE product_no=332;


SELECT P.PRODUCT_NO,P.PRODUCT_NAME , P.PRODUCT_NAME , P.PRICE , P.PRODUCT_COUNT , P.PRODUCT_DETAIL , P.IMAGE , P.CATEGORY
FROM juiceta_product P INNER JOIN juiceta_cart C ON P.PRODUCT_NO = C.PRODUCT_NO
WHERE C.ID='jtest3';
-- 
SELECT rnum,product_no,product_name,price,product_count
FROM (
	SELECT row_number() over(ORDER BY product_no ASC) AS rnum,product_no,product_name,price
	FROM juiceta_product
) WHERE product_no = 332
AND rnum BETWEEN 1 AND 11
ORDER BY rnum DESC;

SELECT rnum , QUESTION_NO,QUESTION_TITLE,QUESTION_CONTENT,QUESTION_TIME , CHECK_ANSWER,ID,PRODUCT_NO
FROM(
	SELECT row_number() over(ORDER BY question_no DESC) AS rnum , QUESTION_NO,QUESTION_TITLE,QUESTION_CONTENT,QUESTION_TIME , CHECK_ANSWER
	 ,ID,PRODUCT_NO 
	FROM juiceta_question
	WHERE product_no=332
)
WHERE rnum BETWEEN 1 AND 11 

