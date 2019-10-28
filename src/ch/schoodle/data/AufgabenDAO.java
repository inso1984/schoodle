package ch.schoodle.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ch.schoodle.applicationdata.Names;
import ch.schoodle.model.Aufgabe;

public class AufgabenDAO extends DBConnector{
	private final String SQL_AUFGABENFORUSER = "SELECT * FROM aufgaben WHERE user=?;";


	public List<Aufgabe> getAllAufgabenForUser(int userId){
		System.out.println("Userid: " + userId);
		List<Aufgabe> result = new ArrayList<>();
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(SQL_AUFGABENFORUSER)) {
			pstmt.setInt(1, userId);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				Aufgabe aufgabe = new Aufgabe();
				aufgabe.setIdAufgaben(resultSet.getInt(Names.IDAUFGABEN));
				aufgabe.setTitel(resultSet.getString(Names.TITEL));
				aufgabe.setBeschreibung(resultSet.getString(Names.BESCHREIBUNG));
				aufgabe.setZuErledigenBis(toJavaDate(resultSet.getDate(Names.ZUERLEDIGTENBIS)));
				aufgabe.setGeplanteZeit(resultSet.getFloat(Names.GEPLANTEZEIT));
				aufgabe.setBenoetigteZeit(resultSet.getFloat(Names.BENOETIGTEZEIT));
				aufgabe.setWiederholend(toBoolean(resultSet.getInt(Names.WIEDERHOLEND)));
				aufgabe.setErledigt(toBoolean(resultSet.getInt(Names.ERLEDIGT)));
				aufgabe.setFach(resultSet.getInt(Names.FACH));
				result.add(aufgabe);
			}
			resultSet.close();
		}catch(Exception e) {
			System.out.println("Error in getAllAufgabenForUser");
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateAufgaben(Aufgabe aufgabe) {
		final String SQL_UPDATE = "UPDATE aufgaben SET " + Names.TITEL + " =?, " + Names.BESCHREIBUNG + " =?, " + Names.FACH + " =?, "
		+ Names.GEPLANTEZEIT + " =?, " + Names.BENOETIGTEZEIT + " =?, " + Names.WIEDERHOLEND + " =?, "
		+ Names.ERLEDIGT + " =?, " + Names.ZUERLEDIGTENBIS + " =? WHERE " + Names.IDAUFGABEN + " =?;";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE)) {
			pstmt.setString(1, aufgabe.getTitel());
			pstmt.setString(2, aufgabe.getBeschreibung());
			pstmt.setInt(3, aufgabe.getFach());
			pstmt.setFloat(4, aufgabe.getGeplanteZeit() == null ? 0:aufgabe.getGeplanteZeit());
			pstmt.setFloat(5, aufgabe.getBenoetigteZeit()==null?0:aufgabe.getBenoetigteZeit());
			pstmt.setBoolean(6, aufgabe.isWiederholend());
			pstmt.setBoolean(7, aufgabe.isErledigt());
			pstmt.setDate(8, aufgabe.getZuErledigenBis()!=null?new Date(aufgabe.getZuErledigenBis().getTime()):null);
			pstmt.setInt(9, aufgabe.getIdAufgaben());
			pstmt.executeUpdate();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}
}
