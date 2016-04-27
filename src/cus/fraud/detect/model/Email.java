package cus.fraud.detect.model;

public class Email {
	private boolean emailNotReplied;
	private boolean emailRejected;
	private boolean extensionLooksShady;
	private boolean hasGenericResponse;
	private boolean inScamDB;

	public Email(boolean emailNotReplied, boolean emailRejected,
			boolean extensionLooksShady, boolean hasGenericResponse,
			boolean inScamDB) {
		super();
		this.emailNotReplied = emailNotReplied;
		this.emailRejected = emailRejected;
		this.extensionLooksShady = extensionLooksShady;
		this.hasGenericResponse = hasGenericResponse;
		this.inScamDB = inScamDB;
	}

	public boolean isEmailNotReplied() {
		return emailNotReplied;
	}

	public boolean isEmailRejected() {
		return emailRejected;
	}

	public boolean isExtensionLooksShady() {
		return extensionLooksShady;
	}

	public boolean isHasGenericResponse() {
		return hasGenericResponse;
	}

	public boolean isInScamDB() {
		return inScamDB;
	}

}
