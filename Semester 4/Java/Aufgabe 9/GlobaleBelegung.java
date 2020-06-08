
import java.util.*;

class GlobaleBelegung {
	private List<Beleger> dieBeleger;

	private List<GlobaleBelegung> kinder = new LinkedList<>();
	private boolean gehoertZumErfolgsPfad = false;
	private Beleger belegerDerFertigWird = null;

	GlobaleBelegung(List<Beleger> dieBeleger) {
		this.dieBeleger = dieBeleger;
	}

	/**
	 * liefert true, wenn alle beleger fertig arbeiten koennen
	 * 
	 * @return
	 */
	boolean expand() {

		// welche Beleger koennen Maximal Forderungen belegen?
		for (Beleger beleger : dieBeleger) {
			boolean belegerKannFertigwerden = true;
			List<Belegung> belegungen = beleger.getBelegungen();

			// Beleger muss maximal Forderungen an allen Betriebsmitteln
			// belegen koennen, um fertig zu werden
			for (Belegung belegung : belegungen) {
				BetriebsmittelTyp typ = belegung.getBetriebsmittelTyp();
				belegerKannFertigwerden = belegerKannFertigwerden
						&& (belegung.getRestforderung()
								+ typ.aktBelegung(dieBeleger) <= typ
								.getAnzahl());
			}

			if (belegerKannFertigwerden) {
				List<Beleger> dieNeuenBeleger = new LinkedList<>(dieBeleger);
				this.belegerDerFertigWird = beleger;

				// Beleger kann fertigarbeiten
                                // den Beleger, der fertig ist, aus dieNeuenBeleger entfernen
				dieNeuenBeleger.remove(belegerDerFertigWird);

				// Wenn dieNeuenBeleger leer sind, dann true zurueckgeben
				if (dieNeuenBeleger.isEmpty()) {
                                // diese globale Belegung gehoert damit zum ErfolgsPfad
					this.gehoertZumErfolgsPfad = true;
					return true;
                                // anderenfalls eine neue GlobaleBelegung erzeugen mit dieNeuenBeleger als Beleger
				} else {
					GlobaleBelegung globaleBelegung = new GlobaleBelegung(dieNeuenBeleger);
				// die neue GlobaleBelegung muss der Liste der Kinder dieser GlobalenBelegung
                                // hinzugefuegt werden.
					kinder.add(globaleBelegung);
				// die Methode expand auf der neuen GlobalenBelegung  aufrufen, um festzustellen
                                // ob diese Belegung fertig laufen kann.
					if (globaleBelegung.expand()) {
                                // wenn diese Belegung fertig laufen kann, gehoert diese GlobaleBelegung zum
                                // Erfolgspfad und true kann zurueckgeliefert werden
						this.gehoertZumErfolgsPfad = true;
						return true;
					}
				}				// Ansonsten passiert nichts.
			}
		}
		return false;
	}
	
	void druckePfad() {
		if (this.gehoertZumErfolgsPfad) {
			System.out.println(this.belegerDerFertigWird.getName());
			
			for (GlobaleBelegung kind : kinder) {
				kind.druckePfad();
			}
		}
	}

}
