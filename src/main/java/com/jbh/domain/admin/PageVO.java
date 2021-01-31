package com.jbh.domain.admin;

public class PageVO {

	private int numOfLine;
	private int currentPage;
	private int beginPage;
	private int endPage;
	private boolean nextGroup;
	private boolean prevGroup;
	
	public PageVO(int currentPage, int numOfLine, int lineOfPage, int total) {
		int lastPage = total % lineOfPage > 0 ? total/lineOfPage + 1 : total/lineOfPage;
		int lastGroup = lastPage % numOfLine > 0 ? lastPage/numOfLine + 1 : lastPage/numOfLine;
		
		this.currentPage = currentPage;
		if(lastPage < currentPage || currentPage < 1)
			this.currentPage = 1;
		
		this.numOfLine = numOfLine;
		
		this.beginPage = (this.currentPage - 1) / numOfLine * numOfLine + 1;
		this.endPage = this.beginPage + numOfLine - 1 > lastPage ? lastPage : this.beginPage + numOfLine - 1;
		
		int currentGroup = this.beginPage / numOfLine + 1;
		
		this.nextGroup = currentGroup < lastGroup ? true : false;
		this.prevGroup = currentGroup > 1 ? true : false;		
	}
	
	public int getNumOfLine() { return this.numOfLine; }
	public int getCurrentPage() { return this.currentPage; }
	public int getBeginPage() { return this.beginPage; }
	public int getEndPage() { return this.endPage; }
	public boolean getNextGroup() { return this.nextGroup; }
	public boolean getPrevGroup() { return this.prevGroup; }
	
	public String toString() {
		return "PageVO [numOfLine="+this.numOfLine+", currentPage="+this.currentPage+", beginPage="+this.beginPage+
				", endPage="+this.endPage+", nextGroup="+this.nextGroup+", prevGroup="+this.prevGroup+"]";
	}
}
