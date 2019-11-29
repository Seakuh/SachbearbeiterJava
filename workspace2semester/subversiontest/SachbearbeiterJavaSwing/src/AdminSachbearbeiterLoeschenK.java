import javax.swing.JOptionPane;

public class AdminSachbearbeiterLoeschenK {

	public void getSachbearbeiterNamen() {
		SachbearbeiterEK.druckeAlleNamen();
	}

	public SachbearbeiterEK gibSachbearbeiter(String name) {

		return SachbearbeiterEK.gib(name);
	}

	public void loescheSachbearbeiter(String name1) {
		SachbearbeiterEK name = SachbearbeiterEK.gib(name1);
		System.out.println(">> " + name.getBenutzerName() + " wurde gelöscht");
		JOptionPane.showMessageDialog(null, ("Benutzer " + name.getBenutzerName() + " gelöscht"), "Gelöscht", JOptionPane.INFORMATION_MESSAGE);
		name.delete();
		System.out.println("");
		SachbearbeiterEK.druckeAlleNamen();
	}

}