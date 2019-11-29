import javax.swing.JComboBox;

public class FortbildungLoeschenK {

	String[] fortbildungen = Fortbildung.gibAlleFortbildungen();
	SachbearbeiterEK sach;
	JComboBox fortbildungenVonSachb;
	String[] status;
	String[] inCombo;

	public FortbildungLoeschenK(String sachB) {
		sach = SachbearbeiterEK.gib(sachB);

		System.out.println(sachB);

		System.out.println(fortbildungen.length);

		for (int i = 0; i < fortbildungen.length; i++) {
			System.out.println(fortbildungen[i]);
			System.out.println(sachB);
			System.out.println(SachbearbeiterEK.getStatus(sach, Fortbildung.gib(fortbildungen[i])));

			fortbildungen[i] = (fortbildungen[i] + "> "  + SachbearbeiterEK.getStatus(sach, Fortbildung.gib(fortbildungen[i])));
		}

		fortbildungenVonSachb = new JComboBox(fortbildungen);
	}

	public String[] getFortbildungen() {
		return fortbildungen;
	}

	public JComboBox oeffnen() {
		return fortbildungenVonSachb;
	}
	
	public void  loescheFortbildung(String sachbearbeiter, Fortbildung fortbildung) {
		
		SachbearbeiterEK vorUb = SachbearbeiterEK.gib(sachbearbeiter);
		SachbearbeiterEK.loescheFortbildung(vorUb, fortbildung);
	}

}
