package it.unisa.lascopa.bean;

import java.io.Serializable;

/**
 * @author simon
 *
 */
public class Account extends Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String 	username;
	private String	password;
	private boolean	attivo;
	
	public Account() {
		super();
		
		this.id = null;
		this.username = "";
		this.password = "";
		this.attivo = false;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the attivo
	 */
	public boolean isAttivo() {
		return attivo;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param attivo the attivo to set
	 */
	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Account) obj).getId();
	}

	@Override
	public String toString() {
		return getClass().getName() + "[id=" + id + ", username=" + username + ", password=" + password + ", attivo=" + attivo + "]";
	}	
}
