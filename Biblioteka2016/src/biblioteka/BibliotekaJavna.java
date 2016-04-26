package biblioteka;

import java.util.LinkedList;

import biblioteka.sistemskeoperacije.SOPronadjiKnjigu;
import biblioteka.sistemskeoperacije.SOUcitajIzFajla;

public class BibliotekaJavna {
	
	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();

	public void ucitajIzFajla(String putanja) {
		SOUcitajIzFajla.izvrsi(putanja, knjige);
	}
	
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, long ISBN, String naslov, String izdavac) {
		return SOPronadjiKnjigu.izvrsi(autor, ISBN, naslov, izdavac, knjige);
	}

}
