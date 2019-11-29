import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SachbearbeiterEditierenK {

	JPanel adminEdit;
	AdministratorAS as = new AdministratorAS();
	SachbearbeiterAS ss = new SachbearbeiterAS();


	public void kontrolliereEingabe(String bn, String pw, String berechtigung, String sachbearbeiter) {

		SachbearbeiterEK bearbeiten = SachbearbeiterEK.gib(sachbearbeiter);
		bearbeiten.setPasswort(pw);
		if (eingabeBenutzername(bn)) {
			bearbeiten.setBenutzername(bn);
			bearbeiten.setBerechtigung(berechtigung);
			JOptionPane.showMessageDialog(null, "Sachbearbeiter bearbeitet", "Editiert",
					JOptionPane.INFORMATION_MESSAGE);
			as.adminSachbearbeiterEditierenAbschliessen(adminEdit);
		} else {
			JOptionPane.showMessageDialog(null, "Benutzername entspricht nicht Muster", "Error",
					JOptionPane.ERROR_MESSAGE);
			as.adminSachbearbeiterEditierenAbschliessen(adminEdit);

		}

	}

	public boolean eingabeBenutzername(String eing) {
		boolean b = Pattern.matches("[a-zA-Z_ß]+", eing);
		if (b) {
			return true;
		} else {
			return false;
		}

	}

}
