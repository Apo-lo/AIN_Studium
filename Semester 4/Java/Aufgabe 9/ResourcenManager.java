
import java.util.LinkedList;
import java.util.List;

public class ResourcenManager {
    private List<Beleger> beleger;

    public static void main(String[] args) {
    	List<Beleger> beleger= new LinkedList<>();
    	BetriebsmittelTyp[] typen = new BetriebsmittelTyp[1];
    	typen[0] = new BetriebsmittelTyp("Eins", 10);
    	// Thread A
    	Belegung belegung = new Belegung(9, typen[0], 3);
    	List<Belegung> belegungen = new LinkedList<>();
    	belegungen.add(belegung);
    	beleger.add(new Beleger(belegungen, "A"));
    	// Thread B
    	belegung = new Belegung(4, typen[0], 5);
    	belegungen = new LinkedList<>();
    	belegungen.add(belegung);
    	beleger.add(new Beleger(belegungen, "B"));
    	// Thread C
    	belegung = new Belegung(7, typen[0], 2);
    	belegungen = new LinkedList<>();
    	belegungen.add(belegung);
    	beleger.add(new Beleger(belegungen, "C"));
    	
    	ResourcenManager manager = new ResourcenManager(beleger);
    	manager.belegungIstSicher();

    }
    
    private ResourcenManager(List<Beleger> beleger) {
    	this.beleger = beleger;
    }

    boolean belegungIstSicher() {
    	GlobaleBelegung gb = new GlobaleBelegung(this.beleger);
    	boolean istSicher = gb.expand();
    	if (istSicher) {
    		System.out.println("Ist sicher");
    		gb.druckePfad();
    	} else {
    		System.out.println("Ist nicht sicher");
    	}
    	return istSicher;
    }
}
