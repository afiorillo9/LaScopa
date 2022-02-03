package it.unisa.lascopa.bean;

import java.io.Serializable;

/**
 * @author simon
 *
 */
public class GestoreUtenti extends Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String	nome;
	private String 	cognome;

	public GestoreUtenti() {
		super();
		
		this.nome = "";
		this.cognome = "";
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}
		
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.getId() == ((GestoreUtenti) obj).getId();
	}

	@Override
	public String toString() {
		return getClass().getName() + "[nome=" + nome + ", cognome=" + cognome + "]";
	}
}
