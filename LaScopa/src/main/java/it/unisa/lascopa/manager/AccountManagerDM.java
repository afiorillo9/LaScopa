/**
 * 
 */
package it.unisa.lascopa.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unisa.lascopa.bean.Account;
import it.unisa.lascopa.bean.GestoreUtenti;
import it.unisa.lascopa.bean.Giocatore;

/**
 * @author simon
 *
 */
public class AccountManagerDM implements AccountManager {
	@Override
	public Account login(String username, String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Account account = new Account();
		
		String selectSQL = "SELECT * FROM Account WHERE username = ? AND password = ?";
		
		try {
			connection = DMCP.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				account.setId(rs.getInt("id"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("psw"));
				account.setAttivo(rs.getBoolean("attivo"));
			
				selectSQL = "SELECT * FROM GestoreUtenti WHERE id_account = ?";
				
				preparedStatement.setInt(1, account.getId());
				
				rs = preparedStatement.executeQuery();
				
				if(rs.next()) {
					GestoreUtenti gestoreUtenti = new GestoreUtenti();
	
					gestoreUtenti.setId(account.getId());
					gestoreUtenti.setNickname(account.getNickname());
					gestoreUtenti.setPassword(account.getPassword());
					gestoreUtenti.setAttivo(account.isAttivo());
					
					gestoreUtenti.setNome(rs.getString("nome"));
					gestoreUtenti.setCognome(rs.getString("cognome"));
					
					return gestoreUtenti;
				} else {
					selectSQL = "SELECT * FROM Giocatori WHERE id_account = ?";
					
					preparedStatement.setInt(1, account.getId());
					
					rs = preparedStatement.executeQuery();
					
					if(rs.next()) {
						Giocatore giocatore = new Giocatore();
						
						giocatore.setId(account.getId());
						giocatore.setNickname(account.getNickname());
						giocatore.setPassword(account.getPassword());
						giocatore.setAttivo(account.isAttivo());
						
						giocatore.setAvatar(rs.getString("avatar"));
						
						//OVVIAMENTE NON VA BENE, LASCIO PER RICORDARE
						giocatore.setOnline(rs.getBoolean("disponibile"));
						
						return giocatore;
					}
				}
			}
		} finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			} finally {
				DMCP.releaseConnection(connection);
			}
		}
		
		return null;
	}
}
