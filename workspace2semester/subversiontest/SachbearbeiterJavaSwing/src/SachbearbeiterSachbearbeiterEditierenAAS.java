import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SachbearbeiterSachbearbeiterEditierenAAS {
	
	String bn;
	String pw;
	String berechtigung;
	JPanel editieren;
	JButton okButton;
	JButton beendenButton;
	JPanel a;
	SachbearbeiterEK sachbearbeiter;
	okLauscher okL = new okLauscher();
	abbruchLauscher aL = new abbruchLauscher();
	SachbearbeiterEditierenAS sachbEd;
	SachbearbeiterEditierenK kontrolle = new SachbearbeiterEditierenK();
	
	
	
	public JPanel oeffnen() {

		System.out.println("Im AdminSachbearbeiterEditierenAAS oeffnen Penel");
		JPanel erg = new JPanel();

		erg.setLayout(null);
		sachbEd = null;
		sachbEd = new SachbearbeiterEditierenAS();
		
		sachbEd.getRadioAdmin().setVisible(false);
		sachbEd.getRadioSach().setVisible(false);
		sachbEd.getBerechtigungLabel().setVisible(false);
		sachbEd.getBerechtigung();
		
		erg.add(sachbEd.sachbearbeiterEditieren(true));
		beendenButton = new JButton("Abbruch");
		beendenButton.setBounds(22, 418, 114, 25);
		beendenButton.addActionListener(aL);
		erg.add(beendenButton);

		okButton = new JButton("OK");
		okButton.setBounds(178, 418, 114, 25);
		okButton.addActionListener(okL);
		erg.add(okButton);
		erg.repaint();
		a = erg;
		okButton.setMnemonic(KeyEvent.VK_O);
		beendenButton.setMnemonic(KeyEvent.VK_A);
		
		return erg;
		
	}	
	
	private class okLauscher implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			SachbearbeiterAS.entgrauen();
			System.out.println("hallo123");
			System.out.println(sachbEd.getBenutzernameToString());
			System.out.println(sachbEd.getPasswortToString());
			System.out.println(sachbEd.getBerechtigung());
			System.out.println(sachbEd.getAuswahl());

			kontrolle.kontrolliereEingabe(sachbEd.getBenutzernameToString(), sachbEd.getPasswortToString(),
					sachbEd.getBerechtigung(), sachbEd.getAuswahl());
			a.setVisible(false);
		}

	}
	
	public class abbruchLauscher implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			SachbearbeiterAS.entgrauen();
			a.setVisible(false);
		}
	}

	public void SachbearbeiterEditierenAbschliessen(JPanel adminEditPanel) {
		
	}

	public JPanel gibPanel() {

		return a;
	}
	
}
