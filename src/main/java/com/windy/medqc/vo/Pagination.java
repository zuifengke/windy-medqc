package com.windy.medqc.vo;

public class Pagination {
	//当前页码
	private int pageIndex=1;
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.pageCount=(totalCount +  this.pageSize  - 1)/this.pageSize;
		System.out.println("setTotalCount pageCount:"+this.pageCount);
		this.totalCount = totalCount;
	}
	public int getPageCount() {
		if(this.pageSize==0)
			return 0;
		return (this.totalCount +  this.pageSize  - 1)/this.pageSize;
	}
	public void getPageCount(int page) {
		this.pageCount = page;
	}
	public int getNextPageIndex() {
		return nextPageIndex;
	}
	public void setNextPageIndex(int nextPageIndex) {
		this.nextPageIndex = nextPageIndex;
	}
	public int getPrePageIndex() {
		return prePageIndex;
	}
	public void setPrePageIndex(int prePageIndex) {
		this.prePageIndex = prePageIndex;
	}
	//记录总数
	private int totalCount=0;
	//总页数
	private int pageCount=0;
	//下一页
	private int nextPageIndex=0;
	//上一页
	private int prePageIndex=0;
	//每页记录数
	private int pageSize=5;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	//数据库查询记录偏移值
	private int offset=0;
	public int getOffset() {
	   return this.pageSize*(this.pageIndex-1);
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	//是否有下一页
	public boolean hasNext()
	{
		System.out.println("totalCount:"+this.totalCount);
		this.pageCount=(this.totalCount +  this.pageSize  - 1)/this.pageSize;

		System.out.println("pageIndex:"+this.pageIndex);
		System.out.println("pageCount:"+this.pageCount);
		return pageIndex < pageCount;
	}
	//是否有上一页
	public boolean hasPre() {
		return pageIndex>1;
	}
	//页吗显示起始页
	private int beginPage;
	
	public int getBeginPage() {
		if(this.pageIndex-5>1)
		{
			this.beginPage=this.pageIndex-5;
		}
		else 
			this.beginPage=1;
		return beginPage;
	}
	//页码显示结束页
	private int endPage;
	
	public int getEndPage() {
		
		if(this.pageCount>this.pageIndex+5)
		{
			this.endPage = this.pageIndex+5;
			
		}
		else {
			this.endPage=this.pageCount;
			
		}
		return endPage;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	private boolean prePoints;
	public boolean isPrePoints() {
		return prePoints;
	}
	public boolean isNextPoints() {
		return nextPoints;
	}
	private boolean nextPoints;
	
}
