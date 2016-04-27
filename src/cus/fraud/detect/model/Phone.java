package cus.fraud.detect.model;

public class Phone {
	private boolean differentAddress;
	private boolean nonexistentPhone;
	private boolean alwaysUnavailable;
	private boolean prepaidPhone;
	private boolean inScamDB;

	public Phone(boolean differentAddress, boolean nonexistentPhone,
			boolean alwaysUnavailable, boolean prepaidPhone, boolean inScamDB) {
		super();
		this.differentAddress = differentAddress;
		this.nonexistentPhone = nonexistentPhone;
		this.alwaysUnavailable = alwaysUnavailable;
		this.prepaidPhone = prepaidPhone;
		this.inScamDB = inScamDB;
	}

	public boolean isDifferentAddress() {
		return differentAddress;
	}

	public boolean isNonexistentPhone() {
		return nonexistentPhone;
	}

	public boolean isAlwaysUnavailable() {
		return alwaysUnavailable;
	}

	public boolean isPrepaidPhone() {
		return prepaidPhone;
	}

	public boolean isInScamDB() {
		return inScamDB;
	}
}
