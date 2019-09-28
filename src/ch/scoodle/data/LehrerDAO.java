package ch.scoodle.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ch.scoodle.model.Lehrer;
/**
 * @author Janet Eberlein
 *
 */
public class LehrerDAO extends DBConnector{
	/**Gibt eine Liste mit Lehrern zurück wenn kein Lehrer Gefunden wird gibt es eine Leere Liste zurück. 
	 * @return
	 */
	public List<Lehrer> getLehrerList(){
		List<Lehrer> result = new ArrayList<>();
		String sql = "SELECT * FROM lehrer;"; 
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				Lehrer lehrer = new Lehrer();
				lehrer.setIdLehrer(resultSet.getInt("idLehrer"));
				lehrer.setNameLehrer(resultSet.getString("nameLehrer"));
				result.add(lehrer);
			}
			resultSet.close();
		}catch(Exception e) {
			//loggin implementieren
			System.out.println("Error in getLehrerList");
			e.printStackTrace();
		}
		return result;
	}
	
}
