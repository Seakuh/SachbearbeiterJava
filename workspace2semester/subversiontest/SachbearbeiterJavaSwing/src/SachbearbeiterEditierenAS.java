import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class SachbearbeiterEditierenAS extends JPanel {
	
	public JTextField benutzerNameEingabe;
	private JTextField eingabePasswort;
	String bn;
	String pw;
	String berechtigung;
	SachbearbeiterEK sachbearbeiter;
	// okLauscher oklauscher;
	JPanel panel = new JPanel();
	private static SachbearbeiterEditierenAS instance;
	String sachbearbeiterauswahl = "";
	String auswahl ="";
	private JTextField textField;
	SachbearbeiterAuswaehlenAAS auswahlCombobox = new SachbearbeiterAuswaehlenAAS();
	JRadioButton rdbtnAdministrator = new JRadioButton("Administrator");
	JRadioButton rdbtnSachbearbeiter = new JRadioButton("Sachbearbeiter");
	JLabel lblBerechtigung = new JLabel("Berechtigung:");


	/**
	 * Create the panel.
	 */
	public JPanel getPanel() {
		return panel;
	}

	public static SachbearbeiterEditierenAS getInstance() {
		if (instance == null) {
			instance = new SachbearbeiterEditierenAS();
		}
		return instance;
	}

	public SachbearbeiterEditierenAS() {
		System.out.println("Geöffnet und return neuen SachbearbeiterEditieren");
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

		lblBerechtigung.setBounds(22, 122, 217, 98);
		panel.add(lblBerechtigung);

		JLabel lblFortbildungen = new JLabel("Fortbildungen:");
		lblFortbildungen.setBounds(12, 276, 143, 59);
		panel.add(lblFortbildungen);

		JLabel lblSachbearbeiterAuswhlen = new JLabel("Sachbearbeiter auswählen:");
		lblSachbearbeiterAuswhlen.setBounds(12, 230, 239, 56);
		panel.add(lblSachbearbeiterAuswhlen);

		benutzerNameEingabe = new JTextField();
		benutzerNameEingabe.setBounds(233, 85, 124, 19);
		panel.add(benutzerNameEingabe);
		benutzerNameEingabe.setColumns(10);

		eingabePasswort = new JTextField();
		pw = eingabePasswort.getText();
		eingabePasswort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(eingabePasswort.getText());
				pw = eingabePasswort.getText();
			}
		});
		eingabePasswort.setColumns(10);
		eingabePasswort.setBounds(233, 126, 124, 19);
		panel.add(eingabePasswort);

		rdbtnSachbearbeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnSachbearbeiter.isSelected()) {
					berechtigung = "normal";
				}
			}
		});
		rdbtnSachbearbeiter.setBounds(233, 160, 144, 23);
		rdbtnSachbearbeiter.setMnemonic(KeyEvent.VK_S);
		rdbtnAdministrator.setMnemonic(KeyEvent.VK_A);
		panel.add(rdbtnSachbearbeiter);

		rdbtnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnAdministrator.isSelected()) {
					berechtigung = "admin";
				}
			}
		});
		rdbtnAdministrator.setBounds(233, 180, 144, 23);
		panel.add(rdbtnAdministrator);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(126, 298, 336, 90);	

		panel.add(textArea);
		
		JComboBox comboBox = auswahlCombobox.oeffnen();
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				
				auswahl = (String)comboBox.getSelectedItem().toString();
				SachbearbeiterEK voruber = SachbearbeiterEK.gib(auswahl);
				eingabePasswort.setText(voruber.getPasswort());
				benutzerNameEingabe.setText(voruber.getBenutzerName());
				if(voruber.getBerechtigung()=="admin") {
					rdbtnAdministrator.setSelected(true);
					rdbtnSachbearbeiter.setSelected(false);

				}else {
					rdbtnSachbearbeiter.setSelected(true);
					rdbtnAdministrator.setSelected(false);

				}
				String text = voruber.gibStringfuertextArea(auswahl);
				System.out.println(text);
				textArea.setText(text);
				
				

				
			}
		});
		auswahl = auswahlCombobox.getAuswahl();
		comboBox.setBounds(233, 248, 131, 24);
		panel.add(comboBox);
	}

	JPanel sachbearbeiterEditieren(boolean editierbar) {

		return panel;

	}

	public String getPw() {
		return pw;
	}

	public String getBn() {
		return bn;
	}

	public String getBerechtigung() {
		return berechtigung;
	}

	public SachbearbeiterEK getSachbearbeiter() {
		return sachbearbeiter;
	}

	public String getBenutzernameToString() {
		return benutzerNameEingabe.getText();
	}

	public String getPasswortToString() {
		return eingabePasswort.getText();
	}

//	public ActionListener getokLauscher() {
//		return oklauscher;
//	}
	
	public String getAuswahl() {
		return auswahl;
	}

	public JComponent getRadioAdmin() {
		return rdbtnAdministrator;
	}
	public JComponent getRadioSach() {
		return rdbtnSachbearbeiter;
	}
	
	public JLabel getBerechtigungLabel() {
		return lblBerechtigung;
	}
}
