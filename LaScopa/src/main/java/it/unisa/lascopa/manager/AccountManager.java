package it.unisa.lascopa.manager;

import java.sql.SQLException;

import it.unisa.lascopa.bean.Account;

/**
 * @author simon
 *
 */
public interface AccountManager {
	public Account login(String username, String password) throws SQLException;
}
