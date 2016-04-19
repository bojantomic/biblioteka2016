package biblioteka.gui.models;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import biblioteka.Knjiga;

@SuppressWarnings("serial")
public class KnjigaTableModel extends AbstractTableModel {

	private final String[] kolone = new String[] { "Naslov", "ISBN", "Izdavac", "izdanje", "Autor 1", "Autor 2" };
	private List<Knjiga> knjige;

	public KnjigaTableModel(List<Knjiga> knjige) {
		if (knjige == null) {
			this.knjige = new LinkedList<>();
		} else {
			this.knjige = knjige;
		}
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return knjige.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Knjiga k = knjige.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return k.getNaslov();
		case 1:
			return k.getIsbn();
		case 2:
			return k.getIzdavac();
		case 3:
			return k.getIzdanje();
		case 4:
			if (k.getAutori().get(0) != null) {
				return k.getAutori().get(0).getIme() + " " + k.getAutori().get(0).getPrezime();
			} else {
				return "";
			}
		case 5:
			if (k.getAutori().get(1) != null) {
				return k.getAutori().get(1).getIme() + " " + k.getAutori().get(1).getPrezime();
			} else {
				return "";
			}
		default:
			return "NN";
		}
	}

	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	public void ucitajKnjige(List<Knjiga> knjige) {
		this.knjige = knjige;
		fireTableDataChanged();
	}

	public Knjiga getKnjigaByIndex(int index) {
		return knjige.get(index);
	}

}
