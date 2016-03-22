package biblioteka;

/**
 * Ovo je klasa koja predstavlja autora neke knjige.
 * @author Bojan Tomic
 * @version 1.0
 *
 */
public class Autor {
	
	/**
	 * Ime autora
	 */
	private String ime;
	
	/**
	 * Prezime autora
	 */
	private String prezime;
	
	
	/**
	 * Vraca vrednost atributa ime
	 * @return ime autora
	 */
	public String getIme() {
		return ime;
	}
	
	/**
	 * Postavlja novu vrednost za atribut ime
	 * @param ime Nova vrednost za ime autora
	 * @throws java.lang.RuntimeException ako je uneto
	 * ime
	 * <ul> 
	 * 		<li>null</li>
	 * 		<li>prazan String</li>
	 * </ul>
	 */
	public void setIme(String ime) {
		if (ime==null || ime.isEmpty())
			throw new RuntimeException("Morate uneti ime");
		
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		if (prezime==null || prezime.isEmpty())
			throw new RuntimeException("Morate uneti prezime");
		
		this.prezime = prezime;
	}
	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		return true;
	}
	
	

}
