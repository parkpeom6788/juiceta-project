SELECT * FROM juiceta_product;

INSERT INTO juiceta_product(product_no,product_name,price,product_count,product_detail,image,category) 
VALUES(juiceta_product_seq.nextval,'파프리카즙',10000,30,'맛있는 파프리카즙','product-1.jpg','과일즙');
INSERT INTO juiceta_product(product_no,product_name,price,product_count,product_detail,image,category) 
VALUES(juiceta_product_seq.nextval,'딸기즙',9000,30,'맛있는 딸기즙','product-2.jpg','과일즙');
INSERT INTO juiceta_product(product_no,product_name,price,product_count,product_detail,image,category) 
VALUES(juiceta_product_seq.nextval,'완두콩차',12000,30,'맛있는 완두콩차','product-3.jpg','과일차');
INSERT INTO juiceta_product(product_no,product_name,price,product_count,product_detail,image,category) 
VALUES(juiceta_product_seq.nextval,'양배추즙',10000,30,'맛있는 양배추즙','product-4.jpg','과일차');

-- 상품리스트 조회
SELECT product_no,product_name,price,product_count,product_detail,image,category FROM juiceta_product;

SELECT * FROM juiceta_customer;

-- 회원탈퇴 ( 비활성상태 )
UPDATE juiceta_customer SET enabled=0 WHERE id='jtest';
COMMIT

-- 아이디찾기
SELECT id FROM juiceta_customer WHERE name='아이유' AND phone='000000000' AND enabled='1';











