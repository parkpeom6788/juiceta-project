select * from  juiceta_board
CREATE TABLE juiceta_board(
	board_no NUMBER PRIMARY KEY,
	board_title VARCHAR2(100) NOT NULL,
	board_content CLOB NOT NULL,
	board_time DATE NOT NULL,
	hits NUMBER default 0
)
-- juiceta_board_seq;
 
insert into juiceta_board values(juiceta_board_seq.nextval,'첫번째 테스트','첫번째 테스트 중입니다',sysdate,0)
insert into juiceta_board values(juiceta_board_seq.nextval,'두번째 테스트','두번째 테스트 중입니다',sysdate,0)
insert into juiceta_board values(juiceta_board_seq.nextval,'세번째 테스트','세번째 테스트 중입니다',sysdate,0)

SELECT row_number() over(ORDER BY board_no DESC) as rnum, board_no, board_title, hits, TO_CHAR(board_time, 'YYYY.MM.DD') as board_time
FROM juiceta_board

SELECT row_number() over(ORDER BY board_no asc) as rnum, board_no, board_title, hits, TO_CHAR(board_time, 'YYYY.MM.DD') as board_time
FROM juiceta_board order by board_no desc

select row_number() over(ORDER BY board_no asc) as rnum, board_no, board_title, board_content, board_time, hits from juiceta_board where board_no = 55


SELECT rnum,board_no,board_title,board_content,board_time, hits
		FROM(
			SELECT ROW_NUMBER() OVER(ORDER BY board_no DESC) AS rnum,board_no,board_title,board_content,board_time, hits
			FROM juiceta_board
		)
		WHERE rnum BETWEEN #{startRowNumber} AND #{endRowNumber}
		
SELECT rnum,board_no,board_title,board_content,board_time, hits
		FROM(
			SELECT ROW_NUMBER() OVER(ORDER BY board_no DESC) AS rnum,board_no,board_title,board_content,board_time, hits
			FROM juiceta_board
		)
		WHERE rnum BETWEEN #{startRowNumber} AND #{endRowNumber}
		
		select count(*) from juiceta_board
		
		select * from juiceta_customer
		
		
select * from juiceta_wishlist
select id, product_no from juiceta_wishlist where id = 'zzzzz'

SELECT P.PRODUCT_NO,P.PRODUCT_NAME , P.PRODUCT_NAME , P.PRICE , P.PRODUCT_COUNT , P.PRODUCT_DETAIL , P.IMAGE , P.CATEGORY
		FROM juiceta_product P INNER JOIN juiceta_cart C ON P.PRODUCT_NO = C.PRODUCT_NO
		WHERE C.ID='zzzzz'
		
select p.product_no, product_name, p.product_detail, p.image, p.category from juiceta_product p inner join juiceta_wishlist w on p.product_no = w.product_no
where w.id ='zzzzz';