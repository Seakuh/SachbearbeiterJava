import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LoginAS extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public LoginAS() {
		
		
		setLayout(null);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(55, 65, 66, 15);
		add(lblLogin);

		JLabel lblBenutzername = new JLabel("Benutzername:");
		lblBenutzername.setBounds(55, 92, 128, 36);
		add(lblBenutzername);

		JLabel lblPasswort = new JLabel("Passwort: ");
		lblPasswort.setBounds(55, 118, 142, 49);
		add(lblPasswort);

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String benutzername = "";
				benutzername = textField.getText();
			}
		});
		textField.setBounds(229, 101, 124, 19);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String passwort = "";
				passwort = textField_1.getText();
			}
		});
		textField_1.setBounds(229, 133, 124, 19);
		add(textField_1);
		textField_1.setColumns(10);

		JRadioButton rdbtnAdministrator = new JRadioButton("Administrator");
		rdbtnAdministrator.setBounds(229, 160, 144, 23);
		add(rdbtnAdministrator);

		JRadioButton rdbtnSachbearbeiter = new JRadioButton("Sachbearbeiter");
		rdbtnSachbearbeiter.setBounds(229, 188, 144, 23);
		add(rdbtnSachbearbeiter);

		JButton btnOk = new JButton("Ok");
		
		btnOk.addActionListener(OKLauscher(rdbtnAdministrator, rdbtnSachbearbeiter));
		btnOk.setBounds(135, 263, 114, 25);
		add(btnOk);
		btnOk.setMnemonic(KeyEvent.VK_O);

		JLabel lblBerechtigungn = new JLabel("Berechtigung:");
		lblBerechtigungn.setBounds(55, 164, 128, 25);
		add(lblBerechtigungn);
		setVisible(true);

		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new Abbruchlauscher());
		btnAbbrechen.setBounds(7, 263, 114, 25);
		add(btnAbbrechen);
		btnAbbrechen.setMnemonic(KeyEvent.VK_B);
		rdbtnAdministrator.setMnemonic(KeyEvent.VK_A);
		rdbtnSachbearbeiter.setMnemonic(KeyEvent.VK_S);

	}

	public static JPanel login() {

		LoginAS loginPanel = new LoginAS();

		return loginPanel;

	}

//	public static LoginAS getInstance() {
//		if(instance == null) {
//			instance = new LoginAS();
//		}
//		return instance;
//	}

	public ActionListener OKLauscher(JRadioButton rdbtnAdministrator, JRadioButton rdbtnSachbearbeiter) {
		ActionListener okLau = (new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.out.println(textField.getText() + "    " + textField_1.getText());
				System.out.println(LoginK.kontrolleEingabe(textField.getText(), textField_1.getName()));
				if (LoginK.kontrolleEingabe(textField.getText(), textField_1.getText()).equals("admin")) {
					if (rdbtnAdministrator.isSelected() || rdbtnSachbearbeiter.isSelected()) {
						if (rdbtnAdministrator.isSelected()) {
							
							LehrveranstaltungsVerwaltungHS.loginBeenden(1, LoginAS.login());
							
						} else if (rdbtnSachbearbeiter.isSelected()) {
							System.out.println("In 2 Sachbearbeiter");
							LehrveranstaltungsVerwaltungHS.loginBeenden(2, LoginAS.login());
						}
					} else {
						JOptionPane.showMessageDialog(null, "Keine Berechtigung ausgewählt", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} else if (LoginK.kontrolleEingabe(textField.getText(), textField_1.getText()).equals("normal")
						&& rdbtnSachbearbeiter.isSelected()) {
					LehrveranstaltungsVerwaltungHS sachbea = new LehrveranstaltungsVerwaltungHS("admin");
					sachbea.loginBeenden(2, LoginAS.login());
				} else {
					JOptionPane.showMessageDialog(null, "Falsche Eingabe", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		return okLau;

	}

	class Abbruchlauscher implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			LehrveranstaltungsVerwaltungHS.loescheLoginPanel();

		}
	}

}
