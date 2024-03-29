package ch.schoodle.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ch.schoodle.applicationdata.Names;
import ch.schoodle.applicationdata.Tools;
import ch.schoodle.data.AufgabenDAO;
import ch.schoodle.model.Aufgabe;
import ch.schoodle.model.User;

public class AufgabenController {
	private HttpServletRequest request;
	public AufgabenController(HttpServletRequest request) throws UnsupportedEncodingException {
		this.request = request;
		this.request.setCharacterEncoding("UTF-8");

	}
	
	public List<Aufgabe> getMeineAufgaben(User user){
		AufgabenDAO aufgabenDAO = new AufgabenDAO();
		System.out.println(user);
		return aufgabenDAO.getAllAufgabenForUser(user.getIdUser());
	}
	
	public void chkSave() {
		String title = this.request.getParameter(Names.TITEL);
		String id = this.request.getParameter(Names.IDAUFGABEN);
		if(title != null) {			
			if(id!=null ) {
				System.out.println(id);
				updateAufgabe(Integer.valueOf(id));
			}else {
				createAufgabe();
			}
			
		}
	}
	
	private void createAufgabe() {
		Aufgabe aufgabe = createAufgabeFromRequest(null);
		AufgabenDAO aufgabenDAO = new AufgabenDAO();
		aufgabenDAO.insertAufgabe(aufgabe);
	}

	private void updateAufgabe(int id) {
		
		Aufgabe aufgabe = createAufgabeFromRequest(id);
		System.out.println(aufgabe.getTitel());
		AufgabenDAO aufgabenDAO = new AufgabenDAO();
		aufgabenDAO.updateAufgaben(aufgabe);
		
	}
	private Aufgabe createAufgabeFromRequest(Integer id) {
		String benoetigteZeit = request.getParameter(Names.BENOETIGTEZEIT);
		String beschreibung = request.getParameter(Names.BESCHREIBUNG);
		String geplanteZeit = request.getParameter(Names.GEPLANTEZEIT);
		String fach = request.getParameter(Names.FACH);
		String titel = request.getParameter(Names.TITEL);
		String zuErledigenBis = request.getParameter(Names.ZUERLEDIGTENBIS);
		Integer userId = Integer.parseInt(request.getParameter(Names.USER));
		Aufgabe aufgabe = new Aufgabe();
		aufgabe.setIdAufgaben(id!=null?id:-1);
		aufgabe.setTitel(titel);
		aufgabe.setBeschreibung(beschreibung);	
		aufgabe.setUser(userId);
		aufgabe.setGeplanteZeit(geplanteZeit==null || geplanteZeit.isEmpty() ? null : Float.parseFloat(geplanteZeit));
		System.out.println(benoetigteZeit);
		aufgabe.setBenoetigteZeit((benoetigteZeit == null || benoetigteZeit.isEmpty())? null : Float.parseFloat(benoetigteZeit));
		aufgabe.setFach(fach.isEmpty()?null:Integer.parseInt(fach));
		aufgabe.setZuErledigenBis(zuErledigenBis.isEmpty() ? null : Tools.dateFromString(zuErledigenBis));
		aufgabe.setErledigt(request.getParameter(Names.ERLEDIGT) !=null && request.getParameter(Names.ERLEDIGT).equals("1"));
		aufgabe.setWiederholend(request.getParameter(Names.WIEDERHOLEND) !=null && request.getParameter(Names.WIEDERHOLEND).equals("1"));
		return aufgabe;
	}
}
