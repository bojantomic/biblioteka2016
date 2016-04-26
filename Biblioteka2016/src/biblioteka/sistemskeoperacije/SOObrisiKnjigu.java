package biblioteka.sistemskeoperacije;

import java.util.List;

import biblioteka.Knjiga;

public class SOObrisiKnjigu {
	
	public static void izvrsi(Knjiga knjiga, List<Knjiga> knjige) {
		if (knjiga == null || !knjige.contains(knjiga))
			throw new RuntimeException("Greska pri brisanju knjige");

		knjige.remove(knjiga);
	}

}
