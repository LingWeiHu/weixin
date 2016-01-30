package com.hutu.weixin.weiliaotuan.core.domain.pojo;

import java.util.List;

public class ServiceResult<T> {
	private String errorCode;
	private String showMessage;
	private List<T> returnResultList;
	private T returnResult;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getShowMessage() {
		return showMessage;
	}

	public void setShowMessage(String showMessage) {
		this.showMessage = showMessage;
	}

	public List<T> getReturnResultList() {
		return returnResultList;
	}

	public void setReturnResultList(List<T> returnResultList) {
		this.returnResultList = returnResultList;
	}

	public T getReturnResult() {
		return returnResult;
	}

	public void setReturnResult(T returnResult) {
		this.returnResult = returnResult;
	}
}
