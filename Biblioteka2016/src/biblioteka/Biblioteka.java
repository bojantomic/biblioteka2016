package biblioteka;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import biblioteka.interfejs.BibliotekaInterfejs;
import biblioteka.sistemskeoperacije.SODodajKnjigu;
import biblioteka.sistemskeoperacije.SOObrisiKnjigu;
import biblioteka.sistemskeoperacije.SOPronadjiKnjigu;
import biblioteka.sistemskeoperacije.SOSacuvajUFajl;
import biblioteka.sistemskeoperacije.SOUcitajIzFajla;

public class Biblioteka implements BibliotekaInterfejs {

	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();

	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		SODodajKnjigu.izvrsi(knjiga, knjige);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		SOObrisiKnjigu.izvrsi(knjiga, knjige);
	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, long ISBN, String naslov, String izdavac) {
		return SOPronadjiKnjigu.izvrsi(autor, ISBN, naslov, izdavac, knjige);
	}

	@Override
	public void sacuvajUFajl(String putanja) {
		SOSacuvajUFajl.izvrsi(putanja, knjige);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void ucitajIzFajla(String putanja) {
		SOUcitajIzFajla.izvrsi(putanja, knjige);
	}

}
