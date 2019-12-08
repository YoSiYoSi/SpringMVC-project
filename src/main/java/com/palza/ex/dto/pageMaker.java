package com.palza.ex.dto;

public class pageMaker {

	
	private int total;
	private int totalPage;
	private int curPage;
	
	private int start;
	private int end;
	
	private int startPage;
	private int endPage;
	
	private int cate_id;
    private String curId;
	private String searchTerm;
    
	public pageMaker() {}
	
	
	public pageMaker(int curPage, int total, int pageView, int cate_id, String curId) {
		this.totalPage = (int) Math.ceil(1.0 * total / pageView);
		this.curPage = curPage;
		this.cate_id = cate_id;
		this.curId = curId;
		
		// 총 페이지 10 개만 출력될수 있도록
		/*this.endPage = (int) Math.ceil(curPage / 10.0) * 10;
		if(this.endPage > this.totalPage) { this.endPage = this.totalPage; }
		this.startPage = this.endPage - 9;
		if(this.startPage < 1) { this.startPage = 1; }*/
		
		// 총 페이지 10개 + 현제 페이지 기준으로 옆으로 5개, 뒤로 4개씩 나올수 있도록
		if(curPage < 6) {
			this.endPage = 10;
			if (this.endPage > this.totalPage) { this.endPage = this.totalPage; }
			this.startPage = 1;
		} else {
			this.endPage = curPage + 4;
			if (this.endPage > this.totalPage) { this.endPage = this.totalPage; }
			this.startPage = this.endPage - 9;
			if(this.startPage < 1) { this.startPage = 1; }
		}
		
		// 글번호 시작 번호, 끝번호 구하기
		this.end = curPage * pageView;
		if(this.end > total) { this.end = total; }
		this.start = this.end - pageView  + 1;
		if(this.start < 1) { this.start = 1; }
	}

	
	public pageMaker(int curPage, int total, int pageView, String curId, String searchTerm) {
		this.totalPage = (int) Math.ceil(1.0 * total / pageView);
		this.curPage = curPage;
		this.curId = curId;
		this.searchTerm = searchTerm;
		
		// 총 페이지 10 개만 출력될수 있도록
		/*this.endPage = (int) Math.ceil(curPage / 10.0) * 10;
		if(this.endPage > this.totalPage) { this.endPage = this.totalPage; }
		this.startPage = this.endPage - 9;
		if(this.startPage < 1) { this.startPage = 1; }*/
		
		// 총 페이지 10개 + 현제 페이지 기준으로 옆으로 5개, 뒤로 4개씩 나올수 있도록
		if(curPage < 6) {
			this.endPage = 10;
			if (this.endPage > this.totalPage) { this.endPage = this.totalPage; }
			this.startPage = 1;
		} else {
			this.endPage = curPage + 4;
			if (this.endPage > this.totalPage) { this.endPage = this.totalPage; }
			this.startPage = this.endPage - 9;
			if(this.startPage < 1) { this.startPage = 1; }
		}
		
		// 글번호 시작 번호, 끝번호 구하기
		this.end = curPage * pageView;
		if(this.end > total) { this.end = total; }
		this.start = this.end - pageView  + 1;
		if(this.start < 1) { this.start = 1; }
	}

	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getCurPage() {
		return curPage;
	}


	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}


	public int getStart() {
		return start;
	}


	public void setStart(int start) {
		this.start = start;
	}


	public int getEnd() {
		return end;
	}


	public void setEnd(int end) {
		this.end = end;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getCate_id() {
		return cate_id;
	}


	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}


	public String getCurId() {
		return curId;
	}


	public void setCurId(String curId) {
		this.curId = curId;
	}
	
	public void setsearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	

	public String getsearchTerm() {
		return searchTerm;
	}
	
	
}
