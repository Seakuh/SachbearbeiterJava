import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class FortbildungZuordnenAAS extends JPanel {

	SachbearbeiterAuswaehlenAAS sachbearbeiterauswahl = new SachbearbeiterAuswaehlenAAS();
	FortbildungAuswaehlenAAS fortbildungenauswahl = new FortbildungAuswaehlenAAS();
	JPanel p = new JPanel();
	String status = "";
//	String sachbearbeiter = "";
//	String fortbildung = "";
	//hallo dizzlebranch

	public FortbildungZuordnenAAS() {
		p.setLayout(null);

		JLabel lblFortbildungZuordnen = new JLabel("Fortbildung zuweisen:");
		lblFortbildungZuordnen.setBounds(12, 31, 220, 15);
		p.add(lblFortbildungZuordnen);

		JLabel lblAusgewhlterSacharbeiter = new JLabel("Ausgewählter Sacharbeiter:");
		lblAusgewhlterSacharbeiter.setBounds(12, 85, 207, 15);
		p.add(lblAusgewhlterSacharbeiter);

		JLabel lblAusgewhlteFortbildung = new JLabel("Ausgewählte Fortbildung:");
		lblAusgewhlteFortbildung.setBounds(225, 85, 191, 15);
		p.add(lblAusgewhlteFortbildung);

		JComboBox comboBoxSachbearbeiter = sachbearbeiterauswahl.oeffnen();
		comboBoxSachbearbeiter.setBounds(12, 126, 191, 24);
		p.add(comboBoxSachbearbeiter);

		JComboBox comboBoxFortbildungen = fortbildungenauswahl.oeffnen();
		comboBoxFortbildungen.setBounds(225, 126, 191, 24);
		p.add(comboBoxFortbildungen);

		JRadioButton rdbtnBelegt = new JRadioButton("belegt");
		rdbtnBelegt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnBelegt.isSelected()) {
				}
			}
		});
		rdbtnBelegt.setBounds(8, 175, 144, 23);
		rdbtnBelegt.setMnemonic(KeyEvent.VK_L);
		p.add(rdbtnBelegt);

		JRadioButton rdbtnBestanden = new JRadioButton("bestanden");
		rdbtnBestanden.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnBelegt.isSelected()) {
				}

			}
		});
		rdbtnBestanden.setMnemonic(KeyEvent.VK_S);
		rdbtnBestanden.setBounds(8, 215, 144, 23);
		p.add(rdbtnBestanden);

		JButton btnAbbruch = new JButton("Abbruch");
		btnAbbruch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdministratorAS.entgrauen();
				SachbearbeiterAS.entgrauen();
				p.setVisible(false);
				
			}
		});
		btnAbbruch.setBounds(12, 263, 114, 25);
		btnAbbruch.setMnemonic(KeyEvent.VK_A);
		p.add(btnAbbruch);
		

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdministratorAS.entgrauen();
				SachbearbeiterAS.entgrauen();
				String fortbildung = "keine Ausahl";
				fortbildung = fortbildungenauswahl.auswahl;
				String sachbearbeiter = "keine Auswahl";
				sachbearbeiter = sachbearbeiterauswahl.auswahl;
				System.out
						.println(fortbildung + sachbearbeiter + rdbtnBelegt.isSelected() + rdbtnBestanden.isSelected());
				if ((rdbtnBelegt.isSelected() && rdbtnBestanden.isSelected())) {
					JOptionPane.showMessageDialog(null, "Es kann nur einen Status geben", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if ((!rdbtnBelegt.isSelected() && !rdbtnBestanden.isSelected())) {
					JOptionPane.showMessageDialog(null, "Es muss ein Status ausgewählt werden", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if ((rdbtnBelegt.isSelected() || rdbtnBestanden.isSelected())) {
					if (rdbtnBelegt.isSelected()) {
						System.out.println("Belegt Button ausgewaehlt");
						SachbearbeiterK.fortbildungzuordnen(sachbearbeiter,fortbildung, "Belegt");
						p.setVisible(false);

					} else if (rdbtnBestanden.isSelected()) {
						System.out.println("Bestandenbutton ausgewählt");
						SachbearbeiterK.fortbildungzuordnen(sachbearbeiter, fortbildung, "Bestanden");
						p.setVisible(false);

					}

				} else if (fortbildung.equals(null) || sachbearbeiter.equals(null)) {
					JOptionPane.showMessageDialog(null, "Es muss ein Sachbearbeiter und Fortbildung ausgewählt sein",
							"Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnOk.setMnemonic(KeyEvent.VK_O);
		btnOk.setBounds(134, 263, 114, 25);
		p.add(btnOk);
	}

	public JPanel oeffnen() {
		return p;
	}

}

//	public FortbildungZuordnenAAS() {
//		p.setLayout(null);
//
//		JComboBox comboBox = auswahlBox.oeffnen();
//		comboBox.setBounds(141, 145, 175, 24);
//		p.add(comboBox);
//		
//		
//
//	}
//
