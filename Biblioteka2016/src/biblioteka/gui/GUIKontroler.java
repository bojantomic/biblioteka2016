package biblioteka.gui;

import java.awt.EventQueue;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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

	public static void ucitajIzFajla() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(glavniProzor.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Uspesno ste izabrali fajl!", "Super!!!",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Doslo je do greske pri biranju fajla!",
					"Greska!!!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void sacuvajKnjigu(Knjiga knjiga) {
		biblioteka.dodajKnjigu(knjiga);
		glavniProzor.osveziTabelu();
	}

	public static List<Knjiga> vratiSveKnjige() {
		return biblioteka.vratiSveKnjige();
	}

	public static void porukaGreskeBiranjeReda() {
		JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Izaberite knjigu za brisanje!",
				"Greska!!!", JOptionPane.ERROR_MESSAGE);
	}

	public static void izbrisiKnjigu(Knjiga k) {
		biblioteka.obrisiKnjigu(k);
		glavniProzor.osveziTabelu();
		
	}

}
