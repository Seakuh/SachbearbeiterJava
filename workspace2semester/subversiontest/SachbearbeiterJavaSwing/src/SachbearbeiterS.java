import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SachbearbeiterS extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	JPanel panel = new JPanel();
	String benutzername;
	String passwort;
	String berechtigung;

	/**
	 * Create the panel.
	 */
	public SachbearbeiterS() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gridBagLayout);

		JLabel lblBenutzername = new JLabel("Benutzername:");
		GridBagConstraints gbc_lblBenutzername = new GridBagConstraints();
		gbc_lblBenutzername.insets = new Insets(0, 0, 5, 5);
		gbc_lblBenutzername.gridx = 1;
		gbc_lblBenutzername.gridy = 2;
		panel.add(lblBenutzername, gbc_lblBenutzername);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		benutzername = textField.getText();

		JLabel lblPasswort = new JLabel("Passwort:");
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswort.gridx = 1;
		gbc_lblPasswort.gridy = 4;
		panel.add(lblPasswort, gbc_lblPasswort);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 4;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		passwort = textField_1.getText();
		

		JLabel lblBerechtigung = new JLabel("Berechtigung:");
		GridBagConstraints gbc_lblBerechtigung = new GridBagConstraints();
		gbc_lblBerechtigung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBerechtigung.gridx = 1;
		gbc_lblBerechtigung.gridy = 6;
		panel.add(lblBerechtigung, gbc_lblBerechtigung);

		JRadioButton rdbtnAdministrator = new JRadioButton("Administrator   ");
		GridBagConstraints gbc_rdbtnAdministrator = new GridBagConstraints();
		gbc_rdbtnAdministrator.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnAdministrator.gridx = 4;
		gbc_rdbtnAdministrator.gridy = 6;
		panel.add(rdbtnAdministrator, gbc_rdbtnAdministrator);

		JRadioButton rdbtnSachbearbeiter = new JRadioButton("Sachbearbeiter");
		GridBagConstraints gbc_rdbtnSachbearbeiter = new GridBagConstraints();
		gbc_rdbtnSachbearbeiter.gridx = 4;
		gbc_rdbtnSachbearbeiter.gridy = 7;
		panel.add(rdbtnSachbearbeiter, gbc_rdbtnSachbearbeiter);
		
		if(rdbtnAdministrator.isSelected()) {
			berechtigung = "admin";
		}
		if(rdbtnSachbearbeiter.isSelected()) {
			berechtigung = "normal";
		}
		
		

	}

	JPanel konfiguriereSachbearbeiterPanel(String ueberschrift, String defaultBenutzername, String defaultPasswort,
			boolean editierbar) {
		
		
		return panel;
	}
	
	
	public String getPw() {
		return passwort;
	}

	public String getBn() {
		return benutzername;
	}

	public String getBerechtigung() {
		return berechtigung;
	}
	

}

//
//import java.util.Scanner;
//
//import javax.swing.JComboBox;
//
//public class SachbearbeiterS {
//
//	public static SachbearbeiterK kontrolle = new SachbearbeiterK();
//	
//
//
//	public static SachbearbeiterEK anmeldung() {
//		System.out.println("-------Login-------");
//
//		System.out.println("Benutzername: ");
//		Scanner benutzername = new Scanner(System.in);
//		String bn = benutzername.nextLine();
//
//		System.out.println("Passwort: ");
//		Scanner passwort = new Scanner(System.in);
//		String pw = benutzername.nextLine();
//
//		SachbearbeiterEK aktUser = kontrolle.eingabeKontrolle(bn, pw);
//
//		if (aktUser.getBenutzerName().equals("Falsche Eingabe")) {
//			System.exit(0);
//		}
//
//		return aktUser;
//	}
//
//	public void setBenutzerName(SachbearbeiterEK name, String neuername) {
//		name.setBenutzername(neuername);
//		System.out.println(">> Benutzername geändert - Neuer Benutzername:" + name.getBenutzerName());
//	}
//
//
//
//	public static void fortbildungZuweisen(String berechtigung) {
//		System.out.println("Welchem Sachbearbeiter soll eine Fortbildung zugewiesen werden?");
//		SachbearbeiterEK.druckeAlleNamen();
//		Scanner sachb = new Scanner(System.in);
//		String name = sachb.nextLine();
//		SachbearbeiterEK prufSa = SachbearbeiterEK.gib(name);
//		name = prufSa.getBenutzerName();
//		System.out.println("Welche Fortbildung soll zugewiesen werden?");
//		Fortbildung.druckeAlleFortbildungen();
//		Scanner fortb = new Scanner(System.in);
//		String fort = fortb.nextLine();
//		Fortbildung prufe = Fortbildung.gib(fort);
//
//		kontrolle.fortbildungZuweisenK(name, fort);
//
//
//	}
//
//	public static void setStatus(String berechtigung) {
//		System.out.println("Von welchem Sachbearbeiter soll der Status geändert werden?");
//		SachbearbeiterEK.druckeAlleNamen();
//
//		Scanner auswahl = new Scanner(System.in);
//		String a = auswahl.nextLine();
//		SachbearbeiterEK prufna = SachbearbeiterEK.gib(a);
//		a = prufna.getBenutzerName();
//		kontrolle.setStatusFortbildung(a, berechtigung);
//	}
//
//	public static void menu(String status) {
//
//	}
//
//	public static void loescheFortbildung(String berechtigung) {
//		System.out.println("Von welchem Sachbearbeiter?");
//		SachbearbeiterEK.druckeAlleNamen();
//		Scanner buswahl = new Scanner(System.in);
//		String b = buswahl.nextLine();
//		SachbearbeiterEK aws = SachbearbeiterEK.gib(b);
//		if (SachbearbeiterEK.hatFortbuldungen(aws)) {
//			System.out.println("Welche forbildung soll gelöscht werden?");
//			SachbearbeiterEK.druckeAlleFortbildungenVonAktuellemSachbearbeiter(aws);
//			Scanner auswahl = new Scanner(System.in);
//			String a = auswahl.nextLine();
//			Fortbildung fort = Fortbildung.gib(a);
//
//			SachbearbeiterEK.loescheFortbildung(aws, fort);
//		} else {
//			System.out.println(">>Der ausgewählte Sachbearbeiter hat noch keine Fortbildungen");
//		}
//
//
//	}
//
//}