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