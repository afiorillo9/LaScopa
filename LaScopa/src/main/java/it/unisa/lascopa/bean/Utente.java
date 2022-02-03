/**
 * 
 */
package it.unisa.lascopa.bean;

import java.io.Serializable;

/**
 * @author simon
 *
 */
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nickname;
	
	public Utente() {
		this.nickname = "";
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.nickname == ((Utente) obj).getNickname();
	}

	@Override
	public String toString() {
		return getClass().getName() + "[nickname=" + nickname + "]";
	}
}
