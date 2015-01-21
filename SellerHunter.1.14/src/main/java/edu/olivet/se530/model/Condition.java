package edu.olivet.se530.model;

public class Condition implements Comparable<Condition> {
	

	private String primary;
	private String secondary;
	
	private int primaryValue;
	private int secondaryValue;
	

	public String getPrimary() {
		return primary;
	}

	public void setPrimary(String primary) {
		this.primary = primary;
	}

	public String getSecondary() {
		return secondary;
	}

	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}

	public int getPrimaryValue() {
		return primaryValue;
	}

	public void setPrimaryValue(int primaryValue) {
		this.primaryValue = primaryValue;
	}

	public int getSecondaryValue() {
		return secondaryValue;
	}

	public void setSecondaryValue(int secondaryValue) {
		this.secondaryValue = secondaryValue;
	}

	public int compareTo(Condition o) {
		int rc = -Integer.compare(this.getPrimaryValue(), o.getPrimaryValue());
		if (rc == 0) {
			return -Integer.compare(this.getSecondaryValue(), o.getSecondaryValue());
		}
		return rc;
	}
	
	
}
