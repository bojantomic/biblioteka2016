package biblioteka.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class DodajKnjigu extends JFrame {

	private JPanel contentPane;
	private JLabel lblNaslov;
	private JLabel lblAutorIme;
	private JTextField textFieldNaslov;
	private JTextField textFieldAutor1Ime;
	private JLabel lblIzdavac;
	private JLabel lblAutorPrezime;
	private JTextField textFieldIzdavac;
	private JTextField textFieldAutor1Prezime;
	private JLabel lblIzdanje;
	private JLabel lblAutorIme_1;
	private JTextField textFieldAutor2Ime;
	private JSpinner spinnerIzdanje;
	private JLabel lblIsbn;
	private JLabel lblAutorPrezime_1;
	private JTextField textFieldISBN;
	private JTextField textFieldAutor2Prezime;
	private JButton btnDodaj;
	private JButton btnOdustani;

	/**
	 * Create the frame.
	 */
	public DodajKnjigu() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodajKnjigu.class.getResource("/icons/Blue hills.jpg")));
		setTitle("Dodaj novu knjigu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 7));
		contentPane.add(getLblNaslov());
		contentPane.add(getLblAutorIme());
		contentPane.add(getTextFieldNaslov());
		contentPane.add(getTextFieldAutor1Ime());
		contentPane.add(getLblIzdavac());
		contentPane.add(getLblAutorPrezime());
		contentPane.add(getTextFieldIzdavac());
		contentPane.add(getTextFieldAutor1Prezime());
		contentPane.add(getLblIzdanje());
		contentPane.add(getLblAutorIme_1());
		contentPane.add(getSpinnerIzdanje());
		contentPane.add(getTextFieldAutor2Ime());
		contentPane.add(getLblIsbn());
		contentPane.add(getLblAutorPrezime_1());
		contentPane.add(getTextFieldISBN());
		contentPane.add(getTextFieldAutor2Prezime());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
	}

	private JLabel getLblNaslov() {
		if (lblNaslov == null) {
			lblNaslov = new JLabel("Naslov");
		}
		return lblNaslov;
	}

	private JLabel getLblAutorIme() {
		if (lblAutorIme == null) {
			lblAutorIme = new JLabel("Autor 1 ime");
		}
		return lblAutorIme;
	}

	private JTextField getTextFieldNaslov() {
		if (textFieldNaslov == null) {
			textFieldNaslov = new JTextField();
			textFieldNaslov.setColumns(10);
		}
		return textFieldNaslov;
	}

	private JTextField getTextFieldAutor1Ime() {
		if (textFieldAutor1Ime == null) {
			textFieldAutor1Ime = new JTextField();
			textFieldAutor1Ime.setColumns(10);
		}
		return textFieldAutor1Ime;
	}

	private JLabel getLblIzdavac() {
		if (lblIzdavac == null) {
			lblIzdavac = new JLabel("Izdavac");
		}
		return lblIzdavac;
	}

	private JLabel getLblAutorPrezime() {
		if (lblAutorPrezime == null) {
			lblAutorPrezime = new JLabel("Autor 1 prezime");
		}
		return lblAutorPrezime;
	}

	private JTextField getTextFieldIzdavac() {
		if (textFieldIzdavac == null) {
			textFieldIzdavac = new JTextField();
			textFieldIzdavac.setColumns(10);
		}
		return textFieldIzdavac;
	}

	private JTextField getTextFieldAutor1Prezime() {
		if (textFieldAutor1Prezime == null) {
			textFieldAutor1Prezime = new JTextField();
			textFieldAutor1Prezime.setColumns(10);
		}
		return textFieldAutor1Prezime;
	}

	private JLabel getLblIzdanje() {
		if (lblIzdanje == null) {
			lblIzdanje = new JLabel("Izdanje");
		}
		return lblIzdanje;
	}

	private JLabel getLblAutorIme_1() {
		if (lblAutorIme_1 == null) {
			lblAutorIme_1 = new JLabel("Autor 2 ime");
		}
		return lblAutorIme_1;
	}

	private JTextField getTextFieldAutor2Ime() {
		if (textFieldAutor2Ime == null) {
			textFieldAutor2Ime = new JTextField();
			textFieldAutor2Ime.setColumns(10);
		}
		return textFieldAutor2Ime;
	}

	private JSpinner getSpinnerIzdanje() {
		if (spinnerIzdanje == null) {
			spinnerIzdanje = new JSpinner();
			spinnerIzdanje.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		}
		return spinnerIzdanje;
	}

	private JLabel getLblIsbn() {
		if (lblIsbn == null) {
			lblIsbn = new JLabel("ISBN");
		}
		return lblIsbn;
	}

	private JLabel getLblAutorPrezime_1() {
		if (lblAutorPrezime_1 == null) {
			lblAutorPrezime_1 = new JLabel("Autor 2 prezime");
		}
		return lblAutorPrezime_1;
	}

	private JTextField getTextFieldISBN() {
		if (textFieldISBN == null) {
			textFieldISBN = new JTextField();
			textFieldISBN.setColumns(10);
		}
		return textFieldISBN;
	}

	private JTextField getTextFieldAutor2Prezime() {
		if (textFieldAutor2Prezime == null) {
			textFieldAutor2Prezime = new JTextField();
			textFieldAutor2Prezime.setColumns(10);
		}
		return textFieldAutor2Prezime;
	}

	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.unesiKnjigu(textFieldNaslov.getText(), textFieldIzdavac.getText(),
							textFieldISBN.getText(), (Integer) (spinnerIzdanje.getValue()),
							textFieldAutor1Ime.getText(), textFieldAutor1Prezime.getText(),
							textFieldAutor2Ime.getText(), textFieldAutor2Prezime.getText());
					dispose();
				}

			});
			btnDodaj.setPreferredSize(new Dimension(15, 25));
			btnDodaj.setMinimumSize(new Dimension(15, 25));
			btnDodaj.setMaximumSize(new Dimension(15, 25));
		}
		return btnDodaj;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnOdustani;
	}

}
