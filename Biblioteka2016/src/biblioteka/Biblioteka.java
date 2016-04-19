package biblioteka;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import biblioteka.interfejs.BibliotekaInterfejs;

public class Biblioteka implements BibliotekaInterfejs {

	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();

	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		// Ne sme biti duplikata knjiga
		if (knjiga == null || knjige.contains(knjiga))
			throw new RuntimeException("Greska pri unosu knjige");

		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if (knjiga == null || !knjige.contains(knjiga))
			throw new RuntimeException("Greska pri brisanju knjige");

		knjige.remove(knjiga);
	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, long ISBN, String naslov, String izdavac) {
		if (naslov == null)
			throw new RuntimeException("Naslov ne sme biti null");

		LinkedList<Knjiga> rezultat = new LinkedList<Knjiga>();

		for (int i = 0; i < knjige.size(); i++)
			if (knjige.get(i).getNaslov().contains(naslov))
				rezultat.add(knjige.get(i));

		return rezultat;
	}

	@Override
	public void sacuvajUFajl(String putanja) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(putanja)));

			out.writeObject(knjige);

			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void ucitajIzFajla(String putanja) {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(putanja)));

			// Ovo je da bi se lista knjiga zaista prebrisala i napunila ponovo
			// ako se stavi samo kao u sledecem redu, onda ne radi
			// knjige = (LinkedList<Knjiga>)(in.readObject());
			LinkedList<Knjiga> knjige2 = (LinkedList<Knjiga>) (in.readObject());
			knjige.clear();
			knjige.addAll(knjige2);

			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
