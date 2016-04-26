package biblioteka.sistemskeoperacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

import biblioteka.Knjiga;

public class SOUcitajIzFajla {
	
	public static void izvrsi(String putanja, List<Knjiga> knjige) {
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
