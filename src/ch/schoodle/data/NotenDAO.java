package ch.schoodle.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ch.schoodle.model.Noten;

/**
 * @author Sascha Wechsler
 *
 */
public class NotenDAO extends DBConnector{
	/**Gibt eine Liste mit den Noten für den aktuellen User zurück, wenn keine Noten gefunden werden gibt es eine Leere Liste zurück. 
	 * @return
	 */
	private final String SQL_NOTENFORUSER = "SELECT * FROM noten WHERE user = ?;";
	
	public List<Noten> getNotenForUserList(int userId){
		String sql = SQL_NOTENFORUSER; 
		List<Noten> result = new ArrayList<>();
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, userId);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				Noten noten = new Noten();
				noten.setIdNoten(resultSet.getInt("idNoten"));
				noten.setNoten(resultSet.getFloat("noten"));
				noten.setFach(resultSet.getInt("fach"));
				noten.setDatum(resultSet.getDate("datum"));
				result.add(noten);
			}
			resultSet.close();
		}catch(Exception e) {
			//loggin implementieren
			System.out.println("Error in getNotenForUserList");
			e.printStackTrace();
		}
		return result;
	}
}
