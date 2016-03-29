package com.twitter.poruke;
/**
 * Ova klasa predstavlja twitter poruku.
 * @author Dragana Tanic
 * @version 1.0
 */

public class TwitterPoruka {
	
	/**
	 * Ime korisnika kao String.
	 */
	
	private String korisnik;
	
	/**
	 * Poruka korisnika kao String.
	 */
	
	private String poruka;
	
	/**
	 * Metoda koja vraca ime korisnika koji je poslao poruku.
	 * @return ime korisnika koji je poslao poruku
	 */

	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Metoda koja postavlja atribut 'korisnik' na vrednost prosledjenog parametra.
	 * @param korisnik ime korisnika
	 * @throws java.lang.RuntimeException ako je vrednost unetog parametra: 
	 * <ul>
	 * <li>null</li> 
	 *  <li>prazan String</li>
	 *  </ul>
	 */

	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Metoda koja vraca poruku korisnika.
	 * @return poruku korisnika
	 */

	public String getPoruka() {
		return "poruka";
	}
	
	/**
	 * Metoda koja postavlja atribut 'poruka' na vrednost prosledjenog parametra.
	 * @param poruka korisnika
	 * @throws java.lang.RuntimeException ako je vrednost unetog parametra: 
	 * <ul>
	 * <li>null</li> 
	 *  <li>poruka duza od 140 karaktera</li>
	 *  </ul>
	 */

	public void setPoruka(String poruka) {
		if (poruka == null || this.poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * Metoda koja vraca string sa podacima o korisniku i o poruci korisnika
	 * @return ime i poruku korisnika
	 */

	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}

}
