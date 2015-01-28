package edu.olivet.se530.model;

public class Condition implements Comparable<Condition> {
	

	private String primary;
	private String secondary;
	
	private int primaryValue;
	private int secondaryValue;
	
	public Condition(){}
	public Condition(String primary, String secondary) {
		// TODO Auto-generated constructor stub
		super();
		this.primary = primary;
		this.secondary = secondary;
	}

	@Override
	public String toString() {
		return "Condition [primary=" + primary + ", secondary=" + secondary
				+ ", primaryValue=" + primaryValue + ", secondaryValue="
				+ secondaryValue + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((primary == null) ? 0 : primary.hashCode());
		result = prime * result
				+ ((secondary == null) ? 0 : secondary.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condition other = (Condition) obj;
		if (primary == null) {
			if (other.primary != null)
				return false;
		} else if (!primary.equals(other.primary))
			return false;
		if (secondary == null) {
			if (other.secondary != null)
				return false;
		} else if (!secondary.equals(other.secondary))
			return false;
		return true;
	}
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
