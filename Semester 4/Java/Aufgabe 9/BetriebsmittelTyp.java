
import java.util.List;

/**
 * Fuer jeden Betriebsmitteltyp gibt es nur genau ein Objekt
 * @author Glaeser
 *
 */
class BetriebsmittelTyp {
	private String name;
	private int anzahl;

	BetriebsmittelTyp(String name, int anzahl) {
		this.name = name;
		this.anzahl = anzahl;
	}

	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}

	void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	int getAnzahl() {
		return anzahl;
	}
	
	int aktBelegung(List<Beleger> dieBeleger) {
		int summe = 0;
		
		for (Beleger beleger : dieBeleger) {
			
			for (Belegung belegung: beleger.getBelegungen()) {
				if (belegung.getBetriebsmittelTyp().equals(this)) {
					summe = summe + belegung.getAktBelegung();
				}
			}
			
		}
		
		return summe;
	}

}
