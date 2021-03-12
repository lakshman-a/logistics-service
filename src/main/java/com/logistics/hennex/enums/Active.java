package com.logistics.hennex.enums;

public enum Active {

	TRUE("TRUE"), FALSE("FALSE");

	private String value;

	Active(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Active parse(String id) {
		Active active = null; // Default
		for (Active item : Active.values()) {
			if (item.getValue().equalsIgnoreCase(id)) {
				active = item;
				break;
			}
		}
		return active;
	}
}
