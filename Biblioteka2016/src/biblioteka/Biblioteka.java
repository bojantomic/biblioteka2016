package biblioteka;

import java.util.LinkedList;

import biblioteka.interfejs.BibliotekaInterfejs;

public class Biblioteka implements BibliotekaInterfejs {

	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();
	
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		// Ne sme biti duplikata knjiga
		if (knjiga==null || knjige.contains(knjiga))
			throw new RuntimeException("Greska pri unosu knjige");
		
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if (knjiga==null || !knjige.contains(knjiga))
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

		for (int i=0;i<knjige.size();i++)
			if (knjige.get(i).getNaslov().contains(naslov))
				rezultat.add(knjige.get(i));
		
		return rezultat;
	}

}
