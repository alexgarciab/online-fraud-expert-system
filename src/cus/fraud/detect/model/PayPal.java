package cus.fraud.detect.model;

public class PayPal {
	private boolean nameNotMatching;
	private boolean postalAddresNotMatching;
	private boolean paypalNotVerified;
	private boolean customerHasDisputes;
	private boolean emailInScamDB;

	public PayPal(boolean nameNotMatching, boolean postalAddresNotMatching,
			boolean paypalNotVerified, boolean customerHasDisputes,
			boolean emailInScamDB) {
		super();
		this.nameNotMatching = nameNotMatching;
		this.postalAddresNotMatching = postalAddresNotMatching;
		this.paypalNotVerified = paypalNotVerified;
		this.customerHasDisputes = customerHasDisputes;
		this.emailInScamDB = emailInScamDB;
	}

	public boolean isNameNotMatching() {
		return nameNotMatching;
	}

	public boolean isPostalAddresNotMatching() {
		return postalAddresNotMatching;
	}

	public boolean isPaypalNotVerified() {
		return paypalNotVerified;
	}

	public boolean isCustomerHasDisputes() {
		return customerHasDisputes;
	}

	public boolean isEmailInScamDB() {
		return emailInScamDB;
	}

}
