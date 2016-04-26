package biblioteka.sistemskeoperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import biblioteka.Knjiga;

public class SOSacuvajUFajl {
	
	public static void izvrsi(String putanja, List<Knjiga> knjige) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(putanja)));

			out.writeObject(knjige);

			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
