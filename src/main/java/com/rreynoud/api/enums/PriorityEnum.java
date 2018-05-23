package com.rreynoud.api.enums;

public enum PriorityEnum {

	High, Normal, Low;

	public static PriorityEnum getPriority(String priority) {
		switch (priority) {
		case "High":
			return High;
		case "Normal":
			return Normal;
		case "Low":
			return Low;

		default:
			return Normal;
		}
	}
}
