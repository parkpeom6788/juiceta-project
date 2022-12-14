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