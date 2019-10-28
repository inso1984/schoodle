package ch.schoodle.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ch.schoodle.model.Stundenplan;
/**
 * @author Sascha Wechsler
 *
 */
public class StundenplanDAO extends DBConnector{
	/**Gibt eine Liste mit dem Stundenplan für den aktuellen User zurück, wenn kein Stundenplan gefunden wird gibt es eine Leere Liste zurück. 
	 * @return
	 */
	private final String SQL_STUNDENPLANFORUSER = "SELECT * FROM stundenplan WHERE user_idUser = ?;";
	
	public List<Stundenplan> getStundenplanForUserList(int userId){
		String sql = SQL_STUNDENPLANFORUSER; 
		List<Stundenplan> result = new ArrayList<>();
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, userId);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				Stundenplan stundenplan = new Stundenplan();
				stundenplan.setIdStundenplanNummer(resultSet.getInt("idStundenplanNummer"));
				stundenplan.setVon(resultSet.getTime("von"));
				stundenplan.setBis(resultSet.getTime("bis"));
				stundenplan.setWochentag_idWochentag(resultSet.getInt("wochentag_idWochentag"));
				stundenplan.setFach_idFach(resultSet.getInt("fach_idFach"));
				result.add(stundenplan);
			}
			resultSet.close();
		}catch(Exception e) {
			//loggin implementieren
			System.out.println("Error in getStundenplanForUserList");
			e.printStackTrace();
		}
		return result;
	}
}
