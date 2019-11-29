import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SachbearbeiterSachbearbeitererzeugenAAS extends JPanel {

	/**
	 * Create the panel.
	 */
	SachbearbeiterS loginPanel = new SachbearbeiterS();
	JPanel panel = new JPanel();
	public JTextField benutzerNameEingabe;
	private JTextField eingabePasswort;
//	String bn = "";
//	String pw = "";
	String berechtigung;
	AdminSachbearbeiterErzeugenK kontrolle = new AdminSachbearbeiterErzeugenK();

	public SachbearbeiterSachbearbeitererzeugenAAS() {
		System.out.println("hallo panel erzeugen");
		// panel.add(loginPanel.konfiguriereSachbearbeiterPanel("", "", "", true));

		panel.setLayout(null);
		panel.setSize(600, 400);

		JLabel lblSachbearbeiteradminErstellen = new JLabel("Sachbearbeiter/Admin editieren:");
		lblSachbearbeiteradminErstellen.setBounds(12, -29, 426, 109);
		panel.add(lblSachbearbeiteradminErstellen);

		JLabel lblBenutzername = new JLabel("Benutzername:");
		lblBenutzername.setBounds(22, 65, 194, 59);
		panel.add(lblBenutzername);

		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setBounds(22, 92, 217, 86);
		panel.add(lblPasswort);

		benutzerNameEingabe = new JTextField();

		benutzerNameEingabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(benutzerNameEingabe.getText());
				String benutzername = benutzerNameEingabe.getText();
			}
		});
		benutzerNameEingabe.setBounds(233, 85, 124, 19);
		panel.add(benutzerNameEingabe);
		benutzerNameEingabe.setColumns(10);

		eingabePasswort = new JTextField();

		eingabePasswort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(eingabePasswort.getText());
				String passwort = eingabePasswort.getText();
			}
		});
		eingabePasswort.setColumns(10);
		eingabePasswort.setBounds(233, 126, 124, 19);
		panel.add(eingabePasswort);


		JButton btnAbbruch = new JButton("Abbruch");
		btnAbbruch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SachbearbeiterAS.entgrauen();
				panel.setVisible(false);
			}
		});
		btnAbbruch.setBounds(22, 299, 114, 25);
		panel.add(btnAbbruch);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdministratorAS.entgrauen();
				panel.setVisible(false);
					kontrolle.trageNeuenNutzerein(benutzerNameEingabe.getText(), eingabePasswort.getText(), "normal");
				} 
			
		});
		btnOk.setBounds(159, 299, 114, 25);
		panel.add(btnOk);

	}
	public JPanel getPanel() {
		System.out.println("neues panel ");
		return panel;
	}


}
