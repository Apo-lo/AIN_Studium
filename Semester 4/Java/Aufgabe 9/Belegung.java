
class Belegung implements Cloneable {
	final private BetriebsmittelTyp betriebsmittelTyp;
    private int maximalForderung;
    private int aktBelegung;
    
    Belegung(int maximalForderung, BetriebsmittelTyp betriebsmittelTyp, int aktBelegung) {
    	this.maximalForderung = maximalForderung;
    	this.betriebsmittelTyp = betriebsmittelTyp;
    	this.aktBelegung = aktBelegung;
    }

	BetriebsmittelTyp getBetriebsmittelTyp() {
		return betriebsmittelTyp;
	}
    
	int getMaximalForderung() {
		return maximalForderung;
	}

	int getRestforderung() {
		return this.maximalForderung - this.aktBelegung;
	}

	void setAktBelegung(int aktBelegung) {
		this.aktBelegung = aktBelegung;
	}

	int getAktBelegung() {
		return aktBelegung;
	}
	
	public Belegung clone() {
		try {
			return (Belegung) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
