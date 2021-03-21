package com.logistics.hennex.enums;

public enum OrderIDFormat {

	ADMIN("HNXA"),USER("HNXU"), CUSTOMER("HNXC");

	private String value;

	OrderIDFormat(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
