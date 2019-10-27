package ch.schoodle.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ch.schoodle.model.Aufgabe;

public class AufgabenDAO extends DBConnector{
	private final String SQL_AUFGABENFORUSER = "SELECT * FROM aufgaben WHERE user=?;";
	private final String IDAUFGABEN = "idAufgaben";
	private final String FACH = "fach";
	private final String TITEL = "titel";
	private final String BESCHREIBUNG = "beschreibung";
	private final String ZUERLEDIGTENBIS = "zuErledigenBis";
	private final String GEPLANTEZEIT = "geplanteZeit";
	private final String BENOETIGTEZEIT = "benötigteZeit";
	private final String WIEDERHOLEND = "wiederholend";
	private final String ERLEDIGT = "erledigt";


	public List<Aufgabe> getAllAufgabenForUser(int userId){
		System.out.println("Userid: " + userId);
		List<Aufgabe> result = new ArrayList<>();
		String sql = SQL_AUFGABENFORUSER; 
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, userId);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				Aufgabe aufgabe = new Aufgabe();
				aufgabe.setIdAufgaben(resultSet.getInt(IDAUFGABEN));
				aufgabe.setTitel(resultSet.getString(TITEL));
				aufgabe.setBeschreibung(resultSet.getString(BESCHREIBUNG));
				aufgabe.setZuErledigenBis(toJavaDate(resultSet.getDate(ZUERLEDIGTENBIS)));
				aufgabe.setGeplanteZeit(resultSet.getFloat(GEPLANTEZEIT));
				aufgabe.setBenoetigteZeit(resultSet.getFloat(BENOETIGTEZEIT));
				aufgabe.setWiederholend(toBoolean(resultSet.getInt(WIEDERHOLEND)));
				aufgabe.setErledigt(toBoolean(resultSet.getInt(ERLEDIGT)));
				aufgabe.setFach(resultSet.getInt(FACH));
				result.add(aufgabe);
			}
			resultSet.close();
		}catch(Exception e) {
			System.out.println("Error in getAllAufgabenForUser");
			e.printStackTrace();
		}
		return result;
	}
}
