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
SELECT product_no,product_name,price,product_count,product_detail,image,category FROM juiceta_product ORDER BY product_no DESC;

SELECT * FROM juiceta_authorities;
SELECT * FROM juiceta_customer;
SELECT * FROM juiceta_product ORDER BY product_no;
SELECT * FROM juiceta_review;

-- 회원탈퇴 ( 비활성상태 )
UPDATE juiceta_customer SET enabled=0 WHERE id='jtest';
COMMIT

-- 아이디찾기
SELECT id FROM juiceta_customer WHERE name='아이유' AND phone='000000000' AND enabled='1';

-- 비밀번호찾기 (임시비밀번호발급)
	-- 회원정보에 해당하는 회원 존재유무 확인
	SELECT COUNT(*) FROM juiceta_customer WHERE id='jtest0' AND name='아이유' AND phone='000000000';

INSERT INTO juiceta_authorities(authority,id) VALUES('ROLE_ADMIN','jtest3');
UPDATE juiceta_product SET product_count=0 WHERE product_no=3;

-- shop pagination
	-- 등록된 상품정보를 이용하여 상품게시물 여러개 등록하기
	INSERT INTO juiceta_product(product_no,product_name,price,product_count,product_detail,image,category)
	SELECT juiceta_product_seq.nextval,product_name,price,product_count,product_detail,image,category FROM juiceta_product;
	
	SELECT COUNT(*) FROM juiceta_product;

	-- startRowNumber 와 endRowNumber 만큼 조회하기
	SELECT rnum,product_no,product_name,price,product_count,product_detail,image,category
	FROM(
		SELECT ROW_NUMBER() OVER(ORDER BY product_no DESC) AS rnum,product_no,product_name,price,product_count,product_detail,image,category
		FROM juiceta_product
	)
	WHERE rnum BETWEEN 1 AND 8;

-- 찜목록조회
SELECT * FROM juiceta_wishlist;
INSERT INTO juiceta_wishlist VALUES('jtest1',126);
SELECT COUNT(*) FROM juiceta_wishlist WHERE id='jtest1' AND product_no=126;

-- 회원리스트 조회
SELECT c.id, c.name,c.address,c.phone,c.enabled,a.authority FROM juiceta_customer c
INNER JOIN juiceta_authorities a ON c.id=a.id
ORDER BY c.id DESC;

-- 상품명으로 상품검색
SELECT * FROM juiceta_product
WHERE product_name LIKE '%양%';

-- 장바구니담기
SELECT * FROM juiceta_cart;
SELECT COUNT(*) FROM juiceta_cart WHERE id='jtest3' AND product_no=332;
INSERT INTO juiceta_cart(id,product_no,product_count) VALUES('jtest3',332,1);
COMMIT

-- 회원아이디로 장바구니 상품 총갯수 조회
SELECT COUNT(*) FROM juiceta_cart WHERE id='jtest3';

-- 상품상세설명에서 바로 구매하기
	-- 주문하기
	INSERT INTO juiceta_order(order_no,order_time,receiver_name,receiver_phone,receiver_address,id)
	VALUES(juiceta_order_seq.nextval,SYSDATE,'송중기','000000000','오리','jtest3');
	COMMIT
	
	SELECT * FROM juiceta_order;
	
	-- 주문상세
	INSERT INTO juiceta_order_detail(order_no,product_no,order_count) VALUES(1,332,2);
	SELECT * FROM juiceta_order_detail;
	
	SELECT * FROM juiceta_board;
	
	INSERT INTO juiceta_board(board_no,board_title,board_content,board_time,hits)
	SELECT juiceta_board_seq.nextval,board_title,board_content,board_time,hits FROM juiceta_board;

	-- 주문 결과 조회
	SELECT * FROM juiceta_order;
	
	SELECT order_no,receiver_name,receiver_phone,receiver_address FROM juiceta_order WHERE order_no=3;

SELECT category FROM juiceta_product;
UPDATE juiceta_product SET category='juice' WHERE category='Juice' OR category='과일즙';
UPDATE juiceta_product SET category='tea' WHERE category='Tea';
COMMIT

