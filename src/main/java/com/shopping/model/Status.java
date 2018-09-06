package com.shopping.model;

import net.sf.json.JSONObject;

public class Status {

	private boolean status;
	
	private String statusInfo;

	public Status(boolean status, String statusInfo) {
		super();
		this.status = status;
		this.statusInfo = statusInfo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	@Override
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}

}
