package biblioteka.sistemskeoperacije;

import java.util.LinkedList;
import java.util.List;

import biblioteka.Autor;
import biblioteka.Knjiga;

public class SOPronadjiKnjigu {

	public static LinkedList<Knjiga> izvrsi(Autor autor, long ISBN, String naslov, String izdavac, List<Knjiga> knjige) {
		if (naslov == null)
			throw new RuntimeException("Naslov ne sme biti null");

		LinkedList<Knjiga> rezultat = new LinkedList<Knjiga>();

		for (int i = 0; i < knjige.size(); i++)
			if (knjige.get(i).getNaslov().contains(naslov))
				rezultat.add(knjige.get(i));

		return rezultat;
	}
	
}