-- 마이페이지 주문내역 ( 주문번호, 주문날짜, 총합계 )
	-- 아이디로 주문내역 검색
	SELECT * FROM juiceta_order WHERE id='jtest3';
	SELECT * FROM juiceta_order_detail WHERE order_no=1;
	
	-- 주문번호, 상품번호, 상품가격, 수량
	SELECT o.order_no,o.order_time,d.product_no, p.price,d.order_count, (p.price*d.order_count) AS total_price
	FROM juiceta_order_detail d
	INNER JOIN juiceta_product p ON d.product_no=p.product_no
	INNER JOIN juiceta_order o ON d.order_no=o.order_no
	INNER JOIN juiceta_customer c ON c.id=o.id
	WHERE c.id='jtest3';
	
	SELECT order_no, order_time, SUM(total_price) AS total_price
	FROM(
		SELECT d.order_no,TO_CHAR(o.order_time,'YYYY-MM-DD HH24:MI:SS') AS order_time,d.product_no, p.price,d.order_count, (p.price*d.order_count) AS total_price
		FROM juiceta_order_detail d
		INNER JOIN juiceta_product p ON d.product_no=p.product_no
		INNER JOIN juiceta_order o ON d.order_no=o.order_no
		INNER JOIN juiceta_customer c ON c.id=o.id
		WHERE c.id='jtest3'
	)
	GROUP BY order_no,order_time
	ORDER BY order_no DESC;
	
	-- 페이징처리
	SELECT order_no, order_time, total_price
	FROM(
		SELECT ROW_NUMBER() OVER(ORDER BY order_no DESC) AS rnum,order_no, order_time, total_price
		FROM(
			SELECT order_no, order_time, SUM(total_price) AS total_price
			FROM(
				SELECT d.order_no,TO_CHAR(o.order_time,'YYYY-MM-DD HH24:MI:SS') AS order_time,d.product_no, p.price,d.order_count, (p.price*d.order_count) AS total_price
				FROM juiceta_order_detail d
				INNER JOIN juiceta_product p ON d.product_no=p.product_no
				INNER JOIN juiceta_order o ON d.order_no=o.order_no
				INNER JOIN juiceta_customer c ON  c.id=o.id
				WHERE c.id='jtest3'
			)
			GROUP BY order_no,order_time
			ORDER BY order_no DESC
		)
	)
	WHERE rnum BETWEEN 1 AND 4;
	
	-- 총 주문수
	SELECT * FROM juiceta_order WHERE id='jtest3';
	SELECT COUNT(*) FROM juiceta_order WHERE id='jtest3';

-- 리뷰작성
SELECT review_no,review_content,star,review_time,id,order_no,product_no FROM juiceta_review;

SELECT * FROM juiceta_order WHERE id='jtest3';

SELECT d. order_no, d.product_no FROM juiceta_order_detail d
INNER JOIN juiceta_order o ON o.order_no=d.order_no 
WHERE o.id='jtest3';

INSERT INTO juiceta_review(review_no,review_content,star,review_time,id,order_no,product_no)
VALUES(juiceta_review_seq.nextval,'맛있었어요~',4,SYSDATE,'jtest3',4,332);

COMMIT

-- 상품번호로 리뷰 조회 : 회원아이디, 상세리뷰글, 별점, 작성일
SELECT id, review_content, star, review_time FROM juiceta_review WHERE product_no=332;

-- 리뷰작성 : 상품번호, 상품명, 주문날짜 (내가 아는 건 orderNo, productNo)
SELECT product_name FROM juiceta_product WHERE product_no=332;
SELECT TO_CHAR(order_time,'YYYY-MM-DD HH24:MI:SS') AS order_time FROM juiceta_order WHERE order_no=1;

-- 장바구니 : 상품이미지, 상품이름, 상품가격, 수량, 합계
SELECT p.image, p.product_no, p.product_name,DBMS_LOB.SUBSTR(p.product_detail) AS product_detail,p.price,c.product_count,(p.price*c.product_count) AS total
FROM juiceta_cart c
INNER JOIN juiceta_product p ON c.product_no=p.product_no
WHERE id='jtest3';

-- 장바구니 상품 총 합계금액
SELECT SUM(p.price*c.product_count) AS cart_total
FROM juiceta_cart c
INNER JOIN juiceta_product p ON c.product_no=p.product_no
WHERE id='jtest3';

-- 상품상세보기 평균별점
SELECT ROUND(AVG(star)) FROM juiceta_review WHERE product_no=331;













