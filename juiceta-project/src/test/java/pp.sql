SELECT * FROM juiceta_customer;

SELECT * FROM juiceta_authorities;

SELECT * FROM juiceta_question;

SELECT * FROM juiceta_product

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,check_answer,id,product_no) 
VALUES (1,'제목입니다1','답변입니다1','2022-12-16',0,'pjs',1)

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,check_answer,id,product_no) 
VALUES (2,'제목입니다2','답변입니다2','2022-12-16',0,'pjs',1)

INSERT INTO juiceta_question(question_no,question_title,question_content,question_time,check_answer,id,product_no) 
VALUES (3,'제목입니다3','답변입니다3','2022-12-16',0,'pjs',1)

delete from juiceta_question;
commit


