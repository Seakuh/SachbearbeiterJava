
public class SachbearbeiterAuswaehlenK {

	String[] namen;
	Wrappergib wrapper = new Wrappergib();

	public SachbearbeiterAuswaehlenK() {
		namen = wrapper.gibNamenWrapper();
	}

	String[] gibNamen() {
		return namen;
	}

	String gibBenutzername(SachbearbeiterEK dieser) {
		return dieser.getBenutzerName();
	}

	public class Wrappergib {

		String[] namen;

		Wrappergib() {
			namen = SachbearbeiterEK.gibAlleNamen();

		}

		public String[] gibNamenWrapper() {
			return namen;
		}

	}

}
