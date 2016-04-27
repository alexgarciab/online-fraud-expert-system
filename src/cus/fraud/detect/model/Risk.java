package cus.fraud.detect.model;

public class Risk {
	private String level;

	public Risk(String level) {
		super();
		this.level = level;
	}

	public String getLevel() {
		return level;
	}

	@Override
	public String toString() {
		return "Risk [" + level + "]";
	}

}
