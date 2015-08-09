package com.windy.medqc.vo;

public class Pagination {
	//��ǰҳ��
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
	//��¼����
	private int totalCount=0;
	//��ҳ��
	private int pageCount=0;
	//��һҳ
	private int nextPageIndex=0;
	//��һҳ
	private int prePageIndex=0;
	//ÿҳ��¼��
	private int pageSize=5;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	//���ݿ��ѯ��¼ƫ��ֵ
	private int offset=0;
	public int getOffset() {
	   return this.pageSize*(this.pageIndex-1);
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	//�Ƿ�����һҳ
	public boolean hasNext()
	{
		System.out.println("totalCount:"+this.totalCount);
		this.pageCount=(this.totalCount +  this.pageSize  - 1)/this.pageSize;

		System.out.println("pageIndex:"+this.pageIndex);
		System.out.println("pageCount:"+this.pageCount);
		return pageIndex < pageCount;
	}
	//�Ƿ�����һҳ
	public boolean hasPre() {
		return pageIndex>1;
	}
	//ҳ����ʾ��ʼҳ
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
	//ҳ����ʾ����ҳ
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
