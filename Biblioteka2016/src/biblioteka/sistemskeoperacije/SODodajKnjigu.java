package biblioteka.sistemskeoperacije;

import java.util.List;

import biblioteka.Knjiga;

public class SODodajKnjigu {
	
	public static void izvrsi(Knjiga knjiga, List<Knjiga> knjige) {
		// Ne sme biti duplikata knjiga
		if (knjiga == null || knjige.contains(knjiga))
			throw new RuntimeException("Greska pri unosu knjige");

		knjige.add(knjiga);
	}

}
