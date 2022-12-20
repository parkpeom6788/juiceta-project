package org.kosta.juicetaproject.model.vo;

public class ShopPagination {
	private int nowPage = 1;	// 현재 페이지
	private int postCountPerPage = 8;	// 페이지당 게시물수
	private int pageCountPerPageGroup = 5;	// 페이지 그룹당 페이지수
	private int totalPostCount;	// 총게시물수
	
	public ShopPagination(int totalPostCount) {	// 첫화면에서는 nowPage 1 이므로 총게시물수만 가져와서 보여줌
		super();
		this.totalPostCount = totalPostCount;
	}
	
	public ShopPagination(int nowPage, int totalPostCount) {
		super();
		this.nowPage = nowPage;
		this.totalPostCount = totalPostCount;
	}
	
	public int getNowPage() {
		return nowPage;
	}
	
	public int getStartRowNumber() {
		return (this.nowPage-1)*this.postCountPerPage+1; 
	}

	public int getEndRowNumber() {	
		int endRowNumber = this.nowPage*this.postCountPerPage;
		if(endRowNumber>this.totalPostCount)
			endRowNumber = this.totalPostCount;
		return endRowNumber;
	}
	
	public int getTotalPage() {
		int totalPage=this.totalPostCount / this.postCountPerPage;
		if(this.totalPostCount % this.postCountPerPage!=0)
			totalPage +=1;
		return totalPage;
	}
	
	public int getTotalPageGroup() {
		int totalPageGroup= getTotalPage() / this.pageCountPerPageGroup;
		if(getTotalPage()%this.pageCountPerPageGroup!=0)
			totalPageGroup += 1;
		return totalPageGroup;
	}
	
	public int getNowPageGroup() {	// page group 의 시작 page, 끝 page 와 previous, next 를 나타내는 데에 필요함
		int nowPageGroup=this.nowPage / this.pageCountPerPageGroup;
		if(this.nowPage%this.pageCountPerPageGroup!=0)
			nowPageGroup += 1;
		return nowPageGroup;
	}
	
	public int getStartPageOfPageGroup() {
		return (this.getNowPageGroup()-1)*this.pageCountPerPageGroup+1;
	}
	
	public int getEndPageOfPageGroup() {
		int endPage=this.getNowPageGroup()*this.pageCountPerPageGroup;
		if(endPage>this.getTotalPage())
			endPage = this.getTotalPage();
		return endPage;
	}
	
	public boolean isPreviousPageGroup() {
		boolean flag=false;
		if(this.getNowPageGroup()>1)
			flag = true;
		return flag;
	}
	
	public boolean isNextPageGroup() {
		boolean flag=false;
		if(this.getNowPageGroup()<this.getTotalPageGroup())
			flag = true;
		return flag;
	}

}

