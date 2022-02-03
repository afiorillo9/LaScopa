/**
 * 
 */
package it.unisa.lascopa.bean;

import java.io.Serializable;

/**
 * @author simon
 *
 */
public class Giocatore extends Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String	avatar;
	private boolean online;	
	
	public Giocatore() {
		super();
		
		this.avatar = "";
		this.online = false;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}
	
	/**
	 * @return the online
	 */
	public boolean isOnline() {
		return online;
	}
		
	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	/**
	 * @param online the online to set
	 */
	public void setOnline(boolean online) {
		this.online = online;
	}

	@Override
	public boolean equals(Object obj) {
		return this.getId() == ((Giocatore) obj).getId();
	}

	@Override
	public String toString() {
		return getClass().getName() + "[avatar=" + avatar + ", online=" + online + "]";
	}
}
