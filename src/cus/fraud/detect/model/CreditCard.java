package cus.fraud.detect.model;

public class CreditCard {
	private boolean cscNotMatching;
	private boolean adressProvided;
	private boolean zipProvided;
	private boolean avsNotMatching;
	private boolean binIinDiffers;
	private boolean usingGiftCard;
	private boolean luhnAlgorithNoPass;
	private boolean lostStolenDB;
	private boolean notTrustedBank;

	public CreditCard(boolean cscNotMatching, boolean adressProvided,
			boolean zipProvided, boolean avsNotMatching, boolean binIinDiffers,
			boolean usingGiftCard, boolean luhnAlgorithNoPass,
			boolean lostStolenDB, boolean notTrustedBank) {
		super();
		this.cscNotMatching = cscNotMatching;
		this.adressProvided = adressProvided;
		this.zipProvided = zipProvided;
		this.avsNotMatching = avsNotMatching;
		this.binIinDiffers = binIinDiffers;
		this.usingGiftCard = usingGiftCard;
		this.luhnAlgorithNoPass = luhnAlgorithNoPass;
		this.lostStolenDB = lostStolenDB;
		this.notTrustedBank = notTrustedBank;
	}

	public boolean isCscNotMatching() {
		return cscNotMatching;
	}

	public boolean isAdressProvided() {
		return adressProvided;
	}

	public boolean isZipProvided() {
		return zipProvided;
	}

	public boolean isAvsNotMatching() {
		return avsNotMatching;
	}

	public boolean isBinIinDiffers() {
		return binIinDiffers;
	}

	public boolean isUsingGiftCard() {
		return usingGiftCard;
	}

	public boolean isLuhnAlgorithNoPass() {
		return luhnAlgorithNoPass;
	}

	public boolean isLostStolenDB() {
		return lostStolenDB;
	}

	public boolean isNotTrustedBank() {
		return notTrustedBank;
	}

}
