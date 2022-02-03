/**
 * 
 */
package it.unisa.lascopa.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author simon
 *
 */
public class Partita implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer 	id;
	private Date		data;
	private Giocatore	giocatoreUno;
	private	Giocatore	giocatoreDue;
	private Punteggio	punteggioUno;
	private	Punteggio	punteggioDue;
	private String		vincitore;	
	private	String		turno;
	
	public Partita() {
		this.id = null;
		this.data = null;
		this.giocatoreUno = null;
		this.giocatoreDue = null;
		this.punteggioUno = null;
		this.punteggioDue = null;
		this.vincitore = "";
		this.turno = "";
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}
	
	/**
	 * @return the giocatoreUno
	 */
	public Giocatore getGiocatoreUno() {
		return giocatoreUno;
	}
	
	/**
	 * @return the giocatoreDue
	 */
	public Giocatore getGiocatoreDue() {
		return giocatoreDue;
	}
	
	/**
	 * @return the punteggioUno
	 */
	public Punteggio getPunteggioUno() {
		return punteggioUno;
	}
	
	/**
	 * @return the punteggioDue
	 */
	public Punteggio getPunteggioDue() {
		return punteggioDue;
	}
	
	/**
	 * @return the vincitore
	 */
	public String getVincitore() {
		return vincitore;
	}
	
	/**
	 * @return the turno
	 */
	public String getTurno() {
		return turno;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
	
	/**
	 * @param giocatoreUno the giocatoreUno to set
	 */
	public void setGiocatoreUno(Giocatore giocatoreUno) {
		this.giocatoreUno = giocatoreUno;
	}
	
	/**
	 * @param giocatoreDue the giocatoreDue to set
	 */
	public void setGiocatoreDue(Giocatore giocatoreDue) {
		this.giocatoreDue = giocatoreDue;
	}
	
	/**
	 * @param punteggioUno the punteggioUno to set
	 */
	public void setPunteggioUno(Punteggio punteggioUno) {
		this.punteggioUno = punteggioUno;
	}

	/**
	 * @param punteggioDue the punteggioDue to set
	 */
	public void setPunteggioDue(Punteggio punteggioDue) {
		this.punteggioDue = punteggioDue;
	}

	/**
	 * @param vincitore the vincitore to set
	 */
	public void setVincitore(String vincitore) {
		this.vincitore = vincitore;
	}

	/**
	 * @param turno the turno to set
	 */
	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Partita) obj).getId();
	}

	@Override
	public String toString() {
		return getClass().getName() + "[id=" + id + ", data=" + data + ", giocatoreUno=" + giocatoreUno.toString() + ", giocatoreDue="
				+ giocatoreDue.toString() + ", punteggioUno=" + punteggioUno.toString() + ", punteggioDue=" + punteggioDue.toString() + ", vincitore="
				+ vincitore + ", turno=" + turno + "]";
	}	
}
