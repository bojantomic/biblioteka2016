package biblioteka.gui;

import java.awt.EventQueue;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import biblioteka.Autor;
import biblioteka.Biblioteka;
import biblioteka.Knjiga;
import biblioteka.interfejs.BibliotekaInterfejs;

public class GUIKontroler {

	private static GlavniProzor glavniProzor;
	private static BibliotekaInterfejs biblioteka;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					biblioteka = new Biblioteka();
					glavniProzor = new GlavniProzor();
					glavniProzor.setVisible(true);
					glavniProzor.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void prikaziDodajKnjiguProzor() {
		DodajKnjigu prozor = new DodajKnjigu();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}

	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(glavniProzor.getContentPane(), "Da li zelite da zatvorite program?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void sacuvajUFajl() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(glavniProzor.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				biblioteka.sacuvajUFajl(file.getAbsolutePath());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e1.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void ucitajIzFajla() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(glavniProzor.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				biblioteka.ucitajIzFajla(file.getAbsolutePath());
				glavniProzor.osveziTabelu();
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e1.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void unesiKnjigu(String naslov, String izdavac, String ISBN, Integer izdanje, String autor1Ime,
			String autor1Prezime, String autor2Ime, String autor2Prezime) {
		try {
			Knjiga knjiga = new Knjiga();

			// Punjenje opstih podataka o knjizi
			knjiga.setNaslov(naslov);
			knjiga.setIzdavac(izdavac);
			knjiga.setIsbn(Integer.parseInt(ISBN));
			knjiga.setIzdanje(izdanje);

			// Popunjavanje liste autora
			LinkedList<Autor> autori = new LinkedList<Autor>();

			if (autor1Ime != null && !autor1Ime.isEmpty() && autor1Prezime != null && !autor1Prezime.isEmpty()) {
				Autor autor = new Autor();
				autor.setIme(autor1Ime);
				autor.setPrezime(autor1Prezime);
				autori.add(autor);
			}

			if (autor2Ime != null && !autor2Ime.isEmpty() && autor2Prezime != null && !autor2Prezime.isEmpty()) {
				Autor autor = new Autor();
				autor.setIme(autor2Ime);
				autor.setPrezime(autor2Prezime);
				autori.add(autor);
			}

			knjiga.setAutori(autori);

			// Dodavanje knjige u listu knjiga
			biblioteka.dodajKnjigu(knjiga);

			// Osvezavanje prikaza u tabeli
			glavniProzor.osveziTabelu();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Proveri formu: " + e1.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static List<Knjiga> vratiSveKnjige() {
		return biblioteka.vratiSveKnjige();
	}

	public static void porukaGreskeBiranjeReda() {
		JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Izaberite knjigu za brisanje!", "Greska!!!",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void izbrisiKnjigu(Knjiga k) {
		biblioteka.obrisiKnjigu(k);
		glavniProzor.osveziTabelu();
	}

}
