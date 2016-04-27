package cus.fraud.detect.engine;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import jess.JessException;
import cus.fraud.detect.model.Address;
import cus.fraud.detect.model.Browser;
import cus.fraud.detect.model.CreditCard;
import cus.fraud.detect.model.Email;
import cus.fraud.detect.model.IP;
import cus.fraud.detect.model.PayPal;
import cus.fraud.detect.model.Phone;

/**
 *
 */
public class Window extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int TOTAL_RULES = 38;

	JCheckBox creditCardCheck1 = new JCheckBox("CSC doesn't match?");
	JCheckBox creditCardCheck2 = new JCheckBox("Address provided?");
	JCheckBox creditCardCheck3 = new JCheckBox("ZIP provided?");
	JCheckBox creditCardCheck4 = new JCheckBox("AVS doesn't match?");
	JCheckBox creditCardCheck5 = new JCheckBox("BIN/IIN different?");
	JCheckBox creditCardCheck6 = new JCheckBox("Using prepaid card?");
	JCheckBox creditCardCheck7 = new JCheckBox("Luhn algotithm not pass?");
	JCheckBox creditCardCheck8 = new JCheckBox("Lost/stolen database?");
	JCheckBox creditCardCheck9 = new JCheckBox("Not trusted bank?");

	JCheckBox paypalCheck1 = new JCheckBox("Name doesn't match?");
	JCheckBox paypalCheck2 = new JCheckBox("Postal address doesn't match?");
	JCheckBox paypalCheck3 = new JCheckBox("PayPal not verified?");
	JCheckBox paypalCheck4 = new JCheckBox("Customer has disputes?");
	JCheckBox paypalCheck5 = new JCheckBox("Email in scam DB?");

	JCheckBox emailCheck1 = new JCheckBox("Email not replied?");
	JCheckBox emailCheck2 = new JCheckBox("Email rejected?");
	JCheckBox emailCheck3 = new JCheckBox("Extension looks shady?");
	JCheckBox emailCheck4 = new JCheckBox("Generic response?");
	JCheckBox emailCheck5 = new JCheckBox("In scam DB?");

	JCheckBox ipCheck1 = new JCheckBox("Billing address different?");
	JCheckBox ipCheck2 = new JCheckBox("Using proxy?");
	JCheckBox ipCheck3 = new JCheckBox("Using VPN?");
	JCheckBox ipCheck4 = new JCheckBox("Fraudulent transactions?");
	JCheckBox ipCheck5 = new JCheckBox("Different login IP?");

	JCheckBox phoneCheck1 = new JCheckBox("Billing address different?");
	JCheckBox phoneCheck2 = new JCheckBox("Number not exists?");
	JCheckBox phoneCheck3 = new JCheckBox("Always unavaliable?");
	JCheckBox phoneCheck4 = new JCheckBox("Prepaid phone?");
	JCheckBox phoneCheck5 = new JCheckBox("In scam DB?");

	JCheckBox addressCheck1 = new JCheckBox("False address?");
	JCheckBox addressCheck2 = new JCheckBox("Not from residential home?");
	JCheckBox addressCheck3 = new JCheckBox("Is P.O. box?");
	JCheckBox addressCheck4 = new JCheckBox("Suspicious country?");
	JCheckBox addressCheck5 = new JCheckBox("In Scam DB?");

	JCheckBox browserCheck1 = new JCheckBox("Using private browser?");
	JCheckBox browserCheck2 = new JCheckBox("Javascript not enabled?");
	JCheckBox browserCheck3 = new JCheckBox("Storing cookies?");
	JCheckBox browserCheck4 = new JCheckBox("Performing fast actions?");
	JCheckBox browserCheck5 = new JCheckBox("Using outdated browser?");

	JButton runButton = new JButton("Run");
	JLabel resultLabel = new JLabel("No runs yet", SwingConstants.CENTER);

	public Window() {
		GridLayout outerLayout = new GridLayout(4, 2);
		setLayout(outerLayout);

		JPanel creditCardPanel = new JPanel();
		GridLayout creditCardLayout = new GridLayout(5, 2);
		creditCardPanel.setLayout(creditCardLayout);
		creditCardPanel.setBorder(BorderFactory
				.createTitledBorder("Credit Card Fraud Detection"));
		creditCardPanel.add(creditCardCheck1);
		creditCardPanel.add(creditCardCheck2);
		creditCardPanel.add(creditCardCheck3);
		creditCardPanel.add(creditCardCheck4);
		creditCardPanel.add(creditCardCheck5);
		creditCardPanel.add(creditCardCheck6);
		creditCardPanel.add(creditCardCheck7);
		creditCardPanel.add(creditCardCheck8);
		creditCardPanel.add(creditCardCheck9);

		JPanel paypalPanel = new JPanel();
		GridLayout paypalLayout = new GridLayout(5, 1);
		paypalPanel.setLayout(paypalLayout);
		paypalPanel.setBorder(BorderFactory
				.createTitledBorder("PayPal Fraud Detection"));
		paypalPanel.add(paypalCheck1);
		paypalPanel.add(paypalCheck2);
		paypalPanel.add(paypalCheck3);
		paypalPanel.add(paypalCheck4);
		paypalPanel.add(paypalCheck5);

		JPanel emailPanel = new JPanel();
		GridLayout emailLayout = new GridLayout(5, 1);
		emailPanel.setLayout(emailLayout);
		emailPanel.setBorder(BorderFactory
				.createTitledBorder("Email Fraud Detection"));
		emailPanel.add(emailCheck1);
		emailPanel.add(emailCheck2);
		emailPanel.add(emailCheck3);
		emailPanel.add(emailCheck4);
		emailPanel.add(emailCheck5);

		JPanel ipPanel = new JPanel();
		GridLayout ipLayout = new GridLayout(5, 1);
		ipPanel.setLayout(ipLayout);
		ipPanel.setBorder(BorderFactory
				.createTitledBorder("IP Fraud Detection"));
		ipPanel.add(ipCheck1);
		ipPanel.add(ipCheck2);
		ipPanel.add(ipCheck3);
		ipPanel.add(ipCheck4);
		ipPanel.add(ipCheck5);

		JPanel phonePanel = new JPanel();
		GridLayout phoneLayout = new GridLayout(5, 1);
		phonePanel.setLayout(phoneLayout);
		phonePanel.setBorder(BorderFactory
				.createTitledBorder("Phone Fraud Detection"));
		phonePanel.add(phoneCheck1);
		phonePanel.add(phoneCheck2);
		phonePanel.add(phoneCheck3);
		phonePanel.add(phoneCheck4);
		phonePanel.add(phoneCheck5);

		JPanel addressPanel = new JPanel();
		GridLayout addressLayout = new GridLayout(5, 1);
		addressPanel.setLayout(addressLayout);
		addressPanel.setBorder(BorderFactory
				.createTitledBorder("Address Fraud Detection"));
		addressPanel.add(addressCheck1);
		addressPanel.add(addressCheck2);
		addressPanel.add(addressCheck3);
		addressPanel.add(addressCheck4);
		addressPanel.add(addressCheck5);

		JPanel browserPanel = new JPanel();
		GridLayout browserLayout = new GridLayout(5, 1);
		browserPanel.setLayout(browserLayout);
		browserPanel.setBorder(BorderFactory
				.createTitledBorder("Browser Fraud Detection"));
		browserPanel.add(browserCheck1);
		browserPanel.add(browserCheck2);
		browserPanel.add(browserCheck3);
		browserPanel.add(browserCheck4);
		browserPanel.add(browserCheck5);

		JPanel resultsPanel = new JPanel(new GridLayout(4, 1));
		resultsPanel.setBorder(BorderFactory.createTitledBorder("Results"));

		JPanel centerPanel = new JPanel(new GridLayout(1, 3));
		centerPanel.add(new JLabel(""));
		centerPanel.add(resultLabel);
		centerPanel.add(new JLabel(""));

		resultsPanel.add(new JLabel(""));
		resultsPanel.add(resultLabel);
		resultsPanel.add(new JLabel(""));
		resultsPanel.add(runButton);
		runButton.setPreferredSize(new Dimension(100, 10));
		runButton.addActionListener(this);

		add(creditCardPanel);
		add(paypalPanel);
		add(emailPanel);
		add(ipPanel);
		add(phonePanel);
		add(addressPanel);
		add(browserPanel);
		add(resultsPanel);

	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Run")) {
			StringBuilder result = new StringBuilder();
			int rulesFired = 0;
			try {
				FraudEngine engine = new FraudEngine();
				CreditCard c1 = new CreditCard(creditCardCheck1.isSelected(),
						creditCardCheck2.isSelected(),
						creditCardCheck3.isSelected(),
						creditCardCheck4.isSelected(),
						creditCardCheck5.isSelected(),
						creditCardCheck6.isSelected(),
						creditCardCheck7.isSelected(),
						creditCardCheck8.isSelected(),
						creditCardCheck9.isSelected());
				PayPal p1 = new PayPal(paypalCheck1.isSelected(),
						paypalCheck2.isSelected(), paypalCheck3.isSelected(),
						paypalCheck4.isSelected(), paypalCheck5.isSelected());
				Email m1 = new Email(emailCheck1.isSelected(),
						emailCheck2.isSelected(), emailCheck3.isSelected(),
						emailCheck4.isSelected(), emailCheck5.isSelected());
				IP i1 = new IP(ipCheck1.isSelected(), ipCheck2.isSelected(),
						ipCheck3.isSelected(), ipCheck4.isSelected(),
						ipCheck5.isSelected());
				Phone p2 = new Phone(phoneCheck1.isSelected(),
						phoneCheck2.isSelected(), phoneCheck3.isSelected(),
						phoneCheck4.isSelected(), phoneCheck5.isSelected());
				Address a1 = new Address(addressCheck1.isSelected(),
						addressCheck2.isSelected(), addressCheck3.isSelected(),
						addressCheck4.isSelected(), addressCheck5.isSelected());
				Browser b1 = new Browser(browserCheck1.isSelected(),
						browserCheck2.isSelected(), browserCheck3.isSelected(),
						browserCheck4.isSelected(), browserCheck5.isSelected());
				engine.add(c1);
				engine.add(p1);
				engine.add(m1);
				engine.add(i1);
				engine.add(p2);
				engine.add(a1);
				engine.add(b1);
				Iterator<?> risks = engine.run();
				while (risks.hasNext()) {
					result.append("   " + risks.next());
					rulesFired++;
				}
			} catch (JessException ex) {
				ex.printStackTrace();
			}
			resultLabel.setText("Risk Percentage: "
					+ ((rulesFired * 100) / TOTAL_RULES) + "%");
		}
	}

	/**
	 * Create the GUI and show it
	 */
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Fraud Detection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new Window();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}