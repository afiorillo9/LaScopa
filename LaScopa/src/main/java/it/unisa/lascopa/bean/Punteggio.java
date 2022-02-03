/**
 * 
 */
package it.unisa.lascopa.bean;

import java.io.Serializable;

/**
 * @author simon
 *
 */
public class Punteggio implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer 	id;
	private Partita 	partita;
	private Giocatore	giocatore;
	private int			scopa;
	private int			carteLunghe;
	private int			setteDOro;
	private	int			carteDenari;
	private int 		settanta;
	private int			totale;
	
	public Punteggio() {
		super();
		
		this.id = null;
		this.partita = null;
		this.giocatore = null;
		this.scopa = 0;
		this.carteLunghe = 0;
		this.setteDOro = 0;
		this.carteDenari = 0;
		this.settanta = 0;
		this.totale = 0;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the partita
	 */
	public Partita getPartita() {
		return partita;
	}

	/**
	 * @return the giocatore
	 */
	public Giocatore getGiocatore() {
		return giocatore;
	}

	/**
	 * @return the scopa
	 */
	public int getScopa() {
		return scopa;
	}

	/**
	 * @return the carteLunghe
	 */
	public int getCarteLunghe() {
		return carteLunghe;
	}

	/**
	 * @return the setteDOro
	 */
	public int getSetteDOro() {
		return setteDOro;
	}

	/**
	 * @return the carteDenari
	 */
	public int getCarteDenari() {
		return carteDenari;
	}

	/**
	 * @return the settanta
	 */
	public int getSettanta() {
		return settanta;
	}

	/**
	 * @return the totale
	 */
	public int getTotale() {
		return totale;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param partita the partita to set
	 */
	public void setPartita(Partita partita) {
		this.partita = partita;
	}

	/**
	 * @param giocatore the giocatore to set
	 */
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	/**
	 * @param scopa the scopa to set
	 */
	public void setScopa(int scopa) {
		this.scopa = scopa;
	}

	/**
	 * @param carteLunghe the carteLunghe to set
	 */
	public void setCarteLunghe(int carteLunghe) {
		this.carteLunghe = carteLunghe;
	}

	/**
	 * @param setteDOro the setteDOro to set
	 */
	public void setSetteDOro(int setteDOro) {
		this.setteDOro = setteDOro;
	}

	/**
	 * @param carteDenari the carteDenari to set
	 */
	public void setCarteDenari(int carteDenari) {
		this.carteDenari = carteDenari;
	}

	/**
	 * @param settanta the settanta to set
	 */
	public void setSettanta(int settanta) {
		this.settanta = settanta;
	}

	/**
	 * @param totale the totale to set
	 */
	public void setTotale(int totale) {
		this.totale = totale;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.id == ((Punteggio) obj).getId();
	}

	@Override
	public String toString() {
		return getClass().getName() + "[id=" + id + ", partita=" + partita.toString() + ", giocatore=" + giocatore.toString() + ", scopa=" + scopa
				+ ", carteLunghe=" + carteLunghe + ", setteDOro=" + setteDOro + ", carteDenari=" + carteDenari
				+ ", settanta=" + settanta + ", totale=" + totale + "]";
	}
}
