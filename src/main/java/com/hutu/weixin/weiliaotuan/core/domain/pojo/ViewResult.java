package com.hutu.weixin.weiliaotuan.core.domain.pojo;

import java.util.List;

public class ViewResult<T> {

	private int rowsCount;
	private int pageIndex;
	private int pageCount;
	private List<T> rowsData;
	private T returnResult;
	public int getRowsCount() {
		return rowsCount;
	}
	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getRowsData() {
		return rowsData;
	}
	public void setRowsData(List<T> rowsData) {
		this.rowsData = rowsData;
	}
	public T getReturnResult() {
		return returnResult;
	}
	public void setReturnResult(T returnResult) {
		this.returnResult = returnResult;
	}
}
