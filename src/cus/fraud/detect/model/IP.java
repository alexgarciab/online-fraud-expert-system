package cus.fraud.detect.model;

public class IP {
	private boolean billingAddressDifferent;
	private boolean usingProxy;
	private boolean usingVPN;
	private boolean fraudulentTrx;
	private boolean differentIPlogin;

	public IP(boolean billingAddressDifferent, boolean usingProxy,
			boolean usingVPN, boolean fraudulentTrx, boolean differentIPlogin) {
		super();
		this.billingAddressDifferent = billingAddressDifferent;
		this.usingProxy = usingProxy;
		this.usingVPN = usingVPN;
		this.fraudulentTrx = fraudulentTrx;
		this.differentIPlogin = differentIPlogin;
	}

	public boolean isBillingAddressDifferent() {
		return billingAddressDifferent;
	}

	public boolean isUsingProxy() {
		return usingProxy;
	}

	public boolean isUsingVPN() {
		return usingVPN;
	}

	public boolean isFraudulentTrx() {
		return fraudulentTrx;
	}

	public boolean isDifferentIPlogin() {
		return differentIPlogin;
	}

}
