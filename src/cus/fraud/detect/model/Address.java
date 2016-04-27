package cus.fraud.detect.model;

public class Address {

	private boolean falseAddress;
	private boolean notFromResidentialHome;
	private boolean poBox;
	private boolean fromSuspiciousCountry;
	private boolean inScamDB;

	public Address(boolean falseAddress, boolean notFromResidentialHome,
			boolean poBox, boolean fromSuspiciousCountry, boolean inScamDB) {
		super();
		this.falseAddress = falseAddress;
		this.notFromResidentialHome = notFromResidentialHome;
		this.poBox = poBox;
		this.fromSuspiciousCountry = fromSuspiciousCountry;
		this.inScamDB = inScamDB;
	}

	public boolean isFalseAddress() {
		return falseAddress;
	}

	public boolean isNotFromResidentialHome() {
		return notFromResidentialHome;
	}

	public boolean isPoBox() {
		return poBox;
	}

	public boolean isFromSuspiciousCountry() {
		return fromSuspiciousCountry;
	}

	public boolean isInScamDB() {
		return inScamDB;
	}

}
