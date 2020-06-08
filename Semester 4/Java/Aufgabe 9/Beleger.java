import java.util.*;

class Beleger {
    private List<Belegung> belegungen;
    private final String name;
    
    Beleger(List<Belegung> belegungen, String name) {
    	this.belegungen = belegungen;
    	this.name = name;
    }

	void setBelegungen(List<Belegung> belegungen) {
		this.belegungen = belegungen;
	}

	List<Belegung> getBelegungen() {
		return belegungen;
	}

	String getName() {
		return name;
	}
}
