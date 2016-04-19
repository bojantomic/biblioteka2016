package biblioteka.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import biblioteka.Knjiga;
import biblioteka.gui.models.KnjigaTableModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBarGlavniProzor;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private JButton btnDodajKnjigu;
	private JButton btnIzbrisiKnjigu;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajKnjigu;

	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.ugasiAplikaciju();
			}
		});

		setIconImage(Toolkit.getDefaultToolkit().getImage(GlavniProzor.class.getResource("/icons/Winter.jpg")));
		setTitle("Glavni prozor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 635, 364);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.EAST);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBarGlavniProzor == null) {
			menuBarGlavniProzor = new JMenuBar();
			menuBarGlavniProzor.add(getMnFile());
			menuBarGlavniProzor.add(getMnHelp());
		}
		return menuBarGlavniProzor;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}

	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.ucitajIzFajla();
				}
			});
			mntmOpen.setIcon(
					new ImageIcon(GlavniProzor.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		}
		return mntmOpen;
	}

	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.sacuvajUFajl();
				}
			});
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
			mntmSave.setIcon(
					new ImageIcon(GlavniProzor.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		}
		return mntmSave;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.ugasiAplikaciju();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
			mntmExit.setIcon(
					new ImageIcon(GlavniProzor.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		}
		return mntmExit;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}

	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
		}
		return mntmAbout;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			addPopup(scrollPane, getPopupMenu());
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			KnjigaTableModel model = new KnjigaTableModel(null);
			table.setModel(model);
		}
		return table;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(140, 10));
			panel.add(getBtnDodajKnjigu());
			panel.add(getBtnIzbrisiKnjigu());
		}
		return panel;
	}

	private JButton getBtnDodajKnjigu() {
		if (btnDodajKnjigu == null) {
			btnDodajKnjigu = new JButton("Dodaj knjigu");
			btnDodajKnjigu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziDodajKnjiguProzor();
				}
			});
			btnDodajKnjigu.setPreferredSize(new Dimension(120, 25));
		}
		return btnDodajKnjigu;
	}

	private JButton getBtnIzbrisiKnjigu() {
		if (btnIzbrisiKnjigu == null) {
			btnIzbrisiKnjigu = new JButton("Izbrisi knjigu");
			btnIzbrisiKnjigu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = table.getSelectedRow();
					if (index == -1) {
						GUIKontroler.porukaGreskeBiranjeReda();
					} else {
						int opcija = JOptionPane.showConfirmDialog(null,
								"Da li ste sigurni da zelite da izbrisete izbranu knjigu?", "Poruka",
								JOptionPane.YES_NO_OPTION);
						if (opcija == JOptionPane.YES_OPTION) {
							KnjigaTableModel model = (KnjigaTableModel) table.getModel();
							Knjiga k = model.getKnjigaByIndex(index);
							GUIKontroler.izbrisiKnjigu(k);
						}
					}
				}
			});
			btnIzbrisiKnjigu.setPreferredSize(new Dimension(120, 25));
		}
		return btnIzbrisiKnjigu;
	}

	public void osveziTabelu() {
		KnjigaTableModel model = (KnjigaTableModel) table.getModel();
		model.ucitajKnjige(GUIKontroler.vratiSveKnjige());

	}

	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajKnjigu());
		}
		return popupMenu;
	}

	private JMenuItem getMntmDodajKnjigu() {
		if (mntmDodajKnjigu == null) {
			mntmDodajKnjigu = new JMenuItem("Dodaj knjigu");
			mntmDodajKnjigu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziDodajKnjiguProzor();
				}
			});
		}
		return mntmDodajKnjigu;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
