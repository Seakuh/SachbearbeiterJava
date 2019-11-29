import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class FortbildungLoeschenAAS extends JPanel {

	SachbearbeiterAuswaehlenAAS sachbearbeiterauswahl = new SachbearbeiterAuswaehlenAAS();
	FortbildungAuswaehlenAAS fortbildungenauswahl = new FortbildungAuswaehlenAAS();
	JPanel p = new JPanel();
	String status = "";
	FortbildungLoeschenK kontrolle;
	String sachbearbeiter = "";
	String fortbildungString = "";
	JComboBox fortbildungBox;

	/**
	 * Create the panel.
	 */
	public FortbildungLoeschenAAS() {
		p.setLayout(null);

		JLabel lblFortbildungZuordnen = new JLabel("Fortbildung löschen:");
		lblFortbildungZuordnen.setBounds(12, 31, 220, 15);
		p.add(lblFortbildungZuordnen);

		JLabel lblAusgewhlterSacharbeiter = new JLabel("Ausgewählter Sacharbeiter:");
		lblAusgewhlterSacharbeiter.setBounds(12, 85, 207, 15);
		p.add(lblAusgewhlterSacharbeiter);

		JLabel lblAusgewhlteFortbildung = new JLabel("Ausgewählte Fortbildung:");
		lblAusgewhlteFortbildung.setBounds(225, 85, 191, 15);
		p.add(lblAusgewhlteFortbildung);
		lblAusgewhlteFortbildung.setVisible(false);

		JComboBox comboBoxSachbearbeiter = sachbearbeiterauswahl.oeffnen();
		comboBoxSachbearbeiter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				System.out.println((String) comboBoxSachbearbeiter.getSelectedItem());

				String auswahl = (String) comboBoxSachbearbeiter.getSelectedItem();
				System.out.println(auswahl);
				kontrolle = new FortbildungLoeschenK(auswahl);
				fortbildungBox = kontrolle.oeffnen();
				fortbildungBox.setBounds(225, 126, 250, 24);
				p.add(fortbildungBox);
				lblAusgewhlteFortbildung.setVisible(true);

			}
		});
		comboBoxSachbearbeiter.setBounds(12, 126, 191, 24);
		p.add(comboBoxSachbearbeiter);

		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdministratorAS.entgrauen();
				SachbearbeiterAS.entgrauen();
				p.setVisible(false);
			}
		});
		btnAbbrechen.setBounds(12, 263, 114, 25);
		p.add(btnAbbrechen);

		JButton btnLschen = new JButton("Löschen");
		btnLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdministratorAS.entgrauen();
				SachbearbeiterAS.entgrauen();

				fortbildungString = fortbildungBox.getSelectedItem().toString();
				String nameFortb = "";
				for (int i = 0; i < fortbildungString.length(); i++) {

					if (fortbildungString.charAt(i) == '>') {
						break;
					}
					nameFortb = nameFortb + fortbildungString.charAt(i);

				}
				
				String sachB = (String) comboBoxSachbearbeiter.getSelectedItem();
				Fortbildung vorueb = Fortbildung.gib(nameFortb);
				
				kontrolle.loescheFortbildung(sachB,vorueb);
				System.out.println(nameFortb);
				
				p.setVisible(false);
				
			}
		});
		btnLschen.setBounds(169, 263, 114, 25);
		btnAbbrechen.setMnemonic(KeyEvent.VK_A);
		btnLschen.setMnemonic(KeyEvent.VK_L);
		p.add(btnLschen);

	}

	public JPanel oeffnen() {
		return p;
	}

}
