package ch.schoodle.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ch.schoodle.model.Fach;
/**
 * @author Janet Eberlein
 *
 */
public class FaecherDAO extends DBConnector{
	/**Gibt eine Liste mit Faechern zurück wenn kein Fach gefunden wird gibt es eine Leere Liste zurück. 
	 * @return
	 */
	public List<Fach> getFaecherList(){
		List<Fach> result = new ArrayList<>();
		String sql = "SELECT * FROM faecher;"; 
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				Fach faecher = new Fach();
				faecher.setIdFach(resultSet.getInt("idFach"));
				faecher.setFach(resultSet.getString("fach"));
				result.add(faecher);
			}
			resultSet.close();
		}catch(Exception e) {
			//loggin implementieren
			System.out.println("Error in getFaecherList");
			e.printStackTrace();
		}
		return result;
	}
	
}

