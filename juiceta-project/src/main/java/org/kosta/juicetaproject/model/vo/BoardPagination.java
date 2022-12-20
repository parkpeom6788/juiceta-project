package org.kosta.juicetaproject.model.vo;

public class BoardPagination {
	private int nowPage=1; //현재 페이지
	private int postCountPerPage=10; //페이지당 게시물 수
	private int pageCountPerPageGroup = 5; // 페이지 그룹당 페이지 수
	private int totalPostCount; // 총 게시물 수
	

	public BoardPagination(int totalPostCount) { // 첫 화면에서는 nowPage1 이므로 총게시물수만 가져와서 보여줌 
		super();
		this.totalPostCount = totalPostCount;
	}


	public BoardPagination(int nowPage, int totalPostCount) {
		super();
		this.nowPage = nowPage;
		this.totalPostCount = totalPostCount;
	}
	
	public long getNowPage() {
		return nowPage;
	}
	/**
	 * 현재 페이지 번호에 ( nowPage ) 해당하는 게시물 리스트의 시작 row number를 반환
	 * 이전 페이지 마지막 번호 +1
	 * 2 페이지의 시작번호는 1 페이지의 마지막 번호 10 + 1 이 시작 번호가 된다. 10 이라는 값은
	 * postCountPerPage이다.
	 * 참고 : 사용자가 페이지번호를 클릭하면 ListController에서 페이지번호를 전달받고
	 * 			 BoardDAO로부터 총게시물수를 반환 받은 후 Pagination 객체를 생성해서
	 * 			 findPostList(Pagination)에 전달하여 현 페이지에 맞는 게시물 리스트를 반환받을 때 사용하기 위한 메서드
	 */
	// 현재 페이지의 시작번호
	public long getStartRowNumber() {
		return (this.nowPage - 1 ) * this.postCountPerPage +1;
	}
	
	
	/**
	 * 현재 페이지 번호(nowPage)에 해당하는 게시물 리스트의 게시물 row의 마지막 번호를 반환
	 * nowPage * postCountPerPage의 연산결과가 게시물의 마지막 번호이나 
	 * 만약 totalPostCount(총게시물 수) 보다 클 경우에는 totalPostCount(총 게시물수)가
	 * 현 페이지의 마지막 게시물 row number가 된다
	 */
	//현재 페이지의 마지막 번호
	public long getEndRowNumber() {
		long endRowNumber = this.nowPage * this.postCountPerPage;
		if(endRowNumber > this.totalPostCount) {
			endRowNumber = this.totalPostCount;
		}
		return endRowNumber;
	}
	
	/**
	 * 총 페이지 수를 반환
	 * 
	 * totalPostCount / postCountPerPage 연산값의 나머지가 0이면 나눈값이 총 페이지 수
	 * totalPostCount / postCountPerPage 연산값의 나머지가 0이 아니면 나눈값+1 이 총페이지 수
	 * 
	 * 예) 게시물 수 12345	678910   11 12
	 * 						  1page   2page    3page
	 */ 
	//총 페이지 수 반환
	public long getTotalPage() {
		long totalPage = this.totalPostCount / this.postCountPerPage;
		if(this.totalPostCount % this.postCountPerPage !=0) {
			totalPage +=1;
		}
		return totalPage;
	}
	/**
	 * 총페이지 그룹수를 반환
	 * getTotalPage() 총페이지수 / pageCountPerPageGroup -> 나머지가 0이면 나눈 값이 총그룹수
	 * -> 나머지가 존재하면 나눈값 +1 한 값이 총그룹수
	 * 예) 총게시물 수 48개
	 * 			페이지 		1 2 3 4		5 6 7 8		9 10
	 * 		페이지 그룹   1group 	2group		3group
	 */
	//총 페이지 그룹수를 반환
	public long getTotalPageGroup() {
		long totalPageGroup = this.getTotalPage() / this.pageCountPerPageGroup;
		if(this.getTotalPage() % this.pageCountPerPageGroup != 0 ) {
			totalPageGroup +=1;
		}
		return totalPageGroup;
	}
	/** 
	 * 현재 페이지가 속한 페이지 그룹이 몇번째 그룹인지를 리턴
	 * nowPage / pageCountPerPageGroup 값의 나머지가 0이면 나눈값이 현재 페이지그룹
	 * nowPage / pageCountPerPageGroup 값의 나머지가 0이 아니면 나눈값 +1이 현재 페이지 그룹
	 * 
	 * 예) 현재 페이지가 7 page
	 * 		page		1 2 3 4		5 6 7
	 * 					1group		2group
	 * 
	 */
	//현재 페이지가 속한 페이지 그룹이 몇번째 그룹인지를  리턴
	public long getNowPageGroup() {
		long nowPageGroup = this.nowPage / this.pageCountPerPageGroup; 
		if(this.nowPage % this.pageCountPerPageGroup != 0) {
			nowPageGroup +=1;
		}
		return nowPageGroup;
	}
	/**
	 * 현재 페이지가 속한 그룹의 시작 페이지 번호를 반환
	 * 이전 페이지 그룹 * pageCountPerPageGroup +1 => 현 페이지 그룹의 시작번호
	 * 현재 페이지 그룹 getNowPageGroup -> 2이면 
	 * 이전 페이지 그룹 (2-1) * pageCountPerpageGroup + 1 => 현재 페이지 그룹의 시작번호 5         
	 * 
	 * pageNo		1 2 3 4		5 6 7 8		 9 10
	 * 					1group		2group		3group
	 */
	//현재 페이지가 속한 그룹의 시작 페이지 번호를 반환
	public long getStartPageOfPageGroup() {
		return (this.getNowPageGroup()-1) * this.pageCountPerPageGroup +1;
	}
	/**
	 * 현재 페이지 그룹의 마지막 번호를 리턴
	 * 
	 * getNowPageGroup() * pageCountPerPageGroup => 마지막 페이짖 번호
	 * 단 위의 연산값이 getTotalPage() 즉 총 페이지 수보다 크면
	 * getTotalPage() 값이 마지막 페이지 번호가 된다
	 * 
	 * pageNo		1 2 3 4 		5 6 7 8 	9 10
	 * 					1group		2group		3group
	 * 
	 */
	//현재 페이지 그룹의 마지막 번호를 리턴
	public long getEndPageOfPageGroup() {
		long endPage = this.getNowPageGroup() * this.pageCountPerPageGroup;
		if(endPage > this.getTotalPage()) {
			endPage = this.getTotalPage();
		}
		return endPage;
	}
	/**
	 * 이전 페이지 그룹이 존재하는 지 여부를 리턴
	 * getNowPageGroup()이 1보다 크면 이전 페이지 그룹이 존재
	 */
	public boolean isPreviousPageGroup() {
		boolean flag = false;
		if(this.getNowPageGroup()>1) {
			flag = true;
		}
		return flag;
	}
	/**
	 * 다음 페이지 그룹이 존재하는 지 여부를 리턴 <br>
	 * getTotalPageGroup() 보다 getNowPageGroup() 이 작으면 다음 페이지 그룹이 존재  
	 * @return flag
	 */
	public boolean isNextPageGroup() {
		boolean flag=false;
		if(this.getNowPageGroup() < this.getTotalPageGroup()) {
			flag = true;
		}
		return flag;
	}
	
	
}
