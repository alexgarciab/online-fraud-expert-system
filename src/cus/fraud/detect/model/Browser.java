package cus.fraud.detect.model;

public class Browser {
	private boolean usingPrivateBrowser;
	private boolean javascriptNotEnabled;
	private boolean notStoringCookies;
	private boolean performingFastActions;
	private boolean usingOutdatedBrowser;

	public Browser(boolean usingPrivateBrowser, boolean javascriptNotEnabled,
			boolean notStoringCookies, boolean performingFastActions,
			boolean usingOutdatedBrowser) {
		super();
		this.usingPrivateBrowser = usingPrivateBrowser;
		this.javascriptNotEnabled = javascriptNotEnabled;
		this.notStoringCookies = notStoringCookies;
		this.performingFastActions = performingFastActions;
		this.usingOutdatedBrowser = usingOutdatedBrowser;
	}

	public boolean isUsingPrivateBrowser() {
		return usingPrivateBrowser;
	}

	public boolean isJavascriptNotEnabled() {
		return javascriptNotEnabled;
	}

	public boolean isNotStoringCookies() {
		return notStoringCookies;
	}

	public boolean isPerformingFastActions() {
		return performingFastActions;
	}

	public boolean isUsingOutdatedBrowser() {
		return usingOutdatedBrowser;
	}

}
