
public class LehrveranstaltungVerwaltung {

	public static void main(String[] args) {

		// Admin + Benutzer erzeugen
		SachbearbeiterEK admin = new SachbearbeiterEK("admin", "1234", "admin");
		SachbearbeiterEK Hans = new SachbearbeiterEK("Hans", "1234", "normal");
		SachbearbeiterEK Gustav = new SachbearbeiterEK("Henna", "1234", "normal");
		SachbearbeiterEK Günter = new SachbearbeiterEK("Guenti_g", "1234", "normal");
		SachbearbeiterEK Elfride = new SachbearbeiterEK("Elfißees", "1234", "normal");
		SachbearbeiterEK Petra = new SachbearbeiterEK("Peti", "1234", "normal");

		// Fortbildungen Hinzufügen
		Fortbildung Mathematik_1 = new Fortbildung("Mathematik_1", true);
		Fortbildung Mathematik_2 = new Fortbildung("Mathematik_2", Mathematik_1, true);
		Fortbildung Allgemeine_Betriebswirtschaftslehre = new Fortbildung("Allg._BWL", true);
		Fortbildung Kostenrechnung = new Fortbildung("K-rechnung", Mathematik_2, Allgemeine_Betriebswirtschaftslehre);

		admin.add();
		Hans.add();
		Gustav.add();
		Günter.add();
		Elfride.add();
		Petra.add();

		SachbearbeiterEK.druckeAlleNamen();

		LehrveranstaltungsVerwaltungHS frame = new LehrveranstaltungsVerwaltungHS("MainFrame");
		//instance = frame;

		frame.oeffnen();
		// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	}
}
